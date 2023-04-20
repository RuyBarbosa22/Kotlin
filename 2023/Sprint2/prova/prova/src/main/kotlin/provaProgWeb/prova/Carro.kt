package provaProgWeb.prova

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Carro (
        @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY) var idCarro: Int,
        var modelo: String,
        var classico: Boolean,
        var preco: Double,
) {
}

