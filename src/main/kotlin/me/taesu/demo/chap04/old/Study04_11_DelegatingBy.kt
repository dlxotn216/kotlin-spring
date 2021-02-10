package me.taesu.demo.chap04.old

/**
 * Created by taesu on 2020-05-18.
 */
fun main(args: Array<String>) {
    Study04_11_DelegatingBy().exam()
}

//상속을 허용하지 않느 클래스에 새로운 동작을 추가할 때 Delegate 패턴을 사용한다
//보통 인터페이스를 구현하는 클래스 내부에 확장하고자 하는 클래스의 구현체를 가지도록 한다
/*
    class Delegator<T> : Collection<T> {
        val list = ArrayList()

        // implement all of Collection<T> method
    }
 */
//하지만 위임을 위해서 초기 작업해야 하는 코드가 많은데
//보통 확장하려는 메소드 외에는 그대로 내부 필드의 객체에 위임하기 때문이다.
//kotlin에선 이런 것을 by라는 키워드를 통해 도와준다
class Study04_11_DelegatingBy {
    private class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet()) : MutableCollection<T> by innerSet {
        var objectsAdded = 0

        override fun add(element: T): Boolean {
            objectsAdded++
            return innerSet.add(element)
        }

        override fun addAll(elements: Collection<T>): Boolean {
            objectsAdded += elements.size
            return innerSet.addAll(elements)
        }
    }

    fun exam() {
        val countingSet = CountingSet<Int>()
        countingSet.add(1)
        countingSet.addAll(arrayOf(1, 2, 3, 4))

        println(countingSet)
        println(countingSet.objectsAdded)

        println(countingSet.contains(1))
    }
}