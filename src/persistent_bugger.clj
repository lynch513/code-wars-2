(ns persistent-bugger
  (:require [clojure.test :refer [is]]))

;; Persistent Bugger

(defn extract-numbers [n]
  (loop [result []
         acc n]
    (if (= acc 0)
      (reverse result)
      (let [mod-result (mod acc 10)]
        (recur (conj result mod-result)
               (int (/ acc 10)))))))

(defn persistence [n]
  (if (< n 10)
    0
    (loop [i 0
           j n]
      (let [number-seq (extract-numbers j)
            multiple-result (reduce * number-seq)]
        (if (< multiple-result 10)
          (inc i)
          (recur (inc i)
                 multiple-result))))))

(comment
  (is (= (persistence 39) 3))
  (is (= (persistence 4) 0))
  (is (= (persistence 25) 2))
  (is (= (persistence 999) 4)))
