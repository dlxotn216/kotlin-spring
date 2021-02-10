package me.taesu.demo.chap04

/**
 * Created by itaesu on 2021/02/10.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
interface AppUser {
    val nickName: String            // 추상 프로퍼티: 반드시 구현 클래스에서 이 프로퍼티를 구현해야 함
    // val type: String = "DEFAULT" // 인터페이스는 자체 상태를 가질 수 없기 때문에 초기화는 불가능

    val type: String
        get() = "DEFAULT"           // 커스텀 Getter

    fun sayHello() = println("Hello $nickName[$type]")
}

class PrivateUser(
        override val nickName: String
) : AppUser

class FacebookUser(
        val email: String
) : AppUser {
    override val nickName: String
        get() = retrieveNickName(email)

    override val type: String
        get() = "FACEBOOK"


    private fun retrieveNickName(email: String): String {
        // retrieve ...
        return email.substringBefore("@")
    }
}

class Code(code: String) {
    var code: String = code
        private set             // 가시성 제한

    var label: String = ""       // backing field
        set(value) {            // custom setter
            println("$value set to code")
            field = value
        }
}

fun main(args: Array<String>) {
    PrivateUser("Leetaesu").sayHello()
    FacebookUser("taesu@crscube.co.kr").sayHello()

    val code = Code("kor")
    code.label = "한국"
    // code.code = "change" // private
    println(code.code)
}