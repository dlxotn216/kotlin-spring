package me.taesu.demo.chap02.old

/**
 * Created by itaesu on 04/05/2020.
 *
 * @author Lee Tae Su
 * @version 1.2.0
 * @since 1.2.0
 */
fun main(args: Array<String>) {
    Study2_3().exam1()
    Study2_3().exam2()
}

class Study2_3 {
    private data class Person(val name: String,     // readonly -> only getter
                              var isMarried: Boolean = false
            // getter + setter
            // is로 시작하는 프로퍼티는 isMarried(), setMarried(married)로 생성이 된다.
    )

    private data class Rectangle(var width: Int,
                                 var height: Int) {

        //custom accessor
        val isSquare: Boolean
            get() {
                return width == height
            }

        //위와 동일한 표현
        val isSquare2: Boolean get() = width == height

        //이 표현은 함수가 아님을 주의
        val isSquare3: Boolean = width == height

        //cannot have set
//        set(isSqure: Boolean) {
//
//        }
    }


    fun exam1() {
        val taesu = Person("Lee Tae Su")
        taesu.isMarried = false

        println(taesu);
    }

    fun exam2() {
        println(Rectangle(2, 4).isSquare)

        println()
        val square2 = Rectangle(4, 4)
        println("${square2} is square ? ${square2.isSquare2}")

        square2.width = 5
        println("${square2} is square ? ${square2.isSquare2}")

        println()
        val square3 = Rectangle(4, 4)
        println("${square3} is square ? ${square3.isSquare}")

        square3.width = 5
        println("${square3} is square ? ${square3.isSquare}")

    }
}