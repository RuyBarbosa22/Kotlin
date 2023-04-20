package provaProgWeb.prova

import org.springframework.data.jpa.repository.JpaRepository

interface CarroRepository: JpaRepository<Carro, Int> {

    fun findByClassicoTrueOrderByPreco(): List<Carro>

    fun findByPrecoLessThan(preco: Double): List<Carro>
}