package me.taesu.demo.chap03.old

/**
 * Created by taesu on 2020-05-11.
 */

fun main(args: Array<String>) {
    Study3_7_StringRegex().exam1()
}

class Study3_7_StringRegex {
    fun exam1(){
        val values = "1.2.3.4.5.6.7.8"
        println(values.split("."))
        //자바인 경우 정규표현식만을 받기 때문에 빈 배열이 나왔을 것

        val filePath = "c://test/name.txt"
        val directoryPath = filePath.substringBeforeLast("/")
        val fullName = filePath.substringAfterLast("/")
        val fileName = fullName.substringBefore(".")
        val extension = fullName.substringAfter(".")

        println("directory: $directoryPath  fullName: $fullName, filename: $fileName extension: $extension")

        val regex = """(.+)/(.+)\.(.+)""".toRegex()
        val matchResult = regex.matchEntire(filePath)
        if (matchResult != null) {
            val (dirPath, fNme, ext) = matchResult.destructured
            println("$dirPath, $fNme, $ext")
        }

        val query = """
                  select
                     userName
                  ,  userId
                  ,  email
                  from user
                  where userId = ${'$'}userId
            """
        //템플릿 문자열 안에 $가 필요하다면 ${'$'}와 같이 넣는다

        println(query.trimMargin("."))
    }
}