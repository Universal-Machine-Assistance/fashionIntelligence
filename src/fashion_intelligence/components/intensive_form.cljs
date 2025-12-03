(ns fashion-intelligence.components.intensive-form
  (:require [fashion-intelligence.components.contact-form-fields :refer [textarea-field]]
            [fashion-intelligence.components.contact-form-groups :refer [focus-radio-group]]
            [fashion-intelligence.components.contact-form-sections :refer [referral-section contact-info-section email-section submit-button]]
            [fashion-intelligence.components.contact-form-card :refer [form-card]]))

(defn intensive-form [form-data]
  [:form
   {:on-submit (fn [e]
                 (.preventDefault e)
                 (js/console.log "Form submitted:" @form-data))}
   
   [form-card 0
    [:p.text-gray-700
     {:style {:font-family "'Special Elite', 'Courier New', monospace"}}
     "Sometimes you just know what you want. If it's saving money and time while transforming your business into a unique, trustworthy brand, our Intensive is a no-brainer!"]]
   [form-card 1 [focus-radio-group form-data]]
   [form-card 2
    [:div.grid.md:grid-cols-2.gap-6
     [textarea-field "Tell us a bit about yourself and your business." ""
      (:about @form-data)
      #(swap! form-data assoc :about %) true {:max-length 5000}]
     [textarea-field "What makes you reach out?" ""
      (:reach-out @form-data)
      #(swap! form-data assoc :reach-out %) true {:max-length 5000}]]]
   [form-card 3 [contact-info-section form-data :split-name? true]]
   [form-card 4 [email-section form-data]]
   [form-card 5 [referral-section form-data 
                 :help-text "If someone referred us to you, please also drop their name in the empty field so we know who to thank!"]]
   [form-card 6 [submit-button form-data]]])

