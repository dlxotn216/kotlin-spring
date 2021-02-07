package me.taesu.demo.chap02.old

import java.util.*

/**
 * Created by taesu on 2020-05-06.
 */

fun main(args: Array<String>){
    Study2_7().exam1()
    Study2_7().exam2()
    Study2_7().exam3()
}

class Study2_7 {

    fun exam1() {
        val binaryReps = TreeMap<Char,String>()

        for (c in 'C'..'F'){
            binaryReps[c] = Integer.toBinaryString(c.toInt())
//            binaryReps.put(c, Integer.toBinaryString(c.toInt())) 동일한 코드
        }

        for((letter, binary) in binaryReps){
            println("$letter = $binary")
        }
    }

    fun exam2() {
        val integers: List<Int> = listOf(1,2,3,4,5,6,7)

        for((index, element) in integers.withIndex()){
            println("integers[$index] == $element")
        }
    }

    /*
    Collection을 대상으로 in을 사용하면 exists의 의미
    Comparable을 구현했다면 in을 통해 Range 계산 할 수 있다.
     */
    fun exam3() {
        fun hasNumberZero() = 0 in listOf(1, 2,3, 4, 5, 6, 0)
        fun hasTargetString(target: String) = target in listOf("test", "taesu")
        fun isDigit(c: Char) = c in '0'..'9'            // '0' <= c && c <='9'
        fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'      // ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')

        fun recognize(c: Char) = when(c) {
            in '0'..'9' -> "Is digit!"
            in 'a'..'z' -> "Is lowercase!"
            in 'A'..'Z' -> "Is uppercase!"
            else -> "I don't know"
        }

        fun isPercentage(value: Int) {
            if (value !in 0..100) {
                throw IllegalArgumentException("$value is not percentage")
            }
        }

        println(hasNumberZero())
        println(hasTargetString("test"))
        println(isDigit('2'))
        println(isLetter('2'))
        println(recognize('0'))
        println(recognize('A'))
        println(isPercentage(2))
        println(isPercentage(200))
    }

}