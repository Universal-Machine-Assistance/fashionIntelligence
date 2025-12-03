(ns fashion-intelligence.components.contact-form-fields)

(defn text-field [label placeholder value on-change required? & {:keys [type max-length]}]
  [:div.mb-6
   [:label.block.text-sm.font-medium.text-gray-900.mb-2
    {:style {:font-family "'Special Elite', 'Courier New', monospace"}}
    (when required? [:span.text-red-500 "* "])
    label]
   [:input.w-full.px-4.py-3.border.border-gray-900.rounded.focus:outline-none.focus:ring-2.focus:ring-gray-900.focus:border-gray-900
    {:type (or type "text")
     :placeholder placeholder
     :value (or value "")
     :on-change #(on-change (-> % .-target .-value))
     :required required?
     :max-length max-length
     :style {:font-family "'Special Elite', 'Courier New', monospace"
             :border-style "dashed"
             :border-width "1px"}}]])

(defn textarea-field [label placeholder value on-change required? & {:keys [max-length rows]}]
  [:div.mb-6
   [:label.block.text-sm.font-medium.text-gray-900.mb-2
    {:style {:font-family "'Special Elite', 'Courier New', monospace"}}
    (when required? [:span.text-red-500 "* "])
    label]
   [:textarea.w-full.px-4.py-3.border.border-gray-900.rounded.focus:outline-none.focus:ring-2.focus:ring-gray-900.focus:border-gray-900.resize-none
    {:placeholder placeholder
     :value (or value "")
     :on-change #(on-change (-> % .-target .-value))
     :required required?
     :max-length max-length
     :rows (or rows 4)
     :style {:font-family "'Special Elite', 'Courier New', monospace"
             :border-style "dashed"
             :border-width "1px"}}]])

(defn checkbox-field [label _value checked? on-change]
  [:label.flex.items-center.mb-4.cursor-pointer
   {:style {:font-family "'Special Elite', 'Courier New', monospace"}}
   [:input.mr-3.w-5.h-5.text-gray-900.border-gray-900.rounded.focus:ring-gray-900
    {:type "checkbox"
     :checked checked?
     :on-change #(on-change (-> % .-target .-checked))
     :style {:border-width "2px"
             :accent-color "#000"}}]
   [:span.text-gray-900 label]])

(defn radio-field [label name value checked? on-change]
  [:label.flex.items-center.mb-4.cursor-pointer
   {:style {:font-family "'Special Elite', 'Courier New', monospace"}}
   [:input.mr-3.w-5.h-5.text-gray-900.border-gray-900.focus:ring-gray-900
    {:type "radio"
     :name name
     :value value
     :checked checked?
     :on-change #(on-change value)
     :style {:border-width "2px"
             :accent-color "#000"}}]
   [:span.text-gray-900 label]])

(defn select-field [label options value on-change required?]
  [:div.mb-6
   [:label.block.text-sm.font-medium.text-gray-900.mb-2
    {:style {:font-family "'Special Elite', 'Courier New', monospace"}}
    (when required? [:span.text-red-500 "* "])
    label]
   [:select.w-full.px-4.py-3.border.border-gray-900.rounded.focus:outline-none.focus:ring-2.focus:ring-gray-900.focus:border-gray-900
    {:value (or value "")
     :on-change #(on-change (-> % .-target .-value))
     :required required?
     :style {:font-family "'Special Elite', 'Courier New', monospace"
             :border-style "dashed"
             :border-width "1px"}}
    (for [option options]
      ^{:key option}
      [:option {:value (if (map? option) (:value option) option)
                :style {:font-family "'Special Elite', 'Courier New', monospace"}}
       (if (map? option) (:label option) option)])]])

