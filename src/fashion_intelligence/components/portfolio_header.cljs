(ns fashion-intelligence.components.portfolio-header)

(defn portfolio-header []
  [:div.text-center.w-full.mt-8
   {:style {:width "100vw"}}
   [:h1.display-header.dd.text-gray-900.mb-6
    {:style {:text-transform "uppercase"
            :width "100%"
            :font-size "clamp(4rem, 15vw, 12rem)"}}
    "PORTFOLIO"]
   [:p.text-xl.text-gray-600.max-w-2xl.mx-auto.font-light.mb-8
    "Una carrera dedicada a la moda, el cine y el retail"]])

