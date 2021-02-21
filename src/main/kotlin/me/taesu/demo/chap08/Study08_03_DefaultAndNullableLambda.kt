package me.taesu.demo.chap08

/**
 * Created by itaesu on 2021/02/21.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    println(arrayListOf("Dev", "Stg", "Edu").joinToString())
    nullable(1)
    nullable(1) {
        (it * 2).toString()
    }
}

fun <T> Collection<T>.joinToString(
        prefix: String = "(",
        postfix: String = ")",
        delimiter: String = ".",
        transform: (T) -> String = { it.toString() }        // 람다도 마찬가지로 default 값을 설정 할 수 있음
): String {
    val stringBuilder = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        stringBuilder.append(transform(element))
        if (index < (size - 1)) {
            stringBuilder.append(delimiter)
        }
    }
    stringBuilder.append(postfix)

    return stringBuilder.toString()
}

// 람다가 nullable 일 수 있다. invoke를 통해서도 실행 가능하니 ?.invoke() 활용도 가능
// (T) -> String? vs ((T) -> String)? 차이점 알기
fun <T> nullable(t: T, toString: ((T) -> String)? = null) {
    println(toString?.invoke(t))

    toString?.let {
        println(toString(t))
    }
}