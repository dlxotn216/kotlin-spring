package me.taesu.demo.chap05.old

/**
 * Created by taesu on 2020-05-30.
 */
fun main(args: Array<String>) {
    Study05_09_LambdaApply().exam()
}

class Study05_09_LambdaApply {
    fun alphabetWith(): String{
        val result = StringBuilder()
        return with(result) {
            for(char in 'A'..'Z'){
                append(char)
            }

            append("\nI'm alphabet")
            result.toString()
        }
    }

    //수신객체 그 자체를 반환하고 싶다면 this를 명시하면 되겠지만
    fun alphabetWithThis(): StringBuilder {
        val result = StringBuilder()
        return with(result) {
            for(char in 'A'..'Z'){
                append(char)
            }

            append("\nI'm alphabet")
            this
        }
    }

    //apply를 통해서는 수신객체 자체를 반환할 수 있다.
    fun alphaApply(): StringBuilder = StringBuilder().apply {
        for (char in 'A'..'Z') {
            append(char)
        }

        append("\nI'm alphabet")
    }

    //buildString 표준라이브러리 함수는 StringBuilder()를 생성하는 코드와 toString을 알아서 해준다
    fun alphabetWithBuildString(): String = buildString {
        for (char in 'A'..'Z') {
            append(char)
        }

        append("\nI'm alphabet")
    }

    fun exam(){
        println(alphabetWith())
        println()
        println(alphaApply())
        println()
        println(alphabetWithThis())
        println()
        println(alphabetWithBuildString())
    }
}