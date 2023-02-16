package sptech.projeto02

class Heroi {

    var nome: String = ""
    var vida: Int = 100
    var forca: Double = 0.0

    fun isVivo(): Boolean {
        return vida > 0
    }

    fun getCategoria(): String {
        return when(forca) {
            in 0.0 .. 100.0 -> "Fraco"
            in 101.9 .. 1000.0 -> "Médio"
            else -> "Forte"
        }
    }
}