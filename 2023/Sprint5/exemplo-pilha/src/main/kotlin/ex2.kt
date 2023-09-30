import java.util.Stack

fun converteBinario() {
    val pilha = Stack<Int>()

    if (numDecimal == 0) {
        pilha.push(0)
    } else {
        var num = numDecimal
        while (num>0) {
            val resto = num % 2
            pilha.push(resto)
            num / 2
        }
    }

    println("Número $numDecimal - representação binária: ")
    while (pilha.isNotEmpty()) {
        println(pilha.pop())
    }
    println()
}
