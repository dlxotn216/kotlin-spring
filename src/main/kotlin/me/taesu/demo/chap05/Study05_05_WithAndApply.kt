package me.taesu.demo.chap05

/**
 * Created by itaesu on 2021/02/13.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    println(alphabet())
    println(alphabetWith())
    println(alphabetWithOuter())
    println(alphabetWithOuterAndExpressionFunction())
}

// 기본적인 방법
fun alphabet(): String {
    val result = StringBuilder()
    for (char in 'A'..'Z') {
        result.append(char)
    }
    return result.toString()
}

// StringBuilder()에 with를 통해 수신객체 지정
fun alphabetWith(): String {
    return with(StringBuilder(), {
        for (char in 'A'..'Z') {
            this.append(char)
        }
        toString()
    })
}

// 마지막 람다 인자를 밖으로
fun alphabetWithOuter(): String {
    return with(StringBuilder()) {
        for (char in 'A'..'Z') {
            this.append(char)
        }
        toString()
    }
}

// 식이 본문인 함수로 변경
fun alphabetWithOuterAndExpressionFunction() = with(StringBuilder()) {
    for (char in 'A'..'Z') {
        this.append(char)
    }
    toString()
}