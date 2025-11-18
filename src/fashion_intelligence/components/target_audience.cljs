(ns fashion-intelligence.components.target-audience)

(defn audience-item [emoji title description]
  [:div.bg-white.bg-opacity-10.p-6.rounded-lg
   [:div.flex.items-start
    [:span.text-2xl.mr-3 emoji]
    [:div
     [:p.font-semibold title]
     [:p.text-sm.text-gray-300 description]]]])

(defn target-audience-section []
  [:section.py-20.px-6.bg-white
   [:div.max-w-6xl.mx-auto
    [:h2.font-serif.text-4xl.md:text-5xl.font-bold.text-center.mb-16.gradient-text
     "¿Es Esto Para Ti?"]
    
    [:div.bg-gray-900.text-white.p-8.md:p-12.rounded-2xl
     [:p.text-xl.md:text-2xl.text-center.mb-8.font-serif
      "Mi servicio corporativo es para marcas de moda que:"]
     
     [:div.grid.md:grid-cols-2.gap-6
      [audience-item
       "🎯"
       "Quieren dejar de depender de la intuición"
       "Necesitan procesos claros y medibles"]
      
      [audience-item
       "📈"
       "Necesitan aumentar rentabilidad sin aumentar tráfico"
       "Optimizar lo que ya tienen"]
      
      [audience-item
       "🔄"
       "Buscan sistemas probados y replicables"
       "Que funcionen en todas las tiendas"]
      
      [audience-item
       "📊"
       "Valoran las decisiones basadas en datos"
       "Quieren ver ROI claro de cada acción"]]]]])

