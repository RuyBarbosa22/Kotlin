package sptech.projetojpa03

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/*
Indica que a classe é uma Entidade, ou seja, mapeia uma tabela
 */
@Entity // do pacote javax.persistence
data class Musica(
// @Id do pacote javax.persistence -> indica o campo que é PK
// @GeneratedValue(strategy = GenerationType.IDENTITY) indica que o valor do campo é autoincremento
@field:Id  @field:GeneratedValue(strategy = GenerationType.IDENTITY)
var codigo:Int,

var nome:String,
var dataGravacao:LocalDate,
var notaSpotify:Double,
var infantil:Boolean,
) {
}