package dominio

class Gato : Animal() { // Implementando a herança, e dizendo que gato é um animal e recebe seus atributos, ou seja, Gato se tornou uma SubClasse.

    // Basta digitar "override" que irá aparecer um autocomplete das funções disponíveis

    //sobrescrevendo a função "comer" de Animal()
    override fun comer(alimento: String) { // alterando o conteúdo da função para caracteristicas da classe (gato)
        println("Gatinho comendo $alimento e fazendo sujeira")
    }

    override fun respirar() {
        println("Gatinho respirando e ronronando")
    }
}