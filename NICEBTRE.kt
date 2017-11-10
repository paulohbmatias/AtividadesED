fun deph(tree: CharArray?,pos:Int, deph:Int):Int{
    if(tree!![0] == 'l') return 0
    if(tree[pos] == 'n'){
        return if(tree[pos+1] == 'l' && tree[pos+2] == 'l') deph+1
        else deph(tree, pos+1, deph+1)
    }
    else if(tree[pos] == 'l') return deph(tree, pos+1, deph)

    return deph+1
}

fun main(args: Array<String>){
    val n = readLine()!!.toInt()
    val tree = arrayOfNulls<CharArray>(n)
    for(i in 0 until n) tree[i] = readLine()!!.toCharArray()
    for(i in 0 until n) println(deph(tree[i],0, 0))

}