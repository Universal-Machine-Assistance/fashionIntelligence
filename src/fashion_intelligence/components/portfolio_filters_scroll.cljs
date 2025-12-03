(ns fashion-intelligence.components.portfolio-filters-scroll)

(defn setup-scroll-listener [container-ref scroll-y cleanup-fn force-update]
  (let [handle-scroll (fn []
                        (when @container-ref
                          (let [scroll-top (.-scrollTop @container-ref)]
                            (reset! scroll-y scroll-top)
                            (when force-update
                              (swap! force-update inc)))))]
    (when @container-ref
      (.addEventListener @container-ref "scroll" handle-scroll false)
      (reset! cleanup-fn (fn []
                           (when @container-ref
                             (.removeEventListener @container-ref "scroll" handle-scroll false)))))))

(defn setup-time-tracker [time-elapsed animation-interval]
  (let [start-time (js/Date.now)
        update-time (fn []
                     (let [elapsed (/ (- (js/Date.now) start-time) 1000)]
                       (reset! time-elapsed elapsed)))]
    (reset! animation-interval (js/setInterval update-time 100))))

(defn initialize-container [container-ref scroll-y time-elapsed cleanup-fn animation-interval force-update]
  (let [container (.querySelector js/document ".portfolio-page-container")]
    (if container
      (do
        (reset! container-ref container)
        (setup-scroll-listener container-ref scroll-y cleanup-fn force-update)
        (setup-time-tracker time-elapsed animation-interval))
      (js/console.log "ERROR: Could not find .portfolio-page-container"))))
