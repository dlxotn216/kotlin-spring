package me.taesu.demo.chap04.old

/**
 * Created by taesu on 2020-05-16.
 */

fun main(args: Array<String>) {
    Study04_07_SecondaryConstructor().exam()
}

class Study04_07_SecondaryConstructor {
    private open class User {
        val name: String
        var email: String?

        //주 생성자 외의 생성자를 부 생성자라고 한다
        //아래와 같이 다른 부 생성자를 호출할 수 있다
        constructor(name: String) : this(name, null)


        constructor(name: String, email: String?) {
            this.name = name
            this.email = email
        }
    }

    private class User1 : User {
        constructor(name: String) : super(name)

        constructor(name: String, email: String?) : super(name, email)
    }

    private class User2(name: String) : User(name) {
        constructor(name: String, email: String?) : this(name)

        //아래와 같이는 불가. primary constructor call expected
//        constructor(name: String, email: String?) : super(name)
    }

    //웬만해선 부 생성자를 만들지 말고 아래와 같이 기본값을 줄 것
    //부 생성자는 자바 상호운용성 때문에 있는 것이다
    private open class User3(val name: String, var email: String? = null)

    private class User4(name: String) : User3(name)
    private class User5(name: String, email: String?) : User3(name, email)

    fun exam() {
        println(User("lee").name)
        println(User("lee").email)
    }
}