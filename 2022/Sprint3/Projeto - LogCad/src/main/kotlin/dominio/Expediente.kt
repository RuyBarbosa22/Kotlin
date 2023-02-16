package dominio

import oshi.util.platform.windows.WmiUtil.getDateTime
import java.time.OffsetDateTime

data class Expediente(
    var HrEntrada: String,
    var HrSaida: String,
    var fkEmpresa: Int
) {
    constructor() : this("", "",  0)

}
