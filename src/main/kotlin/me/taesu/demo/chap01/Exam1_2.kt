package me.taesu.demo.chap01

/**
 * Created by itaesu on 04/05/2020.
 *
 * @author Lee Tae Su
 * @version 1.2.0
 * @since 1.2.0
 */

fun main(args: Array<String>) {
    println(max(20, 10))
    println(max(10, 10))
    println(max(10, 13))

    println(min(20, 10))
    println(min(10, 10))
    println(min(10, 13))


    //immutable
    val integer1 = 24;
//    integer1 = 241;   //error

    //mutable
    var integer2: Int
    integer2 = 241;

    //mutable 이지만 타입이 다른 경우엔 대입될 수 없다.
    var integer3 = 24;
//    integer3 = "aeawf" //error

    var name = "Lee Tae Su"
    println("Hello $name")

    name = "이태수";
//    println("Hello $name님")   name님 자체를 변수로 인식함
    println("Hello ${name}님")   //중괄호로 감싸는 습관을 들이는 것이 좋다.
    println("Hello ${if (name == "이태수") "이태수__" else "taesu"}님")   //중괄호 안에선 따옴표도 사용 가능

}

//Kotlin의 if문은 문장이 아닌 값을 반환하는 식이다.
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

//함수 본문이 하나의 식인 경우 아래와 같이 간결하게 표현할 수 있다.
fun min(a: Int, b: Int): Int = if (a < b) a else b

//타입추론으로 반환타입 생략 가능
fun min2(a: Int, b: Int) = if (a < b) a else b