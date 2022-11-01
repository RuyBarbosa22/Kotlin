package app
import dominio.Conta

    // Encapsulamento (algo privado que pode ser omitido)
    // Existem valores que não podem ser alterados por determinada regra, então para bloquear esse valor
    // na POO, usamos a private var
    // O construtor tambem é uma forma de encapsulamento

fun main() {
    val conta1 = Conta(1000.0, "2552-X", "Ruy") // usando o encapsulamento do construtor da classe

    // conta1.numero = "7674-B"
    // nessa linha tentamos alterar o valor do número de uma conta, mas não conseguimos pois é uma "val"

    //conta1.saldo = 1300.0
    //Isso tambem não daria certo, pois não conseguimos acessar a variavel privada, mesmo que seja var
    // isso vale tanto para altera-la, quanto para ler (print/showMessage) ela

    // usando a função conseguimos ver o valor da private var
    println("Saldo da #1 conta: ${conta1.getSaldo()}")

    if (conta1.pagarConta(250.0)) {
        println("Conta de 250 paga!")
    }else {
        println("Conta de 250 NÃO foi paga")
    }

    // Na teoria isso deveria dar errado, pois estamos tentando pagar uma conta negativa
    if (conta1.pagarConta(-50.0)) {
        println("Conta de -50.0 paga")
    }else {
        println("Conta de -50.0 NÃO foi paga")
    }

    // verificando se o saldo foi reduzido pós pagamento
    println("Saldo da #1 conta: ${conta1.getSaldo()}")

    // tentando pagar uma conta com um valor que não é o suficiente, deveria dar errado
    if (conta1.pagarConta(900.0)) {
        println("Conta de 900 paga!")
    }else {
        println("Conta de 900 NÃO foi paga")
    }

    println("Saldo da #1 conta: ${conta1.getSaldo()}")

    // testando função de receber salário
    conta1.receberSalario(4000.0) // bem humilde
    println("Saldo da #1 conta: ${conta1.getSaldo()}") // testando se recebi


}