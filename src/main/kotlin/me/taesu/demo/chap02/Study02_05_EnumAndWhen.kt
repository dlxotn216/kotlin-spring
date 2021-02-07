package me.taesu.demo.chap02

import java.lang.IllegalArgumentException

/**
 * Created by itaesu on 2021/02/07.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */

// enum은 코틀린에서 소프트 키워드 -> 변수로 사용 가능하나 enum class 와 같이 다릌 키워드를 만나면 키워드가 됨
enum class Color (val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}

fun main(args: Array<String>) {
    println(getMnemonic(Color.RED))
    println(getMnemonic(Color.YELLOW))
    println(getMnemonic(Color.BLUE))
}

fun getMnemonic(color: Color): String {
    return when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "VAin"
    }
}

fun getMnemonic2(color: Color): String {
    return when (color) {
        Color.ORANGE, Color.RED -> "Richard"
        Color.GREEN , Color.YELLOW -> "York"
        Color.VIOLET, Color.INDIGO, Color.BLUE -> "Battle"
    }
}

// 객체가 오는 것도 허용 됨
// 하지만 매번 비교 할 때마다 set을 생성 함, 비효율성이 크게 문제 되지는 않지만 자주 호출 된다면 문제가 생길수도
fun mixedColor(color1: Color, color2: Color) {
    when (setOf(color1, color2)) {
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
        else -> throw IllegalArgumentException("${color1}, ${color2} is not set")
    }
}

// 인자가 없는 when 절을 사용할 수 있음
fun mixedColorOptimized(color1: Color, color2: Color) {
    when {
        (color1 == Color.RED && color2 == Color.YELLOW)
                .or(color1 == Color.YELLOW && color2 == Color.RED) -> Color.ORANGE

        (color1 == Color.YELLOW && color2 == Color.BLUE)
                .or(color1 == Color.BLUE && color2 == Color.YELLOW) -> Color.GREEN

        (color1 == Color.BLUE && color2 == Color.VIOLET)
                .or(color1 == Color.VIOLET && color2 == Color.BLUE) -> Color.INDIGO

        else -> throw IllegalArgumentException("${color1}, ${color2} is not set")
    }
}

class Study02_05_EnumAndWhen {
}