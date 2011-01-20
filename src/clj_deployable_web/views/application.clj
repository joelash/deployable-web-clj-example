(ns clj-deployable-web.views.application
  (:use [hiccup.core])
  (:require [clj-deployable-web.views.layouts :as layouts]))


(defn index [a-paramter]
  (layouts/with-layout
    (html
     [:div.controller-data a-paramter])))
