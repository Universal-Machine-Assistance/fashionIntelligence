(ns fashion-intelligence.components.contact-form-sections
  (:require [fashion-intelligence.components.contact-form-fields :refer [text-field select-field]]))

(def referral-options
  ["Select one" "Instagram" "TikTok" "Google" "Pinterest" "Behance" "A (business) friend"])

(defn referral-section [form-data & {:keys [help-text]}]
  [:div
   [:label.block.text-sm.font-medium.text-gray-900.mb-3
    {:style {:font-family "'Special Elite', 'Courier New', monospace"}}
    [:span.text-red-500 "* "] "How did you hear about us?"]
   [:p.text-sm.text-gray-600.mb-3 
    {:style {:font-family "'Special Elite', 'Courier New', monospace"}}
    (or help-text "If someone referred us to you, please drop their name in the empty field so we know who to thank!")]
   [:div.grid.md:grid-cols-2.gap-6
    [select-field "" 
     referral-options
     (:hear-about @form-data)
     #(swap! form-data assoc :hear-about %) true]
    [text-field "" "Referral name" (:referral-name @form-data)
     #(swap! form-data assoc :referral-name %) false]]])

(defn contact-info-section [form-data & {:keys [split-name?]}]
  (if split-name?
    [:div.grid.md:grid-cols-2.gap-6
     [text-field "Your first name" "" (:first-name @form-data)
      #(swap! form-data assoc :first-name %) true]
     [text-field "Your last name" "" (:last-name @form-data)
      #(swap! form-data assoc :last-name %) true]]
    [:div.grid.md:grid-cols-2.gap-6
     [text-field "Your name" "" (:name @form-data) 
      #(swap! form-data assoc :name %) true]
     [text-field "We can email you at" "" (:email @form-data)
      #(swap! form-data assoc :email %) true {:type "email"}]]))

(defn email-section [form-data]
  [:div.grid.md:grid-cols-2.gap-6
   [text-field "Your email address" "" (:email @form-data)
    #(swap! form-data assoc :email %) true {:type "email"}]
   [text-field "Your business Instagram handle" "" (:instagram @form-data)
    #(swap! form-data assoc :instagram %) true]])

(defn instagram-section [form-data]
  [:div
   [text-field "Your business Instagram handle" "" (:instagram @form-data)
    #(swap! form-data assoc :instagram %) true]])

(defn submit-button [form-data & {:keys [on-submit-click]}]
  [:button.w-full.md:w-auto.px-8.py-4.bg-gray-900.text-white.rounded-lg.hover:bg-gray-800.transition-colors.font-medium
   {:type "submit"
    :on-click (or on-submit-click #(swap! form-data assoc :submit-attempted true))
    :style {:font-family "'Special Elite', 'Courier New', monospace"
            :border "2px solid #000"
            :text-transform "uppercase"
            :letter-spacing "0.1em"
            :font-weight "700"}}
   "Submit"])

