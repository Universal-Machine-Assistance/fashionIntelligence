(ns fashion-intelligence.components.timeline
  (:require [reagent.core :as r]
            [fashion-intelligence.data.projects :as data]
            [fashion-intelligence.components.timeline-utils :as utils]
            [fashion-intelligence.components.project-card :as card]
            [fashion-intelligence.components.project-detail-modal :as modal]
            [fashion-intelligence.components.timeline-filters :as filters]))

(defn filter-projects [projects category-filter role-filter]
  (filter (fn [project]
            (and
             (or (nil? @category-filter)
                 (= (:category project) @category-filter))
             (or (nil? @role-filter)
                 (= (utils/normalize-role (:role project)) @role-filter))))
          projects))

(defn projects-grid [projects selected-project]
  [:div.space-y-0.mb-12
   (for [[idx project] (map-indexed vector projects)]
     (let [colors (data/category-colors (:category project))
           has-images (seq (:images project))
           first-image (first (:images project))
           rotation-angle (if (even? idx) 5 -5)]
       ^{:key (str "project-card-" idx "-" (:title project))}
       [card/project-card project colors has-images first-image 
        #(reset! selected-project project) rotation-angle]))])

(defn timeline-section []
  (let [selected-project (r/atom nil)
        selected-category-filter (r/atom nil)
        selected-role-filter (r/atom nil)
        unique-roles (utils/get-unique-roles)]
    (fn []
      (let [filtered-projects (filter-projects data/projects-data 
                                                selected-category-filter 
                                                selected-role-filter)
            visible-count (count filtered-projects)]
        [:<>
         [:section#portfolio.py-20.px-6
          {:style {:background-image "url('/images/paper_texture.jpg')"
                   :background-repeat "repeat"
                   :background-attachment "fixed"
                   :background-size "auto"}}
          [:div.max-w-7xl.mx-auto
           [:div.text-center.mb-16
            [:h2.font-serif.text-4xl.md:text-5xl.font-bold.mb-6.gradient-text
             "Trayectoria Profesional"]
            [:p.text-lg.text-gray-600.max-w-2xl.mx-auto.font-light.mb-8
             "Una carrera dedicada a la moda, el cine y el retail"]]
           
           [:div.mb-12
            [filters/category-filter-buttons selected-category-filter]
            [filters/role-filter-buttons selected-role-filter unique-roles]]
           
           (when (zero? visible-count)
             [:div.text-center.py-12
              [:p.text-gray-500.text-lg "No hay proyectos en esta categoría."]])
           
           (when (pos? visible-count)
             [projects-grid filtered-projects selected-project])]]
         
         (when @selected-project
           [modal/project-detail-modal selected-project #(reset! selected-project nil)])]))))
