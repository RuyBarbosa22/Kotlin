import java.util.Timer
import kotlin.concurrent.schedule

fun main() {
    fun1(5,0)
}

fun fun1 (repeticao: Int, realizado: Int) {

    if (realizado<repeticao) {
        Timer().schedule(5000) {
            fun2(3,0)

            fun1(repeticao, realizado+1)
        }
    } else {
        fun3(3,0)
    }
}

fun fun2 (repeticao: Int, realizado: Int) {
    if (realizado < repeticao) {
        Timer().schedule(1000) {
            println("Função x2")
            fun2(repeticao, realizado+1)
        }

    }
}

fun fun3 (repeticao : Int, realizado : Int) {
    if (realizado < repeticao) {
        Timer().schedule(3000) {
            println("Função x3")
            fun3(repeticao,realizado+1)
        }
    }

}