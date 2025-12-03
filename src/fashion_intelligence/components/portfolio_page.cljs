(ns fashion-intelligence.components.portfolio-page
  (:require [reagent.core :as r]
            [fashion-intelligence.data.projects :as data]
            [fashion-intelligence.components.project-detail-section :as detail-section]
            [fashion-intelligence.components.timeline-utils :as utils]
            [fashion-intelligence.components.portfolio-header :as header]
            [fashion-intelligence.components.portfolio-grid :as grid]))

(defn filter-projects [projects category-filter role-filter]
  (filter (fn [project]
            (and
             (or (nil? @category-filter)
                 (= (:category project) @category-filter))
             (or (nil? @role-filter)
                 (= (utils/normalize-role (:role project)) @role-filter))))
          projects))

(defn sort-projects-by-images [projects]
  (sort-by (fn [project]
             (if (seq (:images project))
               0 1))
           projects))

(defn portfolio-page []
  (let [selected-project (r/atom nil)
        selected-category-filter (r/atom nil)
        selected-role-filter (r/atom nil)
        page-visible (r/atom false)
        projects-to-show (r/atom 10)]
    (r/create-class
     {:component-did-mount
      (fn []
        (js/setTimeout #(reset! page-visible true) 100))
      :reagent-render
      (fn []
        (let [all-projects data/projects-data
              filtered-projects (filter-projects all-projects 
                                                 selected-category-filter 
                                                 selected-role-filter)
              sorted-projects (sort-projects-by-images filtered-projects)
              sorted-projects-vec (vec sorted-projects)
              total-count (count sorted-projects-vec)
              displayed-projects (take @projects-to-show sorted-projects-vec)
              has-more (> total-count @projects-to-show)]
          [:div.portfolio-page-container
           {:class "opacity-100"
            :style {:transition "opacity 0.6s ease-in-out"
                    :position "fixed"
                    :top "0"
                    :left "0"
                    :right "0"
                    :bottom "0"
                    :z-index 50
                    :margin-top "0px"
                    :padding-top "80px"
                    :min-height "100vh"
                    :overflow-y "auto"
                    :overflow-x "hidden"}}
           [:div.relative.w-full
            {:style {:background-image "url('/images/paper_texture.jpg')"
                     :background-repeat "repeat"
                     :background-attachment "fixed"
                     :background-size "auto"
                     :padding-bottom "80px"
                     :min-height "100vh"}}
            [:div.w-full.absolute.bottom-0.left-0.right-0.flex.items-end.justify-center
             {:style {:z-index 5
                     :pointer-events "none"
                     :padding-bottom "2rem"}}
             [header/portfolio-header]]
            [:div.w-full.flex.flex-col.items-center
             {:style {:min-height "100vh"
                     :position "relative"
                     :z-index 10
                     :padding-top "0"}}
             (if (zero? total-count)
               [:div.text-center.py-12
                [:p.text-gray-500.text-lg "No hay proyectos en esta categoría."]]
               [:<>
                [grid/projects-grid displayed-projects page-visible]
                (when has-more
                  [:div.w-full.flex.justify-center.my-8
                   {:style {:z-index 200}}
                   [:button.px-8.py-3.bg-gray-900.text-white.rounded-lg.font-medium.hover:bg-gray-800.transition-colors
                    {:type "button"
                     :on-click #(swap! projects-to-show (fn [current] 
                                                           (min total-count (+ current 10))))}
                    "Show More"]])])
             (when @selected-project
               [detail-section/project-detail-section @selected-project #(reset! selected-project nil)])]]
           ]))})))