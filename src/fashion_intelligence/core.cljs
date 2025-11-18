(ns fashion-intelligence.core
  (:require
   [reagent.dom :as rdom]
   [fashion-intelligence.app :refer [app]]))

(defn mount-root []
  (let [root-el (.getElementById js/document "app")]
    (rdom/render [app] root-el)))

(defn ^:export init []
  (mount-root))

(defn ^:dev/after-load reload []
  (mount-root))

