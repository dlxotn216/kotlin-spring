package me.taesu.demo.chap04

/**
 * Created by itaesu on 14/05/2020.
 *
 * @author Lee Tae Su
 * @version 1.2.0
 * @since 1.2.0
 */

private interface Clickable {
    fun click()

    //java의 default 메소드와 같음
    fun showOff() = println("I', clickable show off")
}

private interface Focusable {
    fun showOff() = println("I', focusable show off")
}

// class, interface 상관없이 :을 통해 상속 및 구현
private class Button: Clickable, Focusable {
    override fun click() = println("Hello i'm button")

    //동일한 시그니처의 메소드 두개인 경우 반드시 아래와 같이 구현 해주어야 함
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

fun main(args: Array<String>){
    Study04_Interface().exam1()
}

class Study04_Interface {
    fun exam1() {
        Button().click()
        Button().showOff()
    }
}