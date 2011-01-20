(ns clj-deployable-web.controllers.application
  (:require [clj-deployable-web.views.application :as view]))

(defn index []
  (view/index "Do something in your controller"))
