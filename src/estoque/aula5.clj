(ns estoque.aula5)

(def estoque {"Mochila" 10, "Camiseta" 5})                  ; elementos atrelados (10 mochilas, 5 camisetas)
(println estoque)

(println "Temos" (count estoque) "elementos")

(println "As chaves são:" (keys estoque))
(println "Os valores são:" (vals estoque))

; o uso de strings como chaves de mapa não é comum, e sim uma palavra-chave com :nome
(def estoque-keyword {:mochila 10, :camiseta 5})
(println estoque-keyword)

(assoc estoque-keyword :cadeira 3)                          ; adiciona os valores cadeira e 3 em uma cópia do mapa
(println estoque-keyword)
(assoc estoque-keyword :mochila 1)                          ; altera o valor da chave :mochila

(update estoque-keyword :mochila inc)                       ; aplica a função de incrementação no valor de :mochila

(defn tira-um
  [valor]
  (println "tirando m de" valor)
  (- valor 1))

(println (update estoque-keyword :mochila tira-um))         ; atualiza o valor de :mochila, tirando 1
(println (update estoque-keyword :mochila #(- % 3)))        ; tira 3 do valor de mochila

(println (dissoc estoque-keyword :mochila))                 ; remove a chave e o valor :mochila

(def pedido {:mochila { :quantidade 2, :preco 80 }
             :camiseta { :quantidade 3, :preco 40 }})
(println pedido)

(assoc pedido :chaveiro { :quantidade 1, :preco 10 })

(println (pedido :mochila))
(println (get pedido :mochila))
(println (get pedido :cadeira {}))
(println (:mochila pedido))                                 ; a keyword pode ser invocada como função
(println (:cadeira pedido))                                 ; retorna nil

(println (:quantidade (:mochila pedido)))                   ; pega valor aninhado
(println (update-in pedido [:mochila :quantidade] inc))     ; update em mapas aninhados
; THREADING
(println (-> pedido
             :mochila
             :quantidade))                                  ; encadeamento de funções, como pedido.mochila.quantidade

