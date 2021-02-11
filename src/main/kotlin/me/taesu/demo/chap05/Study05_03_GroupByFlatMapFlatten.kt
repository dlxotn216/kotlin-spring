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

    // flatMap의 결과를 set으로
    println(books.flatMap { it.authors }.toSet())

    // 작가의 나이별 그룹
    println(books.flatMap { it.authors }.toSet().groupBy { it.age })

    // List in List
    println(books.map { it.authors })
    println(books.map { it.authors }.size)  // 2

    // List in List를 펼치고 싶을 때 flatten
    println(books.map { it.authors }.flatten())

    // 작가의 이름, 나이로 하는 맵
    println(books.flatMap { it.authors }.map { it.name to it.age }.toMap())

}