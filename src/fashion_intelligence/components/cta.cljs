(ns fashion-intelligence.components.cta)

(defn cta-section []
  [:section#contacto.py-20.px-6.bg-gray-900.text-white
   [:div.max-w-4xl.mx-auto.text-center
    [:h2.font-serif.text-4xl.md:text-5xl.font-bold.mb-8
     "¿Listo para Optimizar Tu Rentabilidad?"]
    
    [:p.text-xl.mb-12.text-gray-300
     "Deja de depender de la intuición. Empieza a medir, sistematizar y optimizar tu retail de moda con frameworks probados."]
    
    [:div.p-8.rounded-2xl.mb-8
     {:style {:background "rgba(255, 255, 255, 0.15)" :backdrop-filter "blur(10px)"}}
     [:div.flex.items-center.justify-center.mb-6
      [:img.w-16.h-16.opacity-90
       {:src "/images/icons/fashion.svg"
        :alt "Fashion icon"}]]
     [:h3.text-2xl.md:text-3xl.font-serif.font-bold.mb-4.text-white
      {:style {:text-shadow "0 2px 4px rgba(0,0,0,0.3)"}}
      "Empecemos con una Conversación"]
     [:p.text-lg.md:text-xl.mb-6.leading-relaxed.max-w-2xl.mx-auto
      {:style {:color "#f9fafb" :text-shadow "0 1px 2px rgba(0,0,0,0.2)" :font-weight "300"}}
      "Cada proyecto es único, y quiero conocer el tuyo. En una consulta inicial, analizamos juntos tu situación actual y descubrimos las oportunidades que pueden transformar tu negocio."]
     [:a.inline-flex.items-center.gap-2.bg-white.text-gray-900.px-8.py-4.rounded-lg.text-lg.font-semibold
      {:href "https://wa.me/18494048259?text=Hola%20Natalie%2C%20me%20gustar%C3%ADa%20agendar%20una%20consulta%20para%20hablar%20contigo%20de%20un%20proyecto"
       :target "_blank"
       :rel "noopener noreferrer"
       :class "hover:bg-gray-100 transition-all duration-300 hover:shadow-lg"}
      [:span "Agendar Consulta"]
      [:svg.w-5.h-5 {:fill "none" :stroke "currentColor" :view-box "0 0 24 24"}
       [:path {:stroke-linecap "round" :stroke-linejoin "round" :stroke-width "2" :d "M17 8l4 4m0 0l-4 4m4-4H3"}]]]]
    
    [:div.text-sm.text-gray-400
     [:p "rdcostume.nr@gmail.com | 1-849-404-8259"]
     [:p "Santo Domingo, República Dominicana"]]]])

