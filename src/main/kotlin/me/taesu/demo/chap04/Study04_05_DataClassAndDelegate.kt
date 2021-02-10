package me.taesu.demo.chap04

/**
 * Created by itaesu on 2021/02/10.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
data class Study(
        val id: String,
        val name: String
) {
    var other: String? = null       // equals, hashcode, toString, copy에서 제외
}

// Hibernate 같은 경우 natural key or business key를 기반으로 equals, hashcode를 오버라이딩 하는 것츨 추천 함
class Entity(
        var key: Long?,
        val name: String
) {
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Entity) {
            return false
        }

        return this.key != null && this.key == other.key
    }

    override fun hashCode(): Int {
        return this.key?.hashCode() ?: 31
    }
}


// 필요한 부분만 오버라이딩 하고 나머지는 by를 통해 위임한다
// deletage 패턴을 사용하면 구현에 있어서 의존관계가 생기지 않는다 (위임하기 때문에)
class CountableList<T>(private val delegator: ArrayList<T> = ArrayList())
    : MutableList<T> by delegator {

    private var modifyCount: Int = 0

    override fun add(element: T): Boolean {
        modifyCount++
        return delegator.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        modifyCount += elements.size
        return delegator.addAll(elements)
    }

    fun status() = println("$modifyCount element added")
}

fun main(args: Array<String>) {
    val study1 = Study("OR!", "or1")
    study1.other = "qwer"
    val study2 = Study("OR!", "or1")
    study2.other = "1234"

    println(study1 == study2)       // true     equals()
    println(study1 === study2)      // false    참조 동등성
    println(study1 === study1)      // true됨

    val studies = hashSetOf(study1, study2)
    println(studies.size)           // 1 (other 필드는 hashCode에서 제외 되므로)

    println(study1) // toString()
    println(study1.hashCode())
    println(study2.hashCode())

    val hashSetOf = hashSetOf(Entity(1L, "first"))
    hashSetOf.add(Entity(1L, "second"))
    println(hashSetOf.size)


    val study = Study("protp", "buf")
    println(study)
    println(study.copy(id = "changed", name = "changedBuf"))    // copy에서도 other 필드는 없

    val countableList = CountableList<Int>()
    countableList.add(1)
    countableList.addAll(arrayOf(2,3,4))
    countableList.status()
}