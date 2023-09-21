(ns array-diff-test
  (:require [array-diff :refer [array-diff]]
            [clojure.test :refer [deftest is]]))

(deftest array-diff-tests
  (is (= (array-diff [1 2] [1]) [2]))
  (is (= (array-diff [1 2 2] [1]) [2 2]))
  (is (= (array-diff [1 2 2] [2]) [1]))
  (is (= (array-diff [1 2 2] []) [1 2 2]))
  (is (= (array-diff [1 2 3] [1 2]) [3]))
  (is (= (array-diff [] [1 2]) [])))
