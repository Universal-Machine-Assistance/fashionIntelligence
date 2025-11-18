(ns fashion-intelligence.components.cta)

(defn cta-section []
  [:section#contacto.py-20.px-6.bg-gray-900.text-white
   [:div.max-w-4xl.mx-auto.text-center
    [:h2.font-serif.text-4xl.md:text-5xl.font-bold.mb-8
     "¿Listo para Optimizar Tu Rentabilidad?"]
    
    [:p.text-xl.mb-12.text-gray-300
     "Deja de depender de la intuición. Empieza a medir, sistematizar y optimizar tu retail de moda con frameworks probados."]
    
    [:div.bg-white.bg-opacity-10.p-8.rounded-2xl.mb-8
     [:h3.text-2xl.font-bold.mb-4
      "Primer Paso: Diagnóstico Gratuito"]
     [:p.text-gray-300.mb-6
      "Evaluación inicial de tu operación actual y oportunidades identificadas"]
     [:a.inline-block.bg-white.text-gray-900.px-8.py-4.rounded-lg.text-lg.font-semibold
      {:href "mailto:natalie@fashionintelligence.com"
       :class "hover:bg-gray-100 transition-colors duration-300"}
      "Solicitar Diagnóstico"]]
    
    [:div.text-sm.text-gray-400
     [:p "natalie@fashionintelligence.com | +1 (829) 555-0123"]
     [:p "Santo Domingo, República Dominicana"]]]])

