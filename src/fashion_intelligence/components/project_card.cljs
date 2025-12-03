(ns fashion-intelligence.components.project-card
  (:require [fashion-intelligence.data.projects :as data]))

(defn project-card [project colors has-images first-image on-click rotation-angle]
  [:div.relative.w-full.overflow-hidden.cursor-pointer.group.mb-12
   {:class "rounded-lg transition-all duration-300 hover:scale-[1.02] shadow-xl"
    :style {:transform (str "rotate(" rotation-angle "deg)")
            :transition "transform 0.3s ease, box-shadow 0.3s ease"
            :height "500px"}
    :on-click (when has-images on-click)}
   (if first-image
     [:div.relative.w-full.h-full
      [:img.w-full.h-full.object-cover
       {:src first-image
        :alt (:title project)
        :loading "lazy"
        :style {:min-height "500px"}}]
      [:div.absolute.inset-0.bg-gradient-to-t.from-black.via-transparent.to-transparent.opacity-60.group-hover:opacity-70.transition-opacity]
      [:div.absolute.bottom-0.left-0.right-0.p-8.text-white
       [:div.mb-3
        [:span.text-sm.font-semibold.uppercase.tracking-wide.px-3.py-1.5.rounded
         {:class (:badge colors)}
         (data/category-names (:category project))]]
       [:h3.text-2xl.md:text-3xl.font-serif.font-bold.mb-2
        (:title project)]
       [:p.text-base.text-gray-200.mb-2
        (str (:year project) " • " (:role project))]
       (when (:client project)
         [:p.text-sm.text-gray-300
          (:client project)])]]
     [:div.relative.w-full.h-full.flex.items-center.justify-center.bg-white.border-2.border-gray-200.shadow-lg
      {:style {:min-height "500px"}}
      [:div.text-center.p-8
       [:span.text-sm.font-semibold.uppercase.tracking-wide.px-3.py-1.5.rounded.mb-4.inline-block
        {:class (:badge colors)}
        (data/category-names (:category project))]
       [:h3.text-2xl.md:text-3xl.font-serif.font-bold.mb-3
        (:title project)]
       [:p.text-base.text-gray-600.mb-2
        (str (:year project) " • " (:role project))]
       (when (:client project)
         [:p.text-sm.text-gray-500
          (:client project)])]])])

