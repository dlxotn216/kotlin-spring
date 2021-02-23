package me.taesu.demo.chap08

import java.io.BufferedReader
import java.io.Closeable
import java.io.FileReader
import java.lang.StringBuilder

/**
 * Created by itaesu on 2021/02/23.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    println(readFirstLineFromFile("/Users/itaesu/Desktop/Work/repositories/kotlin-spring/src/main/kotlin/me/taesu/demo/chap08/Study08_07_NonLocalAndResourceManage.kt"))
    // -> package me.taesu.demo.chap08

    // Closeable 인터페이스를 구현하는 (java에서 try-with-resource를 사용할 수 있는 경우 use를 통해 auto close 처리 가능
    // use는 람다를 파라미터로 받는 인라인 함수이다.
    Study08_07_NonLocalAndResourceManage.Resource().use {
        println("hello")
    }

    foreachTest()
    foreachTestWithLocal()
    foreachTestWithLocalWithLabel()
    foreachTestAnonymousFunction()
    println(testThis())
}

fun readFirstLineFromFile(path: String): String {
    BufferedReader(FileReader(path)).use {
        return it.readLine()
    }
}

fun foreachTest() {
    println("foreachTest")
    arrayListOf("lee", "kim", "yoon").forEach{
        println(it)
        if (it == "kim") {
            return // Non local return문 람다가 아닌 바깥쫌 함수를 리턴시키는 문장
            // 람다를 인자로 받는 함수가 인라인 함수인 경우 non local 리턴이 가능해진다.
            // forEach는 인라인 함수이므로 non local return 된다.
        }
    }
    println("all loop finished")
}

fun foreachTestWithLocal() {
    println("foreachTestWithLocal")
    arrayListOf("lee", "kim", "yoon").forEach{
        println(it)
        if (it == "kim") {
            return@forEach  // 인라인 함수에 전달 된 람다에서 람다 바깥의 함수를 리턴시키지 않기 위해 누구를 리턴 시킬 것인지 지정한다.
        }
    }
    println("all loop finished")
}

fun foreachTestWithLocalWithLabel() {
    println("foreachTestWithLocalWithLabel")
    arrayListOf("lee", "kim", "yoon").forEach context@{
        println(it)
        if (it == "kim") {
            return@context  // 라벨을 지정하여 non local return 방지
        }
    }
    println("all loop finished")
}

fun foreachTestAnonymousFunction() {
    println("foreachTestAnonymousFunction")
    arrayListOf("lee", "kim", "yoon").forEach(fun (it) {    // 라벨을 붙이는 것은 너무 장황하다. 익명 함수를 사용하면 좋다.
        println(it)
        if (it == "kim") {
            return
        }
    })
    println("all loop finished")
}

fun testThis() = StringBuilder().apply outer@{  // this: StringBuilder
        listOf(1,2,3).apply {                   // this: List<Int>
            this@outer.append(this)
        }
    }.toString()

private class Study08_07_NonLocalAndResourceManage {
    class Resource: Closeable {
        override fun close() {
            println("close resource")
        }
    }
}