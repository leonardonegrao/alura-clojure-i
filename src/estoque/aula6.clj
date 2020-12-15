(ns estoque.aula6)

(def pedido {:mochila { :quantidade 2, :preco 80 }
             :camiseta { :quantidade 3, :preco 40 }})

(defn imprime-e-15 [[chave valor]]                          ; desestruturação do vetor
  (println chave "e" valor (class valor))
  15)

(println (map imprime-e-15 pedido))                         ; passa cada vez um vetor de [chave, valor]

(defn preco-dos-produtos [[_ valor]]                         ; underscore deixa claro que o valor será inutilizado
  (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produtos pedido))
(println (reduce + (map preco-dos-produtos pedido)))

(defn preco-total-do-produto [produto]
  (* (:quantidade produto) (:preco produto)))

(defn total-do-pedido
  [pedido]
  (->> pedido
       vals                                                 ; ->> indica thread last e passa o parametro no final
      (map preco-total-do-produto)
      (reduce +)))

(println (total-do-pedido pedido))

(def pedido {:mochila { :quantidade 2, :preco 80 }
             :camiseta { :quantidade 3, :preco 40 }
             :chaveiro { :quantidade 1 }})

(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))

(println (filter (fn [[chave item]] (gratuito? item)) pedido))
(println (filter #(gratuito? (second %)) pedido))

(defn pago?
  [item]
  (not (gratuito? item)))

(println (pago? {:preco 50}))

(println (comp not gratuito?) {:preco 50})                  ; composição de pago usando not e gratuito?
(def pago? (comp not gratuito?))                            ; composição de maneira mais sintática
(println (pago? {:preco 0}))