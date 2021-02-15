package me.taesu.demo.chap06

/**
 * Created by itaesu on 2021/02/15.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    val nullableArrayList: ArrayList<Int>? = ArrayList()    // collection 자체가 nullable
    nullableArrayList?.add(123)
    // nullableArrayList?.add(null) // compile error

    val elementIsNullableArrayList: ArrayList<Int?> = ArrayList()   // collection 내부의 element가 nullable
    elementIsNullableArrayList.add(123)
    elementIsNullableArrayList.add(123123)
    elementIsNullableArrayList.add(null)
    elementIsNullableArrayList.add(null)
    elementIsNullableArrayList.add(null)
    countNullElementAndNotNullElement(elementIsNullableArrayList)

    val elementIsNullableAndCollectionIsNullableArrayList: ArrayList<Int?>? = ArrayList()
    elementIsNullableAndCollectionIsNullableArrayList?.add(123)
    elementIsNullableAndCollectionIsNullableArrayList?.add(null)


    unmodifiableCollectionAndModifiableCollection()

    // 참조타입의 배열
    val arrayOf = arrayOf(1, 2, 3) // 베얄 셍상 밥
    println(arrayOf.joinToString())
    // 1, 2, 3

    val arrayOfNulls = arrayOfNulls<Int>(20) // 20개의 원소가 null로 초기화 된 배열
    println(arrayOfNulls.joinToString())
    // null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null

    val arrayInitWithIndex = Array(20) { it } // 20개의 원소를 인덱스로 초기화
    println(arrayInitWithIndex.joinToString())
    // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19

    val arrayInitWithIndexSquared = Array(20) { it * it } // 20개의 원소를 인덱스 제곱으로 초기화
    println(arrayInitWithIndexSquared.joinToString())
    // 0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225, 256, 289, 324, 361

    val arrayInitWithAlphabet: Array<Char> = Array(26) { 'a' + it } // 알파벳으로 초기화
    println(arrayInitWithAlphabet.joinToString())

    arrayInitWithAlphabet.forEachIndexed { index, element ->
        println("[$index] -> $element")
    }

    // *** 코틀린의 모든 배열은 collection과 동일한 api를 지원한다
    // arrayListOf(1,2,3).forEachIndexed()

    // 원시타입의 배열
    println(IntArray(2).joinToString())
    println((IntArray(2) { it }).joinToString())
    println(intArrayOf(1, 2, 3, 4, 5).joinToString())
}

// filterNotNull 메서드를 자체 제공 함
fun countNullElementAndNotNullElement(list: ArrayList<Int?>) {
    println("not null elements size is ${list.filterNotNull().size}")
    println("not null elements size is ${list.size - list.filterNotNull().size}")
}

fun unmodifiableCollectionAndModifiableCollection() {
    val modifiable: MutableCollection<Int> = arrayListOf(1, 2, 3, 4)
    modifiable.add(123)

    val unmodifiable: Collection<Int> = arrayListOf(1, 2, 3, 4)
    // unmodifiable.add(123) // 메서드가 없다

    // modifiable을 unmodifiable이 바라볼 수 있음을 주의
    // kotlin의 표준 라이브러리는 자바 컬렉션을 바라보기에 읽기전용 컬렉션이 꼭 변경 불가 컬렉션일 수 없음
    // 따라서 ConcurrentModificationException이 읽기전용 컬렉션에서도 발생 할 수 있다는 것
    val unmodifiable2: Collection<Int> = modifiable
    println("unmodifiable2 is $unmodifiable2")
    modifiable.add(123)
    modifiable.add(123)
    modifiable.add(123)
    println("unmodifiable2 is $unmodifiable2")

    // Iterable - MutableIterable
    //     |              |
    // Collection - MutableCollection
    //     |              |
    //   List     - MutableList
    //                    |
    //                 ArrayList

    // Unmodifiable
    listOf(1, 2, 3)
    setOf(1, 2, 1, 2)
    mapOf(1 to "1", 2 to "aewf")

    // 그 외 모든 정적 팩토리메서드는 Mutable
    mutableListOf(1, 2, 3)
    mutableSetOf(1, 2, 1, 2)
    mutableMapOf(1 to "1", 2 to "aewf")
    arrayListOf(1, 2, 3)
    hashMapOf(1 to "1", 2 to "aewf")

}

// 복사할 source를 Immutable 하게 받도록 하여 좀 더 의도를 명확히 할 수 있다
fun <T> copy(source: Collection<T>, target: MutableCollection<T>) {
    // source.add() 메서드가 없다
    for (element in source) {
        target.add(element)
    }
}