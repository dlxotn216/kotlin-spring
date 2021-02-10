package me.taesu.demo.chap05.old

/**
 * Created by itaesu on 22/05/2020.
 *
 * @author Lee Tae Su
 * @version 1.2.0
 * @since 1.2.0
 */
fun main(args: Array<String>) {
    Study05_03_CollectionAPI_Filter_Map().exam()
}

class Study05_03_CollectionAPI_Filter_Map {
    private data class Person(val name: String, val age: Int)

    fun exam() {
        println(listOf(1, 2, 3, 4, 5, 6, 7, 8).filter { it % 2 == 0 })
        println(listOf(Person("young men", 18), Person("taesu", 28), Person("old men", 50)).filter { it.age > 30 })

        println(listOf(1, 2, 3, 4, 5, 6, 7, 8).map { it * it })
        println(listOf(Person("young men", 18), Person("taesu", 28), Person("old men", 50)).map { it.name })

        println(listOf(Person("young men", 18), Person("taesu", 28), Person("old men", 50))
                .filter { it.age > 30 }.map { it.name })

    }
}