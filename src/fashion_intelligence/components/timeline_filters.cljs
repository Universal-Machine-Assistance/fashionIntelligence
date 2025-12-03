(ns fashion-intelligence.components.timeline-filters)

(defn category-filter-buttons [selected-category-filter]
  [:div.flex.flex-wrap.justify-center.gap-3.mb-6
   [:p.text-sm.font-semibold.text-gray-600.w-full.text-center.mb-2 "Filtrar por Categoría:"]
   [:button.px-6.py-2.rounded-lg.font-semibold.transition-all.duration-300
    {:class (if (nil? @selected-category-filter)
              "bg-gray-900 text-white hover:bg-gray-800"
              "bg-gray-200 text-gray-700 hover:bg-gray-300")
     :on-click #(reset! selected-category-filter nil)}
    "Todos"]
   [:button.px-6.py-2.rounded-lg.font-semibold.transition-all.duration-300
    {:class (if (= @selected-category-filter :fashion)
              "bg-rose-500 text-white hover:bg-rose-600"
              "bg-rose-100 text-rose-700 hover:bg-rose-200")
     :on-click #(reset! selected-category-filter :fashion)}
    "Fashion"]
   [:button.px-6.py-2.rounded-lg.font-semibold.transition-all.duration-300
    {:class (if (= @selected-category-filter :film)
              "bg-blue-500 text-white hover:bg-blue-600"
              "bg-blue-100 text-blue-700 hover:bg-blue-200")
     :on-click #(reset! selected-category-filter :film)}
    "Film"]
   [:button.px-6.py-2.rounded-lg.font-semibold.transition-all.duration-300
    {:class (if (= @selected-category-filter :retail)
              "bg-emerald-500 text-white hover:bg-emerald-600"
              "bg-emerald-100 text-emerald-700 hover:bg-emerald-200")
     :on-click #(reset! selected-category-filter :retail)}
    "Retail"]])

(defn role-filter-buttons [selected-role-filter unique-roles]
  [:div.flex.flex-wrap.justify-center.gap-3
   [:p.text-sm.font-semibold.text-gray-600.w-full.text-center.mb-2 "Filtrar por Posición:"]
   [:button.px-6.py-2.rounded-lg.font-semibold.transition-all.duration-300.text-sm
    {:class (if (nil? @selected-role-filter)
              "bg-gray-900 text-white hover:bg-gray-800"
              "bg-gray-200 text-gray-700 hover:bg-gray-300")
     :on-click #(reset! selected-role-filter nil)}
    "Todas"]
   (for [role unique-roles]
     ^{:key (str "role-filter-" role)}
     [:button.px-4.py-2.rounded-lg.font-semibold.transition-all.duration-300.text-sm
      {:class (if (= @selected-role-filter role)
                "bg-purple-500 text-white hover:bg-purple-600"
                "bg-purple-100 text-purple-700 hover:bg-purple-200")
       :on-click #(reset! selected-role-filter role)}
      role])])

