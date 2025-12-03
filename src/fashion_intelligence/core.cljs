(ns fashion-intelligence.core
  (:require
   [reagent.dom :as rdom]
   [fashion-intelligence.app :refer [app]]
   [fashion-intelligence.routes :refer [init-routing]]))

(defn mount-root []
  (let [root-el (.getElementById js/document "app")]
    (rdom/render [app] root-el)))

(defn ^:export init []
  (init-routing)
  (mount-root))

(defn ^:dev/after-load reload []
  (mount-root))

