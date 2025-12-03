(ns fashion-intelligence.components.portfolio-filters-button
  (:require [fashion-intelligence.components.portfolio-filters-constants :as constants]
            [fashion-intelligence.components.portfolio-filters-helpers :as helpers]))

(defn button-style [idx x-offset rotation is-selected?]
  {:left "50%"
   :top (str (+ constants/base-top-offset (* idx constants/button-spacing)) "px")
   :transform (str "translateX(calc(-50% + " x-offset "px)) rotate(" rotation "deg)")
   :z-index 10000
   :padding "12px 24px 12px 16px"
   :background (if is-selected? "#000" "#fefefe")
   :color (if is-selected? "#fff" "#000")
   :border "2px solid #000"
   :font-family "'Special Elite', 'Courier New', monospace"
   :font-size "0.75rem"
   :font-weight "700"
   :letter-spacing "0.12em"
   :text-transform "uppercase"
   :box-shadow "3px 3px 6px rgba(0, 0, 0, 0.2)"
   :clip-path "polygon(0% 0%, calc(100% - 12px) 0%, 100% 50%, calc(100% - 12px) 100%, 0% 100%)"
   :transition "transform 0.3s ease-out"
   :white-space "nowrap"
   :pointer-events "auto"
   :cursor "pointer"})

(defn handle-hover-enter [x-offset rotation]
  (fn [e]
    (let [target (.-target e)]
      (set! (-> target .-style .-transform)
            (str "translateX(calc(-50% + " x-offset "px)) rotate(" (+ rotation 3) "deg) scale(1.1)"))
      (set! (-> target .-style .-boxShadow)
            "4px 4px 8px rgba(0, 0, 0, 0.3)"))))

(defn handle-hover-leave [x-offset rotation]
  (fn [e]
    (let [target (.-target e)]
      (set! (-> target .-style .-transform)
            (str "translateX(calc(-50% + " x-offset "px)) rotate(" rotation "deg) scale(1)"))
      (set! (-> target .-style .-boxShadow)
            "3px 3px 6px rgba(0, 0, 0, 0.2)"))))

(defn cloth-tag-button [label is-selected? on-click position idx scroll-offset]
  (fn []
    (let [scroll-effects (helpers/calculate-scroll-effects scroll-offset position)
            ;; Start at center (0), move out based on scroll
            base-x-offset 0
            x-offset (+ base-x-offset (:x-effect scroll-effects))
            ;; Start vertical (0), rotate based on scroll/time
            base-rotation 0
            rotation (+ base-rotation (:rotation-effect scroll-effects))]
        [:button.absolute.cursor-pointer
         {:style (merge (button-style idx x-offset rotation is-selected?)
                       {:pointer-events "auto"})
          :on-click (fn [e]
                      (.preventDefault e)
                      (.stopPropagation e)
                      (on-click))
          :on-mouse-enter (handle-hover-enter x-offset rotation)
          :on-mouse-leave (handle-hover-leave x-offset rotation)}
         [:span label]])))

