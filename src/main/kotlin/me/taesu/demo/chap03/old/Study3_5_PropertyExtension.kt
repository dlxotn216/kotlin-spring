package me.taesu.demo.chap03.old

/**
 * Created by itaesu on 11/05/2020.
 *
 * @author Lee Tae Su
 * @version 1.2.0
 * @since 1.2.0
 */
fun main(args: Array<String>){
    Study3_5_PropertyExtension().exam()
}

class Study3_5_PropertyExtension {
    var StringBuilder.lastCharAt: Char
        get() = this.get(this.length - 1)
        set(value) = this.setCharAt(this.length - 1, value)

    val StringBuilder.lastCharAt2: Char
        get() = this.get(this.length - 1)
//        set(value) = this.setCharAt(this.length - 1, value)
    //다른 프로퍼티와 마찬가지로 val인 경우엔 set 불가

    fun exam() {
        val value: StringBuilder = StringBuilder("Kotlin?")
        println(value.lastCharAt)

        value.lastCharAt = '!'
        println(value.lastCharAt)
    }
}