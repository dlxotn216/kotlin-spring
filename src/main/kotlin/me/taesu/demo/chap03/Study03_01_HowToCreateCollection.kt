package me.taesu.demo.chap03

/**
 * Created by itaesu on 2021/02/07.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */

fun main(args: Array<String>) {
    val set = hashSetOf(1, 2, 2, 4)
    val map = hashMapOf(1 to "test", 2 to "obj")
    val list = arrayListOf(1, 2, 4, 2, 5, 6)

    println(set.javaClass)
    println(map.javaClass)
    println(list.javaClass)

    // java의 컬력션과 달리 기본적으로 유용한 것들이 많음
    println("max in set ${set} is ${set.max()}")
    println("last in list ${list} is ${list.last()}")
}