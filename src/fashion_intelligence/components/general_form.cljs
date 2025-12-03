(ns fashion-intelligence.components.general-form
  (:require [fashion-intelligence.components.contact-form-fields :refer [textarea-field]]
            [fashion-intelligence.components.contact-form-groups :refer [help-needed-group budget-radio-group]]
            [fashion-intelligence.components.contact-form-sections :refer [referral-section contact-info-section instagram-section submit-button]]
            [fashion-intelligence.components.contact-form-card :refer [form-card]]))

(defn general-form [form-data]
  [:form
   {:on-submit (fn [e]
                 (.preventDefault e)
                 (js/console.log "Form submitted:" @form-data))}
   
   [form-card 0 [help-needed-group form-data]]
   [form-card 1 [budget-radio-group form-data]]
   [form-card 2
    [:div.grid.md:grid-cols-2.gap-6
     [textarea-field "What makes you reach out?" "" 
      (:reach-out @form-data) 
      #(swap! form-data assoc :reach-out %) true {:max-length 5000}]
     [textarea-field "What draws you to our work?" ""
      (:why-us @form-data)
      #(swap! form-data assoc :why-us %) true {:max-length 5000}]]]
   [form-card 3 [contact-info-section form-data :split-name? false]]
   [form-card 4 [instagram-section form-data]]
   [form-card 5 [referral-section form-data]]
   [form-card 6 [submit-button form-data]]])

