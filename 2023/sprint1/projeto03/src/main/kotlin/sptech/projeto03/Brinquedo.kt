package sptech.projeto03

import java.time.LocalDateTime

class Brinquedo {
    var codigo: Int = 0
    var nome: String = ""
    var idadeMinima: Int = 0
    var preco: Double = 0.0
    var emEstoque: Int = 0
    var ultimaAtt: LocalDateTime = LocalDateTime.now()
}