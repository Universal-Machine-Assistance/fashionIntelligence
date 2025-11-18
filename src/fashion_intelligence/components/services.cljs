(ns fashion-intelligence.components.services)

(defn svg-icon [path-data]
  [:svg.w-8.h-8.text-white
   {:fill "none"
    :stroke "currentColor"
    :view-box "0 0 24 24"}
   [:path
    {:stroke-linecap "round"
     :stroke-linejoin "round"
     :stroke-width "2"
     :d path-data}]])

(defn service-card [icon-path title description features]
  [:div.bg-gray-50.p-8.rounded-2xl.card-hover
   [:div.w-16.h-16.bg-gray-900.rounded-lg.flex.items-center.justify-center.mb-6
    [svg-icon icon-path]]
   [:h3.text-2xl.font-bold.mb-4.text-gray-900 title]
   [:p.text-gray-600.mb-4 description]
   [:ul.text-sm.text-gray-600.space-y-2
    (for [feature features]
      ^{:key feature}
      [:li (str "• " feature)])]])

(defn services-section []
  [:section.py-20.px-6.bg-white
   [:div.max-w-6xl.mx-auto
    [:h2.font-serif.text-4xl.md:text-5xl.font-bold.text-center.mb-16.gradient-text
     "Servicios Corporativos"]
    
    [:div.grid.md:grid-cols-2.lg:grid-cols-3.gap-8
     [service-card
      "M12 6.253v13m0-13C10.832 5.477 9.246 5 7.5 5S4.168 5.477 3 6.253v13C4.168 18.477 5.754 18 7.5 18s3.332.477 4.5 1.253m0-13C13.168 5.477 14.754 5 16.5 5c1.746 0 3.332.477 4.5 1.253v13C19.832 18.477 18.246 18 16.5 18c-1.746 0-3.332.477-4.5 1.253"
      "Programa de Entrenamiento"
      "Capacitación sistemática del personal con guiones de venta probados y técnicas de upselling/cross-selling."
      ["Defensa de Objeciones"
       "Medición de conversión por vendedor"
       "Consistencia en servicio"]]
     
     [service-card
      "M16 11V7a4 4 0 00-8 0v4M5 9h14l1 12H4L5 9z"
      "Kits de Venta Estratégicos"
      "Bundles por perfil de cliente con análisis de rentabilidad y rotación según estacionalidad."
      ["Combinaciones de mayor ticket"
       "Análisis de rentabilidad por bundle"
       "Actualización por datos reales"]]
     
     [service-card
      "M9 19v-6a2 2 0 00-2-2H5a2 2 0 00-2 2v6a2 2 0 002 2h2a2 2 0 002-2zm0 0V9a2 2 0 012-2h2a2 2 0 012 2v10m-6 0a2 2 0 002 2h2a2 2 0 002-2m0 0V5a2 2 0 012-2h2a2 2 0 012 2v14a2 2 0 01-2 2h-2a2 2 0 01-2-2z"
      "Reporting Inteligente"
      "Reporte mensual estandarizado con KPIs de rentabilidad y ROI de cada intervención."
      ["Rentabilidad por m²"
       "Conversión de escaparate a venta"
       "Recomendaciones basadas en datos"]]
     
     [service-card
      "M4 5a1 1 0 011-1h14a1 1 0 011 1v2a1 1 0 01-1 1H5a1 1 0 01-1-1V5zM4 13a1 1 0 011-1h6a1 1 0 011 1v6a1 1 0 01-1 1H5a1 1 0 01-1-1v-6zM16 13a1 1 0 011-1h2a1 1 0 011 1v6a1 1 0 01-1 1h-2a1 1 0 01-1-1v-6z"
      "Modelos Replicables"
      "Templates y protocolos documentados que tu equipo puede implementar sin supervisión constante."
      ["Calendarios de escaparate por temporada"
       "Protocolos de montaje documentados"
       "Checklist de implementación"]]
     
     [service-card
      "M15 12a3 3 0 11-6 0 3 3 0 016 0z M2.458 12C3.732 7.943 7.523 5 12 5c4.478 0 8.268 2.943 9.542 7-1.274 4.057-5.064 7-9.542 7-4.477 0-8.268-2.943-9.542-7z"
      "Visual Merchandising"
      "Testing A/B en escaparates y disposiciones dinámicas para potenciar conversiones."
      ["Análisis de comportamiento de compra"
       "Montajes dinámicos probados"
       "Optimización del espacio"]]
     
     [service-card
      "M9 3v2m6-2v2M9 19v2m6-2v2M5 9H3m2 6H3m18-6h-2m2 6h-2M7 19h10a2 2 0 002-2V7a2 2 0 00-2-2H7a2 2 0 00-2 2v10a2 2 0 002 2zM9 9h6v6H9V9z"
      "Análisis de Métricas"
      "Decisiones basadas en métricas estratégicas del negocio, no en corazonadas."
      ["Rotación inteligente de producto"
       "Explicaciones y entrenamiento"
       "Consistencia en experiencias"]]]]])

