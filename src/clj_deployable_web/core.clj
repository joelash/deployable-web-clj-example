(ns clj-deployable-web.core
  (:gen-class)
  (:require [clj-deployable-web.www :as www]))

(defn -main [& args]
  (www/start-server args))
