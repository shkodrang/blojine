(ns blojine.views.home)

(defn index [posts]
  (map (fn [post]
         [:div
          [:h2 (:title post) ", " (:date post)]
          [:p (:body post)]])
       posts))
