(ns fashion-intelligence.components.evidence)

(defn evidence-card [title content impact]
  [:div.bg-gray-50.p-8.rounded-2xl
   [:h3.text-xl.font-bold.mb-4.text-gray-900 title]
   [:p.text-gray-700.mb-4 content]
   [:div.text-sm.text-gray-600
    [:strong "Impacto: "]
    impact]])

(defn evidence-section []
  [:section.py-20.px-6.bg-white
   [:div.max-w-6xl.mx-auto
    [:h2.font-serif.text-4xl.md:text-5xl.font-bold.text-center.mb-16.gradient-text
     "Respaldado por Investigación"]
    
    [:div.grid.md:grid-cols-2.gap-8
     [evidence-card
      "Journal of Retailing"
      [:span
       "Ha demostrado que las estrategias de "
       [:strong "bundling aumentan el valor percibido"]
       " y reducen el costo mental de decisión."]
      "Mayor conversión y ticket promedio"]
     
     [evidence-card
      "Journal of Fashion Marketing and Management"
      [:span
       "Ha demostrado que el "
       [:strong "entrenamiento en visual merchandising aumenta conversión"]
       " de venta significativamente."]
      "Hasta 40% increase en conversiones"]]]])

