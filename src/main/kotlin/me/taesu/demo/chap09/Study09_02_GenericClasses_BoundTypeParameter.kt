package me.taesu.demo.chap09

import me.taesu.demo.chap03.joinTo

/**
 * Created by itaesu on 2021/02/24.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
private class Study09_02_GenericClasses {
    abstract class StringList(override val size: Int) : List<String> {
        // List<T> 에서 T -> String으로 구체화 됐으니 오버라이딩 되는 메서드도 모두 String을 따른다
        override fun get(index: Int): String = get(index)
    }

    // 제네릭 클래스의 경우 <T>는 아직 구체화 된 타입이 아니다.
    abstract class StringArrayList<T> : List<T>

    open class Member(val name: String)
    class User(name: String) : Member(name)

}

fun main(args: Array<String>) {
    println(joinNames(arrayListOf(Study09_02_GenericClasses.User("taesu"),
            Study09_02_GenericClasses.Member("soyoung"))))

    println(max("a", "b"))
    // println(max("a", 1)) // T 타입이 일치하지 않으므로
}

// <T extends Member>
fun <T : Study09_02_GenericClasses.Member> joinNames(members: List<T>) = members.map { it.name }.joinTo(",")

fun <T : Comparable<T>> max(first: T, second: T): T {
    // a > b 연산자는 관례에 의해 a.compareTo(b)로 컴파일 된다.
    return if (first > second) first else second
}

// 여러개의 타입 상한을 주어야 할 때
fun <T> multipleGenericLimit() where T : CharSequence, T : Comparable<T> {

}

// null 가능한 타입에 대해 한정해야 할 때, Any?는 Null 가능한 최상위 타입
fun <T : Any?> mayNull(value: T) {
    value?.hashCode()
}

// null이 아닌 타입에 대해 한정해야 할 때, Any는 Null이 아닌 최상위 타입
fun <T : Any> mustNotNull(value: T) {
    value.hashCode()
}