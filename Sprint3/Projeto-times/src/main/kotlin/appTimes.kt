import java.util.*
import kotlin.concurrent.schedule

fun main() {
    println("Estou apressado ou não?")

    Timer().schedule(4000) {
        println("4 segundos se passaram")

        Timer().schedule(2000) {
            println("2 segundos se passaram")
        }
    }

    println("A pressa é inimiga da perfeição!")
    println("Paciência é uma virtude")


    println("Olha a ansiedade!")
}