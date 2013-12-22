(ns macros-hw.core-spec
  (:require [speclj.core :refer :all]
            [macros-hw.core :refer :all]))

(describe "if-nonempty-let"
  (it "evaluates then body when list is non-empty"
    (should= [:non-empty [0 1 2 3 4]]
             (if-nonempty-let [xs (range 5)]
                              [:non-empty xs]
                              :empty)))

  (it "evaluates else body when list is empty"
    (should= :empty
             (if-nonempty-let [xs []]
                              [:non-empty xs]
                              :empty)))

  (it "evaluates then body when string is not empty"
    (should= "ohai there"
             (if-nonempty-let [x "ohai"]
                              (str x " there")
                              :else)))

  (it "evaluates else body when string is empty"
    (should= :else
             (if-nonempty-let [x ""] x :else))))
