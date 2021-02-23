package me.taesu.demo.chap09

/**
 * Created by itaesu on 2021/02/24.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    val list1: MutableList<String> = arrayListOf()
    val list2 = arrayListOf<String>()
    // 위 두 선언은 컴파일러에 의해 추론이 가능하기에 동일 선언이다.

    list1.add("1")
    list1.add("afwe")
    list1.add("aef")
    println(list1.slice(1..2))
}

fun <T> List<T>.slice(indices: IntRange): List<T> {
    val result = arrayListOf<T>()
    for (index in indices) {
        result.add(get(index))
    }
    return result
}

val <T> List<T>.penultimate: T
    get() = get(size - 2)