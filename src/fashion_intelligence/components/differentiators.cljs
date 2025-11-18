(ns fashion-intelligence.components.differentiators)

(defn diff-item [text color]
  [:div
   {:class (str "bg-" color "-900 bg-opacity-30 p-4 rounded-lg")}
   [:p.font-semibold text]])

(defn differentiators-section []
  [:section.py-20.px-6.bg-gray-900.text-white
   [:div.max-w-6xl.mx-auto
    [:h2.font-serif.text-4xl.md:text-5xl.font-bold.text-center.mb-16
     "Lo Que Me Diferencia"]
    
    [:div.grid.md:grid-cols-2.gap-12
     [:div
      [:h3.text-2xl.font-bold.mb-8.text-red-400
       "❌ Lo Que NO Hago"]
      [:div.space-y-4
       [diff-item "Diseño bonito sin propósito" "red"]
       [diff-item "Cambios basados en tendencias sin análisis" "red"]
       [diff-item "Consultoría genérica sin medición" "red"]]]
     
     [:div
      [:h3.text-2xl.font-bold.mb-8.text-green-400
       "✅ Lo Que SÍ Hago"]
      [:div.space-y-4
       [diff-item "Mido TODO: Cada cambio tiene un antes/después cuantificable" "green"]
       [diff-item "Sistematizo: Crea procesos que tu equipo puede replicar" "green"]
       [diff-item "Optimizo: Cada decisión busca aumentar el impacto" "green"]
       [diff-item "Reporto: Documentación clara del ROI de cada acción" "green"]]]]]])

