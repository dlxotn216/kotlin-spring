package me.taesu.demo.chap09

import java.util.*

/**
 * Created by itaesu on 2021/02/24.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    val list1 = arrayListOf(1,2,3,4)
    val list2 = arrayListOf("1,2,3,4", "5,6,7,8")
    // 컴파일러는 두 리스트를 서로 다른 타입으로 본다. 하지만 런타임엔 동일한 List객체이다.

    // 제네릭화 된 타입을 컴파일 시점에 체크할 수 없다. -> 코드가 동작하는 실행시점엔 제네릭 타입이 소거되어 최적화 되기 때문
    // val value: Any = list1
    // if (value is List<Int>) {
    //
    // }

    // 컴파일 시점에 타입이 주어진 경우는 가능하다, 그리고 어짜피 true이다.
    if (list1 is List<Int>) {

    }

    // 변수가 리스트인지는 알 수 있다. // List<*> == List<?>, 스타 프로젝션이라 부른다.
    if (list1 is List<*>) {
        println("i'm list")
    }

    // 실체화 된 파라미터를 넘겨서 타입 비교를 할 수 있다.
    println(isA<String>("a"))
    println(isA<String>(1))

    // list1은 List<Int>이나 실행시점엔 List로 타입이 모두 소거 됨을 주의.
    println(isA<List<Int>>(list1))      // true
    println(isA<List<String>>(list1))   // true

    // filterIsInstance 표준 라이브러리 함수
    println(listOf(1, 2, "awef").filterIsInstance<String>())
    /*
    // 아래와 같이 컴파일 된다.
    for (element in list) {
       if(element is String) {
            result.add(element)
       }
    }
     */

    // 클래스로더를 통해 로드를 하는 것을 손쉽게 줄일 수 있다.
    println(load<Study09_03_RuntimeGeneric>())
}

class Study09_03_RuntimeGeneric

// 일반적인 함수에서 타입인자 비교가 불가능하다
// fun <T> isA(value: Any) = value is T

// 인라인 함수는 컴파일 시점에 인라이닝 된다.
// refied 키워드를 붙이면 실행시점에 타입을 비교할 수 있게 된다.
inline fun <reified T> isA(value: Any) = value is T

inline fun <reified T> load() = ServiceLoader.load(T::class.java)