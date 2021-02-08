package me.taesu.demo.chap03

/**
 * Created by itaesu on 2021/02/08.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    println("Kotlin".lastChar())
    println("Kotlin".firstChar())

    println(listOf("Kotlin", "Element").joinToString())
    println(listOf("Kotlin", "Element").joinTo())

    val view: View = View()
    view.click()
    view.extend()

    val button: View = Button()
    button.click()
    button.extend()
    Button().extend()
}

/**
 * 수신 객체 타입: String
 * 수신객체: this
 */
fun String.lastChar(): Char = this[this.length - 1]

// 수신객체의 명시 this 없이 접근 가능
fun String.firstChar(): Char = get(0)
// 코틀린의 확장 함수는 자바의 Static 함수로 변환 됨 -> public static final Char firstChar(String str)

// Generic extension function
fun <T> Collection<T>.joinTo(separator: String = ",", prefix: String = "(", postfix: String = ")"): String {
    var result = prefix
    for ((index, element) in withIndex()) {
        result += if (index.equals(size - 1)) element else "${element}${separator}"
    }
    result += postfix
    return result
}

// String specific
fun Collection<String>.joinToString(separator: String = ",", prefix: String = "(", postfix: String = ")"): String {
    var result = prefix
    for ((index, element) in withIndex()) {
        result += if (index.equals(size - 1)) element else "${element}${separator}"
    }
    result += postfix
    return result
}

open class View {
    open fun click() = println("Hello View")
}

// 재정의 메서드는 동적으로 바인딩 됨
class Button : View() {
    override fun click() = println("Hello Button")
}

// Extension is shadowed by member (동일 시그니처를 가진 멤버 메서드를 확장하는 경우 멤버함수에 가려짐)
fun Button.click() = println("Can i interrupt?")

// 확장 함수는 정적으로 바인딩 됨
fun View.extend() = println("Extended View")
fun Button.extend() = println("Extended Button")