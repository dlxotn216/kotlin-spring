package me.taesu.demo.chap05.old

/**
 * Created by itaesu on 21/05/2020.
 *
 * @author Lee Tae Su
 * @version 1.2.0
 * @since 1.2.0
 */

fun main(args: Array<String>) {
    Study05_01_LambdaBasic().exam()
}

class Study05_01_LambdaBasic {
    private data class Person(val name: String, val age: Int)

    private fun findTheOldest(people: List<Person>): Person? {
        var maxAge: Int = 0
        var oldestPerson: Person? = null
        for (person in people) {
            if (person.age > maxAge) {
                maxAge = person.age
                oldestPerson = person
            }
        }

        return oldestPerson
    }

    //아래와 같이 여러 방법으로 Lambda 사용 가능
    private fun findTheOldestUsingLambda(people: List<Person>): Person? {
        return people.maxBy { person -> person.age }
        return people.maxBy() { person -> person.age } //괄호 뒤에 람다

        //it은 호출 구문을 간단히 해주지만 중첩된 경우엔 지양하는것이 좋다
        return people.maxBy { it.age }
        return people.maxBy(Person::age)
    }

    val sum = { x: Int, y: Int -> x + y }
    val minus = { x: Int, y: Int ->
         println("Computing the minus of $x and $y")
         x - y      //여러줄인 람다의 경우 마지막 식이 결과값이 된다
    }

    fun exam() {
        println(findTheOldest(listOf(Person("taesu", 13), Person("bob", 31))))
        println(findTheOldestUsingLambda(listOf(Person("taesu", 13), Person("bob", 31))))

        println(sum.invoke(1, 2))
        println(sum(2, 3))
        println(minus(5, 1))

        println(listOf(Person("taesu", 13), Person("bob", 31)).joinToString(separator = ",", transform = { it.name }))
        println(listOf(Person("taesu", 13), Person("bob", 31)).map { it.name }.joinToString(separator = ","))
    }
}