(ns fashion-intelligence.components.timeline
  (:require [reagent.core :as r]))

(def jenny-polanco-images
  ["/images/clients/jenny_polanco/jenny_01.png"
   "/images/clients/jenny_polanco/jenny_02.png"
   "/images/clients/jenny_polanco/jenny_03.png"
   "/images/clients/jenny_polanco/jenny_04.png"
   "/images/clients/jenny_polanco/jenny_05.png"
   "/images/clients/jenny_polanco/jenny_06.png"
   "/images/clients/jenny_polanco/jenny_07.png"])

(def are-you-afraid-images
  ["/images/clients/are_you_afraid_of_the_dark/are_you_afraid_01.png"
   "/images/clients/are_you_afraid_of_the_dark/are_you_afraid_02.png"
   "/images/clients/are_you_afraid_of_the_dark/are_you_afraid_03.png"
   "/images/clients/are_you_afraid_of_the_dark/are_you_afraid_04.png"
   "/images/clients/are_you_afraid_of_the_dark/are_you_afraid_05.png"])

(def judith-rodriguez-alicia-images
  ["/images/clients/judith_rodriguez_alma/judith_rodriguez_alma_01.png"
   "/images/clients/judith_rodriguez_alma/judith_rodriguez_alma_02.png"
   "/images/clients/judith_rodriguez_alma/judith_rodriguez_alma_03.png"
   "/images/clients/judith_rodriguez_alma/judith_rodriguez_alma_04.png"
   "/images/clients/judith_rodriguez_alma/judith_rodriguez_alma_05.png"
   "/images/clients/judith_rodriguez_alma/judith_rodriguez_alma_06.png"])

(def en-la-sombra-democracia-images
  ["/images/clients/en_la_sombra_de_la_democracia/en_la_sombra_de_la_democracia_01.png"
   "/images/clients/en_la_sombra_de_la_democracia/en_la_sombra_de_la_democracia_02.png"
   "/images/clients/en_la_sombra_de_la_democracia/en_la_sombra_de_la_democracia_03.png"])

(def projects-data
  [{:year "2025" :category :retail :title "Visual Merchandising y Team Leader" :client "Alo Yoga Blue Mall" :role "Team Leader"}
   {:year "2025" :category :retail :title "Catalogo Navidad" :client "La Sirena" :role "Stylist"}
   {:year "2025" :category :fashion :title "Estilismo para Photoshoot" :client "Jenny Polanco" :role "Fashion Stylist" :photographer "Karla Read" :images jenny-polanco-images}
   {:year "2025" :category :film :title "En la Sombra de la Democracia" :client "En la Sombra de la Democracia" :director "Guillermo Molina" :role "Costume Director" :images en-la-sombra-democracia-images}
   {:year "2025" :category :film :title "Asistente de Vestuario" :client "Video Musical Chris Lebron" :director "Carlos Zouain" :role "Assistant"}
   {:year "2024" :category :fashion :title "Backstage Desfile" :client "José Jhan - Premios a la Moda Dominicana" :role "Stylist"}
   {:year "2024" :category :retail :title "Jumbo Madre Catalogo" :client "Jumbo Madre" :role "Retail"}
   {:year "2024" :category :film :title "Buyer" :client "Película Coka Chika" :production "Bien ou Bien" :role "Buyer"}
   {:year "2023" :category :fashion :title "Estilismo para Banda Musical" :client "Pororó - Corona Sunset Punta Cana" :role "Fashion Stylist"}
   {:year "2023" :category :film :title "Buyer" :client "Serie TV Hotel Cocaine" :production "MGM" :role "Buyer"}
   {:year "2023" :category :film :title "Directora de Vestuario" :client "Video Musical Alicia" :artist "Judith Rodriguez" :role "Costume Director" :images judith-rodriguez-alicia-images}
   {:year "2022" :category :film :title "Set Costumer" :client "Are you afraid of the dark" :production "Nickelodeon, Studio Pinewood" :role "Set Costumer" :images are-you-afraid-images}
   {:year "2022" :category :film :title "Set Costumer" :client "The best men" :production "Studio Pinewood" :role "Set Costumer"}
   {:year "2022-2023" :category :fashion :title "Asistente Personal del Diseñador" :client "José Jhan Rodriguez" :role "Assistant"}
   {:year "2021" :category :fashion :title "Diseño y Ejecución de Vestuario" :client "Corona Sunset" :role "Costume Designer"}
   {:year "2021" :category :fashion :title "Estilismo para Colección" :client "Polanco by José Jhan Rodriguez" :role "Fashion Stylist"}
   {:year "2021" :category :film :title "Set Costumer" :client "The Black Demon" :production "Studio Pinewood" :role "Set Costumer"}
   {:year "2021" :category :film :title "Set Costumer" :client "Flow Calle" :director "Frank Perozo" :role "Set Costumer"}
   {:year "2021" :category :film :title "Pre Producción" :client "Serie de TV Suriname" :production "Netflix" :role "Pre-Production"}
   {:year "2020" :category :film :title "Directora de Vestuario" :client "Video Musical Pa' que suba" :artist "Richie Oriach" :role "Costume Director"}
   {:year "2020" :category :film :title "Directora de Vestuario" :client "Largometraje Libélula" :director "Ronny Castillo" :role "Costume Director"}
   {:year "2020" :category :film :title "Largometraje" :client "La otra lucha" :director "Hans Garcia" :role "Coordinator"}
   {:year "2020" :category :film :title "Set Costumer" :client "Juego De Hombre" :director "Miguel Angel Muñiz" :role "Set Costumer"}
   {:year "2019" :category :fashion :title "Asistente General" :client "Diseñador José Jhan Rodriguez" :role "Assistant"}
   {:year "2019" :category :film :title "Directora de Vestuario" :client "Largometraje A Tiro Limpio" :director "Jean Guerra" :role "Costume Director"}
   {:year "2019" :category :film :title "Directora de Vestuario" :client "Largometraje Maboya" :director "Felipe Esteban" :role "Costume Director"}
   {:year "2019" :category :film :title "Directora de Vestuario" :client "Cortometraje Punto de Fuga" :director "Desiree Diaz" :role "Costume Director"}
   {:year "2018" :category :fashion :title "Producción para Desfile" :client "The Colorful Collection by Jose Jhan Rodriguez" :role "Producer"}
   {:year "2018" :category :fashion :title "Fitting" :client "Vin Diesel (actor)" :role "Stylist"}
   {:year "2018" :category :fashion :title "Estilismo" :client "Deborah Karter" :role "Fashion Stylist"}
   {:year "2018" :category :film :title "Directora de Vestuario" :client "Programa de TV SEXSOS" :director "Ronni Castillo" :role "Costume Director"}
   {:year "2018" :category :film :title "Set Costumer" :client "Tropical Cop Tales" :production "Studio Pinewood" :role "Set Costumer"}
   {:year "2018" :category :film :title "Set Costumer" :client "La Maravilla" :production "Bou GROUP" :role "Set Costumer"}
   {:year "2018" :category :film :title "Set Costumer" :client "The Long Song" :production "BBC Londres, Pinewood Studio" :role "Set Costumer"}
   {:year "2017" :category :film :title "Directora de Vestuario" :client "Cortometrajes Madrid, España" :projects "Un País Extraño, Nuestro Laberinto, Victoria, Poena, Croquetas, Olivia, Copacabana, Portero Automático, Niña, Cenizas, Zootropo" :role "Costume Director"}
   {:year "2017" :category :film :title "Set Costumer" :client "Rubirosa, E! tiguere" :directors "Carlos Moreno y Hugo Rodriguez" :role "Set Costumer"}
   {:year "2016" :category :film :title "Set Costumer" :client "La Otra Penelope" :director "Viadimir Abudh" :role "Set Costumer"}
   {:year "2015" :category :film :title "Directora de Vestuario" :client "Nostalgia, Obra Teatral" :director "Lia Briones" :award "Nominada Premios Soberanos 2016" :role "Costume Director"}
   {:year "2015-2016" :category :fashion :title "Servicio al Cliente" :client "Tienda Formales" :role "Retail"}
   {:year "2015-2016" :category :fashion :title "Estilismo" :client "Milagros German - Programa de TV Chevere Nights" :role "Fashion Stylist"}
   {:year "2014-2015" :category :fashion :title "Asesora de Novias" :client "Tienda Pronovias, Blue Mall" :role "Consultant"}
   {:year "2014-2015" :category :retail :title "Asesora de Novias" :client "Tienda Pronovias, Blue Mall" :role "Consultant"}
   {:year "2011" :category :fashion :title "Coordinación Backstage & Dresser" :client "Diseñador Custo Barcelona" :role "Coordinator"}])

(def category-colors
  {:fashion {:bg "bg-rose-50" :border "border-rose-300" :dot "bg-rose-500" :text "text-rose-700" :badge "bg-rose-100 text-rose-800"}
   :film {:bg "bg-blue-50" :border "border-blue-300" :dot "bg-blue-500" :text "text-blue-700" :badge "bg-blue-100 text-blue-800"}
   :retail {:bg "bg-emerald-50" :border "border-emerald-300" :dot "bg-emerald-500" :text "text-emerald-700" :badge "bg-emerald-100 text-emerald-800"}})

(def category-names
  {:fashion "FASHION"
   :film "FILM"
   :retail "RETAIL"})

(defn project-detail-modal [selected-project on-close]
  (when @selected-project
    (let [project @selected-project
          colors (category-colors (:category project))
          images (:images project)]
      [:div.fixed.inset-0.z-50.flex.items-center.justify-center.p-4.overflow-y-auto
       {:style {:background "rgba(0, 0, 0, 0.4)" :backdrop-filter "blur(4px)"}
        :on-click on-close}
       [:div.relative.max-w-6xl.w-full.bg-white.rounded-2xl.shadow-xl.my-8.overflow-hidden.flex.flex-col
        {:on-click #(.stopPropagation %)
         :class "animate-fade-in"
         :style {:max-height "90vh"}}
        [:div.flex-shrink-0.p-6.border-b.border-gray-200.bg-gray-50
         [:div.flex.items-center.justify-between
          [:div.flex-1
           [:span.text-xs.font-semibold.uppercase.tracking-wide.px-3.py-1.rounded-full
            {:class (:badge colors)}
            (category-names (:category project))]
           [:h2.font-serif.text-2xl.md:text-3xl.font-bold.mt-3.text-gray-900 (:title project)]
           [:p.text-sm.text-gray-600.mt-1 (:year project)]]
          [:button.text-gray-400.hover:text-gray-600.transition-colors.w-8.h-8.flex.items-center.justify-center.rounded-full.hover:bg-gray-200
           {:on-click on-close}
           [:svg.w-5.h-5 {:fill "none" :stroke "currentColor" :view-box "0 0 24 24"}
            [:path {:stroke-linecap "round" :stroke-linejoin "round" :stroke-width "2" :d "M6 18L18 6M6 6l12 12"}]]]]]
        [:div.flex-1.overflow-y-auto.p-6
         [:div.mb-6.space-y-2
          [:p.text-gray-700
           [:span.font-semibold "Cliente: "] (:client project)]
          (when (:director project)
            [:p.text-gray-700
             [:span.font-semibold "Director: "] (:director project)])
          (when (:production project)
            [:p.text-gray-700
             [:span.font-semibold "Producción: "] (:production project)])
          (when (:photographer project)
            [:p.text-gray-700
             [:span.font-semibold "Fotógrafa: "] (:photographer project)])
          (when (:role project)
            [:p.text-gray-600.text-sm
             [:span.font-semibold "Rol: "] (:role project)])]
         (when (seq images)
           [:div.mt-6
            [:h3.font-serif.text-xl.font-bold.mb-4.text-gray-900 "Galería"]
            [:div.grid.md:grid-cols-2.lg:grid-cols-3.gap-3
             (for [[idx img] (map-indexed vector images)]
               ^{:key (str "modal-img-" idx)}
               [:div.relative.aspect-square.overflow-hidden.rounded-lg.group.cursor-pointer.bg-gray-100
                {:on-click #(js/window.open img "_blank")}
                [:img.w-full.h-full.object-cover.transition-transform.duration-300
                 {:src img
                  :alt (str (:title project) " - Imagen " (inc idx))
                  :class "group-hover:scale-110"
                  :loading "lazy"
                  :on-error (fn [e]
                              (let [target (.-target e)
                                    style (.-style target)]
                                (set! (.-display style) "none")
                                (js/console.error "Failed to load image:" img)))}]
                [:div.absolute.inset-0.bg-black.bg-opacity-0.group-hover:bg-opacity-20.transition-all.duration-300]])]])]]])))

(defn timeline-item-left [project on-click]
  (let [colors (category-colors (:category project))
        has-images (seq (:images project))
        first-image (first (:images project))]
    [:div.relative.flex.items-center.mb-12
     [:div.flex-1.pr-8.text-right
      [:div.relative.inline-block.max-w-md.overflow-hidden
       {:class (str (when-not first-image (:bg colors)) " p-6 rounded-2xl shadow-lg border-l-4 " (:border colors) 
                    (when has-images " cursor-pointer hover:shadow-xl transition-all duration-300"))
        :on-click (when has-images on-click)
        :style (when first-image {:background-image (str "url(" first-image ")")
                                  :background-size "cover"
                                  :background-position "center"})}
       (when first-image
         [:div.absolute.inset-0
          {:style {:background "linear-gradient(to bottom, rgba(0,0,0,0.4), rgba(0,0,0,0.25), rgba(0,0,0,0.5))"}}])
       [:div.relative.z-10
       [:div.flex.items-center.justify-end.mb-2
        [:span.text-xs.font-semibold.uppercase.tracking-wide.px-3.py-1.rounded-full
         {:class (if first-image "bg-white bg-opacity-90 text-gray-900" (:badge colors))}
         (category-names (:category project))]]
       [:div.mb-2
        [:span.text-sm.font-semibold.uppercase.tracking-wide
         {:class (if first-image "text-white" "text-gray-500")}
         (:year project)]]
       [:h4.font-serif.text-xl.font-semibold.mb-2
        {:class (if first-image "text-white" "text-gray-900")}
        (:title project)]
       [:p.text-sm.mb-1
        {:class (if first-image "text-white" "text-gray-600")}
        [:span.font-medium "Cliente: "] (:client project)]
       (when (:director project)
         [:p.text-sm.mb-1
          {:class (if first-image "text-white" "text-gray-600")}
          [:span.font-medium "Director: "] (:director project)])
       (when (:production project)
         [:p.text-sm.mb-1
          {:class (if first-image "text-white" "text-gray-600")}
          [:span.font-medium "Producción: "] (:production project)])
       (when (:role project)
         [:p.text-xs.mt-2.uppercase.tracking-wide
          {:class (if first-image "text-white text-opacity-80" "text-gray-500")}
          (:role project)])
       (when has-images
         [:p.text-xs.text-white.mt-3.italic.font-medium "Click para ver imágenes →"])]]]
     [:div.flex-shrink-0.w-4.h-4.rounded-full.border-4.border-white.shadow-lg.z-10
      {:class (:dot colors)}]
     [:div.flex-1.pl-8]]))

(defn timeline-item-right [project on-click]
  (let [colors (category-colors (:category project))
        has-images (seq (:images project))
        first-image (first (:images project))]
    [:div.relative.flex.items-center.mb-12
     [:div.flex-1.pr-8]
     [:div.flex-shrink-0.w-4.h-4.rounded-full.border-4.border-white.shadow-lg.z-10
      {:class (:dot colors)}]
     [:div.flex-1.pl-8
      [:div.relative.inline-block.max-w-md.overflow-hidden
       {:class (str (when-not first-image (:bg colors)) " p-6 rounded-2xl shadow-lg border-l-4 " (:border colors)
                    (when has-images " cursor-pointer hover:shadow-xl transition-all duration-300"))
        :on-click (when has-images on-click)
        :style (when first-image {:background-image (str "url(" first-image ")")
                                  :background-size "cover"
                                  :background-position "center"})}
       (when first-image
         [:div.absolute.inset-0
          {:style {:background "linear-gradient(to bottom, rgba(0,0,0,0.4), rgba(0,0,0,0.25), rgba(0,0,0,0.5))"}}])
       [:div.relative.z-10
       [:div.flex.items-center.mb-2
        [:span.text-xs.font-semibold.uppercase.tracking-wide.px-3.py-1.rounded-full
         {:class (if first-image "bg-white bg-opacity-90 text-gray-900" (:badge colors))}
         (category-names (:category project))]]
       [:div.mb-2
        [:span.text-sm.font-semibold.uppercase.tracking-wide
         {:class (if first-image "text-white" "text-gray-500")}
         (:year project)]]
       [:h4.font-serif.text-xl.font-semibold.mb-2
        {:class (if first-image "text-white" "text-gray-900")}
        (:title project)]
       [:p.text-sm.mb-1
        {:class (if first-image "text-white" "text-gray-600")}
        [:span.font-medium "Cliente: "] (:client project)]
       (when (:director project)
         [:p.text-sm.mb-1
          {:class (if first-image "text-white" "text-gray-600")}
          [:span.font-medium "Director: "] (:director project)])
       (when (:production project)
         [:p.text-sm.mb-1
          {:class (if first-image "text-white" "text-gray-600")}
          [:span.font-medium "Producción: "] (:production project)])
       (when (:role project)
         [:p.text-xs.mt-2.uppercase.tracking-wide
          {:class (if first-image "text-white text-opacity-80" "text-gray-500")}
          (:role project)])
       (when has-images
         [:p.text-xs.text-white.mt-3.italic.font-medium "← Click para ver imágenes"])]]]]))

(defn timeline-section []
  (let [selected-project (r/atom nil)]
    (fn []
      [:section.py-20.px-6.bg-gray-50
       [:div.max-w-6xl.mx-auto
        [:div.text-center.mb-16
         [:h2.font-serif.text-4xl.md:text-5xl.font-bold.mb-6.gradient-text
          "Trayectoria Profesional"]
         [:p.text-lg.text-gray-600.max-w-2xl.mx-auto.font-light
          "Una carrera dedicada a la moda, el cine y el retail"]]
        
        [:div.relative
         [:div.absolute.w-1.h-full.bg-gray-300.transform
          {:class "left-1/2 -translate-x-1/2"}]
         [:div.space-y-0
          (for [[idx project] (map-indexed vector projects-data)]
            (if (even? idx)
              ^{:key (str "timeline-left-" idx "-" (:title project))}
              [timeline-item-left project #(reset! selected-project project)]
              ^{:key (str "timeline-right-" idx "-" (:title project))}
              [timeline-item-right project #(reset! selected-project project)]))]]]
       
       [project-detail-modal selected-project #(reset! selected-project nil)]])))

