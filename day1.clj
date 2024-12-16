(ns clojure.adventofcode.day1
  (:gen-class))

(require '[clojure.java.io :as io]
         '[clojure.string :as str])

(defn read-two-column-file [filename]
  (with-open [r (io/reader filename)]
    (doall
     (map (fn [line]
            (let [[a b] (str/split line #"\s+")]
              [(Integer/parseInt a) (Integer/parseInt b)]))
          (line-seq r)))))

(defn calculate-distance [file-data]
  (let [col1 (sort (map first file-data))
        col2 (sort (map second file-data))]
    (reduce + (map (fn [a b] (abs (- a b))) col1 col2))))

(defn calculate-frequencies [file-data]
  (let [col1 (sort (map first file-data))
        col2 (sort (map second file-data))
        freq-map (frequencies col2)]
    (reduce + (map (fn [x] (* x (get freq-map x 0))) col1))))

(println (calculate-distance (read-two-column-file "data")))
(println (calculate-frequencies (read-two-column-file "data")))
