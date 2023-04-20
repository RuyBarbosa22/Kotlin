package pratica.sptech

import net.bytebuddy.dynamic.loading.InjectionClassLoader.Strategy
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Tenis (
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY) var codigo: Int,
    var modelo: String,
    var marca: String,
    var bonito: Boolean,
    var lancamento: LocalDate,
    var nota: Double,
) {
}

