(ns fashion-intelligence.components.contact-hero)

(defn contact-hero-section []
  [:section.py-20.px-6.bg-gray-50
   [:div.max-w-6xl.mx-auto
    [:div.max-w-2xl
     [:p.text-2xl.md:text-3xl.font-serif.text-gray-900.mb-6.leading-relaxed
      "Tienes grandes planes."]
     [:p.text-2xl.md:text-3xl.font-serif.text-gray-900.mb-6.leading-relaxed
      "Juntos podemos transformarlos en realidad."]
     [:p.text-lg.md:text-xl.font-mono.text-gray-900.tracking-wider.mb-6
      "Hablemos."]
     [:p.text-base.text-gray-700.mb-2
      "Te responderé en menos de 24 horas para conversar sobre los siguientes pasos."]
     [:p.text-base.text-gray-700
      "Para solicitudes de colaboración patrocinada o consultas de prensa, escríbeme a "
      [:a.text-gray-900.border-b.border-gray-900.hover:border-gray-500.transition-colors
       {:href "mailto:rdcostume.nr@gmail.com"}
       "rdcostume.nr@gmail.com"]]]]])
