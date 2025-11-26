(ns fashion-intelligence.components.differentiators)

(defn diff-item [text bg-color text-color]
  [:div
   {:class "p-4 rounded-lg border-2"
    :style {:background-color bg-color
            :border-color (str bg-color "80")
            :color text-color}}
   [:p.font-semibold text]])

(defn differentiators-section []
  [:section.py-20.px-6
   {:style {:background "linear-gradient(to bottom, #fef7f0, #f5f0ff)"}}
   [:div.max-w-6xl.mx-auto
    [:h2.font-serif.text-4xl.md:text-5xl.font-bold.text-center.mb-16
     {:style {:color "#4a5568"}}
     "Lo Que Me Diferencia"]
    
    [:div.grid.md:grid-cols-2.gap-12
     [:div
      [:h3.text-2xl.font-bold.mb-8
       {:style {:color "#d977a6"}}
       "❌ Lo Que NO Hago"]
      [:div.space-y-4
       [diff-item "Diseño bonito sin propósito" "#ffe0e8" "#8b4a6b"]
       [diff-item "Cambios basados en tendencias sin análisis" "#ffe0e8" "#8b4a6b"]
       [diff-item "Consultoría genérica sin medición" "#ffe0e8" "#8b4a6b"]]]
     
     [:div
      [:h3.text-2xl.font-bold.mb-8
       {:style {:color "#7dd3c0"}}
       "✅ Lo Que SÍ Hago"]
      [:div.space-y-4
       [diff-item "Mido TODO: Cada cambio tiene un antes/después cuantificable" "#e0f7f4" "#2d6a5a"]
       [diff-item "Sistematizo: Creo procesos que tu equipo puede replicar" "#e0f7f4" "#2d6a5a"]
       [diff-item "Optimizo: Cada decisión busca aumentar el impacto" "#e0f7f4" "#2d6a5a"]
       [diff-item "Reporto: Documentación clara del ROI de cada acción" "#e0f7f4" "#2d6a5a"]]]]]])

