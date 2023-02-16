import java.time.LocalDateTime
import java.util.Timer
import java.util.TimerTask

fun main() {

    println("Iniciado!")

    // Timer -> usamos para AGENDAR uma ação
    // A ação está no método run()
    // o número ao final, é o tempo de espera do agendamento, em MS (millisegundos)
    // ex: 3000 -> 3s / 60000 -> 1m (60s)
    Timer().schedule(object : TimerTask() {
        override fun run() {
            println("Agora são ${LocalDateTime.now()}")
        }
    }, 2000)

    // para repetir uma ação a cada X segundos
    mostrarHora()
}

var contador = 0

fun mostrarHora() {
    println("Agora são ${LocalDateTime.now()}")
    Timer().schedule(object : TimerTask() {
        override fun run() {
            contador++
            if (contador < 5) {
                mostrarHora() // agendando a própria função
            }
        }
    }, 2000)
}
