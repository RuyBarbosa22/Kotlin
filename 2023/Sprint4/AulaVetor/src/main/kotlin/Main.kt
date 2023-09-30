@OptIn(ExperimentalStdlibApi::class)
fun main(args: Array<String>) {

    // vetor após criado, não pode ter posições adicionadas, apenas valores alterados
    val vetor1 = arrayOf(1,2,3,4)
    val vetor2 = arrayOf("Domingo", "Sabado", "Sexta-feira", "Quinta-feira")
    val vetor3: Array<Int> // criando um vetor de valor definido, porem sem valores inseridos

    val lista = Array(5) {0} // as listas podem ter posições adicionadas
    val lista2 = Array(5) {it * 10}
    val lista3 = Array(3) {0.0}

    for (i in vetor1) {
        println(i)
    }

    println("____________")

    for (j in vetor2) {
        println(j)
    }

    println("____________")

    for (k in lista) {
        println(k)
    }

    println("____________")

    for (l in lista2.indices) { // exibe os indices do vetor, não valores
        lista3[l] = readln().toDouble()
    }

    for (l in lista2.indices.sortedDescending()) { // exibe os indices do vetor, de forma decrescente
        lista3[l] = readln().toDouble()
    }

    println("Exibindo lista2")

    for (m in lista2) {
        println(m)
    }
}