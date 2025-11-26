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
      "Cuando Necesitas Asesoramiento Personal"]
     [:p.text-lg.text-gray-600.max-w-2xl.mx-auto.font-light.leading-relaxed
      "A veces sientes que tu imagen no refleja quién realmente eres, o que necesitas una guía para expresar tu estilo único. No estás sola en esto."]]
    
    [:div.grid.md:grid-cols-3.gap-8
     [problem-item
      "/images/icons/vacio.svg"
      "Te Sientes Perdida"
      [:span "Tienes un guardarropa lleno, pero nada que ponerte. Cada pieza cuenta una historia diferente, pero ninguna es realmente " [:em "tuya"] "."]]
     
     [problem-item
      "/images/icons/lentes.svg"
      "Necesitas Claridad"
      [:span "Sabes lo que te gusta, pero no sabes cómo combinarlo. Quieres verte bien, pero también quieres sentirte auténtica y confiada."]]
     
     [problem-item
      "/images/icons/alma.svg"
      "Buscas Conexión"
      [:span "No se trata solo de ropa, se trata de cómo quieres que te vean y cómo quieres sentirte. Quieres que tu estilo comunique quién eres realmente."]]]]])

