package me.taesu.demo.chap05

/**
 * Created by itaesu on 2021/02/11.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    val books = arrayListOf(
            Book("Kotlin in action", arrayListOf(
                    Person("Lee", 20),
                    Person("Kim", 22),
                    Person("Park", 26)
            )),
            Book("Java8 in action", arrayListOf(
                    Person("Lee", 20),
                    Person("Jung", 22),
                    Person("Yoon", 26)
            )))
    books.flatMap { it.authors }        // List<T> 생성
            .toSet()                    // Set<T> 생성
            .groupBy { it.age }         // Map<K, List<T>> 생성

    println(books.asSequence()
            .flatMap { it.authors.asSequence() }
            .distinct()
            .groupBy { it.age })        // Map<K, List<T>> 생성


    // 연산 최적화
    println(books.asSequence()
            .flatMap { it.authors.asSequence() }
            .filter {
                println("$it")  // Lee (20), Kim (22)
                it.age > 20
            }
            .map {
                println("$it")  // Kim (22)
                it.name
            }
            .firstOrNull())
}