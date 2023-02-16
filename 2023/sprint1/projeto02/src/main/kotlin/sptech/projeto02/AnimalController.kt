package sptech.projeto02

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/animais")
class AnimalController {

    val animais = mutableListOf<String>()

    @GetMapping("/cadastrar/{novoAnimal}")
    fun cadastrar(@PathVariable novoAnimal: String) : String {
        animais.add(novoAnimal)
        return "Animal $novoAnimal cadastrado com sucesso"
    }

    @GetMapping("/listar")
    fun listar() : String {
        var lista = "${animais.size} animais cadastrados: "
        animais.forEach { lista += "$it, " }
        return lista
    }

    @GetMapping("/{indice}")
    fun pegarUm(@PathVariable indice: Int) : String {
        if (indice >= 0 && indice < animais.size) {
            return animais[indice]
        } else {
            return "Nada encontrado na posição $indice"
        }
    }
}