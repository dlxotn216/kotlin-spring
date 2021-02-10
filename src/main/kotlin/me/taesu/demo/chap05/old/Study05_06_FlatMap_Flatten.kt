package me.taesu.demo.chap05.old

/**
 * Created by itaesu on 25/05/2020.
 *
 * @author Lee Tae Su
 * @version 1.2.0
 * @since 1.2.0
 */
fun main(args: Array<String>) {
    Study05_06_FlatMap_Flatten().exam()
}

class Study05_06_FlatMap_Flatten {
    private data class Book(val name: String, val authors: List<String>)

    fun exam(){
        println(listOf(Book("Kotlin in action", listOf("taesu", "lee", "kim")),
                Book("java in action", listOf("yoon", "tim", "Merry")),
                Book("lambda in action", listOf("class", "lee", "taesu")))
                .flatMap { it.authors }     //1. 반복하며 authors로 변환한다 (map(, 2. 하나의 컬렉션으로 합친다 (flatten)
                .toSet())

        val listOfList = listOf(listOf("taesu", "lee", "kim"),
                listOf("qwer", "qqq", "eefawef"),
                listOf("123123", "wef", "kim"))

        println(listOfList.flatMap { it })

        //same with flatMap{ it }
        println(listOfList.flatten())
    }
}