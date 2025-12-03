(ns fashion-intelligence.components.image-viewer
  (:require [reagent.core :as r]))

(defn image-viewer-modal [selected-image-idx images on-close]
  (when (and @selected-image-idx (seq images))
    (let [total (count images)
          safe-close (fn [e]
                       (try
                         (when e
                           (.preventDefault e)
                           (.stopPropagation e))
                         (on-close)
                         false
                         (catch js/Error err
                           (js/console.error "Error closing image viewer:" err)
                           (reset! selected-image-idx nil)
                           false)))
          next-img (fn []
                     (let [current-idx @selected-image-idx]
                       (reset! selected-image-idx (mod (inc current-idx) total))))
          prev-img (fn []
                     (let [current-idx @selected-image-idx]
                       (reset! selected-image-idx (mod (dec current-idx) total))))
          handle-keydown (fn [e]
                           (case (.-key e)
                             "ArrowRight" (do (.preventDefault e) (next-img))
                             "ArrowLeft" (do (.preventDefault e) (prev-img))
                             "Escape" (safe-close e)
                             nil))]
      (r/create-class
       {:component-did-mount
        (fn []
          (.addEventListener js/document "keydown" handle-keydown))
        :component-will-unmount
        (fn []
          (.removeEventListener js/document "keydown" handle-keydown))
        :reagent-render
        (fn []
          (let [current-idx @selected-image-idx
                current-img (nth images current-idx)]
            [:div.fixed.inset-0.flex.items-center.justify-center.p-4
             {:style {:background "rgba(0, 0, 0, 0.9)" :backdrop-filter "blur(8px)" :z-index 10000}
              :on-click safe-close
              :tab-index -1}
             [:div.relative.max-w-7xl.w-full.flex.items-center.justify-center
              {:on-click #(.stopPropagation %)
               :style {:max-height "95vh"}}
              (when (> total 1)
                [:button.absolute.left-4.text-white.hover:text-gray-300.transition-colors.w-12.h-12.flex.items-center.justify-center.rounded-full.bg-black.bg-opacity-50.hover:bg-opacity-70
                 {:on-click (fn [e]
                              (.preventDefault e)
                              (.stopPropagation e)
                              (prev-img))
                  :style {:z-index 10001
                         :pointer-events "auto"
                         :cursor "pointer"}}
                 [:svg.w-6.h-6 {:fill "none" :stroke "currentColor" :view-box "0 0 24 24"}
                  [:path {:stroke-linecap "round" :stroke-linejoin "round" :stroke-width "2" :d "M15 19l-7-7 7-7"}]]])
              [:div.relative.bg-white.shadow-2xl.mx-auto
               {:style {:padding "1rem"
                       :box-shadow "0 10px 25px rgba(0, 0, 0, 0.3)"
                       :max-width "90vw"
                       :max-height "90vh"
                       :display "flex"
                       :flex-direction "column"}}
               [:img.w-full.h-auto.object-contain
                {:src current-img
                 :alt (str "Imagen " (inc current-idx) " de " total)
                 :on-click safe-close
                 :class "cursor-zoom-out"
                 :style {:max-height "85vh"
                        :pointer-events "auto"
                        :width "auto"
                        :height "auto"
                        :display "block"}}]]
              (when (> total 1)
                [:button.absolute.right-4.text-white.hover:text-gray-300.transition-colors.w-12.h-12.flex.items-center.justify-center.rounded-full.bg-black.bg-opacity-50.hover:bg-opacity-70
                 {:on-click (fn [e]
                              (.preventDefault e)
                              (.stopPropagation e)
                              (next-img))
                  :style {:z-index 10001
                         :pointer-events "auto"
                         :cursor "pointer"}}
                 [:svg.w-6.h-6 {:fill "none" :stroke "currentColor" :view-box "0 0 24 24"}
                  [:path {:stroke-linecap "round" :stroke-linejoin "round" :stroke-width "2" :d "M9 5l7 7-7 7"}]]])
              [:button.absolute.top-4.right-4.text-white.hover:text-gray-300.transition-colors.w-10.h-10.flex.items-center.justify-center.rounded-full.bg-black.bg-opacity-50.hover:bg-opacity-70
               {:type "button"
                :on-click (fn [e]
                           (when e
                             (.preventDefault e)
                             (.stopPropagation e))
                           (on-close)
                           false)
                :style {:z-index 10001
                       :pointer-events "auto"
                       :cursor "pointer"}}
               [:svg.w-6.h-6 {:fill "none" :stroke "currentColor" :view-box "0 0 24 24"}
                [:path {:stroke-linecap "round" :stroke-linejoin "round" :stroke-width "2" :d "M6 18L18 6M6 6l12 12"}]]]
              (when (> total 1)
                [:div.absolute.bottom-4.text-white.text-sm.bg-black.bg-opacity-50.px-4.py-2.rounded-full
                 {:style {:left "50%" :transform "translateX(-50%)" :z-index 10001}}
                 (str (inc current-idx) " / " total)])]]))}))))