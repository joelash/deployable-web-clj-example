clj-deployable-web
=============

This is an example web application developed in Clojure using Compojure. I've set this app up to be deployable via a war (using [https://github.com/alienscience/leiningen-war leiningen-war] plugin). The war is setup such that it can be deployed in the [https://github.com/calavera/trinidad trinidad] container, which runs on tomcat, and tomcat will serve static files needed by the application.

== Usage

* install dependencies
  lein deps

* Run the server in development
  lein run :server 

* Build the war
  lein war

* run the app from war
  jruby -S trinidad --config trinidad_config.yml
 

== License

Copyright (C) 2011 Joel Friedman

Distributed under the Eclipse Public License, the same as Clojure.

Please do whatever you'd like with this source code. Hope you learn something.
