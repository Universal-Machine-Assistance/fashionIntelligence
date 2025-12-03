(ns fashion-intelligence.components.floating-contact-button
  (:require [fashion-intelligence.routes :refer [navigate-to]]))

(defn floating-contact-button []
  [:a.fixed.bottom-6.right-6.transition-all.duration-300
   {:href "/contact"
    :on-click (fn [e]
                (.preventDefault e)
                (navigate-to :contact))
    :style {:z-index 9999
            :width "70px"
            :height "70px"}
    :class "hover:scale-110 hover:shadow-lg md:bottom-8 md:right-8"}
   [:div.relative.w-full.h-full
    {:style {:cursor "pointer"}}
    [:img.w-full.h-full.object-contain.transition-transform.duration-300
     {:src "/images/Moon.png"
      :alt "Contact"
      :loading "lazy"
      :class "hover:rotate-12"
      :style {:filter "drop-shadow(0 4px 8px rgba(0, 0, 0, 0.2))"}}]]])

