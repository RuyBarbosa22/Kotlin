import java.time.LocalTime
import java.util.*
import kotlin.concurrent.schedule

fun main() {

}

fun saudar() {      //função que usa recursividade para criar um loop infinito
    println("Seja bem vindo! Agora são ${LocalTime.now()}")

    Timer().schedule(3000) {
        saudar()
    }
}