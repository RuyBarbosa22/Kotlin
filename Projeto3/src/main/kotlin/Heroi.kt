import javax.swing.JOptionPane
import javax.swing.JOptionPane.showMessageDialog

fun main() {

    //aqui usamos a tipagem dinâmica
    val nome = "Bruce Lee"
    val idade = 35
    val peso = 75.0
    val vivo = false

    //a linha abaixo NÃO compila, pois não podemos mudar o tipo
    //nome = 9.9

    val cidadeNatal: String //variáveis de tipagem estática oferecem uma segurança maior ao código

    // ao tentarmos atribuir um valor diferente do tipo que foi declarado na variavel recebems um erro
    //na própria linha da variável, facilitando encontrar erros, diferente da tipagem dinâmica

    //cidadeNatal = 9

    //aqui usamos a tipagem estática
    val paisOrigem: String = "Estados Unidos"
    val filhos: Int = 1
    val altura: Double = 1.75
    val lutador: Boolean = true

    treinar(4) //passando um "argumento" para a função com parâmetro
    lutar("Demogorgon", 3)
    meditar(5, 5.0, true)
}

fun treinar(horas: Int) { // função com parâmetro
    println("Heroi treinou por $horas horas")
}

fun lutar(oponente: String, rounds: Int) {
    println("Lutando")
}

fun meditar(tempo: Int, nivelDeConcentracao: Double, ambienteEscuro: Boolean) {

    if (tempo <1 || tempo > 12) {
        showMessageDialog(null, "Tempo inválido")
        return
    } else if (nivelDeConcentracao <0 || nivelDeConcentracao > 3.5){
        showMessageDialog(null,"Nível de concentração inválido")
        return
    }

    var forca = (tempo * 1.5) + (2 * nivelDeConcentracao)
    if (ambienteEscuro == true) {
        forca+15
    }
    println("Após $tempo meditando, o heroi ficou $forca% mais forte")
}