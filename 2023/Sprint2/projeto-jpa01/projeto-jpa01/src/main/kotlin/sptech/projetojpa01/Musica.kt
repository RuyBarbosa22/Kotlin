package sptech.projetojpa01

import net.bytebuddy.asm.Advice.Local
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Musica (
        @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
        var codigo: Int,
        var nome: String,
        var dataCriacao: LocalDate,
        var notaSpotify: Double,
        var infantil: Boolean
){
}