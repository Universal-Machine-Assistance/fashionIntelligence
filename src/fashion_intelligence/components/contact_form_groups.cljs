(ns fashion-intelligence.components.contact-form-groups
  (:require [fashion-intelligence.components.contact-form-fields :refer [checkbox-field radio-field]]))

(defn help-needed-checkbox [form-data key label]
  [checkbox-field label nil
   (contains? (:help-needed @form-data) key)
   #(swap! form-data update :help-needed 
           (fn [set] (if % (conj (or set #{}) key)
                         (disj (or set #{}) key))))])

(defn help-needed-group [form-data]
  [:div
   [:label.block.text-sm.font-medium.text-gray-900.mb-3
    {:style {:font-family "'Special Elite', 'Courier New', monospace"}}
    [:span.text-red-500 "* "] "Select all that you need help with:"]
   [:div.space-y-2
    [help-needed-checkbox form-data :brand-strategy "Brand strategy"]
    [help-needed-checkbox form-data :visual-identity "Visual identity"]
    [help-needed-checkbox form-data :website "Website"]
    [help-needed-checkbox form-data :something-else "Something else"]]
   (when (and (empty? (:help-needed @form-data)) (:submit-attempted @form-data))
     [:p.text-red-500.text-sm.mt-2
      {:style {:font-family "'Special Elite', 'Courier New', monospace"}}
      "You need to select at least one option."])])

(defn budget-radio-group [form-data]
  [:div
   [:label.block.text-sm.font-medium.text-gray-900.mb-3
    {:style {:font-family "'Special Elite', 'Courier New', monospace"}}
    [:span.text-red-500 "* "] "What's your budget?"]
   [:div.space-y-2
    [radio-field "$150-$500" "budget" "150-500" 
     (= (:budget @form-data) "150-500")
     #(swap! form-data assoc :budget %)]
    [radio-field "$500-$1,000" "budget" "500-1000"
     (= (:budget @form-data) "500-1000")
     #(swap! form-data assoc :budget %)]
    [radio-field "$1,000-$1,500" "budget" "1000-1500"
     (= (:budget @form-data) "1000-1500")
     #(swap! form-data assoc :budget %)]
    [radio-field "$1,500-$2,000" "budget" "1500-2000"
     (= (:budget @form-data) "1500-2000")
     #(swap! form-data assoc :budget %)]
    [radio-field "$2,000+" "budget" "2000-plus"
     (= (:budget @form-data) "2000-plus")
     #(swap! form-data assoc :budget %)]]])

(defn focus-radio-group [form-data]
  [:div
   [:label.block.text-sm.font-medium.text-gray-900.mb-3
    {:style {:font-family "'Special Elite', 'Courier New', monospace"}}
    [:span.text-red-500 "* "] "What do you need help with?"]
   [:div.space-y-2
    [radio-field "Brand design—$2,500" "focus" "brand"
     (= (:focus @form-data) "brand")
     #(swap! form-data assoc :focus %)]
    [radio-field "Website—$3,500 incl. template" "focus" "website"
     (= (:focus @form-data) "website")
     #(swap! form-data assoc :focus %)]
    [radio-field "Both—$6,000" "focus" "both"
     (= (:focus @form-data) "both")
     #(swap! form-data assoc :focus %)]]])

