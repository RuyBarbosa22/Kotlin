package sptech.projetojpa03

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/musicas")
class MusicaController(val repository: MusicaRepository) {

    @GetMapping("/melhores")
    fun getMelhores() : ResponseEntity<List<Musica>> {
        val resultado = repository
                        .findByNotaSpotifyGreaterThanOrderByNome(9.5)

        if (resultado.isNotEmpty()) {
            return ResponseEntity.status(200).body(resultado)
        }
        return ResponseEntity.status(204).build()
    }

    @PatchMapping("/{codigo}/nao-mais-infantil")
    fun patchInfantil(@PathVariable codigo:Int): ResponseEntity<Void> {
        if (repository.existsById(codigo)) {
            val musicaRecuperada = repository.findById(codigo).get()
            musicaRecuperada.infantil = false
            repository.save(musicaRecuperada)
            return ResponseEntity.status(200).build()
        } else {
            return ResponseEntity.status(404).build()
        }
    }

}


