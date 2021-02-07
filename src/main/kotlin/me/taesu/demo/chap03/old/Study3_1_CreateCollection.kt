package me.taesu.demo.chap03.old

/**
 * Created by taesu on 2020-05-06.
 */
fun main(args: Array<String>){
    Study3_1_CreateCollection().exam1()
}

class Study3_1_CreateCollection {
    val set = hashSetOf(1,2,3,4,5,1)
    val list = arrayListOf(2,1,123,123,12,31,1,2,31,5)
    val map = hashMapOf(1 to "one", 2 to "two", 3 to "three")

    fun exam1(){
        println(set.javaClass)
        println(list.javaClass)
        println(map.javaClass)

        println(list.last())
        println(set.max())
    }
}