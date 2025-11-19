(ns fashion-intelligence.components.about)

(defn expertise-item [title description]
  [:div.border-l-4.border-gray-900.pl-4
   [:p.font-semibold title]
   [:p.text-sm.text-gray-600 description]])

(defn about-section []
  [:section.py-20.px-6.bg-gray-50
   [:div.max-w-6xl.mx-auto
    [:h2.font-serif.text-4xl.md:text-5xl.font-bold.text-center.mb-16.gradient-text
     "Sobre Natalie Rodríguez"]
    
    [:div.grid.md:grid-cols-2.gap-12.items-center.mb-16
     [:div
      [:p.text-lg.text-gray-700.mb-6.leading-relaxed
       "Natalie Rodríguez del Rosario es una "
       [:strong "Costume Designer, Fashion Designer y Fashion Stylist"]
       " con raíces en el diseño de modas y vestuario para cine, teatro y entretenimiento."]
      [:p.text-lg.text-gray-700.mb-6.leading-relaxed
       "Originaria de Santo Domingo, R.D., combina su formación en instituciones como el Instituto Técnico Superior Mercy Jaquez, Chavón y la Escuela Audiovisual de Cinematografía de Madrid, para crear looks que no solo embellecen, sino que "
       [:strong "narran, impactan y optimizan"]
       "."]
      [:p.text-lg.text-gray-700.leading-relaxed
       "Su expertise abarca desde el diseño conceptual hasta la ejecución en sets y retail, con un énfasis en la "
       [:strong "innovación y la adaptabilidad"]
       "."]]
     
     [:div.bg-white.p-8.rounded-2xl
      [:h3.text-2xl.font-bold.mb-6.text-gray-900
       "Mi Expertise Multidisciplinaria"]
      [:div.space-y-4
       [expertise-item
        "Costume Designer"
        "Narrar historias en producciones escénicas"]
       [expertise-item
        "Fashion Designer"
        "Crear ropa vendible para el mercado"]
       [expertise-item
        "Fashion Stylist"
        "Coordinar looks para impacto visual inmediato"]]]]
    
    [:div.max-w-4xl.mx-auto.mt-16
     [:div.bg-white.p-8.rounded-2xl.shadow-sm
      [:h3.text-3xl.font-serif.font-bold.mb-8.text-center.text-gray-900
       "Mi Filosofía"]
      
      [:div.space-y-8
       [:div
        [:h4.text-xl.font-bold.mb-4.text-gray-800
         "1. ¿Por qué hago ropa?"]
        [:p.text-lg.text-gray-700.leading-relaxed
         "Creo en manifestar la belleza interior con tu exterior, vistiendo la esencia del ser. Embelleciendo al cuerpo, volviéndolos uno."]]
       
       [:div
        [:h4.text-xl.font-bold.mb-4.text-gray-800
         "2. ¿Por qué diseño?"]
        [:p.text-lg.text-gray-700.leading-relaxed
         "Diseño porque me gusta lo auténtico, el singular del individuo, en que de una forma u otra cada ser es único, me gustaría encontrar en cada diseño la pieza especial para cada ser."]]
       
       [:div
        [:h4.text-xl.font-bold.mb-4.text-gray-800
         "3. ¿Qué quiero dejarle al cliente cuando se ponen en mis manos?"]
        [:p.text-lg.text-gray-700.leading-relaxed
         "Identidad propia, cómodo con su cuerpo, con su esencia."]]]]]]])

