(ns fashion-intelligence.components.contact-form-tabs)

(defn tab-button [active? label on-click]
  [:button.relative.cursor-pointer.transition-all.duration-300
   {:style {:padding "14px 28px 16px 28px"
            :font-family "'Special Elite', 'Courier New', monospace"
            :font-size "0.875rem"
            :font-weight "700"
            :letter-spacing "0.05em"
            :text-transform "uppercase"
            :color (if active? "#000" "#666")
            :background-image "url('/images/add_heading.jpg')"
            :background-size "cover"
            :background-position "center"
            :background-repeat "no-repeat"
            :background-color (if active? "rgba(255, 255, 255, 0.95)" "rgba(245, 245, 245, 0.9)")
            :background-blend-mode "overlay"
            :border "2px solid #000"
            :border-bottom "none"
            :clip-path "polygon(0% 0%, calc(100% - 24px) 0%, calc(100% - 12px) 8px, 100% 8px, 100% 100%, 0% 100%)"
            :box-shadow (if active?
                         "0 -4px 8px rgba(0, 0, 0, 0.25), inset 0 1px 0 rgba(255, 255, 255, 0.9), 0 2px 4px rgba(0, 0, 0, 0.1)"
                         "0 -2px 4px rgba(0, 0, 0, 0.1)")
            :transform (if active? "translateY(-3px)" "translateY(0)")
            :z-index (if active? 10 5)
            :position "relative"
            :margin-right "8px"
            :white-space "nowrap"}
    :on-click on-click
    :on-mouse-enter #(when-not active?
                      (set! (-> % .-target .-style .-transform) "translateY(-1px)")
                      (set! (-> % .-target .-style .-boxShadow) "0 -3px 6px rgba(0, 0, 0, 0.15)"))
    :on-mouse-leave #(when-not active?
                      (set! (-> % .-target .-style .-transform) "translateY(0)")
                      (set! (-> % .-target .-style .-boxShadow) "0 -2px 4px rgba(0, 0, 0, 0.1)"))}
   [:span {:style {:position "relative"
                   :z-index 1
                   :text-shadow (if active? "none" "0 1px 2px rgba(255, 255, 255, 0.8)")}} label]
   (when active?
     [:div.absolute
      {:style {:bottom "-2px"
              :left "0"
              :right "0"
              :height "2px"
              :background "transparent"
              :z-index 11}}])])

(defn tab-navigation [active-tab on-tab-change]
  [:div.relative.mb-8
   {:style {:border-bottom "2px solid #000"
            :padding-bottom "0"
            :position "relative"}}
   [:div.flex
    {:style {:position "relative"
             :z-index 1}}
    [tab-button (= @active-tab :general) "General project" #(on-tab-change :general)]
    [tab-button (= @active-tab :intensive) "Design Intensive" #(on-tab-change :intensive)]]])

