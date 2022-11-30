package app

import com.lordcodes.turtle.ShellLocation
import com.lordcodes.turtle.shellRun
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main() {
    val diaSemana = LocalDate.now().dayOfWeek.value // Dia da semana (1-7)
    val horaAtual =  LocalDateTime.now() // Data e hora atual

    val formatoHour = DateTimeFormatter.ofPattern("HH:mm:ss")
    val formatoDay = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")

    println(diaSemana)
    println(horaAtual.format(formatoHour))
    println(horaAtual.format(formatoDay))

    val Desktop= ShellLocation.HOME.resolve("C:\\Users\\Mene\\Desktop")
    shellRun(Desktop) {
        files.openFile("C:\\Users\\Mene\\Desktop\\teste.bat")
    }
}

