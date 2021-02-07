package me.taesu.demo.chap02

/**
 * Created by itaesu on 2021/02/07.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */

fun main(args: Array<String>) {
    val study0201Function = Study02_01_Function()
    println(study0201Function.max(1, 2))

    println(study0201Function.maxWithExpression(2, 3))
}

class Study02_01_Function {
    // 블록이 본문인 함수, 반환 타입의 생략이 불가능 함
    fun max(a: Int, b: Int): Int {
        // 코틀린의 if는 문장이 아닌 식임. 따라서 값을 반환할 수 있음.
        return if (a > b) a else b
    }

    // 식이 본문인 함수, 반환 타입의 생략이 가능 함.
    fun maxWithExpression(a: Int, b: Int) = if (a > b) a else b


}