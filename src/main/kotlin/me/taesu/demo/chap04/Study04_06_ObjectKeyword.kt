package me.taesu.demo.chap04

import java.io.File

/**
 * Created by itaesu on 2021/02/10.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
// 싱글턴 객체 선언
object MathUtils {
    var calculatorCount = 0
    fun add(num1: Int, num2: Int): Int {
        calculatorCount++
        return num1 + num2
    }
}

// 싱글턴 객체는 인터페이스 구현도 가능하여 Comparator 등에 매우 적합
object FilePathComparator : Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }
}

// 중첩 객체 (static)으로도 선언 가능
data class Person(val name: String) {
    object NameComparator : Comparator<Person> {
        override fun compare(o1: Person, o2: Person): Int {
            return o1.name.compareTo(o2.name)
        }
    }
}

class Monster private constructor(val name: String) {

    // 동반객체는 확장함수와 달리 private 멤버에 접근 가능하므로 정적 팩토리 메서드로 활용하기 좋다
    companion object {
        fun fromName(name: String) = Monster(name)
    }

    // 클래스 당 하나의 동반객체를 정의할 수 있다
    // companion object Factory {
    //     fun fromName(name: String) = Monster(name = name)
    // }
}

class Animal private constructor(val type: String = "UNKNOWN", val name: String) {
    // 동반객체에 이름을 붙일 수 있다.
    companion object Factory {
        fun fromName(name: String) = Animal(name = name)
    }
}

interface JsonParser<T> {
    fun fromJson(string: String): T
}

class Response(val key: Long, val id: String) {
    // 동반객체에서 인터페이스 구현이 가능, 이 객체를 파라미터로 전달도 가능
    companion object : JsonParser<Response> {
        private val version: String = "1"
        override fun fromJson(string: String): Response {
            ///...
            return Response(1L, "${version}test")
        }

    }
}

fun Response.Companion.extension(string: String) = Response(2L, "extension")
fun Response.Companion.extension2() {
    // private 멤버엔 접근 불가
}

interface EventListener {
    fun onClick()
}

class WindowButton {
    private val listeners: MutableList<EventListener> = ArrayList()
    fun addEventListener(listener: EventListener) {
        listeners.add(listener)
    }
}

fun main(args: Array<String>) {
    println(MathUtils.add(1, 2))
    println(MathUtils.calculatorCount)
    MathUtils.calculatorCount = 0   // 외부에서 접근도 가능
    // MathUtils() 이미 인스턴스이기 때문에

    println(listOf(Person("Lee"), Person("Kim")).sortedWith(Person.NameComparator))

    println(Monster.fromName("donkey").name)
    println(Animal.Factory.fromName("donkey").name)
    println(Animal.fromName("donkey").name)     // 생략 가능

    var outer = "string"
    WindowButton().addEventListener(
            object : EventListener {        // 익명클래스를 정의할 때도 object 키워드를 사용, 싱글턴은 아님을 주의
                override fun onClick() {
                    outer = "changed"       // 자바와 달리 외부의 변수의 값을 바꿀 수 있음을 주의
                    println("Window button clicked")
                }
            }
    )
}