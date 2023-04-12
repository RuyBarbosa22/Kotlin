package sptech.projetojpa02

import net.bytebuddy.asm.Advice.Local
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
@Validated
interface MusicaRepository : JpaRepository<Musica, Int> {

    /*
     findBy = indica uma busca (select)
     o parametro "nome" será usado na cláusula "where" do select
     o retorno é uma List porque podem haver várias músicas com o mesmo nome
     */

    // fun findByNome(nome: String): List<Musica> //acha se for exatamente igual o parametro
    fun findByNomeIgnoreCaseContains(nome: String): List<Musica> // acha qualquer item que tenha em alguma parte o paramentro
    // *ignora Upper/Lower case

    // Before = Uma data antes da que vem no parametro
    // After = depois do parâmetro
    fun findByDataGravacaoBefore(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) data:LocalDate): List<Musica>

    /*
    Para campos booleanos podemos cirar Dynamic Finder com True ou False
    No exemplo abaixo ele buscaria todos com infantil - True
     */

    fun findByInfantilTrue(): List<Musica>

    /*
    Aqui a consulta será:
    "nome" contendo o valor do primeiro parametro
    e
    "dataGravação apos o valor do segundo parametro
     */

//    fun findByNomeContainsAndDataGravacaoAfter(nome: String,
//                                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//                                               data: LocalDate): List<Musica>


    //    fun countByNomeContains(nome: String): Int // count by nome, o valor de nome é oque passamos no paramero da URI do json

//    fun fundbyNotaSpotifyBetween(minimo: Double, maxima: Double): List<Musica>

    // notaSpotify > valor do paremtro
    // ordenado por "nome" em ordem descrescente (z -> a)

    fun findByNotaSpotifyGreaterThanOrderByNome(minima: Double): List<Musica>

    fun findByNotaSpotifyGreaterThanOrderByNomeDesc(minima: Double): List<Musica>



}






