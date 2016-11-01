# ReactJs Fun

Learning Rum, a ReactJS Wrapper for Clojure.

## How to Build and Run the Application

Build and test the application:

    lein do clean, cljsbuild once, test

> This project uses 'clj-webdriver'. If you have any experience with Selenium WebDriver you might know that it will only
> work with specific versions of Firefox.

The current version of 'clj-webdriver' works with 
[Firefox 39](https://ftp.mozilla.org/pub/firefox/releases/39.0.3/linux-x86_64/en-US/firefox-39.0.3.tar.bz2). 
You may need to downgrade your browser to run tests.

Start a local web server and run the app using port 3000:

    lein ring server-headless 3000

Create a deploy-able war file:

    lein ring uberwar

## Plugins Used

* [lein-ring](https://github.com/weavejester/lein-ring) (to create a deploy-able package and run a local server).

* [lein-cljsbuild](https://github.com/emezeske/lein-cljsbuild) (for cross-compiling ClojureScript to JavaScript).

## Frameworks Used

* [ring](https://github.com/ring-clojure/ring) (a web app library).

* [rum](https://github.com/tonsky/rum) (a ReactJS Wrapper for Clojure).

* [hiccup](https://github.com/weavejester/hiccup) (to create static HTML pages; for my own reference, the API documentation is located [here](https://crossclj.info/ns/hiccup/1.0.5/hiccup.page.html)).

* [composure](https://github.com/weavejester/compojure) (a routing library for ring).

* [clj-webdriver](https://github.com/semperos/clj-webdriver) (for unit tests; for my own reference, the wiki page is located [here](https://github.com/semperos/clj-webdriver/wiki) and the Taxi API documentation is located [here](https://github.com/semperos/clj-webdriver/wiki/Taxi-API-Documentation)).

