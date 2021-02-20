package me.taesu.demo.chap08

/**
 * Created by itaesu on 2021/02/20.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    val sum = { x: Int, y: Int -> x + y } // 람다를 변수에 할당
    val action = { print(sum(123, 123)) }
    println(action())

    // 람다의 실제 타입 선언, (Int, Int) -> Int
    val sumDetailDeclaration: (Int, Int) -> Int = { x, y -> x + y }
    // void -> Unit
    val actionDetailDeclaration: () -> Unit = { sumDetailDeclaration(12, 12) }

    twoAndThree({ a, b -> a + b }, 2, 3)
    twoAndThree({ a, b -> a * b }, 2, 3)

    twoAndThree(10, 20) { a, b ->
        a + b
    }
    twoAndThree(10, 20) { a, b ->
        a * b
    }
}

fun twoAndThree(operation: (Int, Int) -> Int, left: Int, right: Int) {
    val result = operation(left, right)
    println("result is $result")
}

fun twoAndThree(left: Int, right: Int, operation: (Int, Int) -> Int) {
    val result = operation(left, right)
    println("result is $result")
}