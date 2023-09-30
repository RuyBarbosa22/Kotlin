import java.util.*

fun ehPalindromo() {
    val vetor = arrayOf(1,2,3,3,2,1);
    var certo = 0
    val pilha = Stack<Int>()

    for (i in 0..vetor.size-1) {
        pilha.push(vetor[i])
    }
    for (i in 0..vetor.size-1) {
        if (vetor[i] == pilha.pop()) {
            certo++
        }
    }
    if (certo == vetor.size) {
        println("É palindromo")
    } else {
        println("Não é palindromo")
    }
}