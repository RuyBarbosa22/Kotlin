package sptech.projetojpa03

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.validation.annotation.Validated
import java.time.LocalDate

/*
<Musica, Int>
O 1o valor é o nome da classe de Entidade
O 2o valor é o nome da classe do Id da Entidade

Por padrão, a URI base é o nome da entidade com 's' no final.
No caso, ficará "/musicas"
 */
// caso você queira uma URI personalizada:
// @RepositoryRestResource(path = "sons") // nesse caso, seria "/sons"
interface MusicaRepository : JpaRepository<Musica, Int> {

/*
Aqui usamos a funcionalidade de Dynamic Finder

findBy -> indica uma busca
findByNome -> indica uma busca pelo campo "nome"
O parâmetro "nome" será usado na clásula "where" do select
O retorno é uma List porque podem haver várias músicas com o mesmo nome
 */
    // fun findByNome(nome:String):List<Musica>
//    fun findByNomeContains(nome:String):List<Musica>
    fun findByNomeIgnoreCaseContains(nome:String):List<Musica>

    // Before -> indica uma data antes da que vem no parâmetro
    fun findByDataGravacaoBefore(
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        data:LocalDate
    ):List<Musica>

/*
Para campos booleanos, podemos criar Dynamic Finder com True ou False
No exemplo abaixo, ele buscaria todos com intantil = true
 */
    fun findByInfantilTrue():List<Musica>
/*
Aqui a consulta será:
 "nome" contendo o valor do 1o parâmetro
 E
 "dataGravacao" após o valor do 2o parâmetro
 */
    fun findByNomeContainsAndDataGravacaoAfter(
        nome: String,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        data: LocalDate
    ): List<Musica>

    /*
    Aqui a consulta será:
     "nome" contendo o valor do 1o parâmetro
     E
     "infantil" igual a false
     */
    fun findByNomeContainsAndInfantilFalse(nome: String): List<Musica>

    fun findByNotaSpotifyBetween(
                minima:Double, maxima:Double): List<Musica>
/*
notaSpotify > valor do parâmetro
ordenado por "nome" em order crescente (a -> z)
 */
    fun findByNotaSpotifyGreaterThanOrderByNome(
                        minima:Double): List<Musica>

/*
notaSpotify > valor do parâmetro
ordenado por "nome" em order decrescente (z -> a)
 */
    fun findByNotaSpotifyGreaterThanOrderByNomeDesc(
                        minima:Double): List<Musica>
}







