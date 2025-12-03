(ns fashion-intelligence.components.portfolio-card)

(def category-colors
  {:fashion {:badge "bg-rose-100 text-rose-800"}
   :film {:badge "bg-blue-100 text-blue-800"}
   :retail {:badge "bg-emerald-100 text-emerald-800"}})

(def category-names
  {:fashion "FASHION"
   :film "FILM"
   :retail "RETAIL"})

(defn portfolio-card [project on-click]
  (let [first-image (first (:images project))
        colors (get category-colors (:category project) {})]
    [:div.project-cover-wrapper.relative.overflow-hidden.cursor-pointer.group
     {:on-click on-click
      :class "w-full aspect-[4/3] rounded-lg"}
     (if first-image
       [:div.relative.w-full.h-full
        [:img.w-full.h-full.object-cover.transition-transform.duration-500.group-hover:scale-110
         {:src first-image
          :alt (:title project)
          :loading "lazy"}]
        [:div.absolute.inset-0.bg-gradient-to-t.from-black.via-transparent.to-transparent.opacity-60.group-hover:opacity-70.transition-opacity]
        [:div.absolute.bottom-0.left-0.right-0.p-6.text-white
         [:div.mb-2
          [:span.text-xs.font-semibold.uppercase.tracking-wide.px-2.py-1.rounded
           {:class (get-in colors [:badge] "bg-gray-800 text-white")}
           (get category-names (:category project) "PROJECT")]]
         [:h3.text-xl.md:text-2xl.font-serif.font-bold.mb-1
          (:title project)]
         [:p.text-sm.text-gray-200.mb-2
          (str (:year project) " • " (:role project))]
         (when (:client project)
           [:p.text-xs.text-gray-300
            (:client project)])]]
       [:div.relative.w-full.h-full.flex.items-center.justify-center.bg-gray-100.border-2.border-gray-200
        [:div.text-center.p-6
         [:span.text-xs.font-semibold.uppercase.tracking-wide.px-2.py-1.rounded.mb-3.inline-block
          {:class (get-in colors [:badge] "bg-gray-200 text-gray-700")}
          (get category-names (:category project) "PROJECT")]
         [:h3.text-xl.md:text-2xl.font-serif.font-bold.mb-2
          (:title project)]
         [:p.text-sm.text-gray-600.mb-1
          (str (:year project) " • " (:role project))]
         (when (:client project)
           [:p.text-xs.text-gray-500
            (:client project)])]])]))

