package me.taesu.demo.chap04

/**
 * Created by itaesu on 2021/02/10.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    val button = Button()
    button.click()
    val mouse = Mouse()
    mouse.click()

}

interface Clickable {
    // default method
    fun click() = println("Not yet implemented")
}
class Button : Clickable {
    override fun click() = println("Button clicked")
}
class Mouse : Clickable


// 다중 상속
interface Printer {
    fun print() = println("printer")
}

interface Writer {
    fun print() = println("printer")
}

class PrintWriter : Printer, Writer {
    // 반드시 오버라이딩 해야
    override fun print() {
        // 특정 Super class의 메서드 호출
        super<Printer>.print()
    }
}


// Open
interface Repository {
    fun save()
}

// open을 해줘야 open 메서드를 선언 할 수 있음
open class RepositoryImpl: Repository{
    // final
    fun notOpen() = println("open")

    // open
    open fun open() = println("open")

    // open
    override fun save() {

    }
}

open class SubImpl: RepositoryImpl() {
    // error
    // override fun notOpen() = println("Sub not Open")

    override fun open() = println("Sub Open")

    // 더 이상 상속 금지
    final override fun save() = println("Sub Open")
}

class Child: SubImpl() {
    // error
    // override fun save() = println("Sub Open")
}
