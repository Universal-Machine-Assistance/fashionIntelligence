(ns fashion-intelligence.components.timeline)

(def projects-data
  {:fashion
   [{:year "2025" :title "Visual Merchandising y Team Leader" :client "Alo Yoga Blue Mall" :role "Team Leader"}
    {:year "2025" :title "Estilismo para Photoshoot" :client "Jenny Polanco" :role "Fashion Stylist" :photographer "Karla Read"}
    {:year "2024" :title "Backstage Desfile" :client "José Jhan - Premios a la Moda Dominicana" :role "Stylist"}
    {:year "2023" :title "Estilismo para Banda Musical" :client "Pororó - Corona Sunset Punta Cana" :role "Fashion Stylist"}
    {:year "2022-2023" :title "Asistente Personal del Diseñador" :client "José Jhan Rodriguez" :role "Assistant"}
    {:year "2021" :title "Diseño y Ejecución de Vestuario" :client "Corona Sunset" :role "Costume Designer"}
    {:year "2021" :title "Estilismo para Colección" :client "Polanco by José Jhan Rodriguez" :role "Fashion Stylist"}
    {:year "2019" :title "Asistente General" :client "Diseñador José Jhan Rodriguez" :role "Assistant"}
    {:year "2018" :title "Producción para Desfile" :client "The Colorful Collection by Jose Jhan Rodriguez" :role "Producer"}
    {:year "2018" :title "Fitting" :client "Vin Diesel (actor)" :role "Stylist"}
    {:year "2018" :title "Estilismo" :client "Deborah Karter" :role "Fashion Stylist"}
    {:year "2015-2016" :title "Servicio al Cliente" :client "Tienda Formales" :role "Retail"}
    {:year "2015-2016" :title "Estilismo" :client "Milagros German - Programa de TV Chevere Nights" :role "Fashion Stylist"}
    {:year "2014-2015" :title "Asesora de Novias" :client "Tienda Pronovias, Blue Mall" :role "Consultant"}
    {:year "2011" :title "Coordinación Backstage & Dresser" :client "Diseñador Custo Barcelona" :role "Coordinator"}]
   
   :film
   [{:year "2025" :title "Asistente de Vestuario" :client "Video Musical Chris Lebron" :director "Carlos Zouain" :role "Assistant"}
    {:year "2024" :title "Buyer" :client "Película Coka Chika" :production "Bien ou Bien" :role "Buyer"}
    {:year "2023" :title "Buyer" :client "Serie TV Hotel Cocaine" :production "MGM" :role "Buyer"}
    {:year "2023" :title "Directora de Vestuario" :client "Video Musical Alicia" :artist "Judith Rodriguez" :role "Costume Director"}
    {:year "2022" :title "Set Costumer" :client "Are you afraid of the dark" :production "Nickelodeon, Studio Pinewood" :role "Set Costumer"}
    {:year "2022" :title "Set Costumer" :client "The best men" :production "Studio Pinewood" :role "Set Costumer"}
    {:year "2021" :title "Set Costumer" :client "The Black Demon" :production "Studio Pinewood" :role "Set Costumer"}
    {:year "2021" :title "Set Costumer" :client "Flow Calle" :director "Frank Perozo" :role "Set Costumer"}
    {:year "2021" :title "Pre Producción" :client "Serie de TV Suriname" :production "Netflix" :role "Pre-Production"}
    {:year "2020" :title "Directora de Vestuario" :client "Video Musical Pa' que suba" :artist "Richie Oriach" :role "Costume Director"}
    {:year "2020" :title "Directora de Vestuario" :client "Largometraje Libélula" :director "Ronny Castillo" :role "Costume Director"}
    {:year "2020" :title "Largometraje" :client "La otra lucha" :director "Hans Garcia" :role "Coordinator"}
    {:year "2020" :title "Set Costumer" :client "Juego De Hombre" :director "Miguel Angel Muñiz" :role "Set Costumer"}
    {:year "2019" :title "Directora de Vestuario" :client "Largometraje A Tiro Limpio" :director "Jean Guerra" :role "Costume Director"}
    {:year "2019" :title "Directora de Vestuario" :client "Largometraje Maboya" :director "Felipe Esteban" :role "Costume Director"}
    {:year "2019" :title "Directora de Vestuario" :client "Cortometraje Punto de Fuga" :director "Desiree Diaz" :role "Costume Director"}
    {:year "2018" :title "Directora de Vestuario" :client "Programa de TV SEXSOS" :director "Ronni Castillo" :role "Costume Director"}
    {:year "2018" :title "Set Costumer" :client "Tropical Cop Tales" :production "Studio Pinewood" :role "Set Costumer"}
    {:year "2018" :title "Set Costumer" :client "La Maravilla" :production "Bou GROUP" :role "Set Costumer"}
    {:year "2018" :title "Set Costumer" :client "The Long Song" :production "BBC Londres, Pinewood Studio" :role "Set Costumer"}
    {:year "2017" :title "Directora de Vestuario" :client "Cortometrajes Madrid, España" :projects "Un País Extraño, Nuestro Laberinto, Victoria, Poena, Croquetas, Olivia, Copacabana, Portero Automático, Niña, Cenizas, Zootropo" :role "Costume Director"}
    {:year "2017" :title "Set Costumer" :client "Rubirosa, E! tiguere" :directors "Carlos Moreno y Hugo Rodriguez" :role "Set Costumer"}
    {:year "2016" :title "Set Costumer" :client "La Otra Penelope" :director "Viadimir Abudh" :role "Set Costumer"}
    {:year "2015" :title "Directora de Vestuario" :client "Nostalgia, Obra Teatral" :director "Lia Briones" :award "Nominada Premios Soberanos 2016" :role "Costume Director"}]
   
   :retail
   [{:year "2025" :title "Visual Merchandising y Team Leader" :client "Alo Yoga Blue Mall" :role "Team Leader"}
    {:year "2015-2016" :title "Servicio al Cliente" :client "Tienda Formales" :role "Retail"}
    {:year "2014-2015" :title "Asesora de Novias" :client "Tienda Pronovias, Blue Mall" :role "Consultant"}]})

(defn timeline-item [project category]
  [:div.relative.pl-8.pb-8.border-l-2.border-gray-300.last:border-0
   [:div.absolute.-left-2.w-4.h-4.bg-gray-900.rounded-full.border-2.border-white.shadow-md]
   [:div.mb-2
    [:span.text-sm.font-semibold.text-gray-500.uppercase.tracking-wide (:year project)]]
   [:h4.font-serif.text-xl.font-semibold.mb-2.text-gray-900 (:title project)]
   [:p.text-gray-600.text-sm.mb-1
    [:span.font-medium "Cliente: "] (:client project)]
   (when (:director project)
     [:p.text-gray-600.text-sm.mb-1
      [:span.font-medium "Director: "] (:director project)])
   (when (:production project)
     [:p.text-gray-600.text-sm.mb-1
      [:span.font-medium "Producción: "] (:production project)])
   (when (:role project)
     [:p.text-xs.text-gray-500.mt-2.uppercase.tracking-wide (:role project)])])

(defn timeline-category [category-title projects color-class]
  [:div.mb-16
   [:div.flex.items-center.mb-8
    [:div.flex-1.h-px.bg-gray-300]
    [:h3.font-serif.text-3xl.font-bold.mx-6 {:class color-class} category-title]
    [:div.flex-1.h-px.bg-gray-300]]
   [:div.space-y-6
    (for [[idx project] (map-indexed vector projects)]
      ^{:key (str category-title "-" idx)}
      [timeline-item project category-title])]])

(defn timeline-section []
  [:section.py-20.px-6.bg-gray-50
   [:div.max-w-5xl.mx-auto
    [:div.text-center.mb-16
     [:h2.font-serif.text-4xl.md:text-5xl.font-bold.mb-6.gradient-text
      "Trayectoria Profesional"]
     [:p.text-lg.text-gray-600.max-w-2xl.mx-auto.font-light
      "Una carrera dedicada a la moda, el cine y el retail"]]
    
    [timeline-category "FASHION" (:fashion projects-data) "text-gray-900"]
    [timeline-category "FILM" (:film projects-data) "text-gray-900"]
    [timeline-category "RETAIL" (:retail projects-data) "text-gray-900"]]])

