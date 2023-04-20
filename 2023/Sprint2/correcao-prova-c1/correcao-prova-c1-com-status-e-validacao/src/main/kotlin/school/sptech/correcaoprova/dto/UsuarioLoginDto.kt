package school.sptech.correcaoprova.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class UsuarioLoginDto(
        @field:NotBlank @field:Size(min = 4)
        var login: String, //obrigatório, e tenha pelo menos 4 letras
        @field:NotBlank @field:Size(min = 6)
        val senha: String // obrigatório e tenha pelo menos 6 letras
) 