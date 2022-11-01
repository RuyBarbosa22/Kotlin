package dominio

class Cachorro : Animal() {

    // Sobrescrevendo função e adaptando caracteristicas
    override fun respirar() {
        println("Respirando e latindo")
    }

    override fun comer(alimento: String) {
        println("Cachorrinho comendo brincando")
    }
}