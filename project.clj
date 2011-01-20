(defproject clj-deployable-web "1.0.0-SNAPSHOT"
  :description "This is an exmaple clojure web project that will be deployable via Tomcat or Trinidad"
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [compojure "0.5.3"]
                 [ring/ring-jetty-adapter "0.3.2"]
                 [ring/ring-devel "0.3.2"]
                 [clj-http "0.1.2"]
                 [hiccup "0.3.1"]]
  :dev-dependencies [[swank-clojure "1.2.1"]
                     [uk.org.alienscience/leiningen-war "0.0.12"]]
  :run-aliases {:server clj-deployable-web.core}
  :main clj-deployable-web.core
  :aot [clj-deployable-web.deploy.servlet]
  :war {:web-content "html"})
