package me.taesu.demo.chap03

/**
 * Created by itaesu on 2021/02/08.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    val array = listOf("string", "integer", "double").toTypedArray()
    val concated = listOf("my", *array)  // spread 연산자로 "배열"을 펼침
    println(concated)

    // qprint(*arrayOf("qwer", *array, "awefa")) // redundant
    qprint("qwer", *array, "awefa")
}

fun <T> qprint(vararg elements: T) {
    elements.forEach { println(it) }
}