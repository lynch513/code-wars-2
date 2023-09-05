(ns array-diff
  (:require [clojure.test :refer [is]]))

(defn array-diff [a b]
  (remove (set b) a))

(comment
  (into #{} [2 2])
  (remove #{1} [1 2])
  (array-diff [1 2] [1])

  (set [1 2])
  ((set [1 2]) 1)
  ((complement (set [1 2])) 3)
  ((set 1) [1 2])
  ([1 2] 1)

  (is (= (array-diff [1 2] [1]) [2]))
  (is (= (array-diff [1 2 2] [1]) [2 2]))
  (is (= (array-diff [1 2 2] [2]) [1]))
  (is (= (array-diff [1 2 2] []) [1 2 2]))
  (is (= (array-diff [1 2 3] [1 2]) [3]))
  (is (= (array-diff [] [1 2]) [])))
