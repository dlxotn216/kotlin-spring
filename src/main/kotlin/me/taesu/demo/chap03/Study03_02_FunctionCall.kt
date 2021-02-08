package me.taesu.demo.chap03

import java.time.LocalDate
import java.util.*

private val s = ")"

/**
 * Created by itaesu on 2021/02/07.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    println(joinToStringV1(listOf("abc", "dev", "com"), ";", "(", ")"))

    // named parameter
    println(joinToStringV1(list = listOf("abc", "dev", "com"), prefix = "(", postfix = ")", separator = ";"))

    // Default parameter
    println(joinToStringV2(list = listOf("abc", "dev", "com"), prefix = "[", postfix = "]"))

    mainUser()
}

fun <E> joinToStringV1(list: List<E>, separator: String, prefix: String, postfix: String): String {
    var result = prefix
    for (index in list.indices) {
        result += if (index.equals(list.size - 1)) {
            "${list.get(index)}"
        } else {
            "${list.get(index)}${separator}"
        }
    }
    result += postfix
    return result
}

// public static final과 동일
const val DEFAULT_PREFIX = "("
const val DEFAULT_SEPARATOR = ","
const val DEFAULT_POSTFIX = ")"

// 코틀린 파일 이름에 해당하는 자바 클래스로 변환 되어 그 내부에 public static 형태로 존재하게 됨
fun <E> joinToStringV2(list: List<E>, separator: String = DEFAULT_SEPARATOR, prefix: String = DEFAULT_PREFIX, postfix: String = DEFAULT_POSTFIX): String {
    var result = prefix
    for ((index, element) in list.withIndex()) {
        result += if (index.equals(list.size - 1)) element else "${element}${separator}"
    }
    result += postfix
    return result
}

class User {
    var name: String? = null
    private set

    var birthDate: LocalDate? = null
    private set

    var email: String? = null
    private set

    fun update(name: String, birthDate: LocalDate, email: String) {
        this.name = name
        this.birthDate = birthDate
        this.email = email;
    }
}

// 확장 함수를 이
fun <T> Optional<T>.unwrap(): T? = orElse(null)

fun mainUser() {
    val entity = User()
    entity.update("taesu", LocalDate.of(1993, 2, 16), "taesu@crscube.co.kr")

    val user: User? = Optional.ofNullable(entity).unwrap()
    println("name:${user?.name}, birthDate:${user?.birthDate}, email:${user?.email}")
}