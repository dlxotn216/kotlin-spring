package me.taesu.demo.chap05.old

/**
 * Created by itaesu on 22/05/2020.
 *
 * @author Lee Tae Su
 * @version 1.2.0
 * @since 1.2.0
 */

fun main(args: Array<String>) {
    Study05_04_any_all_count().exam()
}

class Study05_04_any_all_count {
    private data class Person(val name: String, val age: Int)

    fun exam() {
        //all -> 컬렉션의 모든 요소가 lambda의 predicate를 만족하는가?
        println(listOf(Person("young men", 38), Person("taesu", 28), Person("old men", 50)).all { it.age > 19 })
        println(listOf(Person("young men", 38), Person("taesu", 28), Person("old men", 50)).all { it.age > 29 })

        //any -> 컬렉션의 요소 중 하나 이상의 요소가 lambda의 predicate를 만족하는가?
        println(listOf(Person("young men", 38), Person("taesu", 28), Person("old men", 50)).any { it.age > 40 })
        println(listOf(Person("young men", 38), Person("taesu", 28), Person("old men", 50)).any { it.age > 60 })


        //count -> 컬렉션의 요소 중 lambda의 predicate에 만족하는 개수
        println(listOf(Person("young men", 38), Person("taesu", 28), Person("old men", 50)).count { it.age > 40 })

        //아래처럼 해도 결과는 같다. 하지만 내부 구현에서 보면 filter는 연산에 대해서 컬렉션을 생성한다.
        //반면 count는 집계 만 진행한다.
        println(listOf(Person("young men", 38), Person("taesu", 28), Person("old men", 50)).filter { it.age > 40 }.size)


        //두 결과는 같다
        println(listOf(Person("young men", 38), Person("taesu", 28), Person("old men", 50)).firstOrNull { it.age > 40 })

        //fir st or null과 같다
        println(listOf(Person("young men", 38), Person("taesu", 28), Person("old men", 50)).find { it.age > 40 })
    }
}