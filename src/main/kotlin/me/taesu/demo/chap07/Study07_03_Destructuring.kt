package me.taesu.demo.chap07

/**
 * Created by itaesu on 2021/02/17.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    val (x, y) = Study07_03_Destructuring.MutablePoint(1, 2)
    println("$x, $y")

    println(Study07_03_Destructuring.FileName.from("result.txt"))
    printEntries(
            mapOf(
                    "1" to "2",
                    "a" to "awef"
            )
    )
}

fun printEntries(map: Map<String, String>) {
    for ((key, value) in map) {
        println("$key = $value")
    }
}

private class Study07_03_Destructuring {
    class MutablePoint(
            var x: Int,
            var y: Int) {
        operator fun component1() = x
        operator fun component2() = y
    }

    data class FileName(
            val name: String,
            val extension: String
    ) {
        companion object {
            fun from(fullName: String): FileName {
                val split = fullName.split(".", limit = 2)
                return FileName(split[0], split[1])
            }

            fun from2(fullName: String): FileName {
                // 배열이나 컬렉션도 구조분해가 가능하다 5개까지만
                val (name, extension) = fullName.split(".", limit = 2)
                return FileName(name, extension)
            }
        }
    }
}