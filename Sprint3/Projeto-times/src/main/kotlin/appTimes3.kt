import java.sql.Time
import java.time.LocalTime
import java.util.*
import kotlin.concurrent.schedule

fun main() {
    saudarMasParar(3,0)
}

// aqui criamos uma função com parametros para validarmos um determinado momento ela pare
fun saudarMasParar(repeticao : Int, realizados: Int) {
    if (realizados < repeticao) {
        println("Sejam todos bem vindos! Agora são ${LocalTime.now()}")

        Timer().schedule(3000) {
            saudarMasParar(repeticao, realizados+1)
        }
    }
}