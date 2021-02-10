package me.taesu.demo.chap05.old

/**
 * Created by itaesu on 22/05/2020.
 *
 * @author Lee Tae Su
 * @version 1.2.0
 * @since 1.2.0
 */
fun main(args: Array<String>) {
    Study05_02LambdaWithVariable().exam(listOf("404", "500"))
    Study05_02LambdaWithVariable().exam2()
}

class Study05_02LambdaWithVariable {
    fun exam(response: List<String>) {
        var clientErrors = 0
        var serverErrors = 0

        //java와 달리 람다 안에서 변수를 capturing 할 수 있다.
        //만약 람다를 반환하는 경우 위 값들을 따로 래핑하여 사용함
        response.forEach {
            if (it.startsWith("4")) {
                clientErrors++
            } else {
                serverErrors++
            }
        }

        println(clientErrors)
        println(serverErrors)
    }

    private open class Human(val sex: String)

    private data class Men(val name: String, val age: Int) : Human("M") {

        //this는 생략 가능
        private val getNameFunc1 = this::name
        private val getNameFunc2 = ::name
        private val getSexFunc = ::sex

        private val constructorRef = ::Men
    }

    fun exam2() {
        val getAge = Men::age

        println(getAge.get(Men("taesu", 28)))

        println(listOf(Men("taesu", 28), Men("tatoo", 18), Men("spec", 38)).maxBy(getAge))


    }
}