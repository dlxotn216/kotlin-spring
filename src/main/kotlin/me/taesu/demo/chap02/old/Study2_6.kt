package me.taesu.demo.chap02.old

/**
 * Created by itaesu on 04/05/2020.
 *
 * @author Lee Tae Su
 * @version 1.2.0
 * @since 1.2.0
 */
fun main(args: Array<String>) {
    Study2_6().exam1()
}

class Study2_6 {
    fun fizzBuzz(i: Int) {
        when {
            i % 15 == 0 -> println("FizzBuzz")
            i % 3 == 0 -> println("Fizz")
            i % 5 == 0 -> println("Buzz")
            else -> println(i)
        }
    }

    fun exam1() {
        //폐구간 (닫힌 구간) -> 양끝을 다 포함 함
        for (i in 1..100) {
            fizzBuzz(i)
        }

        println()
        //폐구간 (닫힌 구간) -> 양끝을 다 포함 함
        val intProgression = 100 downTo 1 step 2// 2씩 감소하는 역방향 수열
        for (i in 100 downTo 1 step 2) {
            fizzBuzz(i)
        }

        //열린 구간 for(i=0; i<100; i++)
        println("i in 0 until 100")
        for(i in 0 until 100){
            print("$i ")
        }

        //열린 구간 for(i=0; i<100; i++)
        println("i in 0..100-1")
        for(i in 0..100-1){
            print("$i ")
        }

        //for (i=0; i< 100; i+=2)
        println("i in 0 until 100 step 2")
        for(i in 0 until 100 step 2){
            print("$i ")
        }
    }
}