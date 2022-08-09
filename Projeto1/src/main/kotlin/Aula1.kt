import kotlin.math.pow

fun main() {
    println("Olá, mundo");
    println("Bom dia");

    var bairro = "Guaianases";
    val cpf = "111222-99";

    println("Meu bairro é $bairro")
    println("Meu bairro é ${bairro}")
    println("Meu bairro é ${bairro.toUpperCase()}")

    bairro = "Itaquera"
    println("Meu bairro é ${bairro}")

    // cpf = "123456-00"
    // println("Meu bairro é ${cpf}") //apresenta o erro de não poder alterar.

    // não é possível mudar o valor de uma val, por ser uma constante.
    // quando não sabemos qual tipo de variável usar, usamos val.

    val soma = 5 + 4
    val multi = 3 * 3
    val divisao = 90 / 2
    val subtracao = 8 - 3
    val potencia = Math.pow(2.0,3.0) // função para potenciação, devem ser apresentados números reais.
    val potencia2 = 2.0.pow(3)

    println(soma)
    println(multi)
    println(divisao)
    println(subtracao)
    println(potencia)
    println(potencia2)
    val idade = 12

    if (idade > 17){
        println("Maior de idade")
    } else {
        println("Menor de idade")
    }

    var contador = 0

    while (contador < 5){
        println(contador)
        contador++
    }

//     for(c = 0; c < 10; c++){
//         println(c)
//     }		//esse tipo de "for" não é semelhante ao JavaScript no Kotlin.


//estrura de decisão "when".

    var salario = 2100

    when (salario) {
        200 -> println("muito pobre")
        1000 -> println("pobre")
        in 2000..5000 -> println("classe média")
        20000 -> println("#ostentação")
        else -> println ("valor inválido")
    }

    // "->" quer dizer "execute".

    for(n in 0..11){
        println(n)
    }

    val altura = 1.9

    val resultado = if (altura>= 1.8) "alto" else "baixo"

    println(resultado)
    // no kotlin não existe operador ternário, mas é possível fazer if/else em apenas uma linha

    val nota = 7.5

    val situacao = when (nota) { //se a nota estiver em determinada opção, o valor é armazenado na variável "situacao"
        in 0.0..5.99 -> "Reprovado"
        in 6.00..7.50 -> "Estágio s/ escolha"
        in 7.51..10.00 -> "Estágico você escolhe a empresa"
        else -> "nota inválida"
    }

    println(situacao)

}