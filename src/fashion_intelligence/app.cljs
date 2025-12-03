(ns fashion-intelligence.app
  (:require
   [reagent.core :as r]
   [fashion-intelligence.routes :refer [current-route]]
   [fashion-intelligence.components.navigation :refer [navigation-component]]
   [fashion-intelligence.components.hero :refer [hero-component]]
   [fashion-intelligence.components.problem :refer [problem-section]]
   [fashion-intelligence.components.solution :refer [solution-section]]
   [fashion-intelligence.components.services :refer [services-section]]
   [fashion-intelligence.components.personal-services :refer [personal-services-section]]
   [fashion-intelligence.components.methodology :refer [methodology-section]]
   [fashion-intelligence.components.about :refer [about-section]]
   [fashion-intelligence.components.clients :refer [clients-section]]
   [fashion-intelligence.components.target-audience :refer [target-audience-section]]
   [fashion-intelligence.components.brand-promise :refer [brand-promise-section]]
   [fashion-intelligence.components.evidence :refer [evidence-section]]
   [fashion-intelligence.components.cta :refer [cta-section]]
   [fashion-intelligence.components.footer :refer [footer-component]]
   [fashion-intelligence.components.portfolio-page :refer [portfolio-page]]
   [fashion-intelligence.components.portfolio-project-page :refer [portfolio-project-page]]
   [fashion-intelligence.components.contact-page :refer [contact-page]]
   [fashion-intelligence.components.floating-contact-button :refer [floating-contact-button]]))

(defn home-page []
  [:div
   [:div#home
    [hero-component]]
   [:div#approach
    [solution-section]
    [problem-section]]
   [:div#services
    [services-section]
    [methodology-section]]
   [about-section]
   [clients-section]
   [target-audience-section]
   [brand-promise-section]
   [evidence-section]
   [:div#contact
    [cta-section]
    [personal-services-section]]
   [:div#inquire
    [footer-component]]])

(defn app []
  (let [page-transitioning (r/atom false)]
    (fn []
      [:div.font-sans.text-gray-800.antialiased
       [navigation-component]
       [:div.page-container
        {:class (if @page-transitioning "transitioning" "")
         :style {:transition "opacity 0.4s ease-in-out, transform 0.4s ease-in-out"}}
        (case @current-route
          :portfolio-project [portfolio-project-page]
          :portfolio [portfolio-page]
          :contact [contact-page]
          :home [home-page]
          [home-page])]
       (when (not= @current-route :contact)
         [floating-contact-button])])))

