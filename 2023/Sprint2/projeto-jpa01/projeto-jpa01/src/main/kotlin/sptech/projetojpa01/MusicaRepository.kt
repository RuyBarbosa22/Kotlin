package sptech.projetojpa01

import org.springframework.data.jpa.repository.JpaRepository

// @RepositoryRestResource(path = "sons") // neste caso a URI padrão seria sons

// o banco cria e identifica as tabelas automaticamente, pois o JPA automatiza isso em bancos mais comuns
//no H2 é comum que seja em memoria, então não colocamos nenhuma credencial
// já no mySql, por exemplo,
interface MusicaRepository: JpaRepository<Musica, Int> {
}