class Estado {

    // uma interrogação no tipo da variável indica que é aceito como valor
    var nome:String? = null
    get() = field?.uppercase()

    /*isso é um GETTER, onde definimos como o valor do campo é entregue tivemos que por no "?"7
    após field porque o campo aceita null
     */

    set(value) {
        if (value?.length!! >= 3) {
            field = value
        }
    }

    var populacao:Int = 0
    set(value) {
        if (value >= 0){ //isso é um bloco SETTER, onde definimos regras
            field = value
        }
    }
}