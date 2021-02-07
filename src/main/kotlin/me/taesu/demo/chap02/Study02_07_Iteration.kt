package me.taesu.demo.chap02

/**
 * Created by itaesu on 2021/02/07.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    val oneToHundredRangeClosed = 1..10

    // 자바와 같이 for (int i=0; i<length ;i++)가 없음
    for (num in oneToHundredRangeClosed) {
        println(fizBuzz(num))
    }
    println()

    for (num in 1..10) {
        // range open
        println(fizBuzz(num))
    }
    println()

    for (num in 1 until 10) {
        // range closed
        println(fizBuzz(num))
    }
    println()

    // for (num in 10..1 step 2) { // this range is empty
    // 역방향
    for (num in 10 downTo 1 step 2) {
        println(fizBuzz(num))
    }

    println()
    println(isNumeric('1'))
    println(isNumeric('a'))

    println(isLetter('a'))
    println(isLetter('1'))

    println()
    println(determine('a'))
    println(determine('9'))

    // Range가 아닌 Collection에도 사용 가능
    println("Java" in setOf("Java", "Kotlin", "Scla"))

    val comparableRange = "Java".."Kotlin"
    // Comparable을 사용한 Range의 경우 iterator가 없어 반복이 불가능 하다
    // for(str in comparableRange) { }
}

fun isNumeric(c: Char) = c in '0'..'9'
fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun determine(c: Char) = when (c) {
    in '0'..'9' -> "is Numeric"
    in 'a'..'z', in 'A'..'Z' -> "is Letter"
    else -> "Others"
}

fun fizBuzz(num: Int) = when {
    num % 15 == 0 -> "FizBuz"
    num % 3 == 0 -> "Fiz"
    num % 5 == 0 -> "Buz"
    else -> num.toString()
}

class Study02_07_Iteration {
}