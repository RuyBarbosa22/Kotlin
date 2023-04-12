package sptech.projetojpa02

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Cachorro(
        @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY) var codigo: Int,
        var nome: String,
        var castrado: Boolean,
        var peso: Double,
)
