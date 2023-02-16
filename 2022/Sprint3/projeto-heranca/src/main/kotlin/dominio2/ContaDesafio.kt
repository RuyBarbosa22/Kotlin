package dominio2

open class ContaDesafio(
    val titular: String,
    private var saldo: Double
) {

    open fun getSaldo(): Double {
        return saldo
    }

    open fun depositar(valor: Double) {
        if (valor > 0) {
            saldo += valor
        }
    }

}