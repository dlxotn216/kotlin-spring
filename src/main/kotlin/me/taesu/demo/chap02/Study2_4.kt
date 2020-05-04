package me.taesu.demo.chap02

/**
 * Created by itaesu on 04/05/2020.
 *
 * @author Lee Tae Su
 * @version 1.2.0
 * @since 1.2.0
 */
fun main(args: Array<String>) {
    Study2_4().exam1()
}

class Study2_4 {
    private enum class Color(val r: Int, var g: Int, val b: Int) {
        RED(255, 0, 0), ORANGE(255, 165, 0), YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
        INDIGO(75, 0, 130), VIOLET(238, 130, 238);

        fun rgb() = (r * 256 + g) * 256 + b
    }

    //자바와 달리 Soft keyword 임
    val enum: String = "soft keyword"

    //When 절도 하나의 문장이 아닌 식임.
    private fun getMnemonic(color: Color) =
            when (color) {
                Color.RED -> "Richard"
                Color.ORANGE -> "Of"
                Color.YELLOW -> "York"
                Color.GREEN -> "Gave"
                Color.BLUE -> "Battle"
                Color.INDIGO -> "In"
                Color.VIOLET -> "Vain"
            }

    //여러 원소에 대해 공통 매칭 처리
    private fun getWarmth(color: Color): String =
            when (color) {
                Color.RED, Color.YELLOW, Color.ORANGE -> "Warm"
                Color.GREEN -> "Natural"
                Color.BLUE, Color.INDIGO, Color.VIOLET -> "Cold"
            }

    //집합에 대한 연산 처리 가능
    //set은 원소의 집합 -> 원소의 순서는 중요하지 않으
    private fun mix(c1: Color, c2: Color): Color {
        return when (setOf(c1, c2)) {
            setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
            setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
            setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
        //else 구문을 통해 존재하지 않는 상황에 대한 처리 가능
            else -> throw IllegalArgumentException("Undefined combination (${c1}, ${c2})")
        }
    }

    //위의 함수는 매번 호출마다 set 인스턴스를 생성하기에 자주 호출된다면 아래와 같이 최적화가 가능
    private fun mixOptimized(c1: Color, c2: Color): Color {
        return when {   //인자가 없는 when 절
            (c1 == Color.RED && c2 == Color.YELLOW) || (c2 == Color.RED && c1 == Color.YELLOW) -> Color.ORANGE
            (c1 == Color.YELLOW && c2 == Color.BLUE) || (c2 == Color.YELLOW && c1 == Color.BLUE) -> Color.GREEN
            (c1 == Color.BLUE && c2 == Color.VIOLET) || (c2 == Color.BLUE && c1 == Color.VIOLET) -> Color.INDIGO
            else -> throw IllegalArgumentException("Undefined combination (${c1}, ${c2})")
        }
    }

    fun exam1() {
        println(Color.BLUE.rgb())
        println(getMnemonic(Color.VIOLET))
        println(getWarmth(Color.VIOLET))
        println("combination of violet, blue is ${mix(Color.VIOLET, Color.BLUE)}")
        println("combination of violet, blue is ${mixOptimized(Color.VIOLET, Color.BLUE)}")

        try {
            print(mix(Color.VIOLET, Color.ORANGE))
        } catch (e: Exception) {
            println(e.message)
        }
    }


}