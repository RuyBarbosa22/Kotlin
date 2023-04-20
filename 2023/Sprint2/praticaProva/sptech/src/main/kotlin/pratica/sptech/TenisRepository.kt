package pratica.sptech

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate

interface TenisRepository: JpaRepository<Tenis, Int> {

    //acha se for exatamente igual o parametro
    fun findByModelo(modelo: String): List<Tenis>

    // acha qualquer item que tenha em alguma parte o paramentro & ignora Upper/Lower case
    fun findByNomeIgnoreCaseContains(nome: String): List<Tenis>

    // Before = Uma data antes da que vem no parametro
    fun findByLancamentoBefore(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) data: LocalDate): List<Tenis>

    // After = depois do parâmetro
    fun findByLancamentoAfter(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) data: LocalDate): List<Tenis>

    //Para campos booleanos podemos cirar Dynamic Finder com True ou False
    fun findByBonitoTrue(): List<Tenis> // Acha tenis bonito = True

    fun findByBonitoFalse(): List<Tenis> // Acha tenis bonito = False


    //"nome" = 1º parametro
    // lancamento = 2º parametro

   fun findByNomeContainsAndLancamentoAfter(nome: String,
                                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                               data: LocalDate): List<Tenis>

    // count by nome, o valor de nome é oque passamos no paramero da URI do json
    fun countByNomeContains(nome: String): Int

    // acha tenis com nota
    fun findByNotaGreaterThan(minima: Double): List<Tenis>

    // acha tenis com nota > minima & ordena por nome de forma descrescente
    fun findByNotaGreaterThanOrderByNomeDesc(minima: Double): List<Tenis>

    // acha tenis com nota entre
    fun fundbyNotaSpotifyBetween(minimo: Double, maxima: Double): List<Tenis>
}