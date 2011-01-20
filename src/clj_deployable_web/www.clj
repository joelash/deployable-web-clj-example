(ns clj-deployable-web.www
  (:use [compojure.core]
        [ring.adapter.jetty]
        [ring.middleware.file]
        [ring.middleware.reload])
  (:require [clj-deployable-web.controllers.application :as application]
            [clj-deployable-web.context :as context]))


;; For all intents and purposes this should be in it's own
;; configuration ns

(def environment
     (let [app-env (get (System/getenv) "CLJ_WEB_ENV")]
       (if app-env (keyword app-env) :development)))

(def production?
  (= :production environment))

(def development?
  (not production?))

;; end configuration

;; usefull middleware
(defn wrap-if [handler pred wrapper & args]
  (if pred
    (apply wrapper handler args)
    handler))
;;end middleware

;; routes
(defroutes clj-web-routes
  (GET "/" [] (application/index)))

(def app (-> #'clj-web-routes
             context/wrap-context
             (wrap-if development? wrap-reload ['clj-deployable-web.www
                                                'clj-deployable-web.controllers.application
                                                'clj-deployable-web.views.layouts
                                                'clj-deployable-web.views.application])
             (wrap-if development? wrap-file "." {:root "html"})))

(defn start-server [& args]
  (run-jetty #'app {:port 3000}))
