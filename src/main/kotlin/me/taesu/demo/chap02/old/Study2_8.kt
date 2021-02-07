package me.taesu.demo.chap02.old

import java.io.BufferedReader
import java.io.StringReader

/**
 * Created by taesu on 2020-05-06.
 */

fun main(args: Array<String>) {
    Study2_8().exam1();
}

class Study2_8 {

    fun exam1() {
        val number = 100
        val percentage: Int =
                if (number in 0..100){
                    number
                } else {
                    throw IllegalArgumentException("$number is not a percentage")
                }

        fun readNumber(reader: BufferedReader): Int? {
            try {
                val line = reader.readLine()
                return Integer.parseInt(line)
            } catch (e: Exception){
                return null
            } finally {
                reader.close()
            }
        }

        //Kotlin은 모두다 Unchecked Exception임
        println(readNumber(BufferedReader(StringReader("239"))))

        //블록이 본문인 함수라면 return이 필요.
        fun tryExpr(reader: BufferedReader): Int? {
            val input = try {
                Integer.parseInt(reader.readLine())
            } catch (e: Exception){
                null
            } finally {
                reader.close()
            }
            return input
        }
        println(tryExpr(BufferedReader(StringReader("awef"))))

        //식이 본문인 함수라면 return 없어야 함.
        fun returnTryCatch(reader: BufferedReader): Int? =
                try {
                    Integer.parseInt(reader.readLine())
                } catch (e: Exception){
                    null
                } finally {
                    reader.close()
                }

        println(returnTryCatch(BufferedReader(StringReader("awef"))))
        println(returnTryCatch(BufferedReader(StringReader("234324"))))
    }
}
