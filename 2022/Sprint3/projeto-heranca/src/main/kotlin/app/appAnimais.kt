package app

import dominio.Animal
import dominio.Cachorro
import dominio.Gato

    // Esse é o arquivo que foi usado para explicar a matéria
    // O próximo arquivo já é um exercício (appConta/dominio2)

fun main() {
    val bicho1 = Animal()
    bicho1.comer("Carne")
    bicho1.respirar()

    // A classe "Gato()" recebe os comportamentos de "Animal(), assim como seus atributos"
    val bicho2 = Gato()
    bicho2.comer("Carne")
    bicho2.respirar()
    bicho2.peso = 4.2
    bicho2.idade = 4

    // Chamamos as funções da mesma forma, mas cada uma com suas respectivas caracteristicas

    val dog1 = Cachorro()
    dog1.comer("Ração")
    dog1.respirar()

    val escolha = 1 //supondo que o usuário escolheu essa opção

    // Fazendo uma validação para qual caracteristica de classe o "bichin" vai seguir
    val bichin = if (escolha == 1) Animal() else if (escolha == 2) Gato() else Cachorro()
    bichin.comer("Ração")
    bichin.respirar()

    // Se o usuário escolhesse 2, o bichin ia se comportar como um gato, seguindo parametros de Gato(), e o mesmo para Cachorro()
    // Esse conceito de o bichin ter a possibilidade de seguir a classe Animal quanto Gato e Cachorro, se chama polimorfismo
}