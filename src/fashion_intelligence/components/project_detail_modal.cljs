(ns fashion-intelligence.components.project-detail-modal
  (:require [reagent.core :as r]
            [fashion-intelligence.data.projects :as data]
            [fashion-intelligence.components.image-gallery :as gallery]))

(defn project-info [project]
  [:div.mb-6.space-y-2
   (when (:director project)
     [:p.text-gray-700
      [:span.font-semibold "Director: "] (:director project)])
   (when (:production project)
     [:p.text-gray-700
      [:span.font-semibold "Producción: "] (:production project)])
   (when (:photographer project)
     [:p.text-gray-700
      [:span.font-semibold "Fotógrafa: "] (:photographer project)])
   (when (:role project)
     [:p.text-gray-600.text-sm
      [:span.font-semibold "Rol: "] (:role project)])])

(defn project-detail-modal [selected-project on-close]
  (let [selected-image-idx (r/atom nil)]
    (fn []
      (when @selected-project
        (let [project @selected-project
              colors (data/category-colors (:category project))
              images (:images project)]
          [:div.fixed.inset-0.z-50.flex.items-center.justify-center.p-4.overflow-y-auto
           {:style {:background "rgba(0, 0, 0, 0.4)" :backdrop-filter "blur(4px)"}
            :on-click on-close}
           [:div.relative.max-w-6xl.w-full.bg-white.rounded-2xl.shadow-xl.my-8.overflow-hidden.flex.flex-col
            {:on-click #(.stopPropagation %)
             :class "animate-fade-in"
             :style {:max-height "90vh"}}
            [:div.flex-shrink-0.p-6.border-b.border-gray-200.bg-gray-50
             [:div.flex.items-center.justify-between
              [:div.flex-1
               [:span.text-xs.font-semibold.uppercase.tracking-wide.px-3.py-1.rounded-full
                {:class (:badge colors)}
                (data/category-names (:category project))]
               [:h2.font-serif.text-2xl.md:text-3xl.font-bold.mt-3.text-gray-900 (:title project)]
               [:p.text-sm.text-gray-600.mt-1 (:year project)]]
              [:button.text-gray-400.hover:text-gray-600.transition-colors.w-8.h-8.flex.items-center.justify-center.rounded-full.hover:bg-gray-200
               {:on-click on-close}
               [:svg.w-5.h-5 {:fill "none" :stroke "currentColor" :view-box "0 0 24 24"}
                [:path {:stroke-linecap "round" :stroke-linejoin "round" :stroke-width "2" :d "M6 18L18 6M6 6l12 12"}]]]]]
            [:div.flex-1.overflow-y-auto.p-6
             [project-info project]
             [gallery/image-gallery images (:title project) selected-image-idx]]]])))))

