package sptech.projeto02

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController // Isso é uma anotação
class ContadorController {

    /* Por padrão, todas Rest Controller no Spring Boot é um SINGLETON (Só existe 1),
    sendo assim, só existe uma instância para o projeto */

    var contagem = 0

    // como é um SINGLETON, os atributos de instancia são compartilhados por todas chamadas



    @GetMapping("/contar") // Aqui mapeamos um END-POINT
    fun contar(): String {
        contagem++
        return "Você já acessou $contagem vezes"
    }
}