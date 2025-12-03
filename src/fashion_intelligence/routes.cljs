(ns fashion-intelligence.routes
  (:require [reagent.core :as r]
            [clojure.string :as str]))

(def current-route (r/atom :home))
(def current-project-slug (r/atom nil))

(defn title-to-slug [title]
  (-> title
      (str/lower-case)
      (str/replace #"[^a-z0-9]+" "-")
      (str/replace #"^-|-$" "")))

(defn path-to-route [pathname]
  (cond
    (.startsWith pathname "/portfolio/") 
    (let [slug (subs pathname 11)]
      (reset! current-project-slug slug)
      :portfolio-project)
    (= pathname "/portfolio") :portfolio
    (= pathname "/contact") :contact
    (= pathname "/") :home
    :else :home))

(defn route-to-path [route project-slug]
  (case route
    :portfolio-project (str "/portfolio/" project-slug)
    :portfolio "/portfolio"
    :contact "/contact"
    :home "/"
    "/"))

(defn navigate-to [route & [project-slug]]
  (reset! current-route route)
  (when project-slug
    (reset! current-project-slug project-slug))
  (let [path (route-to-path route project-slug)]
    (.pushState (.-history js/window) #js {} "" path))
  (when (not= route :home)
    (.scrollTo js/window 0 0)))

(defn init-routing []
  (let [pathname (.-pathname (.-location js/window))
        route (path-to-route pathname)]
    (reset! current-route route))
  (.addEventListener js/window "popstate"
    (fn [_e]
      (let [pathname (.-pathname (.-location js/window))
            route (path-to-route pathname)]
        (reset! current-route route)))))

(defn current-page []
  @current-route)

