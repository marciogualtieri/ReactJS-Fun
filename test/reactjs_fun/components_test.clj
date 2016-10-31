(ns reactjs_fun.components_test
  (:require [clojure.test :refer :all]
            [ring.adapter.jetty :refer [run-jetty]]
            [clj-webdriver.taxi :refer :all]
            [reactjs_fun.features.config :refer :all]
            [reactjs_fun.routes :refer [app-routes]]))

(defn start-server []
  (loop [server (run-jetty app-routes {:port test-port, :join? false})]
    (if (.isStarted server)
      server
      (recur server))))

(defn stop-server [server]
  (.stop server))

(defn with-server [test-to-run]
  (let [server (start-server)]
    (test-to-run)
    (stop-server server)))

(defn start-browser []
  (set-driver! {:browser :firefox}))

(defn stop-browser []
  (quit))

(defn with-browser [test-to-run]
  (start-browser)
  (test-to-run)
  (stop-browser))

(use-fixtures :once with-server with-browser)

(def invalid-phone-digits "abc@#$%^&*_=~`:;<,>.?/\"'")

(deftest when-load-index-page---then-contact-form-is-present
  (to test-base-url)
  (is (= (value (find-element {:id "your-email-input"})) "your@email.com"))
  (is (= (value (find-element {:id "your-phone-input"})) "+1 (234) 567-8901")))

(deftest when-fill-email-in-contact-form---then-value-is-updated
  (to test-base-url)
  (def your-email-input (find-element {:id "your-email-input"}))
  (clear your-email-input)
  (input-text your-email-input "a@b.c")
  (is (= (value your-email-input) "a@b.c"))
  (is (not (.contains (attribute your-email-input :style) "background-color"))))

(deftest when-fill-email-in-contact-form-with-invalid-value---then-background-color-is-updated
  (to test-base-url)
  (def your-email-input (find-element {:id "your-email-input"}))
  (clear your-email-input)
  (input-text your-email-input "not-a-valid-email")
  (is (.contains (attribute your-email-input :style) "background-color")))

(deftest when-fill-phone-in-contact-form---then-value-is-updated
  (to test-base-url)
  (def your-phone-input (find-element {:id "your-phone-input"}))
  (clear your-phone-input)
  (input-text your-phone-input "+2 345 6789")
  (is (= (value your-phone-input) "+2 345 6789")))

(deftest when-fill-phone-in-contact-form-with-invalid-digits---then-invalid-digits-are-ignored
  (to test-base-url)
  (def your-phone-input (find-element {:id "your-phone-input"}))
  (clear your-phone-input)
  (input-text your-phone-input "+1")
  (input-text your-phone-input invalid-phone-digits)
  (input-text your-phone-input " (234) 567-8901")
  (is (= (value your-phone-input) "+1 (234) 567-8901")))