(ns persistent-bugger-test
  (:require [persistent-bugger :refer [persistence]]
            [clojure.test :refer :all]))

(deftest persistence-test
  []
  (is (= (persistence 39) 3))
  (is (= (persistence 4) 0))
  (is (= (persistence 25) 2))
  (is (= (persistence 999) 4)))



