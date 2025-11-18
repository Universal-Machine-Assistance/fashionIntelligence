(ns fashion-intelligence.components.hero)

(defn hero-component []
  [:section.hero-bg.min-h-screen.flex.items-center.justify-center.px-6.py-20.relative.overflow-hidden
   [:div.absolute.top-20.right-10.w-64.h-64.rounded-full.bg-gradient-to-br.from-amber-100.to-transparent.opacity-50]
   [:div.absolute.bottom-20.left-10.w-48.h-48.rounded-full.bg-gradient-to-tr.from-stone-200.to-transparent.opacity-40]
   
   [:div.max-w-5xl.mx-auto.text-center.relative.z-10
    [:div.mb-12
     [:h1.font-serif.text-6xl.md:text-8xl.font-light.mb-4.tracking-wide.text-gray-900
      "Natalie Rodríguez"]
     [:h2.font-serif.text-2xl.md:text-3xl.font-light.mb-8.tracking-wide.gold-accent
      "Fashion Stylist & Retail Curation"]
     [:p.text-lg.md:text-xl.text-gray-600.max-w-3xl.mx-auto.leading-relaxed.font-light
      "Transformo espacios de moda en "
      [:em "experiencias narrativas"]
      ". Cada rincón de tu tienda cuenta una historia que resuena con quienes buscan más que ropa: buscan "
      [:strong "identidad"]
      "."]]
    
    [:div.flex.flex-wrap.justify-center.gap-6.mb-16
     [:span.text-stylish.tracking-widest.text-gray-500.border-b.border-gray-300.pb-1
      "Personal Styling"]
     [:span.text-stylish.tracking-widest.text-gray-500.border-b.border-gray-300.pb-1
      "Visual Curation"]
     [:span.text-stylish.tracking-widest.text-gray-500.border-b.border-gray-300.pb-1
      "Brand Identity"]]
    
    [:a.inline-block.border.border-gray-900.text-gray-900.px-10.py-4.text-sm.tracking-widest
     {:href "#curation"
      :class "hover:bg-gray-900 hover:text-white transition-all duration-500"}
     "Descubre Mi Curation"]]])

