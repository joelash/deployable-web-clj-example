(ns clj-deployable-web.config)

(def environment
  (let [app-env (System/getenv "CLJ_WEB_ENV")]
    (if app-env (keyword app-env) :development)))

(def production?
  (= :production environment))

(def development?
  (not production?))
