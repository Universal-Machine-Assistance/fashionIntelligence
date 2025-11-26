(ns fashion-intelligence.components.solution)

(defn metric-card [value title description]
  [:div.metric-card.p-8.rounded-2xl.card-hover
   [:div.text-4xl.font-bold.text-gray-900.mb-2 value]
   [:div.text-lg.font-semibold.mb-3 title]
   [:p.text-gray-600 description]])

(defn solution-section []
  [:section.py-20.px-6.bg-gray-50
   [:div.max-w-6xl.mx-auto
    [:h2.font-serif.text-4xl.md:text-5xl.font-bold.text-center.mb-16.gradient-text
     "La Solución: Estilismo Personalizado"]
    
    [:div.text-center.mb-12
     [:p.text-xl.text-gray-600.max-w-4xl.mx-auto.leading-relaxed
      "Trabajo contigo para descubrir y hacer brillar "
      [:strong "tu personalidad única"]
      ". No se trata de seguir tendencias, sino de crear un estilo que te represente auténticamente y te haga sentir "
      [:strong "confiada y poderosa"]
      " en cada ocasión."]]
    
    [:div.grid.md:grid-cols-3.gap-8
     [metric-card
      "100%"
      "Personalizado para Ti"
      "Cada recomendación está diseñada específicamente para tu estilo de vida y personalidad"]
     
     [metric-card
      "1:1"
      "Atención Personalizada"
      "Sesiones individuales donde exploramos juntas qué te hace sentir más tú"]
     
     [metric-card
      "∞"
      "Estilo Auténtico"
      "Un guardarropa que refleja quién eres y te da confianza en cualquier situación"]]]])

