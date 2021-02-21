package me.taesu.demo.chap08

import java.lang.StringBuilder

/**
 * Created by itaesu on 2021/02/21.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    val name = "Lee Tae Su"
    println(name.filter { it != ' ' })
}

fun String.filter(predicate: (Char) -> Boolean): String {
    val stringBuilder = StringBuilder()
    for (e in this) {
        if (predicate(e)) { // 일반 함수 호출 하듯이 호출
            stringBuilder.append(e)
        }
    }
    return stringBuilder.toString()
}