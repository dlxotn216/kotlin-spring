package me.taesu.demo.chap06

/**
 * Created by itaesu on 2021/02/15.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    val m1: Any? = Study06_02_SafeCast.Member(1L, "taesu@crscube.co.kr")
    val m2: Any? = Study06_02_SafeCast.Member(1L, "taesu@crscube.co.kr")
    val m3: Any? = null
    val m4 = Study06_02_SafeCast()

    println(m1 == m2)   // true
    println(m1 == m3)   // false
    println(m1 == m4)   // false
    println(m3 == m4)   // false

    // Assertion, 절대 널이 아니다
    val m1IsNotNull = m1!!
    try {
        val m3IsNotNull = m3!!
    } catch (e: KotlinNullPointerException) {
        println(e)
    }

    try {
        println(m4!!.member!!.email)     // 절대 이런식으로 체이팅해서 Assertion 하지 말 것, 스택트레이스에서 제대로 표현이 안됨
    } catch (e: KotlinNullPointerException) {
        println(e)
    }

    m1?.let {
        println("m1 is not null")
    }

    // m3이 null이기 때문에 절대 실행되지 않는다
    m3?.let {
        println("m1 is not null")
    } // == m3?.let({ println("m1 is not null") })

    // 이런식으로 let을 중첩시키지 말 것. 가독성이 저하된다
    m4?.let {
        m4.member?.let {
            println("m4.member is not null")
        }
    }
}

private class Study06_02_SafeCast(
        val member: Member? = null
) {
    class Member(val key: Long,
                 val email: String) {
        override fun equals(other: Any?): Boolean {
            // as 연산자는 변환 가능하지 않은 타입인 경우 ClassCastException이 발생한다
            // as? 와 같이 사용하면 Cast 불가능한 경우이면 null을 반환한다. 일베스 연산자여 연계하여 사용하면 유용하다
            val otherMember = other as? Member ?: return false
            return otherMember.key == key && otherMember.email == email
        }

        override fun hashCode(): Int = key.hashCode() * 37 + email.hashCode()
    }
}