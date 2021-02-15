package me.taesu.demo.chap06

/**
 * Created by itaesu on 2021/02/15.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    shoProgress(23)
    shoProgress(1023)
    shoProgress(-12)


    println(Study06_05_PrimitiveType.Person("taesu", 22).isOlderThan(
            Study06_05_PrimitiveType.Person("taesu")
    ))

    println(Study06_05_PrimitiveType.Person("taesu", 22).isOlderThan(
            Study06_05_PrimitiveType.Person("taesu", 20)
    ))

    println(Study06_05_PrimitiveType.Member("taesu", 22).isOlderThan(
            Study06_05_PrimitiveType.Member("taesu", 11)
    ))

    val i = 1
    // val l: Long = i // compile error, 자바처럼 자동 변환이 되지 않는다
    val l2: Long = i.toLong()

    // val int: Int = 1L // compile error, 자바처럼 자동 변환이 되지 않는다
    val int: Int = (1L).toInt()

    // println(1 == 1L) // java 라면 false int.equals(long)

    val oneInt: Int = 1
    val oneLong: Long = 1L
    // println(oneInt == oneLong)
    println(oneInt.toLong() == oneLong) // 무조건 명시적 볂놘 해야 함

    val longValue1: Long = 42L
    val byteValue1: Byte = 1
    val addValue1 = longValue1 + byteValue1
    println(addValue1)
    println(addValue1 is Long)
}

// 코틀린에는 Primtive type에 대한 Wrapper가 없다
fun shoProgress(percentage: Int) {
    println("${percentage.coerceIn(0, 100)}% completed")
}

private class Study06_05_PrimitiveType {
    class Person(
            val name: String,
            val age: Int? = null
    ) {
        fun isOlderThan(other: Person): Boolean {
            return if (age == null || other.age == null) false else age > other.age
        }
    }

    class Member(
            val name: String,
            var age: Int?
    ) {
        fun isOlderThan(other: Member): Boolean {
            val ageCapture = age ?: return false
            val otherAgeCapture = other.age ?: return false
            // age가 var인 경우 변경될 우려가 있어 위와 같이 val로 갭쳐해줘야 함
            return ageCapture > otherAgeCapture
        }
    }
}