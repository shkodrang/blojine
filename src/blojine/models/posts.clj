(ns blojine.models.posts
  (:require [monger.core :as mg]
            [monger.collection :as mcol]
            [monger.query :as mq]))

(mg/connect!)
(mg/set-db! (monger.core/get-db "blojine"))

(def page-limit 10)

(defn insert [date author category title body]
  (mcol/insert "posts" {:date date
                        :author author
                        :category category
                        :title title
                        :body body}))

(defn retrieve [date]
  (mcol/find-one-as-map "posts" {:date date}))

(defn retrieve-all [page]
  (mq/with-collection "posts"
    (mq/find {})
    (mq/fields [:date :author :category :title :body])
    (mq/paginate :page page :per-page page-limit)))

(defn delete [date]
  (mcol/remove "posts" {:date date}))
