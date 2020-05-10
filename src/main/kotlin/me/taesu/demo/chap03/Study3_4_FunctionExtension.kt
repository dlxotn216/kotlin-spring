package me.taesu.demo.chap03

/**
 * Created by itaesu on 11/05/2020.
 *
 * @author Lee Tae Su
 * @version 1.2.0
 * @since 1.2.0
 */

fun main(args: Array<String>) {
    Study3_4_FunctionExtension().exam1()
    Study3_4_FunctionExtension().exam2()
}

class Study3_4_FunctionExtension {

    //확장함수를 통해 클래스에 껴껴넣을 수 있음
    fun <T> Collection<T>.joinToString(
            separator: String,
            prefix: String,
            postfix: String
    ): String {
        var result = prefix

        for ((index, element) in this.withIndex()) {
            if (index < this.size - 1) {
                result += "$element$separator"
            } else {
                result += "$element"
            }
        }

        result += postfix
        return result
    }

    fun exam1() {
        println(listOf("awefawf", "feawfa", "aefawf").joinToString("::", "((", "))"))
    }

    private open class View {
        open fun click() = println("I'm view")
    }

    private class Button : View() {
        override fun click() = println("I'm button")
    }

    fun exam2() {
        val view: View = View()
        val button: View = Button()

        //I'm view
        view.click()
        //I'm button
        button.click()

        fun View.render() = println("Render view")
        fun Button.render() = println("Render button")

        //Render view
        view.render()
        //Render view
        button.render()

        // 확장함수는 오버라이딩 되지 않아 다형성이 나타나지 않음
        // -> 확상함수는 클래스 밖에 선언되므로 정적으로 (컴파일 시점에) 결정 된다.
    }
}