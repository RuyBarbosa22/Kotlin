package dominio

@Suppress("UNREACHABLE_CODE")
class Conta (
    private var saldo: Double, //dizendo que esse atributo é encapsulado
    val numero: String,
    val titular: String
){
    // criando uma função para verificar o saldo
    // Aqui usamos o "padrão JavaBean" ou "padrão get/set"

    // Metodo para obter um valor encapsulado: get()
    // Metodo para alterar um valor encapsulado: set()

    fun getSaldo(): Double {
        return saldo
    }

    fun pagarConta(valor:Double):Boolean {
        if (valor < 0 || saldo - valor < 0) { //valida se conta é negativa e se existe saldo
            return false
        }
        saldo -= valor
        return true
    }

    fun receberSalario(salario: Double): Boolean {
        if (salario > 0) {
            saldo += salario
            return true
        } else {
            return false
        }
    }

}