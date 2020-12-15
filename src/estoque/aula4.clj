(ns estoque.aula4)

(def precos [30, 700, 1000])

; podemos usar o get ou o próprio vetor para retornar elementos, mas com get garantimos que não haverá exceptions
(println (precos 0))
(println (get precos 2))
(println (get precos 17 0))                                 ; recebe um valor padrão de retorno (0) quando não encontrar

(println (conj precos 5))                                   ; não altera o vetor original
(println precos)

(println (inc 5))                                           ; soma 1, similar a ++ em outras linguagens

(println (update precos 0 inc))                             ; update aplica uma função em algum elemento de um vetor

(defn soma-3 [valor] (+ valor 3))
(println (update precos 0 soma-3))                          ; o elemento será passado como parametro de soma 3

(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println "map" (map valor-descontado precos))               ; para cada elemento, chama valor-descontado

(println (range 10))                                        ; retorna o range de 0 a 10
(println (filter even? (range 10)))                         ; retorna apenas os números pares do range

(println "vetor" precos)
(println "filter" (filter aplica-desconto? precos))         ; retorna apenas valores que atendem ao requisito

(println (reduce + precos))                                 ; soma os valores da coleção

(defn minha-soma [valor-1
                  valor-2]
  (println "somando" valor-1 valor-2)
  (+ valor-1 valor-2))

(println (reduce minha-soma precos))                        ; reduce com função personalizada
(println (reduce minha-soma (range 10)))

(println (reduce minha-soma 0 precos))                      ; começa somando 0 com o primeiro elemento

