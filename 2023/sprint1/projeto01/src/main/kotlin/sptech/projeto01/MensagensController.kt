package sptech.projeto01

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/*
@Restcontroller -> transforma a classe numa controladora Rest ou seja, ela pode conter
chamadas (funcionalidades públicas) da API
 */
@RestController

class MensagensController {

    /*
    @GetMapping -> transforma o método numa chamada da API
     */
    @GetMapping("/bom-dia") //localhost:8080/bom-dia
    fun bomDia():String {

        return "Bom dia, galera!"

    }

    @GetMapping("/boa-tarde") //localhost:8080/bom-tarde
    fun boaTarde():String{
        return "Boa tarde"
    }

    @GetMapping("/boa-noite") //localhost:8080/boa-noite
    fun boaNoite():String{
        return "oi moanoite oi moanoite oi moanoite oi moanoite oi moanoite oi moanoite oi moanoite"
    }

    @GetMapping("/")
    fun API():String{
        return "Bem-vindo a API"
    }
}