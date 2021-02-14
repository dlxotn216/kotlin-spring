package me.taesu.demo.chap06

/**
 * Created by itaesu on 2021/02/14.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */

fun main(args: Array<String>) {
    println(strLen("awef"))     // 4
    println(strLen(null))       // null

    // println(strLenWithNull(null))    // compile error
    println(strLenWithDefault(null))    // 0

    println(strLenNullSafe(null))    // 0

    strUpperCase("aaa")
    strUpperCase(null)

    elvisOperator("aaa")
    strUpperCase(null)

    println()
    println(elvisThrowExam("taesu@crscube.co.kr"))
    try {
        println(elvisThrowExam(null))
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    println()
    Study06_01_Nullable().print("taesu@crscube.co.kr")
    try {
        Study06_01_Nullable().print("taesu")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    println()
    Study06_01_Nullable().save("taesu@crscube.co.kr")
    Study06_01_Nullable().save("taesu")
}

// Nullable 타입으로도 오버로딩이 가능하다
fun strLen(s: String) = s.length
fun strLen(s: String?) = s?.length

fun strLenWithNull(s: String) = s.length
fun strLenWithDefault(s: String?) = s?.length ?: 0

fun strLenNullSafe(s: String?): Int {
    return if (s != null) {
        // null이 아님이 확실하니 s?.length 처럼 접근을 하지 않아도 된다
        s.length
    } else {
        0
    }
}

fun strUpperCase(s: String?) {
    // if 검사와 ?. 연산자는 완전 동일하다
    val equality = (if (s != null) s.toUpperCase() else null) == s?.toUpperCase()
    println(equality)
}

fun elvisOperator(s: String?) {
    // if 검사를 이용한 기본 값 처리와 ?:(elvis) 연산자는 완전 동일하다
    val equality = (if (s != null) s.toUpperCase() else "UNKNOWN") == s?.toUpperCase() ?: "UNKNOWN"
    println(equality)
}

fun elvisThrowExam(email: String?) = retrieveUserName(email) ?: throw IllegalArgumentException("$email does not exists")
fun retrieveUserName(email: String?) = email?.substringBefore("@")

private class Study06_01_Nullable {
    data class Member(
            val name: String,
            val email: String
    )

    class MemberRepository {
        fun retrieveMember(email :String) : Member? = if(email.contains("@")) {
            Member(email.substringBefore("@"), email)
        } else {
            null
        }
    }

    fun print(email: String) {
        val member = MemberRepository().retrieveMember(email) ?: throw IllegalArgumentException(email)

        // null이 아님이 보장 됨
        with(member) {
            println("hello $name")
        }
    }

    fun save(email: String) {
        val member = MemberRepository().retrieveMember(email) ?: return
        // null이면 걍 리턴

        // null이 아님이 보장 됨
        with(member) {
            println("saved $name")
        }

    }
}