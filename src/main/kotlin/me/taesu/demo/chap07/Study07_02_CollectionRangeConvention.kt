package me.taesu.demo.chap07

import java.time.LocalDate

/**
 * Created by itaesu on 2021/02/17.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    val mapOf = mutableMapOf(1 to "a", "b" to 2)
    println(mapOf[1])
    println(mapOf["b"])
    mapOf[123] = "new"

    val mutable = Study07_02_CollectionRangeConvention.MutablePoint(2, 4)
    println(mutable[0])
    mutable[0] = 1231
    println(mutable[0])

    val rectangle = Study07_02_CollectionRangeConvention.Rectangle(
            Study07_02_CollectionRangeConvention.MutablePoint(1, 2),
            Study07_02_CollectionRangeConvention.MutablePoint(19, 22)
    )
    println(Study07_02_CollectionRangeConvention.MutablePoint(2, 4) in rectangle)
    println(Study07_02_CollectionRangeConvention.MutablePoint(22, 4) in rectangle)

    val now = LocalDate.now()
    val plusDays = now.plusDays(10)
    println("$now, ${now.plusWeeks(1)}, $plusDays")
    println((now.plusWeeks(1) in (now..plusDays)))

    for (day in now..plusDays) {
        println(day)
    }
}
// for문을 위한 관례
operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
        object : Iterator<LocalDate> {
            var current = start
            override fun hasNext(): Boolean = current <= endInclusive

            override fun next(): LocalDate = current.apply {
                current = plusDays(1)
            }

            // 위와 동일한 구문이다
            /*
            override fun next(): LocalDate {
                val temp = current
                current = current.plusDays(1)
                return temp
            }
            */
        }

private class Study07_02_CollectionRangeConvention {
    data class MutablePoint(
            var x: Int,
            var y: Int) {
        operator fun get(index: Int): Int {
            return when (index) {
                0 -> x
                1 -> y
                else -> throw IllegalArgumentException("$index")
            }
        }

        operator fun set(index: Int, value: Int) {
            when (index) {
                0 -> x = value
                1 -> y = value
                else -> throw IllegalArgumentException("$index")
            }
        }
    }

    data class Rectangle(
            val upperLeft: MutablePoint,
            val lowerRight: MutablePoint
    ) {
        operator fun contains(point: MutablePoint): Boolean {
            return upperLeft.x <= point.x && upperLeft.y <= point.y
                    && lowerRight.x >= point.x && lowerRight.y >= point.y
        }
    }
}