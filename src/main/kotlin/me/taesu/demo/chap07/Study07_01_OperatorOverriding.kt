package me.taesu.demo.chap07

/**
 * Created by itaesu on 2021/02/15.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
private class Study07_01_OperatorOverriding {
    data class Point(
            val x: Int,
            val y: Int) {
        operator fun plus(point: Point): Point = Point(x + point.x, y + point.y)
        operator fun times(scale: Double): Point = Point((x * scale).toInt(), (y * scale).toInt())

        // 단항 연산자 오버로딩
        operator fun unaryMinus(): Point = Point(-x, -y)
    }

    data class MutablePoint(
            var x: Int,
            var y: Int) {
        operator fun plus(point: Point): Point = Point(x + point.x, y + point.y)
        operator fun times(scale: Double): Point = Point((x * scale).toInt(), (y * scale).toInt())

        // plusAssign은 변경가능한 경우에 적용이 가능하다. Unit을 반환 함
        operator fun plusAssign(point: MutablePoint) {
            x += point.x
            y += point.y
        }
    }
}

// 교환법칙을 위해서
private operator fun Double.times(point: Study07_01_OperatorOverriding.Point): Study07_01_OperatorOverriding.Point = point.times(this)

// 꼭 반환타입이 일치할 필요 없음
operator fun Char.times(many: Int): String = toString().repeat(many)

fun main(args: Array<String>) {
    println(Study07_01_OperatorOverriding.Point(1, 2) + Study07_01_OperatorOverriding.Point(3, 4))
    println((Study07_01_OperatorOverriding.Point(3, 4) * 4.2))
    println((4.2 * Study07_01_OperatorOverriding.Point(3, 4)))
    println('a' * 4)

    val mutablePoint = Study07_01_OperatorOverriding.MutablePoint(3, 4)
    mutablePoint += mutablePoint
    println(mutablePoint)

    val numbers = arrayListOf(1,2,3)
    numbers += 24
    numbers + arrayListOf(2,1,4.1)
    println(numbers)
    println(numbers + arrayListOf(2,1,4.1))
}