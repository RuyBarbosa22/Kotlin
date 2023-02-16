class Musica {
    var interprete: String = ""
        set(value) {
            if (value.length >=2){
                field=value
            }
        }
    var acessosSpotify: Int = 0
        set(value) { //recebemos o valor digitado pelo usuário
            if (value>0 && !acessoEncerrado){ //se o valor digitado for maior que zero, e acessoEncerrado for false
                field=value //o campo (acessosSpotify) recebe o valor digitado
            }
        }
    var acessoEncerrado: Boolean = false // pré-definimos o valor da variavel boolean como false



}