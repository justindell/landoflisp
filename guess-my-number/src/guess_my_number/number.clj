;; use with a repl session, for example
;; (ns test                      
;;  (:use guess-my-number.number))
;; test=> (guess-my-number)             
;; =>50
;; test=> (smaller)
;; =>25
;; test=> (bigger)
;; =>37
;; test=> (start-over)
;; =>50

(ns guess-my-number.number
  (:use [clojure.core :only [bit-shift-left]]))

(def *small* 1)
(def *big* 100)

(defn guess-my-number []
  (bit-shift-left (+ *small* *big*) -1))

(defn smaller []
  (def *big* (dec (guess-my-number)))
  (guess-my-number))

(defn bigger []
  (def *small* (inc (guess-my-number)))
  (guess-my-number))

(defn start-over []
  (def *small* 1)
  (def *big* 100)
  (guess-my-number))
