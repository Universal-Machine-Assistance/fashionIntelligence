(ns fashion-intelligence.components.contact-page
  (:require [fashion-intelligence.components.contact-hero :refer [contact-hero-section]]
            [fashion-intelligence.components.contact-form :refer [contact-form-component]]
            [fashion-intelligence.components.footer :refer [footer-component]]))

(defn contact-page []
  [:div
   [:div#contact-form
    [contact-hero-section]
    [contact-form-component]]
   [footer-component]])

