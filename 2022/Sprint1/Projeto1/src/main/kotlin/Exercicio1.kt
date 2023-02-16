import kotlin.math.pow

// 1. A partir do peso e altura, calcule e exiba o IMC assim "Seu IMC é de X".

// 2. A partir da idade, exiba "Você já pode votar" para idade >16 ou "Ainda não pode votar" para idade < 16.

// 3. Exiba a frase "Eu S2 mamão" 7 vezes na tela. SEM repetir o código 7 vezes.

// 4. A partir da quantidade de gols que o atacante tem, exiba: "Sem pontária", caso não tenha gols;
// "Pontaria meia boca", caso tenha 1 a 2 gols;
// "Artilheiro", caso tenha mais de 5 gols;
// Caso os gols sejam menor do que 0, não faça nada, apenas ignore!

fun main() {

    // 1.
    val peso = 65.00
    val altura = 1.75

    val imc = peso/(altura.pow(2))

    println("Seu IMC é ${"%.2f".format(imc)}")

    // 2.

    val idade = 18

    if (idade >=16){
        println("Você já pode votar")
    } else{
        "Ainda não pode votar"
    }

    // 3.
    var contador = 0

    while (contador <7){
        println("Eu S2 mamão")
        contador++
    }

    // 4.
    val gols = 5

    if (gols <0) {
        return
    } else if (gols == 0) {
        println("Sem pontária")
    } else if (gols in 1..2) {
        println("Pontaria meia boca")
    } else if (gols in 3..5) {
        println("Dá pro gasto")
    }    else if (gols > 5) {
        println("Artilheiro")
    }

    // usando when

    when (gols) {
        0 -> println("Sem pontaria")
        in 1..2 -> println("Pontaria meia boca")
        in 3..5 -> println("Dá pro gasto")
        else -> println("Artilheiro")
    }

}