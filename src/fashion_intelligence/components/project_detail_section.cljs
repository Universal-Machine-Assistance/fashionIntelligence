(ns fashion-intelligence.components.project-detail-section
  (:require [reagent.core :as r]
            [fashion-intelligence.data.projects :as data]
            [fashion-intelligence.components.image-gallery :as gallery]))

(defn project-info [project]
  [:div.mb-6.space-y-3
   (when (:director project)
     [:p.text-gray-700.text-lg
      [:span.font-semibold "Director: "] (:director project)])
   (when (:production project)
     [:p.text-gray-700.text-lg
      [:span.font-semibold "Producción: "] (:production project)])
   (when (:photographer project)
     [:p.text-gray-700.text-lg
      [:span.font-semibold "Fotógrafa: "] (:photographer project)])
   (when (:role project)
     [:p.text-gray-600.text-base
      [:span.font-semibold "Rol: "] (:role project)])])

(defn project-detail-section [selected-project on-close]
  (let [selected-image-idx (r/atom nil)]
    (fn []
      (when @selected-project
        (let [project @selected-project
              colors (data/category-colors (:category project))
              images (:images project)]
          (r/create-class
           {:component-did-mount
            (fn []
              (js/setTimeout
               #(let [element (.getElementById js/document "project-detail-section")]
                  (when element
                    (.scrollIntoView element #js {:behavior "smooth" :block "start"})))
               100))
            :reagent-render
            (fn []
              [:section#project-detail-section.min-h-screen.py-20.px-6
               {:style {:background-image "url('/images/paper_texture.jpg')"
                        :background-repeat "repeat"
                        :background-attachment "fixed"
                        :background-size "auto"}}
               [:div.max-w-6xl.mx-auto
                [:div.mb-8
                 [:button.flex.items-center.text-gray-600.hover:text-gray-900.transition-colors.mb-6
                  {:on-click on-close}
                  [:svg.w-5.h-5.mr-2 {:fill "none" :stroke "currentColor" :view-box "0 0 24 24"}
                   [:path {:stroke-linecap "round" :stroke-linejoin "round" :stroke-width "2" :d "M15 19l-7-7 7-7"}]]
                  "Volver al Portfolio"]]
                
                [:div.bg-white.rounded-2xl.shadow-xl.p-8.mb-8
                 [:div.flex.flex-col.md:flex-row.items-start.gap-6
                  (when (seq images)
                    [:div.flex-shrink-0.w-full
                     {:class "md:w-1/2"}
                     [:img.w-full.h-auto.rounded-lg.shadow-lg
                      {:src (first images)
                       :alt (:title project)
                       :loading "lazy"}]])
                  [:div.flex-1
                   [:span.text-xs.font-semibold.uppercase.tracking-wide.px-3.py-1.rounded-full.inline-block.mb-4
                    {:class (:badge colors)}
                    (data/category-names (:category project))]
                   [:h1.font-serif.text-4xl.md:text-5xl.font-bold.mb-4.text-gray-900
                    (:title project)]
                   [:p.text-xl.text-gray-600.mb-6
                    (:year project)]
                   [project-info project]]]]
                
                (when (seq images)
                  [:div.bg-white.rounded-2xl.shadow-xl.p-8
                   [gallery/image-gallery images (:title project) selected-image-idx]])]])}))))))

