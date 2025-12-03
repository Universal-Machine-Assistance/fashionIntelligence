(ns fashion-intelligence.components.contact-form-card
  (:require [reagent.core :as r]))

(defn form-card [idx child]
  (let [is-visible (r/atom false)
        rotation-angle (if (even? idx) 
                        (+ 1.5 (* (js/Math.random) 1))
                        (- -1.5 (* (js/Math.random) 1)))]
    (r/create-class
     {:component-did-mount
      (fn []
        (js/setTimeout #(reset! is-visible true) (* idx 100)))
      :reagent-render
      (fn []
        [:div.mb-8
         {:style {:opacity (if @is-visible 1 0)
                  :transform (if @is-visible
                              (str "rotate(" rotation-angle "deg) translateY(0)")
                              (str "rotate(" rotation-angle "deg) translateY(30px)"))
                  :transition (str "opacity 0.8s ease " (* idx 0.1) "s, transform 0.8s ease " (* idx 0.1) "s")}}
         [:div.relative.p-8.rounded-lg
          {:style {:border "2px dashed #000"
                   :box-shadow "0 6px 12px rgba(0, 0, 0, 0.15), 0 2px 4px rgba(0, 0, 0, 0.1)"
                   :background-image "url('/images/add_heading.jpg')"
                   :background-size "cover"
                   :background-position "center top"
                   :background-repeat "no-repeat"
                   :font-family "'Special Elite', 'Courier New', monospace"
                   :max-width "100%"
                   :position "relative"}}
          child]])})))
