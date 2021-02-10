package me.taesu.demo.chap05

/**
 * Created by itaesu on 2021/02/10.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    val people = arrayListOf(Person("taesu", 29), Person("soyoung", 29))

    // 람다는 항상 중괄호에 위치한다
    val sum = { x: Int, y: Int -> x + y }
    println(sum(2, 4));

    { println("test") }() // 즉시실행
    run { println("test") } // 이게 더 나음, 세미콜론이 필요해지기에

    // 기본 형식
    people.maxBy({ person: Person -> person.age })

    // 관례를 통해 맨 마지막 인자가 람다인 경우 메서드 외부로 빼내기 가능
    people.maxBy() { person: Person -> person.age }

    // 관례를 통해 람다 하나만 파라미터로 받는다면 메서드 호출부분 생략 가능
    people.maxBy { person: Person -> person.age }

    // 타입추론으로 인해 생략 가능
    people.maxBy { person -> person.age }

    // it keyword 사용 가능
    people.maxBy { it.age }

    // 또는 메서드 레퍼런스 전달
    people.maxBy(Person::age)

    var count = 0
    people.forEach {
        count++ // 외부 값을 변경 할 수 있음.
    }
    println(count)

    fun Person.isAdult() = age >= 20
    println(Person::isAdult)        // 확장 함수에 대해서도 참조 가능

}
