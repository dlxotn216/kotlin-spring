package me.taesu.demo.chap04

/**
 * Created by itaesu on 14/05/2020.
 *
 * @author Lee Tae Su
 * @version 1.2.0
 * @since 1.2.0
 */

fun main(args: Array<String>){}



class Study04_02_OpenFinalAbstractClass {
    private interface Clickable {
        fun click()

        //java의 default 메소드와 같음
        fun showOff() = println("I', clickable show off")
    }

    //final로 다른 클래스가 상속 불가
    private class Button: Clickable {
        override fun click() = println("Hello i'm button")

        override fun showOff() {
            super<Clickable>.showOff()
        }
    }

    //open이므로 상속 가능
    private open class RichButton: Clickable {
        //기본적으로 fial이다
        fun disable() {}

        open fun animate() {}

        override fun click() {

        }

    }

    //추상 클래스이므로 구현이 필수가 아님
    private abstract class AbstractClickable : Clickable {
        //구현부가 없는 추상메소드
        abstract fun render()
    }

    private class MyButton: RichButton() {
        override fun click() {
        }

        //상속 ㅏㄱ능한 것은 showOff, animate
    }
}