package me.taesu.demo.chap09

/**
 * Created by itaesu on 2021/02/24.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    val list: MutableList<Int> = mutableListOf(12)
    // println(addInt(list)) // MutableList<Int> != MutableList<Any>    -> 무공변
    val list1: MutableList<Any> = mutableListOf("aewf")
    println(addInt(list1))
}

// a 타입에 변수에 b 타입의 값이 들어 갈 수 있다면 b 타입은 a 타입의 하위 타입이다.
fun test(i: Int) {
    // 하위 타입 이므로 컴파일 가능
    val n: Number = i

    fun f(e: String) {

    }
    // 하위 타입이 아니므로 컴파일 에러
    // f(i)
    // f(n)

    // Int? <- Int
    val ni: Int? = i;
}

fun addInt(list: MutableList<Any>): MutableList<Any> {
    list.add(23)
    return list
}

private class Study09_04_GeericVariance {
    class Herd<T : Animal> {
        private val animals = arrayListOf<T>()
        operator fun get(index: Int): T = animals.get(index)
        val size: Int
            get() = animals.size
    }

    open class Animal {
        open fun feed() = println("feeed")
    }

    class Cat : Animal() {
        override fun feed() = println("feed cat")
    }

    // PECS
    // 반환 타입에서 T를 사용한다면 out, 공변성
    class VarianceOutAnimal<out T : Animal> {
        private val animals = arrayListOf<T>()
        operator fun get(index: Int): T = animals.get(index)
        val size: Int
            get() = animals.size
    }

    private fun feedAll(animals: Herd<Animal>) {
        for (i in 0 until animals.size) {
            animals[i].feed()
        }
    }

    private fun feedAllVariance(animals: VarianceOutAnimal<Animal>) {
        for (i in 0 until animals.size) {
            animals[i].feed()
        }
    }

    private fun feedAnimal() {
        val animals = Herd<Animal>()
        val cats: Herd<Cat> = Herd()
        feedAll(animals)
        // Herd<Animal> - Herd<Cat>은 무공변이다.
        // feedAll(cats)

        // VarianceAnimal의 <T>는 이제 공변이 된다.
        val varianceOutCat: VarianceOutAnimal<Cat> = VarianceOutAnimal()
        feedAllVariance(varianceOutCat)
    }

    // PECS
    // T를 파라미터로 사용한다면 in, 반공변성
    class AnimalAppender<in T : Animal> {
        private val animals = arrayListOf<T>()
        val size: Int
            get() = animals.size

        fun add(element: T) {
            animals.add(element)
        }
    }

    // T를 받아 R 변환하는 경우, in 반공변, out 공변
    interface Transformer<in T, out R> {
        fun transform(input: T): R
    }
}
