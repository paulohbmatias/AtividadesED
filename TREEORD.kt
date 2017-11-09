fun sameTree(inOrder: List<Int>, preOrder: List<Int>, posOrder: List<Int>, nos:Int):Boolean{
    var inOrder2 = inOrder
    var posicao:Int = -1
    var pos = 0
    var n = nos-1
    var preOrder2 = preOrder
    while(true) {
        if(preOrder[0] != posOrder[nos-1]) return false
        for (i in 0..n) if (inOrder2[i] == preOrder2[0]) posicao = i
        if(posicao != 0){
            preOrder2 = preOrder2.subList(1, preOrder2.size)
            n = posicao-1
            continue
        }
        if(posicao != n) {

            preOrder2 = preOrder2.subList(posicao+1, preOrder2.size)
            n = n - posicao
            inOrder2 = inOrder2.subList(posicao+1, inOrder2.size)
            continue
        }
        return preOrder2[0] == posOrder[pos++]

    }

}

fun main(args: Array<String>) {
    val nos = readLine()!!.toInt()
    val preOrder = readLine()!!.split(' ').map(String::toInt)
    val posOrder = readLine()!!.split(' ').map(String::toInt)
    val inOrder = readLine()!!.split(' ').map(String::toInt)

    print(if(sameTree(inOrder, preOrder, posOrder, nos)) "yes" else "no")
}

