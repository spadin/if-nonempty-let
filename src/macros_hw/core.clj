(ns macros-hw.core)

(defmacro if-nonempty-let [bindings then else]
  `(let ~bindings
    (if (empty? (first ~bindings))
      ~else
      ~then)))
