package me.taesu.demo.chap02

/**
 * Created by itaesu on 2021/02/07.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    val study0203Stringtemplate = Study02_03_StringTemplate()

    val name = if (args.isNotEmpty()) args[0] else "default"
    println("Hello $name")
    println("$name 반가워요")
    // println("$name반가워요") // 한글과 붙여 쓸 경우 컴파일 에러
    println("${name}반가워요")
}

class Study02_03_StringTemplate {
}