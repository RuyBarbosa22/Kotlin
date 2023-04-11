package school.sptech.correcaoprova


import org.hibernate.validator.constraints.br.CPF
import java.time.LocalDate
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Past
import javax.validation.constraints.Size
import kotlin.math.max

class Usuario {
    @NotBlank var login: String = ""
    @NotBlank var senha: String = ""
    @NotBlank @Size(min = 5, max = 10) var nome: String = ""
    @Email var email: String = ""
    @CPF var cpf: String = ""
    @Past var nascimento: LocalDate? = null
    var rendaMensal: Double = 0.0
    var dicaSenha: String = ""
    var ativo: Boolean = true
    var autenticado: Boolean = false
    var acessos: Int = 0

    //@Future
    //@FutureOrPast
    //PastOrPresent
}
