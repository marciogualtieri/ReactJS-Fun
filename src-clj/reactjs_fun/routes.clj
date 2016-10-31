(ns reactjs_fun.routes
    (:use compojure.core
      reactjs_fun.views
      [hiccup.middleware :only (wrap-base-url)])
    (:require [compojure.route :as route]
      [compojure.handler :as handler]
      [compojure.response :as response]))

(defroutes main-routes
           (GET "/" [] (index-page))
           (route/resources "/")
           (route/not-found "Page not found"))

(def app-routes
  (-> (handler/site main-routes)
      (wrap-base-url)))