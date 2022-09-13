class Cofrinho {
    lateinit var objetivo: String
    var saldo: Double = 0.0
    var meta: Double = 0.0
    var depositos: Int = 0

    fun depositar(valorDeposito: Double) {
        saldo+= valorDeposito
        if (valorDeposito <= 0){
            return
        }
    }

    fun retirar(valorRetirada: Double) {
        saldo -= valorRetirada
        if (valorRetirada <= 0){
            return
        }
    }

    fun porcentagemAteMeta(): Double {
        return (saldo/meta)*100
    }

    fun descrever(): String {
        if (meta > saldo){
            return "O cofrinho de objetivo $objetivo está com R$$saldo de saldo, estando a ${porcentagemAteMeta()}% da meta de R$$meta"
        }else{
            return "O cofrinho de objetivo $objetivo está com R$$saldo de saldo. Já chegou na meta, estando em ${porcentagemAteMeta()}% dela!"
        }
    }
}