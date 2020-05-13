package me.taesu.demo.chap04

/**
 * Created by itaesu on 14/05/2020.
 *
 * @author Lee Tae Su
 * @version 1.2.0
 * @since 1.2.0
 *
 *
 * Class 멤버
 * public -> 뫃든 곳에서 접근 가능
 * internal -> 같은 모듈 내 클래스 (모듈이란 컴파일 시 연관된 파일들), 자바는 default(package private)이 있지만 코틀린은 패키지가 단순 네임스페이스임
 * protected -> 상속 관계에 있는 클래스, 자바와 달리 동일 패키지에 있더라도 불가
 * private -> 해당 클래스 내에서만 가능
 *
 * 최상위 선언(파일의)
 * public -> 뫃든 곳에서 접근 가능
 * internal -> 같은 모듈 내 클래스 (모듈이란 컴파일 시 연관된 파일들), 자바는 default(package private)이 있지만 코틀린은 패키지가 단순 네임스페이스임
 * protected -> 선언 불가
 * private -> 해당 파일 내에서만 가능, 다른 파일에서 재선언 불가 (Redeclaration)
 */

class Study04_03_VisibilityModifier {
    private interface Focusable {
        fun focus() {}
    }

    internal open class TalkativeButton : Focusable {
        private fun yell() = println("yell")

        //자바와 달리 같은 패키지에서 접근 불가 Kotlin에선 오직 상속 관계에 있는 클래스에서만 보임
        protected fun whishper() = print("whisper")
    }


    //기본적으로 public이므로 internal 보다 높은 가시성이기에 에러
//    fun TalkativeButton.giveSpeech() {


    internal fun TalkativeButton.giveSpeech() {
        //private 이므로 접근 불가
//        yell()

        //protected이므로 접근 불가
//        whishper()
    }
}