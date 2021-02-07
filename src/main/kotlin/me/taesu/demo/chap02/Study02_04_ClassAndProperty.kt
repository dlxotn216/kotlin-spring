package me.taesu.demo.chap02

import java.time.LocalDate

/**
 * Created by itaesu on 2021/02/07.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    val person = Person("Lee", false)
    // person.name = "test"; // error
    person.isMarried = true

    person.birthDate = LocalDate.now()
    println(person.birthDate)

}

// 자바에선 필드 + 접근자 = 프로퍼티
// 코틀린에선 아래와 같은 프로퍼티가 둘 다 대체 함
class Person(val name: String,          // field + getter
             var isMarried: Boolean)     // field + getter + setter
{
    // Custom Getter
    var birthDate: LocalDate? = null
    get() {
        return LocalDate.now()
    }
    // Custom Setter
    set(birthDate) {
        field = birthDate ?: LocalDate.now()
    }
}

class Study02_04_ClassAndProperty {

}