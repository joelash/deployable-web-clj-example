(ns clj-deployable-web.views.layouts
  (:use [hiccup.core]
        [hiccup.page-helpers])
  (:require [clj-deployable-web.config :as config]
            [clj-deployable-web.context :as context]))

(defn with-layout [& contents]
  (html5
   [:head
    [:title "clj-web"]
    (include-css (context/link "/public/css/main.css"))]
   [:body
    [:h1.welcome "Welcome to this web thingy!"]
    [:div#contents contents]
    [:div#footer "Environment is " config/environment]]))
