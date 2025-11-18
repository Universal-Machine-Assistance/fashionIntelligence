(ns fashion-intelligence.components.brand-promise)

(defn brand-promise-section []
  [:section.py-20.px-6.bg-gray-50
   [:div.max-w-4xl.mx-auto.text-center
    [:h2.font-serif.text-4xl.md:text-5xl.font-bold.mb-12.gradient-text
     "Mi Promesa de Marca"]
    
    [:blockquote.text-2xl.md:text-3xl.font-serif.text-gray-800.leading-relaxed
     "\"Más allá de la moda, nos enfocamos en el ser humano. Ya sea para un cliente individual o una línea completa, nuestra misión es "
     [:strong "descubrir y realzar la belleza única de cada persona"]
     " a través de soluciones de moda innovadoras y estratégicas."
     [:br]
     [:br]
     "Cada persona tiene una identidad y está buscando una pieza que conecta con ella\""]]])

