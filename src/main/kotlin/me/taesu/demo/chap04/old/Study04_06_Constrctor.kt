package me.taesu.demo.chap04.old

/**
 * Created by taesu on 2020-05-15.
 */

fun main(args: Array<String>) {
    Study04_06_Constrctor().exam()
}

class Study04_06_Constrctor {
    //아래는 모두 동일한 클래스의 주 생성자 선언 법
    //주 생성자(Primary constructor)란 클래스 이름 뒤에 오는 생성자를 말한다.
    private class User(val name: String)

    private class User2(name: String){
        val name: String

        init {
            this.name = name
        }
    }

    private open class User3 constructor(name: String){
        val name: String

        init {
            this.name = name
        }
    }

    //아래와 같이 생성자의 인자들에 기본값을 넣을 수 있다.
    private open class User4(val name: String = "unknown")

    //상속 시에 상위 클래스가 가진 프로퍼티는 val이 아닌 일반 인자로 받아서 전달 필요
    private class User5(name: String, val email: String) : User3(name)

    //모든 필드에 Default 값이 있기에 기본 생성자 호출 가능
    private class User6(val email: String) : User4()

    //외부에서 인스턴스 화 ㅏㄱ고 싶다면
    private class User7 private constructor(val name: String)

    fun exam() {
        println(User("taesu").name)
        println(User2("taesu").name)
        println(User3("taesu").name)
        println(User4("taesu").name)
        println(User4().name)
        println(User5("taesu", "taesu@gmail.com").name)
        println(User5("taesu", "taesu@gmail.com").email)
        println(User6("taesu@gmail.com").name)
        println(User6("taesu@gmail.com").email)

//        User7("taesu") 호출 불가
    }
}