package me.taesu.demo.chap05

/**
 * Created by itaesu on 2021/02/11.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun <E> joinToString(
        list: Collection<E>, prefix: String = "(", postfix: String = ")", delimiter: String = ",",
        transformation: ((E) -> String)? = { it.toString() }
): String {
    var result = prefix
    for ((index, element) in list.withIndex()) {
        val mapped = transformation?.invoke(element)
        result += if (index == (list.size - 1)) {
            mapped
        } else {
            "$mapped$delimiter"
        }
    }
    result += postfix
    return result
}

fun main(args: Array<String>) {
    println(joinToString(arrayListOf(Person("taesu", 20), Person("soyoung", 20))))
    println(joinToString(arrayListOf(Person("taesu", 20), Person("soyoung", 20))) {
        it.name
    })

    // 자바와 달리 filter, map 등 연산이 최종연산임
    // filter
    val people = arrayListOf(Person("taesu", 20), Person("soyoung", 20), Person("doman", 30), Person("kwroe", 19))
    fun Person.isAdult() = age > 19
    people.filter { it.age > 19 }
    people.filter(Person::isAdult)

    // map
    println(people.map { it.name })

    // combination
    println(people.filter { it.age > 19 }.map { it.name })

    // all people are adult?
    println(people.all { it.age > 19 })

    // any people are adult?
    println(people.any { it.age > 19 })

    // how many people are adult?
    println(people.count { it.age > 19 })

    // find any adult's name
    println(people.find { it.age > 19 }?.name) // == firstOrNull
    println(people.firstOrNull { it.age > 200 }?.name ?: "not found")


}