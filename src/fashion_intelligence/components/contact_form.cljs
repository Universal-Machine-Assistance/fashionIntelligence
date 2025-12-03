(ns fashion-intelligence.components.contact-form
  (:require [reagent.core :as r]
            [fashion-intelligence.components.general-form :refer [general-form]]
            [fashion-intelligence.components.intensive-form :refer [intensive-form]]
            [fashion-intelligence.components.contact-form-tabs :refer [tab-navigation]]))

(defn contact-form-component []
  (let [active-tab (r/atom :general)
        general-form-data (r/atom {:help-needed #{}
                                   :submit-attempted false})
        intensive-form-data (r/atom {})]
    (fn []
      [:section.py-20.px-6
       {:style {:background-image "url('/images/paper_texture.jpg')"
                :background-repeat "repeat"
                :background-size "auto"
                :min-height "100vh"}}
       [:div.max-w-4xl.mx-auto
        [tab-navigation active-tab #(reset! active-tab %)]
        [:div.mt-8
         (if (= @active-tab :general)
           [general-form general-form-data]
           [intensive-form intensive-form-data])]]])))
