(ns fashion-intelligence.components.timeline-utils
  (:require [fashion-intelligence.data.projects :as data]))

(defn normalize-role [role]
  (cond
    (or (= role "Assistant") (= role "Asistente de vestuario") 
        (= role "Asistente Personal del Diseñador") (= role "Asistente General"))
    "Asistente"
    (or (= role "Costume Director") (= role "Directora de Vestuario") 
        (= role "Co-Costume Director") (= role "Costume Designer"))
    "Director"
    (or (= role "Fashion Stylist") (= role "Stylist"))
    "Stylist"
    (= role "Pre-Production")
    "Coordinator"
    (= role "Team Leader")
    "Retail"
    :else role))

(defn get-unique-roles []
  (->> data/projects-data
       (map :role)
       (filter some?)
       (map normalize-role)
       distinct
       sort))

