(ns fashion-intelligence.components.portfolio-grid
  (:require [reagent.core :as r]
            [fashion-intelligence.data.projects :as data]
            [fashion-intelligence.components.portfolio-card-large :as card]))

(defn projects-grid [projects page-visible-atom]
  (let [hovered-card-idx (r/atom nil)]
    (fn []
      (js/console.log "projects-grid called with" (count projects) "projects, page-visible:" @page-visible-atom)
      [:div.w-full.flex.flex-col.items-center.space-y-0
       (doall
        (for [[idx project] (map-indexed vector projects)]
          (let [colors (data/category-colors (:category project))
                has-images (seq (:images project))
                first-image (first (:images project))
                rotation-angle (if (even? idx) 3 -3)
                base-z-index (+ 150 idx)
                is-hovered (= @hovered-card-idx idx)
                card-z-index (if is-hovered 9999 base-z-index)]
            (js/console.log "Creating card for project:" (:title project))
            ^{:key (str "portfolio-card-" idx "-" (:title project))}
            [:div.w-full.flex.justify-center
             {:class "opacity-100 translate-y-0"
              :style {:transition (str "opacity 0.8s ease " (* idx 0.1) "s, transform 0.8s ease " (* idx 0.1) "s")
                      :position "relative"
                      :z-index card-z-index}}
             [card/project-card-large project colors has-images first-image 
              (fn []) rotation-angle base-z-index
              #(reset! hovered-card-idx (when % idx))]])))])))
