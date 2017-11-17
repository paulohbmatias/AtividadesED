class ABP(val root: NoTree){
    class NoTree(var conteudo: Int) {
        var esq: NoTree? = null
        var dir:NoTree? = null
    }
    var c:Int = 0


    fun insere(x:Int, node:NoTree?){
        c++
        if(x<node!!.conteudo) {
            if (node.esq == null) node.esq = NoTree(x) else insere(x, node.esq)

        }
        else if (x>node.conteudo)
            if (node.dir == null) node.dir = NoTree(x) else insere(x, node.dir)

    }

}
fun main(args:Array<String>){
    val n = readLine()!!.toInt()
    val elements = IntArray(n)
    elements[0] = readLine()!!.toInt()
    val arv = ABP(ABP.NoTree(elements[0]))
    for(i in 1 until n) {
        elements[i] = readLine()!!.toInt()
    }
    println(arv.c)
    for(i in 1 until n){
        arv.insere(elements[i], arv.root)
        println(arv.c)
    }
}