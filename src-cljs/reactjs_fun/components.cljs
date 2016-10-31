(ns reactjs_fun.components
  (:require [rum.core :as rum]))

(js/console.time "Init")
(enable-console-print!)

(def color (atom "#FA8D97"))

(defn element [id] (js/document.getElementById id))

(rum/defc validating-input < rum/reactive [ref fn id]
          [:input {:id        id
                   :type      "text"
                   :style     {:width            170
                               :background-color (when-not (fn (rum/react ref))
                                                           (rum/react color))}
                   :value     (rum/react ref)
                   :on-change #(reset! ref (.. % -target -value))}])

(rum/defcc restricting-input < rum/reactive [comp ref fn id]
           [:input {:id        id
                    :type      "text"
                    :style     {:width 170}
                    :value     (rum/react ref)
                    :on-change #(let [new-val (.. % -target -value)]
                                     (if (fn new-val)
                                       (reset! ref new-val)
                                       (rum/request-render comp)))}])

(rum/defc contact-form []
          (let [state (atom {:email "your@email.com"
                             :phone "+1 (234) 567-8901"})]
               [:dl
                [:h2 "Contact Me"]
                [:dt "Your E-mail:"]
                [:dd (validating-input (rum/cursor state [:email]) #(re-matches #"[^@]+@[^@.]+\..+" %) "your-email-input")]
                [:dt "Your Phone:"]
                [:dd (restricting-input (rum/cursor state [:phone]) #(re-matches #"[0-9\- +()]*" %) "your-phone-input")]]))

(rum/mount (contact-form) (element "contact-form"))

(js/console.timeEnd "Init")
