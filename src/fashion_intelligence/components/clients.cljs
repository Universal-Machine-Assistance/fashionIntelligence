(ns fashion-intelligence.components.clients
  (:require [reagent.core :as r]))

(def jenny-polanco-images
  [{:src "/images/clients/jenny_polanco/jenny_01.png"
    :alt "Jenny Polanco styling 1"}
   {:src "/images/clients/jenny_polanco/jenny_02.png"
    :alt "Jenny Polanco styling 2"}
   {:src "/images/clients/jenny_polanco/jenny_03.png"
    :alt "Jenny Polanco styling 3"}
   {:src "/images/clients/jenny_polanco/jenny_04.png"
    :alt "Jenny Polanco styling 4"}
   {:src "/images/clients/jenny_polanco/jenny_05.png"
    :alt "Jenny Polanco styling 5"}
   {:src "/images/clients/jenny_polanco/jenny_06.png"
    :alt "Jenny Polanco styling 6"}
   {:src "/images/clients/jenny_polanco/jenny_07.png"
    :alt "Jenny Polanco styling 7"}])

(def film-portfolio-images
  [{:src "/images/clients/en_la_sombra_de_la_democracia/en_la_sombra_de_la_democracia_03.png"
    :alt "En la Sombra de la Democracia - Costume Director"}
   {:src "/images/clients/en_la_sombra_de_la_democracia/en_la_sombra_de_la_democracia_02.png"
    :alt "En la Sombra de la Democracia - Costume Director"}
   {:src "/images/clients/el_ano_del_dragon/el_ano_del_dragon_01.png"
    :alt "El año del dragon - Costume Director"}
   {:src "/images/clients/el_ano_del_dragon/el_ano_del_dragon_02.png"
    :alt "El año del dragon - Costume Director"}
   {:src "/images/clients/judith_rodriguez_alma/judith_rodriguez_alma_01.png"
    :alt "Video Musical Alicia - Costume Director"}
   {:src "/images/clients/judith_rodriguez_alma/judith_rodriguez_alma_02.png"
    :alt "Video Musical Alicia - Costume Director"}
   {:src "/images/clients/are_you_afraid_of_the_dark/are_you_afraid_01.png"
    :alt "Are You Afraid of the Dark - Set Costumer"}
   {:src "/images/clients/are_you_afraid_of_the_dark/are_you_afraid_02.png"
    :alt "Are You Afraid of the Dark - Set Costumer"}
   {:src "/images/clients/la_otra_lucha/la_otra_lucha_01.png"
    :alt "La otra lucha - Coordinator"}
   {:src "/images/clients/la_otra_lucha/la_otra_lucha_02.png"
    :alt "La otra lucha - Coordinator"}
   {:src "/images/clients/a_tiro_limpio/a_tiro_limpio_01.png"
    :alt "A Tiro Limpio - Costume Director"}
   {:src "/images/clients/a_tiro_limpio/a_tiro_limpio_02.png"
    :alt "A Tiro Limpio - Costume Director"}])

(defn image-modal [selected-image on-close]
  (when @selected-image
    [:div.fixed.inset-0.z-50.flex.items-center.justify-center.bg-black.bg-opacity-90.p-4
     {:on-click on-close}
     [:div.relative.max-w-6xl.max-h-screen
      [:button.absolute.top-4.right-4.text-white.text-4xl.font-light.hover:text-gray-300.z-10
       {:on-click on-close}
       "×"]
      [:img.max-w-full.max-h-screen.object-contain
       {:src (:src @selected-image)
        :alt (:alt @selected-image)}]]]))

(defn gallery-grid [images on-image-click]
  [:div.grid.md:grid-cols-2.lg:grid-cols-3.gap-4
   (for [img images]
     ^{:key (:src img)}
     [:div.relative.overflow-hidden.rounded-lg.cursor-pointer.card-hover
      {:on-click #(on-image-click img)}
      [:img.w-full.h-auto.object-cover.transition-transform.duration-500
       {:src (:src img)
        :alt (:alt img)
        :class "hover:scale-105"}]])])

(defn category-section [title description images on-image-click]
  [:div.mb-16
   [:div.text-center.mb-8
    [:h3.font-serif.text-3xl.md:text-4xl.font-bold.mb-4.gold-accent
     title]
    [:p.text-lg.text-gray-600.max-w-2xl.mx-auto
     description]]
   (when (seq images)
     [gallery-grid images on-image-click])])

(defn clients-section []
  (let [selected-image (r/atom nil)]
    (fn []
      [:section.py-20.px-6.bg-white
       [:div.max-w-7xl.mx-auto
        [:div.text-center.mb-16
         [:h2.font-serif.text-4xl.md:text-5xl.font-bold.mb-6.gradient-text
          "Portfolio de Clientes"]
         [:p.text-lg.text-gray-600.max-w-2xl.mx-auto.font-light
          "Proyectos destacados organizados por categoría"]]
        
        [category-section
         "FASHION"
         "Colaboraciones en diseño de moda, estilismo y dirección creativa"
         jenny-polanco-images
         #(reset! selected-image %)]
        
        [category-section
         "FILM"
         "Dirección de vestuario y trabajo en producciones cinematográficas y televisivas"
         film-portfolio-images
         #(reset! selected-image %)]
        
        [category-section
         "RETAIL"
         "Visual merchandising, consultoría y gestión de equipos en retail"
         []
         #(reset! selected-image %)]
        
        [:div.text-center.mt-12
         [:p.text-gray-600.text-lg
          "¿Interesado en colaborar? "
          [:a.gold-accent.font-semibold.hover:underline
           {:href "#contacto"}
           "Contacta conmigo"]]]]
       
       [image-modal selected-image #(reset! selected-image nil)]])))

