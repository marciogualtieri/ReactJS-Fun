(defproject my-website "0.1.0-SNAPSHOT"
  :description "My Website"
  :url "http://github.com/marciogualtieri"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}

  :source-paths ["src-clj"]
  :main my-website.core

  :plugins [[lein-ring "0.8.11"]
            [lein-cljsbuild "1.1.0"]]

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.122"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.4"]
                 [rum "0.6.0"]
                 [clj-webdriver "0.7.1"]
                 [org.seleniumhq.selenium/selenium-server "2.47.0"]
                 [ring/ring-jetty-adapter "1.4.0"]]

  :cljsbuild {
              :builds [{:source-paths ["src-cljs"]
                        :compiler     {:output-to     "resources/public/js/components.js"
                                       :optimizations :whitespace
                                       :pretty-print  true}}]}

  :ring {:handler my_website.routes/app-routes})