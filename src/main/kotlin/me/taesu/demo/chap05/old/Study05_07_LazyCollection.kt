package me.taesu.demo.chap05.old

/**
 * Created by taesu on 2020-05-26.
 */

fun main(args: Array<String>) {
    Study05_07_LazyCollection().exam()
}

class Study05_07_LazyCollection {
    private data class Person(val name: String)

    fun exam() {
        val filter = listOf(Person("taesu"),
                Person("aef"),
                Person("awefwaf"),
                Person("Kim"),
                Person("yoon"),
                Person("Lee"),
                Person("You"),
                Person("Park"))                      //  List<Person>
                .map { it.name }                            //  List<String>
                .filter { it.startsWith("K") }       //  Filtered List<String>
        println(filter)


        val filter2 = listOf(Person("taesu"),
                Person("aef"),
                Person("awefwaf"),
                Person("Kim"),
                Person("yoon"),
                Person("Lee"),
                Person("You"),
                Person("Park"))                          // List<Person>
                .asSequence()
                .map { it.name }
                .filter { it.startsWith("K") }
                .toList()                                       // Filtered List<String>
        println(filter2)
    }
}