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
     "La Solución: Data-Driven Retail"]
    
    [:div.text-center.mb-12
     [:p.text-xl.text-gray-600.max-w-4xl.mx-auto
      "Natalie entra como "
      [:strong "creadora de frameworks"]
      ", no solo diseñadora. Transformo la intuición en "
      [:strong "sistemas probados y replicables"]
      " que aumentan tu rentabilidad sin aumentar tráfico."]]
    
    [:div.grid.md:grid-cols-3.gap-8
     [metric-card
      "100%"
      "Decisiones Basadas en Datos"
      "Cada cambio tiene un antes/después cuantificable"]
     
     [metric-card
      "3x"
      "Ticket Promedio"
      "Optimización de bundles y cross-selling"]
     
     [metric-card
      "24/7"
      "Sistemas Replicables"
      "Tu equipo puede implementar sin depender de mí"]]]])

