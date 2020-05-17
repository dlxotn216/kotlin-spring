package me.taesu.demo.chap04

/**
 * Created by taesu on 2020-05-17.
 */
fun main(args: Array<String>){
    Study04_09_PropertySetter().exam()
}

class Study04_09_PropertySetter {

    private class User {
        var name: String="Undefined"
        set(value) {
            println(""" User property name was changed
                | $field -> $value""".trimMargin())
            field = value
            nameCount = field.length
        }

        var nameCount: Int = name.length

        //접근자의 가시성은 기본적으로 property의 가시성과 같으나 아래와 같이 바꿀 수 있음
        private set
    }

    fun exam(){
        val user = User()
        println(user.nameCount)

        user.name = "taesu"
//        user.nameCount = 1 외부에서 접근 불가
        println(user.nameCount)
    }
}