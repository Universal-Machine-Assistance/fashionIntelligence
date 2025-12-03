(ns fashion-intelligence.components.portfolio-card-large
  (:require [fashion-intelligence.data.projects :as data]
            [fashion-intelligence.routes :as routes]
            [reagent.core :as r]))

(defn project-card-large [project _colors _has-images first-image _on-click rotation-angle _base-z-index on-hover-change]
  (let [project-slug (routes/title-to-slug (:title project))
        is-hovered (r/atom false)
        is-transitioning (r/atom false)
        handle-click (fn [e]
                       (.preventDefault e)
                       (reset! is-transitioning true)
                       (js/setTimeout
                        (fn []
                          (routes/navigate-to :portfolio-project project-slug))
                        300))
        handle-mouse-enter (fn []
                            (reset! is-hovered true)
                            (when on-hover-change (on-hover-change true)))
        handle-mouse-leave (fn []
                            (reset! is-hovered false)
                            (when on-hover-change (on-hover-change false)))]
    (fn []
      (let [transform (if @is-hovered
                       (str "rotate(" rotation-angle "deg) scale(1.08)")
                       (str "rotate(" rotation-angle "deg) scale(1)"))
            shadow (if @is-hovered
                    "0 35px 60px -12px rgba(0, 0, 0, 0.35), 0 0 0 1px rgba(0, 0, 0, 0.1)"
                    "0 25px 50px -12px rgba(0, 0, 0, 0.25), 0 0 0 1px rgba(0, 0, 0, 0.05)")
            opacity (if @is-transitioning 0 1)
            transition-scale (if @is-transitioning 1.2 1)
            final-transform (if @is-transitioning
                             (str "rotate(" rotation-angle "deg) scale(" transition-scale ")")
                             transform)]
        [:a.relative.mx-auto.overflow-hidden.cursor-pointer.group.mb-16.block
         {:href (str "/portfolio/" project-slug)
          :on-click handle-click
          :on-mouse-enter handle-mouse-enter
          :on-mouse-leave handle-mouse-leave
          :class "rounded-lg shadow-2xl"
          :style {:transform final-transform
                  :opacity opacity
                  :transition "transform 0.4s cubic-bezier(0.4, 0, 0.2, 1), box-shadow 0.4s cubic-bezier(0.4, 0, 0.2, 1), opacity 0.3s ease-out"
                  :width "33.333%"
                  :min-width "280px"
                  :max-width "400px"
                  :aspect-ratio "3/4"
                  :background "white"
                  :padding "12px"
                  :box-shadow shadow
                  :position "relative"
                  :text-decoration "none"}}
     (if first-image
       [:div.relative.w-full.h-full.flex.flex-col
        [:div.flex-1.overflow-hidden.rounded-sm
         {:style {:aspect-ratio "4/5"
                  :filter "contrast(1.1) brightness(0.95) saturate(0.9)"}}
         [:img.w-full.h-full.object-cover
          {:src first-image
           :alt (:title project)
           :loading "lazy"
           :style {:mix-blend-mode "multiply"}}]]
        [:div.relative.flex.flex-col.justify-end.mt-2.px-2.pb-2
         {:style {:min-height "80px"
                  :background "rgba(255, 255, 255, 0.95)"
                  :border-top "2px dashed #000"
                  :border-right "none"
                  :border-bottom "none"
                  :border-left "none"}}
         [:div.mb-2
          [:span.text-xs.font-bold.uppercase.tracking-wider.px-2.py-1.inline-block
           {:class "handmade-label"
            :style {:font-family "'Special Elite', 'Courier New', monospace"
                   :color "#000"
                   :background "transparent"
                   :border "1px solid #000"
                   :transform "rotate(-1deg)"
                   :letter-spacing "0.1em"
                   :text-transform "uppercase"}}
           (data/category-names (:category project))]]
         [:h3.text-lg.font-bold.mb-1.line-clamp-2
          {:class "typewriter-text"
           :style {:font-family "'Special Elite', 'Courier New', monospace"
                  :color "#000"
                  :font-weight "700"
                  :letter-spacing "0.05em"}}
          (:title project)]
         [:p.text-xs.mb-1
          {:class "typewriter-text"
           :style {:font-family "'Special Elite', 'Courier New', monospace"
                  :color "#000"
                  :font-weight "400"}}
          (str (:year project) " • " (:role project))]
         (when (:client project)
           [:p.text-xs.line-clamp-1
            {:class "typewriter-text"
             :style {:font-family "'Special Elite', 'Courier New', monospace"
                    :color "#333"}}
            (:client project)])]]
       [:div.relative.w-full.h-full.flex.flex-col.items-center.justify-center.bg-gray-50.border-2.border-gray-900.rounded-sm
        {:style {:border-style "dashed"}}
        [:div.text-center.p-6
         [:span.text-xs.font-bold.uppercase.tracking-wider.px-3.py-1.inline-block.mb-3
          {:class "handmade-label"
           :style {:font-family "'Special Elite', 'Courier New', monospace"
                  :color "#000"
                  :background "transparent"
                  :border "1px solid #000"
                  :transform "rotate(-1deg)"
                  :letter-spacing "0.1em"}}
          (data/category-names (:category project))]
         [:h3.text-xl.font-bold.mb-2
          {:class "typewriter-text"
           :style {:font-family "'Special Elite', 'Courier New', monospace"
                  :color "#000"
                  :font-weight "700"}}
          (:title project)]
         [:p.text-sm.mb-2
          {:class "typewriter-text"
           :style {:font-family "'Special Elite', 'Courier New', monospace"
                  :color "#000"}}
          (str (:year project) " • " (:role project))]
         (when (:client project)
           [:p.text-xs
            {:class "typewriter-text"
             :style {:font-family "'Special Elite', 'Courier New', monospace"
                    :color "#333"}}
            (:client project)])]])]))))

