package aula2308.segundaParte

import javax.swing.JOptionPane

class PedidoPizza {
    lateinit var sabor: String
    var preco: Double = 0.0
    var qtdAmigos: Int = 0

    // criando uma lista vazia que permite entrada e saida/atualização de itens (cupons)
    var cuponsUsados = mutableListOf<String>()

    fun descreverPizza(): String {
        return "Sua pizza é de $sabor e custa $preco"
    }

    fun validarCupom(cupom: String) {
        cuponsUsados.add(cupom) //adicionando o parametro "cupom" na lista
        if (cupom == "#amopizza")
            preco *= 0.9
    }

    fun obterCuponsUsados() : String {
        var frase = "Cupons usados :\r\n"
        cuponsUsados.forEach {frase += "- $it \r\n"}
        return frase
}


    fun obterValorAmigo() {
        preco = preco / qtdAmigos
    }
}
