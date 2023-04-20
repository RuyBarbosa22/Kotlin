package school.sptech.correcaoprova

import org.hibernate.validator.constraints.br.CPF
import java.time.LocalDate
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Email
import javax.validation.constraints.Future
import javax.validation.constraints.FutureOrPresent
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Past
import javax.validation.constraints.PastOrPresent
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

/*
As anotações de validação só funcionam em classes data class caso as anotações começem com "@field:"
como no código abaixo
 */
data class Usuario(
    @field:NotBlank var login: String, // @NotBlank -> evita null, "" e conteúdo só com espaços
    @field:NotBlank var senha: String, // Existe o @NotEmpty, mas ele deixa passar "     "
    @field:NotBlank @field:Size(min = 5, max = 10) var nome: String, // podemos usar mais de uma validação por campo
    @field:Email var email: String,
    @field:CPF var cpf: String,

//  @Future
//  @FutureOrPresent
//  @PastOrPresent
    @field:Past var nascimento: LocalDate,
    @field:DecimalMin("1200.0") var rendaMensal:Double,

    /*
@Pattern -> aqui usamos uma REGEX (expressão regular)
     */
    @field:Pattern(
        regexp = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})",
        message = "Envie um telefone válido"
    ) var telefone: String,
    /*
    2222-4444
    55555-4444
    11-55555-4444
    (11) 55555-4444
    (11)55555-4444
     */

    var dicaSenha: String,
    var ativo: Boolean,
    var autenticado: Boolean,
    var acessos: Int
)
