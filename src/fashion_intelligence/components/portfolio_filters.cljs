(ns fashion-intelligence.components.portfolio-filters
  (:require [reagent.core :as r]
            [fashion-intelligence.components.portfolio-filters-button :refer [cloth-tag-button]]
            [fashion-intelligence.components.portfolio-filters-constants :refer [filter-buttons-config]]
            [fashion-intelligence.components.portfolio-filters-helpers :refer [calculate-total-push]]
            [fashion-intelligence.components.portfolio-filters-scroll :refer [initialize-container]]))

(defn setup-scroll-tracking [container-ref scroll-y time-elapsed cleanup-fn animation-interval force-update attempts-left]
  (let [container (.querySelector js/document ".portfolio-page-container")]
      (if container
        (initialize-container container-ref scroll-y time-elapsed cleanup-fn animation-interval force-update)
      (when (pos? attempts-left)
        (js/setTimeout #(setup-scroll-tracking container-ref scroll-y time-elapsed cleanup-fn animation-interval force-update (dec attempts-left)) 100)))))

(defn category-filter-buttons [selected-category-filter]
  (let [scroll-y (r/atom 0)
        time-elapsed (r/atom 0)
        container-ref (r/atom nil)
        cleanup-fn (r/atom nil)
        animation-interval (r/atom nil)
        force-update (r/atom 0)]
    (r/create-class
     {:component-did-mount
      (fn []
        (setup-scroll-tracking container-ref scroll-y time-elapsed cleanup-fn animation-interval force-update 50))
      :component-will-unmount
      (fn []
        (when @cleanup-fn
          (@cleanup-fn))
        (when @animation-interval
          (js/clearInterval @animation-interval)))
      :reagent-render
      (fn []
        ;; Read atoms to make component reactive to their changes
        (let [_scroll @scroll-y
              _time @time-elapsed
              _update @force-update
              total-push (calculate-total-push time-elapsed scroll-y)]
          [:div.relative.w-full.mb-12
           {:style {:min-height "280px"
                    :position "relative"
                    :pointer-events "none"
                    :z-index 10000}}
           ;; Thread connecting all buttons - vertical dashed line
           [:div.absolute
            {:style {:left "50%"
                     :top (str (+ 80 20) "px")
                     :width "2px"
                     :height (str (* (dec (count filter-buttons-config)) 70) "px")
                     :transform "translateX(-50%)"
                     :z-index 9999
                     :pointer-events "none"
                     :background "repeating-linear-gradient(to bottom, #000 0px, #000 4px, transparent 4px, transparent 8px)"
                     :opacity "0.4"}}]
           (doall
            (for [{:keys [label position idx filter-value]} filter-buttons-config]
              ^{:key label}
              [cloth-tag-button label
               (= @selected-category-filter filter-value)
               (fn []
                 (if (= @selected-category-filter filter-value)
                   (reset! selected-category-filter nil)
                   (reset! selected-category-filter filter-value)))
               position
               idx
               total-push]))]))})))
