package me.taesu.demo.chap03

/**
 * Created by itaesu on 2021/02/08.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    val to = "obj" to "user" // == "obj".to("user") => to extension function 호출
    println(to)

    val map = mapOf(1 to "23", 2 to "32", 4 to "12")
    val map2 = mapOf(1.to("23"), Pair(2, "32"), 4.to("12"))
    // 1 to "23 -> 1.to("23") => Pair(1, "23")
    println(map)
    println(map2)

    // destructuring
    val (key, id) = Pair(1L, "taesu")
    val (k, i) = 1L to "taesu"
    println("${key}->${id}")
    println("${k}->${i}")

    for ((index, element) in listOf("taesu", "lee", "kim").withIndex()) {
        println("[${index}]=${element}")
    }

    for ((index, element) in listOf(Code("a", "A"), Code("b", "B")).withIndex()) {
        val (value, label) = element
        println("[${index}]-> $value is $label")
    }
}

// 객체에 대해 destructuring 하려면 component1, 2.. 명시 필요
class Code (val value: String, val label: String) {
    operator fun component1(): String = value
    operator fun component2(): String = label
}

infix fun String.to(other: String) = "${this}-${other}"