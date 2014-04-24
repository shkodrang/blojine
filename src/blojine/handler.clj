(ns blojine.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [blojine.models.posts :as posts]
            [blojine.views.layout :as layout]
            [blojine.views.home :as home]))

(defroutes app-routes
  (GET "/" [] (layout/common "Index"
                             (home/index (posts/retrieve-all 0))))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
