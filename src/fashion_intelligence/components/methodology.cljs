(ns fashion-intelligence.components.methodology)

(defn check-icon []
  [:svg.w-5.h-5.text-green-600.mr-3
   {:fill "currentColor"
    :view-box "0 0 20 20"}
   [:path
    {:fill-rule "evenodd"
     :d "M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z"
     :clip-rule "evenodd"}]])

(defn method-step [number title description]
  [:li.flex.items-start
   [:span.w-6.h-6.bg-gray-900.rounded-full.flex.items-center.justify-center.text-white.text-sm.font-bold.mr-3.mt-1
    number]
   [:div
    [:p.font-semibold title]
    [:p.text-gray-600.text-sm description]]])

(defn methodology-section []
  [:section.py-20.px-6.bg-white
   [:div.max-w-6xl.mx-auto
    [:h2.font-serif.text-4xl.md:text-5xl.font-bold.text-center.mb-16.gradient-text
     "Mi Metodología Probada"]
    
    [:div.grid.md:grid-cols-2.gap-12
     [:div
      [:h3.text-2xl.font-bold.mb-6.text-gray-900
       "Basada en Data, No en Intuición"]
      [:ul.space-y-4
       [method-step
        "1"
        "Decisiones basadas en métricas estratégicas"
        "Análisis de comportamiento de compra real, no suposiciones"]
       [method-step
        "2"
        "Testing A/B en escaparates"
        "Montajes dinámicos para potenciar ventas con datos concretos"]
       [method-step
        "3"
        "Consistencia en experiencias"
        "Cada cliente recibe el mismo nivel de servicio optimizado"]]]
     
     [:div.bg-gray-50.p-8.rounded-2xl
      [:h4.text-xl.font-bold.mb-6.text-gray-900
       "Sistemas Replicables"]
      [:div.space-y-4
       [:div.flex.items-center
        [check-icon]
        [:span "Templates de escaparate por temporada/ocasión"]]
       [:div.flex.items-center
        [check-icon]
        [:span "Protocolos de montaje documentados"]]
       [:div.flex.items-center
        [check-icon]
        [:span "Calendarios de rotación optimizados"]]
       [:div.flex.items-center
        [check-icon]
        [:span "Checklist de implementación"]]]]]]])

