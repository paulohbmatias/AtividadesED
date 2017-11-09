import java.util.*


class LSE {
    class No {
        var conteudo: String? = null
        var prox: No? = null

        init {
            prox = null
        }


    }
    private var cabeca: No? = null
    var nElementos: Int = 0

    init {
        cabeca = null
        nElementos = 0
    }

    fun elemento(pos: Int): String? {

        var aux = cabeca
        // Percorre a lista do 1o elemento até pos
        for (i in 1 until pos) {
            // modifica "aux" para apontar para o proximo elemento da lista
            aux = aux!!.prox
        }

        return aux!!.conteudo
    }

    fun insere(pos: Int, valor: String): Boolean {
        val novoNo = No()
        novoNo.conteudo = valor

        if((pos == 1)){
            novoNo.prox = cabeca
            cabeca = novoNo
        }else{
            var aux = this.cabeca
            while (aux!!.prox != null) {
                aux = aux.prox
            }
            novoNo.prox = null
            aux.prox = novoNo
        }
        nElementos++
        return true
    }


}
fun recorrencia(list:LSE, prefix:String) : Int{
    var cont = 0
    for (i in 1..list.nElementos) if(list.elemento(i)!!.startsWith(prefix)) cont++
    return cont
}

fun main(args: Array<String>){
    val reader = Scanner(System.`in`)
    val n = reader.nextInt()
    val list = LSE()
    val q = reader.nextInt()
    val prefix = LSE()


    for(i in 1..n) list.insere(i, reader.next())
    for(i in 1..q) prefix.insere(i, reader.next())
    for(i in 1..q) println(recorrencia(list, prefix.elemento(i)!!))
}



