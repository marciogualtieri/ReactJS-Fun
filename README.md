# my-website-clojure

My personal website developed in Clojure.

## Usage

Build the application:

    lein cljsbuild once
    
Test the application:
    
    lein test

Starts a local web server and run the app using port 3000:

    lein ring server-headless 3000

Creates a deploy-able war file:

    lein ring uberwar

## Plugins Used

* [lein-ring](https://github.com/weavejester/lein-ring) (to create deploy-able package and run local server instance).

* [lein-cljsbuild](https://github.com/emezeske/lein-cljsbuild) (for cross-compiling ClojureScript to JavaScript).

## Frameworks Used

* [ring](https://github.com/ring-clojure/ring) (a web app library).

* [rum](https://github.com/tonsky/rum) (a ReactJS Wrapper for Clojure).

* [hiccup](https://github.com/weavejester/hiccup) (to create static HTML pages; for my own reference, the API documentation is located [here](https://crossclj.info/ns/hiccup/1.0.5/hiccup.page.html)).

* [composure](https://github.com/weavejester/compojure) (a routing library for ring).

* [clj-webdriver](https://github.com/semperos/clj-webdriver) (for unit tests; for my own reference, the wiki page is located [here](https://github.com/semperos/clj-webdriver/wiki) and the Taxi API documentation is located [here](https://github.com/semperos/clj-webdriver/wiki/Taxi-API-Documentation)).

## License

Copyright © 2016 BiiWii Enterprises

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
