(ns fashion-intelligence.components.portfolio-filters-constants)

(def scroll-effect-multiplier 3.0)
(def rotation-effect-multiplier 0.5)
(def card-push-speed 150)
(def max-card-push 800)
(def base-top-offset 80)
(def button-spacing 70)

(def filter-buttons-config
  [{:label "Todos" :position :left :idx 0 :filter-value nil}
   {:label "Fashion" :position :right :idx 0 :filter-value :fashion}
   {:label "Film" :position :left :idx 1 :filter-value :film}
   {:label "Retail" :position :right :idx 1 :filter-value :retail}])

