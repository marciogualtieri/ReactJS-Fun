(ns reactjs_fun.views
    (:require
      [hiccup
       [page :refer [html5 include-js include-css]]]
      ))

(defn index-page []
      (html5
        [:head
         [:title "My Website: Clojure"]]
        [:body
         [:div {:id "contact-form" :class "reactjs_fun"}]
         (include-js "/js/components.js")
         (include-css "/css/style.css")]))