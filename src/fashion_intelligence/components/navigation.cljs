(ns fashion-intelligence.components.navigation
  (:require [reagent.core :as r]
            [fashion-intelligence.routes :refer [current-route navigate-to]]))

(defn scroll-to-section [section-id]
  (fn [e]
    (.preventDefault e)
    (let [element (.getElementById js/document section-id)]
      (when element
        (.scrollIntoView element #js {:behavior "smooth"})))))

(defn handle-portfolio-click [e]
  (.preventDefault e)
  (navigate-to :portfolio))

(defn handle-home-click [e]
  (.preventDefault e)
  (navigate-to :home)
  (js/setTimeout 
   (fn []
     (let [element (.getElementById js/document "home")]
       (when element
         (.scrollIntoView element #js {:behavior "smooth"}))))
   100))

(defn handle-home-click-mobile [menu-open-atom]
  (fn [e]
    (reset! menu-open-atom false)
    (handle-home-click e)))

(defn navigation-component []
  (let [menu-open (r/atom false)]
    (fn []
      [:nav.fixed.top-0.left-0.right-0.z-100.bg-white.bg-opacity-95.backdrop-blur-sm.border-b.border-gray-200
       {:style {:z-index 90
                :pointer-events "auto"}}
       [:div.max-w-7xl.mx-auto.px-6
        [:div.flex.items-center.justify-between.h-16
         [:a.text-xl.font-serif.font-bold.text-gray-900.hover:text-gray-700.transition-colors
          {:href "#home"
           :on-click handle-home-click}
          "Natalie Rodríguez"]
         
         [:div.hidden.md:flex.items-center.space-x-8
          [:a.text-sm.font-medium.text-gray-700.hover:text-gray-900.transition-colors
           {:href "#home"
            :on-click handle-home-click
            :class (when (= @current-route :home) "font-bold text-gray-900")}
           "Home"]
          [:a.text-sm.font-medium.text-gray-700.hover:text-gray-900.transition-colors
           {:href "#approach"
            :on-click (scroll-to-section "approach")}
           "Approach"]
          [:a.text-sm.font-medium.text-gray-700.hover:text-gray-900.transition-colors
           {:href "#services"
            :on-click (scroll-to-section "services")}
           "Services"]
          [:a.text-sm.font-medium.text-gray-700.hover:text-gray-900.transition-colors
           {:href "/portfolio"
            :on-click handle-portfolio-click
            :class (when (= @current-route :portfolio) "font-bold text-gray-900")}
           "Portfolio"]
          [:div.flex.items-center.space-x-4.ml-4.pl-4.border-l.border-gray-300
           [:a.text-sm.font-medium.text-gray-700.hover:text-gray-900.transition-colors
            {:href "/contact"
             :on-click (fn [e]
                        (.preventDefault e)
                        (navigate-to :contact))
             :class (when (= @current-route :contact) "font-bold text-gray-900")}
            "Contact"]
           [:a.text-sm.font-medium.text-gray-900.bg-gray-900.text-white.px-4.py-2.rounded.hover:bg-gray-800.transition-colors
            {:href "#inquire"
             :on-click (scroll-to-section "inquire")}
            "Inquire"]]]
         
         [:button.md:hidden.text-gray-700.hover:text-gray-900
          {:on-click #(swap! menu-open not)}
          [:svg.w-6.h-6 {:fill "none" :stroke "currentColor" :view-box "0 0 24 24"}
           [:path {:stroke-linecap "round" :stroke-linejoin "round" :stroke-width "2" :d "M4 6h16M4 12h16M4 18h16"}]]]
         
         (when @menu-open
           [:div.absolute.top-16.left-0.right-0.bg-white.border-b.border-gray-200.shadow-lg.md:hidden
            [:div.px-6.py-4.space-y-4
             [:a.block.text-sm.font-medium.text-gray-700.hover:text-gray-900.transition-colors
              {:href "#home"
               :on-click (handle-home-click-mobile menu-open)
               :class (when (= @current-route :home) "font-bold text-gray-900")}
              "Home"]
             [:a.block.text-sm.font-medium.text-gray-700.hover:text-gray-900.transition-colors
              {:href "#approach"
               :on-click #(do (reset! menu-open false) ((scroll-to-section "approach") %))}
              "Approach"]
             [:a.block.text-sm.font-medium.text-gray-700.hover:text-gray-900.transition-colors
              {:href "#services"
               :on-click #(do (reset! menu-open false) ((scroll-to-section "services") %))}
              "Services"]
             [:a.block.text-sm.font-medium.text-gray-700.hover:text-gray-900.transition-colors
              {:href "/portfolio"
               :on-click #(do (reset! menu-open false) (handle-portfolio-click %))
               :class (when (= @current-route :portfolio) "font-bold text-gray-900")}
              "Portfolio"]
             [:a.block.text-sm.font-medium.text-gray-700.hover:text-gray-900.transition-colors
              {:href "/contact"
               :on-click #(do (reset! menu-open false) 
                             (.preventDefault %)
                             (navigate-to :contact))
               :class (when (= @current-route :contact) "font-bold text-gray-900")}
              "Contact"]
             [:a.block.text-sm.font-medium.text-gray-900.bg-gray-900.text-white.px-4.py-2.rounded.text-center.hover:bg-gray-800.transition-colors
              {:href "#inquire"
               :on-click #(do (reset! menu-open false) ((scroll-to-section "inquire") %))}
              "Inquire"]]])]]])))

