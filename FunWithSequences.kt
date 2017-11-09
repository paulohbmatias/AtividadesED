import java.util.*

fun compara(n:Int, m:IntArray): Boolean{
    for (i in m) if(n==i) return true
    return false
}

fun main(args: Array<String>){
    val reader = Scanner(System.`in`)
    val n = reader.nextInt()
    val t1 = IntArray(n)
    for(i in 0..(n-1)) t1.set(i, reader.nextInt())
    val m = reader.nextInt()
    val t2 = IntArray(m)
    for(i in 0..(m-1)) t2.set(i, reader.nextInt())
    for(i in t1) if(!compara(i, t2)) print("$i ")
}