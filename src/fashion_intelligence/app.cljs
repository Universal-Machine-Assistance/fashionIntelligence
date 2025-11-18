(ns fashion-intelligence.app
  (:require
   [fashion-intelligence.components.hero :refer [hero-component]]
   [fashion-intelligence.components.problem :refer [problem-section]]
   [fashion-intelligence.components.solution :refer [solution-section]]
   [fashion-intelligence.components.services :refer [services-section]]
   [fashion-intelligence.components.differentiators :refer [differentiators-section]]
   [fashion-intelligence.components.methodology :refer [methodology-section]]
   [fashion-intelligence.components.about :refer [about-section]]
   [fashion-intelligence.components.clients :refer [clients-section]]
   [fashion-intelligence.components.target-audience :refer [target-audience-section]]
   [fashion-intelligence.components.brand-promise :refer [brand-promise-section]]
   [fashion-intelligence.components.evidence :refer [evidence-section]]
   [fashion-intelligence.components.cta :refer [cta-section]]
   [fashion-intelligence.components.footer :refer [footer-component]]))

(defn app []
  [:div.font-sans.text-gray-800.antialiased.bg-white
   [hero-component]
   [problem-section]
   [solution-section]
   [services-section]
   [differentiators-section]
   [methodology-section]
   [about-section]
   [clients-section]
   [target-audience-section]
   [brand-promise-section]
   [evidence-section]
   [cta-section]
   [footer-component]])

