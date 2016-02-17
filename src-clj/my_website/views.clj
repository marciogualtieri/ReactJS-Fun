(ns my_website.views
    (:require
      [hiccup
       [page :refer [html5 include-js]]]
      ))

(defn index-page []
      (html5
        [:head
         [:title "My Website: Clojure"]]
        [:body
         [:div {:id "contact-form"}]
         (include-js "/js/components.js")]))