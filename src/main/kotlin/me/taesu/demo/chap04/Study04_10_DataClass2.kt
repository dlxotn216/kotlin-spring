package me.taesu.demo.chap04

/**
 * Created by taesu on 2020-05-18.
 */

fun main(args: Array<String>) {
    Study04_10_DataClass2().exam()
}

class Study04_10_DataClass2 {
    //toString, equals, hashCode를 컴파일러가 알아서 생성 해 준다.
    private data class User (val name: String, val email: String)

    fun exam() {
        val taesu = User("taesu", "taesu@crscube.co.kr")
        println(taesu)

        val taesu2 = User("taesu", "taesu@crscube.co.kr")
        println(taesu == taesu2)


        val hashSet = hashSetOf(taesu)
        println(hashSet.contains(taesu2))

        //data class의 copy 메소드를 사용해서 복제를 할 수 있으며
        //값을 변화 한 복제 객체를 얻을 수 있다.
        //data class의 불변성을 지키는데 용이할 수 있다.
        println("after copy taesu")
        println(taesu.copy(name = "taesu chcnaged"))
        println(taesu)
    }

}