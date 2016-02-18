(ns my_website.views
    (:require
      [hiccup
       [page :refer [html5 include-js include-css]]]
      ))

(defn index-page []
      (html5
        [:head
         [:title "My Website: Clojure"]]
        [:body
         [:div {:id "contact-form" :class "my_website"}]
         (include-js "/js/components.js")
         (include-css "/css/style.css")]))