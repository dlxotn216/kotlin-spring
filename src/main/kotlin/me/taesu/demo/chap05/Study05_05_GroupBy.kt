package me.taesu.demo.chap05

/**
 * Created by taesu on 2020-05-23.
 */
fun main(args: Array<String>) {
    Study05_05_GroupBy().exam()
}

class Study05_05_GroupBy {
    private data class Person(val name: String, val age: Int)

    fun exam() {
        println(listOf(Person("taesu", 28),
                Person("Lee", 31),
                Person("User", 31))
                .groupBy { it.age }) // Map<Int, List<Person>>


        //mapKeys를 통해 key 값을 변환할 수 있다
        println(listOf(Person("taesu", 28),
                Person("Lee", 31),
                Person("User", 31))
                .groupBy { it.age }                     // Map<Int, List<Person>>
                .mapKeys { """Age of ${it.key}""" }     // Map<String, List<Person>>
        )

        //mapValues를 통해 value 값을 변환할 수 있다
        println(listOf(Person("taesu", 28),
                Person("Lee", 31),
                Person("User", 31))
                .groupBy { it.age }                     // Map<Int, List<Person>>
                .mapValues { it.value.first() }           // Map<Int, Person>
        )
    }
}