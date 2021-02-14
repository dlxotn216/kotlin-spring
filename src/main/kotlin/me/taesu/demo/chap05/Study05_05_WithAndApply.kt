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

    println(alphabetApply())
    println(alphabetApplyOuter())
    println(alphabetApplyOuterAndExpressionFunction())
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

fun alphabetApply(): String {
    return StringBuilder().apply({
        for (char in 'A'..'Z') {
            this.append(char)
        }
    }).toString()
}

fun alphabetApplyOuter(): String {
    return StringBuilder().apply {
        for (char in 'A'..'Z') {
            this.append(char)
        }
    }.toString()
}

fun alphabetApplyOuterAndExpressionFunction() = StringBuilder().apply {
    for (char in 'A'..'Z') {
        this.append(char)
    }
}.toString()

// 표준 라이브러리 함수 buildString은 StringBuilder 생성 및 toString을 알아서 호출 해준다
fun alphabetBuildString() = buildString {
    for (char in 'A'..'Z') {
        this.append(char)
    }
}

// 수신 객체 지정 람다는 람다 내부에서 this가 수신 객체가 된다
fun buildStringCustom1(buildAction: StringBuilder.() -> Unit) = StringBuilder().apply(buildAction).toString()
fun alphabetbuildStringCustom1() = buildStringCustom1 {
    for (char in 'A'..'Z') {
        this.append(char)
    }
}

// 이렇게 받으면 it이 String Builder가 된다
fun buildStringCustom2(buildAction: (StringBuilder) -> Unit) = StringBuilder().apply(buildAction).toString()
fun alphabetbuildStringCustom2() = buildStringCustom2 {
    for (char in 'A'..'Z') {
        it.append(char)
    }
}



fun a(action: (StringBuilder) -> Unit) = StringBuilder().apply(action).toString()
fun test() = a{
  it.append("${it is StringBuilder}")
}

fun b(action: StringBuilder.() -> Unit) = StringBuilder().apply(action).toString()
fun testb() = b{
  this.append("${this is StringBuilder}")
}