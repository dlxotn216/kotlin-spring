package me.taesu.demo.chap06

/**
 * Created by itaesu on 2021/02/15.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun verify(input: String?) {
    // String의 isNullOrEmpty, isNullOfBlank는 nullable 타입에 대해서 선언된 확장 함수이다
    // 따라서 ?.과 같이 접근하지 않아도 null safety가 보장된다
    if (input.isNullOrEmpty()) {
        println("input is empty")
    } else {
        println("input is not empty")
    }
}

private class Study06_04_ExtensionNullable {
    data class NullableValue(var value: String?)

}
private fun Study06_04_ExtensionNullable.NullableValue?.isEmpty(): Boolean = this == null || this.value.isNullOrEmpty()

// 모든 타입 파라미터는 nullable이다
fun <T> printHashCode(t: T) { // == fun <T: Any?> printHashCode(t: T) {
    println(t?.hashCode())
}

fun <T: Any> printHashCodeNotNullable(t: T) {
    println(t.hashCode())
}

fun main(args: Array<String>) {
    verify(null)
    verify("String")

    val nullableValue1: Study06_04_ExtensionNullable.NullableValue? = Study06_04_ExtensionNullable.NullableValue("test")
    if (nullableValue1.isEmpty()) {
        println("nullableValue1 is null")
    }
    val nullableValue2: Study06_04_ExtensionNullable.NullableValue? = null
    if (nullableValue2.isEmpty()) {
        println("nullableValue2 is null")
    }

    printHashCode(nullableValue1)
    printHashCodeNotNullable(nullableValue1!!)

    printHashCode(nullableValue2)
    // printHashCodeNotNullable(nullableValue2) // compile error

    // 코틀린에서 자바 코드를 호출 할 때 자바 코드에 @Nullable, @NotNull 등의 Null 타입 관련 어노테이션을 찾는다
    // 만약 없으면 플랫폼 타입이 된다 User!, Member!
    // 이러한 플랫폼 타입은 nullable or notnull 이 된다. 호출자가 알아서 감수해야 한다
    // 자바 메소드를 오버라이드 할 때도 nullable or notnull로 구현할 지 선택해야 한다
}