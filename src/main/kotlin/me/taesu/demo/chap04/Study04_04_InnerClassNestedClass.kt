package me.taesu.demo.chap04

import java.io.Serializable

/**
 * Created by itaesu on 14/05/2020.
 *
 * @author Lee Tae Su
 * @version 1.2.0
 * @since 1.2.0
 */

class Study04_04_InnerClassNestedClass {
    private interface State : Serializable

    private interface View : State {
        fun getCurrentState(): State
        fun restoreState(state: State) {}
    }

    private class Button: View {
        override fun getCurrentState(): State {
            return ButtonState()
        }

        //자바인 경우 일반 클래스라면 직렬화 시 NoSerializableException: Button이 발생
        //클래스 안에 정의한 클래스는 Inner 클래스가 되므로
        //따라서 static을 선언하여 중첩 클래스로 만들어주어야 함
        //코틀린은 기본적으로 static이 붙은 중첩클래스와 동일하다
        private class ButtonState: State

        //inner 키워드를 붙여야 Inner 클래스가 된다
        private inner class ButtonInnerState: State {

            //@Outer를 통해 바깥쪽
            fun getOuter(): Button = this@Button
        }
    }
}