package dominio

    // Herança

open class Animal( // No Kotlin, o "open" significa que a classe está aberta a herança, ou seja, ela pode ser uma superclasse(mais comum)/classe base
    var peso: Double = 0.0,
    var idade: Int = 0
) {

/*
Tornamos nossa função "open" para que outras SubClasses possam usar e sobrescreve/-las
Podemos usar a função mesmo que não seja "open", a diferença é que caso não seja, não é possivel fazer
alterações especificas para aquela classe (como fizemos em "Gato()"
*/

    open fun comer(alimento: String) {
        println("Comendo $alimento")
    }

    open fun respirar() {
        println("Respirando")
    }
}