package sptech.projeto01


import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CalculosController {

    /*
    Aqui nosso URI tem PATH PARAM ("que é o "numero"). Sempre entre Seu Madruga {} (Chaves)
    Para que ele fique associado automaticamente a um dos parâmetros,
    é preciso que o parâmetro esteja precedido de @PathVariable
    E o parâmetro deve ter o mesmo nome que conta no @GetMapping
     */

    @GetMapping("/calculos/dobro/{numero}")
    fun dobro(@PathVariable numero:Double):String {
        return "O dobro de $numero é ${numero*2}"
    }

    @GetMapping("/calculos/soma/{n1}/{n2}")
    fun soma(@PathVariable n1:Double, @PathVariable n2:Double):String {
        return "A soma dos numeros $n1 e $n2 é ${n1 + n2}"
    }
}