@OptIn(ExperimentalStdlibApi::class)
fun main(args: Array<String>) {

    val vetor1 = arrayOf(1,2,3,4)
    val vetor2 = Array(5) {0}
    val vetor3 = Array(5) {it * 10}
    val vetor4 = Array(3) {0.0}
    val vetor5 = arrayOf("Domingo", "Sabado", "Sexta-feira", "Quinta-feira")

    for (i in vetor1) {
        println(i)
    }

    println("____________")

    for (j in vetor2) {
        println(j)
    }

    println("____________")

    for (k in vetor3) {
        println(k)
    }

    println("____________")

    for (l in vetor4.indices) {
        vetor4[l] = readln().toDouble()
    }

    println("Exibindo vetor4")

    for (m in vetor4) {
        println(m)
    }
}