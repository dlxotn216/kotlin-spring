package me.taesu.demo.chap04.old

/**
 * Created by taesu on 2020-05-17.
 */
fun main(args : Array<String>){
    Study04_08_InterfacProperty().exam()
}

class Study04_08_InterfacProperty {

    //인터페이스에 추상 프로퍼티 선언은 구현하는 클래스가 반드시 프로퍼티 값을 얻을 수 있는 방법을 제공해야 한다는 규약
    private interface User {
        val name: String
    }

    //주 생성자에서 property를 오버라이드 하고 있다
    private class PrivateUser(override val name: String) : User

    //프로퍼티의 getter를 오버라이드 하였고 매번 계산해서 반환한다
    private class SubscribingUser(val email: String) : User {
        override val name: String
        get() = email.substringBefore("@")
    }

    //프로퍼티 초기화 식을 통해 객체 생성 시에 값을 초기화 한다
    private class FacebookUser(val accountId: Int) : User {
        override val name: String = getNameFromAccountId(accountId)
    }

    fun exam(){
        println(PrivateUser("Taesu").name)
        println(SubscribingUser("taesu@crscube.co.kr").name)
        println(FacebookUser(1).name)
    }
}

private fun getNameFromAccountId(accountId: Int): String{
    return "account ID"
}