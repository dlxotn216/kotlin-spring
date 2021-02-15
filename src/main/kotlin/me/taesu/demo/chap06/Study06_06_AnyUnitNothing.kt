package me.taesu.demo.chap06

/**
 * Created by itaesu on 2021/02/15.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    val int: Any = 1    // 값 1이 boxing 됨
    // Kotlin의 Any -> Object
    // 하지만 equals, hashCode, toString 외에 wait, notify 등 메서드는 Object로 캐스트 해서 사용해야 한다

    try {
        nothingTest(null)
    } catch (e: Exception) {
        e.printStackTrace()
        println(e)
    }
    nothingTest("23")

    println("without nothing")
    try {
        withoutNothingTest(null)
    } catch (e: Exception) {
        e.printStackTrace()
        println(e)
    }
    withoutNothingTest("23")
}

// Kotlin의 Unit은 자바의 void와 상응한다
// 모든 리턴값이 없는 메서드는 암시적으로 컴파일러에 의해 Unit을 반환하게 되어있다
fun print(string: String) {
    println(string)
}

fun printAndReturnUnit(string: String): Unit {
    return println(string)
}

interface Processor<T> {
    fun proces(input: String): T
    fun supply(t: T): T
}

class ProcessImpl : Processor<Unit> {
    override fun proces(input: String) {
        // 아무것도 반환하지 않아도 된다
    }

    override fun supply(t: Unit) {
        // 파라미터는 반드시 Unit으로 받기는 해야 함..
    }
}

fun throwIllegalArgs(message: String): Nothing = throw IllegalArgumentException(message)

// Unit을 반환하는 것에 명시를 해줘야 함..
fun throwIllegalArgsWithoutNothing(message: String): Unit = throw IllegalArgumentException(message)

fun nothingTest(input: String?) {
    println(input ?: throwIllegalArgs("input is invalid"))
}

fun withoutNothingTest(input: String?) {
    println(input ?: throwIllegalArgsWithoutNothing("input is invalid"))
}
