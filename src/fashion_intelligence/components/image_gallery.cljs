(ns fashion-intelligence.components.image-gallery
  (:require [fashion-intelligence.components.image-viewer :as viewer]))

(defn image-gallery-item [img title idx on-image-click]
  (let [rotation (if (even? idx)
                   (+ -2 (* (js/Math.random) 4))
                   (+ 2 (* (js/Math.random) -4)))]
    [:div.relative.cursor-pointer.group
     {:on-click #(on-image-click idx)
      :style {:transform (str "rotate(" rotation "deg)")
              :transition "transform 0.3s ease-out"
              :margin-bottom "2rem"}}
     [:div.relative.bg-white.shadow-lg
      {:style {:padding "0.75rem 0.75rem 3.5rem 0.75rem"
               :box-shadow "0 4px 6px rgba(0, 0, 0, 0.1), 0 1px 3px rgba(0, 0, 0, 0.08)"
               :width "100%"
               :max-width "300px"
               :margin "0 auto"}}
      [:img.w-full.h-auto.object-cover
       {:src img
        :alt (str title " - Imagen " (inc idx))
        :loading "lazy"
        :style {:display "block"
                :width "100%"
                :height "auto"
                :object-fit "cover"
                :filter "contrast(1.05) brightness(0.98)"}
        :on-load (fn [e]
                   (let [target (.-target e)]
                     (set! (-> target .-style .-display) "block")))
        :on-error (fn [e]
                   (let [target (.-target e)
                         parent (.-parentElement target)]
                     (js/console.error "Failed to load image:" img)
                     (set! (-> parent .-style .-display) "none")))}]
      [:div.absolute.bottom-0.left-0.right-0.px-3.py-2.text-center
       {:style {:background "white"
                :font-family "'Special Elite', 'Courier New', monospace"
                :font-size "0.75rem"
                :color "#333"
                :letter-spacing "0.05em"
                :height "3rem"
                :display "flex"
                :align-items "center"
                :justify-content "center"}}
       [:span.overflow-hidden.text-ellipsis.whitespace-nowrap title]]]
     [:div.absolute.inset-0.pointer-events-none.transition-all.duration-300.flex.items-center.justify-center
      {:style {:background "rgba(0, 0, 0, 0)"}}
      [:div.relative.z-10.text-center.px-4.opacity-0.group-hover:opacity-100.transition-opacity
       {:style {:background "rgba(0, 0, 0, 0.7)"
                :padding "0.5rem 1rem"
                :border-radius "4px"}}
       [:p.text-white.text-xs.font-medium "Click to enlarge"]]]]))

(defn image-gallery [images title selected-image-idx-atom]
  (when (seq images)
    [:div.mt-6
     [:h3.font-serif.text-xl.font-bold.mb-6.text-gray-900 "Galería"]
     [:div.flex.flex-wrap.justify-center.gap-6
      {:style {:gap "1.5rem"}}
      (doall
       (for [[idx img] (map-indexed vector images)]
         ^{:key (str "polaroid-img-" idx "-" img)}
         [:div
          {:style {:flex "0 1 auto"
                   :min-width "200px"
                   :max-width "300px"
                   :width "100%"}}
          [image-gallery-item img title idx #(reset! selected-image-idx-atom %)]]))]
     [viewer/image-viewer-modal selected-image-idx-atom images #(reset! selected-image-idx-atom nil)]]))

