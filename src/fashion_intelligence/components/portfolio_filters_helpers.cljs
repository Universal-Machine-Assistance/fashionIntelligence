(ns fashion-intelligence.components.portfolio-filters-helpers
  (:require [fashion-intelligence.components.portfolio-filters-constants :as constants]))

(defn calculate-base-rotation [position idx]
  (if (= position :left)
    (if (even? idx) -8 5)
    (if (even? idx) 8 -5)))

(defn calculate-final-offsets [position]
  {:x-offset (if (= position :left) -180 180)
   :rotation (if (= position :left) -45 45)})

(defn calculate-scroll-effects [scroll-offset position]
  {:x-effect (* scroll-offset constants/scroll-effect-multiplier (if (= position :left) -1 1))
   :rotation-effect (* scroll-offset constants/rotation-effect-multiplier (if (= position :left) -1 1))})

(defn calculate-button-position [clicked? final-x-offset scroll-effects base-rotation final-rotation]
  (let [base-x-offset (if clicked? final-x-offset 0)
        x-offset (+ base-x-offset (:x-effect scroll-effects))
        rotation (+ (if clicked? final-rotation base-rotation) (:rotation-effect scroll-effects))]
    {:x-offset x-offset
     :rotation rotation}))

(defn calculate-total-push [time-elapsed scroll-y]
  (let [card-push-effect (min (* @time-elapsed constants/card-push-speed) constants/max-card-push)]
    (+ @scroll-y card-push-effect)))

