package me.taesu.demo.chap02

/**
 * Created by itaesu on 04/05/2020.
 *
 * @author Lee Tae Su
 * @version 1.2.0
 * @since 1.2.0
 */
data class Person(val name: String, var age: Int? = null);

fun main(args: Array<String>) {
    exam01()
    exam02()
    exam03()
}

private fun exam01() {
    val oldestPerson = listOf<Person>(Person("Lee Tae Su", 28),
            Person("Lee Tae Su 2"),
            Person("Tae Su Lee", 30),
            Person("Yoon So young", 27))
            .maxBy {
                /* person -> if (person.age == null) 0 else person.age  */          // 허용 되지 않음
                /* person -> person.age == null ? 0 : person.age */                 // 허용 되지 않음
                person ->
                person.age ?: 0
            }

    println("oldest peron is $oldestPerson")
}

private fun exam02() {
    val oldestPerson = listOf<Person>(Person("Lee Tae Su", 28),
            Person("Lee Tae Su 2"),
            Person("Tae Su Lee", 30),
            Person("Yoon So young", 27))
            .maxBy { it.age ?: 0 }      //it으로 간소화 할 수 있음

    println("oldest peron is $oldestPerson")
}

private fun exam03() {
    //Compile error가 나지 않음
    val findPersonByName = findPersonByName(listOf(Person("Lee Tae Su", 28),
            Person("Lee Tae Su 2"),
            Person("Tae Su Lee", 30),
            Person("Yoon So young", 27)), "Lee Tae Su") ?: Person("Unknown")

    val findPerson = findPerson(listOf(Person("Lee Tae Su", 28),
            Person("Lee Tae Su 2"),
            Person("Tae Su Lee", 30),
            Person("Yoon So young", 27)), { person -> person.name == "Lee Tae Su 22" })

    println("fins person by name is $findPersonByName")
    println("fins person is $findPerson")

    //Compile error -> 명확히 타입을 선언해주는 것이 좋을 것
    /*
    val test: Person = findPersonByName(listOf(Person("Lee Tae Su", 28),
            Person("Lee Tae Su 2"),
            Person("Tae Su Lee", 30),
            Person("Yoon So young", 27)), "Lee Tae Su")
    */

    val test2: Person? = findPersonByName(listOf(Person("Lee Tae Su", 28),
            Person("Lee Tae Su 2"),
            Person("Tae Su Lee", 30),
            Person("Yoon So young", 27)), "Lee Tae Su")
}

// Nullable Person을 반환
private fun findPersonByName(persons: List<Person>, name: String): Person? {
    return persons.firstOrNull { person -> person.name == name }
}

// Null safety Person을 반환
private fun findPerson(persons: List<Person>, matcher: (Person) -> Boolean): Person {
    return persons.firstOrNull(matcher) ?: Person("Unknown")
}