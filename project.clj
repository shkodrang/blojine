(defproject blojine "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]]
  :plugins [[lein-ring "0.8.10"]]
  :ring {:handler blojine.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]
                        [com.novemberain/monger "1.7.0"]
                        [hiccup "1.0.5"]]}})
