package sptech.projetojpa01

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

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
}





