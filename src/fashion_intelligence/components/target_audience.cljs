(ns fashion-intelligence.components.target-audience)

(defn audience-item [icon-src title description]
  [:div.bg-gray-800.bg-opacity-60.p-6.rounded-xl.transition-all.duration-300.border.border-gray-700
   {:class "hover:bg-opacity-80 hover:transform hover:scale-[1.02] hover:border-gray-600"}
   [:div.flex.items-start
    [:div.flex-shrink-0.w-14.h-14.mr-4.flex.items-center.justify-center.bg-gray-700.rounded-lg
     [:img.w-8.h-8.opacity-95
      {:src icon-src
       :alt title
       :style {:filter "brightness(0) invert(1)"}}]]
    [:div.flex-1
     [:p.font-serif.text-lg.font-semibold.mb-2.text-white.leading-tight title]
     [:p.text-base.text-gray-200.leading-relaxed.font-sans description]]]])

(defn target-audience-section []
  [:section.py-20.px-6.bg-white
   [:div.max-w-6xl.mx-auto
    [:h2.font-serif.text-4xl.md:text-5xl.font-bold.text-center.mb-16.gradient-text
     "¿Es Esto Para Ti?"]
    
    [:div.bg-gray-900.text-white.p-10.md:p-14.rounded-3xl.shadow-2xl.border.border-gray-800
     [:p.text-xl.md:text-2xl.text-center.mb-12.font-serif.leading-relaxed.text-gray-100.font-medium
      "Mi servicio corporativo es para marcas de moda que:"]
     
     [:div.grid.md:grid-cols-2.gap-6
      [audience-item
       "/images/icons/target.svg"
       "Quieren dejar de depender de la intuición"
       "Necesitan procesos claros y medibles"]
      
      [audience-item
       "/images/icons/chart.svg"
       "Necesitan aumentar rentabilidad sin aumentar tráfico"
       "Optimizar lo que ya tienen"]
      
      [audience-item
       "/images/icons/tiendas.svg"
       "Buscan sistemas probados y replicables"
       "Que funcionen en todas las tiendas"]
      
      [audience-item
       "/images/icons/roi.svg"
       "Valoran las decisiones basadas en datos"
       "Quieren ver ROI claro de cada acción"]]]]])

