(ns macros-hw.core)

(defmacro if-nonempty-let [bindings then else]
  {:pre [(= 2 (count bindings))]}
  `(let ~bindings
    (if (empty? ~(bindings 0))
      ~else
      ~then)))
