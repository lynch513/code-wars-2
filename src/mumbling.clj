(ns mumbling
  (:require [clojure.test :refer [is]]
            [clojure.string :as str]))


(defn accum [s]
  (->> (loop [count 1
              acc []
              input s]
         (if (empty? input)
           acc
           (let [[head & tail] input
                 repeated-tail (apply str (repeat (dec count) head))
                 capitalized (str/capitalize (str head repeated-tail))]
             (recur (inc count) (conj acc capitalized) (apply str tail)))))
       (str/join "-")))


(comment
  (str/join "-" [1 2 3])
  (accum "TeSt")
  (empty? "")
  (str "" \t)
  (str/capitalize (str \t "t"))
  (str/upper-case \t)
  (str)
  (str \t "est")
  (apply str (repeat 4 \t))
  (let [[h & t] "t"]
    (println (str "head" h) " " (apply str t)))
  (first "test")

  (is (= (accum "ZpglnRxqenU"), "Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn-Uuuuuuuuuuu"))
  (is (= (accum "NyffsGeyylB"), "N-Yy-Fff-Ffff-Sssss-Gggggg-Eeeeeee-Yyyyyyyy-Yyyyyyyyy-Llllllllll-Bbbbbbbbbbb"))
  (is (= (accum "MjtkuBovqrU"), "M-Jj-Ttt-Kkkk-Uuuuu-Bbbbbb-Ooooooo-Vvvvvvvv-Qqqqqqqqq-Rrrrrrrrrr-Uuuuuuuuuuu"))
  (is (= (accum "EvidjUnokmM"), "E-Vv-Iii-Dddd-Jjjjj-Uuuuuu-Nnnnnnn-Oooooooo-Kkkkkkkkk-Mmmmmmmmmm-Mmmmmmmmmmm"))
  (is (= (accum "HbideVbxncC"), "H-Bb-Iii-Dddd-Eeeee-Vvvvvv-Bbbbbbb-Xxxxxxxx-Nnnnnnnnn-Cccccccccc-Ccccccccccc")))
