package me.taesu.demo.chap99appendix

import java.time.Duration

/**
 * Created by itaesu on 2021/03/02.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main() {
    read("qwer1234")
    println("${(5.seconds() - 400.millis()).toMillis()}ms")

    val map = mutableMapOf(1 to "taesu", 2 to "soyoung")
    println(map[1] ?: "UNKNOWN")
    println(map[12] ?: "UNKNOWN")
    map[12] = "nid"
    println(map[12] ?: "UNKNOWN")
}

// Default parameter의 기본값이 동적으로 계산 될 수 있다.
fun read(str: String, length: Int = str.length) {
    println("$str.length is $length")
}

fun Int.millis(): Duration = Duration.ofMillis(this.toLong())
fun Int.seconds(): Duration = Duration.ofSeconds(this.toLong())