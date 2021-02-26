package me.taesu.demo.chap11

import java.time.LocalDate
import java.time.Period

/**
 * Created by itaesu on 2021/02/26.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    println("kotlin" should startWith("ko"))

    println("kotlin" must start with ("ko"))
    val startWrapper = "kotlin" must start
    startWrapper with "ko"

    val user = TestUser("taesu", "Lee")
    user should have name("Lee")

    dateTest()
}

infix fun <T> T.should(matcher: T.() -> Boolean) = matcher(this)
class startWith(val prefix: String) : (String) -> Boolean {
    override fun invoke(value: String): Boolean = value.startsWith(prefix)
}

object start
infix fun String.must(x: start): StartWrapper = StartWrapper(this)
class StartWrapper(val value: String) {
    infix fun with(prefix: String) = value.startsWith(prefix)
}

class TestUser(val id: String, val name: String)

object have
infix fun TestUser.should(x: have): HaveWrapper = HaveWrapper(this)
class HaveWrapper(val value: TestUser) {
    infix fun name(name: String) = name == value.name
}

fun dslTest() {
    val study = Study("PROTO", "PROGRESS")
    // obj infix matcher
    study may equalStatus("PROGRESS")

    // object will(return wrapper) -> have
    // have id(infix) value
    study will have id "PROTO"
}
class Study(val id: String, val status: String)
infix fun Study.may(matcher: (Study) -> Boolean) = matcher(this)
class equalStatus(val status: String): (Study) -> Boolean {
    override fun invoke(p1: Study): Boolean  = p1.status == status
}

infix fun Study.will(x: have): StudyWillHaveWrapper = StudyWillHaveWrapper(this)
class StudyWillHaveWrapper(val study: Study) {
    infix fun id(id: String)  = study.id == id
}

fun dateTest() {
    val yesterday = 1.days.ago
    val tomorrow = 1.days.fromNow

    println(yesterday)
    println(tomorrow)
}
val Int.days: Period
    get() = Period.ofDays(this)
val Period.ago: LocalDate
    // get() = LocalDate.now().minus(this)
    get() = LocalDate.now() - this
val Period.fromNow: LocalDate
    // get() = LocalDate.now().plus(this)
    get() = LocalDate.now() + this
