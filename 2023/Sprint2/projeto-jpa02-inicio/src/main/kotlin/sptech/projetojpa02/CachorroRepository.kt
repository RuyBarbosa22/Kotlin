package sptech.projetojpa02

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.validation.annotation.Validated

@Validated
interface CachorroRepository : JpaRepository<Cachorro, Int> {

    fun findByCastradoTrue(): List<Cachorro>

    fun findByNomeIgnoreCaseContains(nome: String): List<Cachorro>
}
