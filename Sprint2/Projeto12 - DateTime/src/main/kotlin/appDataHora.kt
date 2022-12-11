
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main() {
    val hoje = LocalDate.now() // LocalDate é uma classe usada para lidar apenas com datas (horario não)
    // o .now()  é uma função dessa classe que retorna a data atual
    println(hoje)

    val dataQualquer = "2003-11-17" // Criando a data a partir de um texto
    // ou solicitando do usuário

    val data1 = LocalDate.parse(dataQualquer)

    println(data1)

    // para usarmos outro formato de data usamos a classe DateTimeFormatter
    var formato = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var data2 = LocalDate.parse("04/01/2000", formato)
    println(data2) // na tela continua mostrando ano-mes-dia

    val agora = LocalDateTime.now()
    println(agora)

    // todas as linguagens apresentam as datas da mesma forma, seguindo a norma ISO (Formato Internacional
    // ano:mes:dia:Hora:Minuto:Segundo:Nanosegundo

    val dataHoraQualquer = "2000-12-31T21:30:00"
    val dataHora1 = LocalDateTime.parse(dataHoraQualquer)

    var formatoDH = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
    var dataHora2 = LocalDateTime.parse("31/12/2004 15:30:00", formatoDH)
    println(dataHora2) //Continua apresentando no formato ISO

    //exibindo data e hora em formatos "amigaveis"
    var hojeBonito = hoje.format(formato)
    var agoraBonito = agora.format(formatoDH)
    println(hojeBonito)
    println(agoraBonito)

    //operações com data
    val ontem = hoje.minusDays(1)
    println(ontem)

    val amanha = hoje.plusDays(1)
    println(amanha)

    val daquiAlgumasHoras = agora.plusHours(5) //+5 horas
    println(daquiAlgumasHoras)
}