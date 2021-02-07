package me.taesu.demo.chap02

/**
 * Created by itaesu on 2021/02/07.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    println(percentageValidator(20))
    try {
        println(percentageValidator(200))
    } catch (e: Exception) {
        // 자바와 달리 체크드 예외가 없
        println("exception -> ${e.message}")
    } finally {
        println("process was closed")
    }

    var parsed = try {
        Integer.parseInt("123a")
    } catch (e: Exception) {

    }
    println(parsed)

    parsed = try {
        Integer.parseInt("123")
    } catch (e: Exception) {
        -1
    }
    println(parsed)

    parsed = try {
        Integer.parseInt("123a")    // 블럭의 마지막 값이 결과 값이 된다
    } catch (e: Exception) {
        -1                          // 블럭의 마지막 값이 결과 값이 된다
    }
    println(parsed)

    parsed = try {
        Integer.parseInt("123")    // 블럭의 마지막 값이 결과 값이 된다
    } catch (e: Exception) {
        -1                          // 블럭의 마지막 값이 결과 값이 된다
    } finally {
        "finally"   // this expression is unused
    }
    println("with finally ${parsed}")
}

fun percentageValidator(percentage: Int): String {
    return if (percentage in 0..100) {
        "${percentage}%"
    } else {
        throw IllegalArgumentException("${percentage} is invalid.")
    }
}