(ns clj-deployable-web.views.layouts
  (:use [hiccup.core]
        [hiccup.page-helpers]))

(defn with-layout [& contents]
  (html5
   [:head
    [:title "clj-web"]
    (include-css "public/css/main.css")]
   [:body
    [:h1.welcome "Welcome to this web thingy!"]
    [:div#contents contents]]))
