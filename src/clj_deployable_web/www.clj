(ns clj-deployable-web.www
  (:use [compojure.core]
        [ring.adapter.jetty]
        [ring.middleware.file]
        [ring.middleware.reload])
  (:require [clj-deployable-web.controllers.application :as application]
            [clj-deployable-web.context :as context]
            [clj-deployable-web.config :as config]
            [compojure.route :as route]))


;; usefull middleware
(defn wrap-if [handler pred wrapper & args]
  (if pred
    (apply wrapper handler args)
    handler))
;; end middleware

;; routes
(defroutes clj-web-routes
  (GET "/" [] (application/index))
  (route/not-found "Page not found"))
;; not-found is uber important, otherwise 500 errors due defroutes not
;; handling gracefully and returning a default not-found and returning
;; nil when then screws up jetty

(def app (-> #'clj-web-routes
             context/wrap-context
             (wrap-if config/development? wrap-reload ['clj-deployable-web.www
                                                'clj-deployable-web.controllers.application
                                                'clj-deployable-web.views.layouts
                                                'clj-deployable-web.views.application])
             (wrap-if config/development? wrap-file "." {:root "html"})))

(defn start-server [& args]
  (run-jetty #'app {:port 3000}))
