(ns fashion-intelligence.components.personal-services)

(defn process-step [number title content]
  [:div.mb-8
   [:div.flex.items-start.mb-4
    [:div.w-10.h-10.bg-gray-900.text-white.rounded-full.flex.items-center.justify-center.font-bold.text-lg.mr-4.flex-shrink-0
     number]
    [:h4.text-xl.font-bold.text-gray-900 title]]
   [:div.ml-14
    (if (string? content)
      [:p.text-gray-700.leading-relaxed content]
      content)]])

(defn personal-services-section []
  [:section.py-20.px-6.bg-white
   [:div.max-w-4xl.mx-auto
    [:div.text-center.mb-12
     [:h2.font-serif.text-4xl.md:text-5xl.font-bold.mb-4.gradient-text
      "Servicios de Diseño y/o Estilismo"]
     [:p.text-lg.text-gray-600.mb-8
      "By: Natalie Rodríguez"]
     [:p.text-lg.text-gray-700.leading-relaxed.max-w-3xl.mx-auto
      "Servicio personalizado de diseño y estilismo que transforma tu visión en realidad. Trabajamos juntos para crear piezas únicas que reflejen tu identidad y esencia, desde la conceptualización hasta la entrega final."]]
    
    [:div.bg-gray-50.p-8.rounded-2xl.shadow-sm
     [process-step
      "1"
      "Reunión de presentación"
      [:div.space-y-4
       [:p.text-gray-700.leading-relaxed
        "En esta primera reunión establecemos las condiciones del servicio y las expectativas mutuas. Es el momento de conocernos y definir juntos el proyecto."]
       [:div
        [:p.font-semibold.text-gray-900.mb-2 "Durante la reunión, recopilamos la siguiente información del cliente:"]
        [:ul.list-disc.list-inside.space-y-1.text-gray-700
         [:li "¿Cómo se quiere visualizar?"]
         [:li "¿Qué quiere proyectar?"]
         [:li "Estilo de su preferencia"]
         [:li "Textura/telas de su preferencia"]]]
       [:div.bg-white.p-4.rounded-lg.border-l-4.border-gray-900.mt-4
        [:p.font-semibold.text-gray-900.mb-2 "Medición profesional:"]
        [:p.text-gray-700.leading-relaxed
         "En esta primera reunión también se toman todas las medidas necesarias del cliente para garantizar un ajuste perfecto en las piezas diseñadas."]]]]
     
     [process-step
      "2"
      "Propuesta de diseño"
      [:div.space-y-3
       [:p.text-gray-700.leading-relaxed
        "Con base en toda la información recopilada en la reunión inicial, desarrollamos una propuesta personalizada que incluye diseño, materiales, colores y estilo. Esta propuesta refleja tu visión y nuestras recomendaciones profesionales."]
       [:div.bg-white.p-4.rounded-lg.border-l-4.border-gray-900
        [:p.font-semibold.text-gray-900.mb-2 "Costo de la propuesta:"]
        [:p.text-gray-700.leading-relaxed
         "La propuesta tiene un costo de 100 USD, que se aplica al costo total del proyecto una vez aprobado."]]]]
     
     [process-step
      "3"
      "Cotización y proceso de pago"
      [:div.space-y-4
       [:p.text-gray-700.leading-relaxed
        "Una vez que apruebes la propuesta, te enviaremos una cotización detallada con todos los costos del proyecto. El proceso de pago se estructura de la siguiente manera:"]
       [:div.bg-white.p-4.rounded-lg.border-l-4.border-gray-900
        [:p.font-semibold.text-gray-900.mb-2 "Estructura de pago:"]
        [:ul.list-disc.list-inside.space-y-1.text-gray-700
         [:li "Pago total de la cotización para iniciar el trabajo"]
         [:li "50% pago de honorarios al inicio"]
         [:li "Al momento de finalizar el trabajo: saldar el 50% restante de honorarios"]]]]]
     
     [:div.mt-8.pt-8.border-t.border-gray-300
      [:h4.text-xl.font-bold.mb-4.text-gray-900
       "Política de trabajo:"]
      [:div.space-y-3
       [:p.text-gray-700.leading-relaxed
        "Para garantizar la calidad y el ajuste perfecto de cada pieza, el proceso incluye:"]
       [:ul.list-disc.list-inside.space-y-2.text-gray-700
        [:li "Agendar días para fittings (obligatorio). Estas sesiones son esenciales para asegurar que cada pieza se ajuste perfectamente a tu cuerpo y estilo."]
        [:li "Agendar día para rectificación y entrega final. Si no hay modificaciones adicionales, la entrega se realiza en esta fecha. En caso de requerir nuevas modificaciones, se agregará un día adicional para la entrega."]]]]]]])

