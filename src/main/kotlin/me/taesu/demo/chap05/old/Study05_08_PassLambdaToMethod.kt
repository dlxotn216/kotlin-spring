package me.taesu.demo.chap05.old

/**
 * Created by itaesu on 28/05/2020.
 *
 * @author Lee Tae Su
 * @version 1.2.0
 * @since 1.2.0
 */

fun main(args: Array<String>) {
    Study05_08_PassLambdaToMethod().exam()
    Study05_08_PassLambdaToMethod().exam2()
}

class Study05_08_PassLambdaToMethod {
    fun method(name: String, computation: Runnable) {
        println("""task $name start""")
        computation.run()
    }

    //Labmda를 반환하는 메소드는 아래와같이 감싸주어야 한다
    fun returnLambda(work: String): Runnable = Runnable { println(work) }

    //아래와 같이 선언도 가능
    val runnalbeLambda: Runnable = Runnable { println("runnable") }

    fun exam() {
        //객체 식으로 람다를 전달
        // -> 매번 새로운 무명 객체가 생성된다
        method("0001", object : Runnable {
            override fun run() {
                println("test")
            }
        })

        //람다가 별다른 변수를 capture 하고 있지 않으면 전역에서 하나만 생성하여 재사용한다
        method("00002", Runnable { println("00002 test") })

        //매번 새로운 람다를 생성 함
        val workName = "work name"
        method("00002", Runnable { println(workName) })

        method("awefaf", returnLambda("work"))
        method("awefaf", runnalbeLambda)
    }


    private data class Person(val name: String, val email: String? = "UNKNOWN")

    private fun lambda(name: String, personSupplier: (name: String) -> Person): Person = personSupplier.invoke(name)
    private fun lambda(name: String, email: String, personSupplier: (name: String, email: String) -> Person): Person = personSupplier.invoke(name, email)

    fun exam2() {
        println(lambda("taesu", { Person(it) }))
        println(lambda("taesu", "qwer", { name: String, email: String -> Person(name, email) }))
    }

}