import java.util.Stack

fun main(args: Array<String>) {
    val pilha = Stack<String>()
    pilha.push("poggers")
    pilha.push("noggers")
    pilha.push("jarjar binks")

    println(pilha)

    val retiraPilha = pilha.pop()
    println("Item retirado = $retiraPilha")

    val espiada = pilha.peek()
    println("Item espiado = $espiada")

    val pilhaNome = Stack<String>()
    pilhaNome.push("R")
    pilhaNome.push("u")
    pilhaNome.push("y")
}
