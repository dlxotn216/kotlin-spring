package me.taesu.demo.chap03

/**
 * Created by itaesu on 2021/02/08.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
var StringBuilder.lastChar: Char
    // {FileName}Kt.getLastChar("string")
    get() {
        return get(length - 1)
    }
    // {FileName}Kt.setLastChar("string", 'b')
    set(char) {
        this.setCharAt(length - 1, char)
    }

fun main(args: Array<String>) {
    val stringBuilder = StringBuilder("Kotlin?")
    println(stringBuilder.lastChar)

    // 프로퍼티처럼 사용 할 수 있다
    stringBuilder.lastChar = '!'
    println(stringBuilder)
}