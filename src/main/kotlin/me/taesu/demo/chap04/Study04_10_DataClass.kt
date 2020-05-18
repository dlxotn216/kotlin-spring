package me.taesu.demo.chap04

/**
 * Created by taesu on 2020-05-18.
 */

fun main(args: Array<String>) {
    Study04_10_DataClass().exam()
}

class Study04_10_DataClass {
    private open class User (val name: String, val email: String){
        override fun toString(): String {
            return """$name : $email"""
        }

    }

    private open class UserWithEquals (name: String, email: String): User(name, email){
        override fun equals(other: Any?): Boolean {
            if(other !is UserWithEquals){
                return false
            }

            return (name == other.name) and (email == other.email)
        }
    }

    private class UserWithhashCode (name: String, email: String): User(name, email){
        override fun equals(other: Any?): Boolean {
            if(other !is UserWithhashCode){
                return false
            }

            return (name == other.name) and (email == other.email)
        }

        //equals를 구현했다면 반드시 hashCode도 해주어야 한다.
        override fun hashCode(): Int {
            return name.hashCode() * 31 + email.hashCode()
        }
    }

    fun exam() {
        val taesu = User("taesu", "taesu@crscube.co.kr")
        println(taesu)

        val taesu1 = User("taesu", "taesu@crscube.co.kr")

        //kotlin에서 == 연산자는 내부적으로 equals 메소드 호출 한다
        //자바와 같이 주소값을 비교하려면 === 연산자를 사용
        println(taesu == taesu1)


        val taesuWithEquals = UserWithEquals("taesu", "taesu@crscube.co.kr")
        val taesuWithEquals2 = UserWithEquals("taesu", "taesu@crscube.co.kr")
        println(taesuWithEquals == taesuWithEquals2)    //equals 오버라이딩 했으므로 true

        val hashSet = hashSetOf(taesuWithEquals)
        println(hashSet.contains(taesuWithEquals2)) //will be false


        //hashCode를 구현해주어야 Collection이 정상 동작 한다
        val taesuWithhashCode = UserWithhashCode("taesu", "taesu@crscube.co.kr")
        val taesuWithhashCode2 = UserWithhashCode("taesu", "taesu@crscube.co.kr")

        println(taesuWithhashCode == taesuWithhashCode2)

        val hashSet2 = hashSetOf(taesuWithhashCode)
        println(hashSet2.contains(taesuWithhashCode2))

    }

}