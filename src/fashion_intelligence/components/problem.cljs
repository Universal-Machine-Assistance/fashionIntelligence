(ns fashion-intelligence.components.problem)

(defn problem-item [icon-src title description]
  [:div.text-center
   [:div.w-20.h-20.mx-auto.mb-6.flex.items-center.justify-center
    [:img.w-16.h-16.opacity-70
     {:src icon-src
      :alt title
      :style {:filter "grayscale(100%)"}}]]
   [:h3.font-serif.text-2xl.mb-4.gold-accent title]
   [:p.text-gray-600.leading-relaxed description]])

(defn problem-section []
  [:section#curation.py-24.px-6.bg-white
   [:div.max-w-5xl.mx-auto
    [:div.text-center.mb-16
     [:h2.font-serif.text-5xl.md:text-6xl.font-light.mb-6.text-gray-900
      "La Inconsistencia Mata la Identidad"]
     [:p.text-lg.text-gray-600.max-w-2xl.mx-auto.font-light
      "Cada tienda habla un idioma diferente. No hay armonía, solo ruido."]]
    
    [:div.grid.md:grid-cols-3.gap-8
     [problem-item
      "/images/icons/vacio.svg"
      "Sin Narrativa"
      [:span "Vendedores talentosos sin guión. Cada uno cuenta una versión diferente de tu marca."]]
     
     [problem-item
      "/images/icons/lentes.svg"
      "Sin Visión"
      [:span "Escaparates que decoran pero no " [:em "comunican"] ". Belleza sin propósito es olvido."]]
     
     [problem-item
      "/images/icons/alma.svg"
      "Sin Alma"
      [:span "Métricas que miden transacciones, no conexiones. Has vendido, pero ¿has impactado?"]]]]])

