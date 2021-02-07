package me.taesu.demo.chap03

/**
 * Created by taesu on 2020-05-08.
 */

fun <T> joinToString(elements: Collection<T>,
                     separator: String = ",",
                     prefix: String = "(",
                     postfix: String = ")"): String {

    var result = prefix

    for ((index, element) in elements.withIndex()) {
        if (index < elements.size - 1) {
            result += "$element$separator"
        } else {
            result += "$element"
        }
    }

    result += postfix
    return result
}


fun main(args: Array<String>) {
    /*
    Kotlin의 함수는 Java와 달리 클래스에 종속되지 않아도 된다.
    아래와 같이 호출 할 수 있다.
     */
    println(me.taesu.demo.chap03.joinToString(listOf(1, 2, 3)))

    //java에선 아래와 같이 호출 할 수 있다.
    //Kotlin 파일 이름이 클래스로 대치 됨
    //me.taesu.demo.chap03.Study3_1_UtilFunctionKt.joinToString(listOf(1, 2, 3))

    //아래와 같이 파일에 어노테이션을 붙여서 클래스 명을 명시할 수 있다.
    //@file:JvmName("StringFunctions")
}