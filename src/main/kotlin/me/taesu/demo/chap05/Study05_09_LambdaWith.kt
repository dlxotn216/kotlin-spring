package me.taesu.demo.chap05

/**
 * Created by taesu on 2020-05-30.
 */
fun main(args: Array<String>) {
    Study05_09_LambdaWith().exam()
}

class Study05_09_LambdaWith {

    fun alphabet(): String {
        val result = StringBuilder()

        for (char in 'A'..'Z') {
            result.append(char)
        }

        result.append("\nfinished")
        return result.toString()
    }

    fun alphabetUsingWith(): String {
        val result = StringBuilder()

        //with를 통해 수신객체를 지정하면 람다 내에서의 this 바인딩을 수신객체로 할 수 있다.
        //javascript의 this 바인딩과 비슷
        return with(result) {
            for (char in 'A'..'Z') {
                append(char) // this.append와 동일하다
            }

            append("\nfinished")
            toString()      //맨 마지막에 있는 구문이 리턴문이다.
        }

        //위 아래는 동일한 코드이며 관례에 따라 람다를 밖으로 빼낼 수 있다.
//        return with(result, {
//            for(char in 'A'..'Z'){
//                append(char)
//            }
//
//            append("\nfinished")
//            toString()
//        })
    }

    fun exam() {
        println(alphabet())

        println(alphabetUsingWith())
    }
}