package me.taesu.demo.chap03

/**
 * Created by taesu on 2020-05-11.
 */

fun main(args: Array<String>) {
    Study3_6_VarArgsAndInfix().exam()
    Study3_6_VarArgsAndInfix().infixExam()
}

class Study3_6_VarArgsAndInfix {

    fun <T> listOfTest(vararg args: T) {
        //vararg 키워드를 통해 가변인자를 받을 수 있다.
        println(args)
    }

    fun <T> listOfTest2(args: Array<T>) {
        //배열을 가변인자로 보낼 때 *를 통해 전달할 수 있다.
        println(listOf("args : ", *args))
    }

    fun exam() {
        listOfTest("a", "b", "c")
        listOfTest2(arrayOf("a", "b", "c"))
    }

    fun infixExam() {
        val pair: Pair<Int, String> = 1 to "one"

        //map의 확장함수인 mapOf는 아래와 같음
        //public fun <K, V> mutableMapOf(vararg pairs: kotlin.Pair<K, V>): kotlin.collections.MutableMap<K, V> { /* compiled code */ }

        println(mapOf(1 to "one", pair, 2 to "two"))

        val (key, value) = 3 to "three"
        println("$key : $value")
        // javascript와 차이점 주의 {key, value}가 아니라 (key, value)임

    }
}