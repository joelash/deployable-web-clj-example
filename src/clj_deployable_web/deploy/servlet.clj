(ns clj-deployable-web.deploy.servlet
  (:use ring.util.servlet)
  (:require [clj-deployable-web.www])
  (:gen-class :extends javax.servlet.http.HttpServlet))

(defservice clj-deployable-web.www/app)
