package me.taesu.demo.chap08

import java.util.concurrent.locks.Lock

/**
 * Created by itaesu on 2021/02/23.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    printInline("hello") // -> println("hello")와 같이 함수의 본문이 호출지로 인라인 된다.

    arrayOf(1, 2, 3, 4).asSequence()
            .map { it * it }
}

inline fun printInline(printTo: String) {
    println(printTo)
}

fun foo(lock: Lock) {
    println("before sync")
    synchronized(lock) {
        // 인라인 함수에 람다를 넘긴다
        println("sync")
    }
    println("after sync")
}

// 아래와 같이 컴파일 된다
/*
fun foo(lock: Lock) {
    println("before sync")
    lock.lock()
    try {
        println("sync")
    } finally {
        lock.unlock()
    }
    println("after sync")
}
 */

inline fun <T> synchronized(lock: Lock, action: () -> T): T {
    lock.lock()
    try {
        return action()
    } finally {
        lock.unlock()
    }
}

private class Study08_05_InlineFunction {
    class LockOwner(val lock: Lock) {
        fun runUnderLock(body: () -> Unit) {
            // 인라인 함수에 람다가 아닌 변수에 저장 된 함수를 넘긴다
            // 이 경우 변수에 저장 된 람다 코드를 알 수 없기 때문에 람다 본문은 인라이닝 되지 않고 synchronized 함수 본문만 인라이닝 된다.
            synchronized(lock, body)
        }

        /*
        fun runUnderLock(body: () -> Unit) {
            lock.lock()
            try {
                body()
            } finally {
                lock.unlock()
            }
        }
        */
    }
}

// 일부에 대해서 인라이닝 금지 할 수 있다.
inline fun partialInline(inlined: () -> Unit, noinline notInlined: () -> Unit) {
    inlined()       // 전달받아 바로 호출하기에 inline
    notInlined()    // 전달받아 바로 호출하지만 키워드로 인해 not inlined

    // val test = inlined; // 마찬가지로 에러

    // pass to other
    // other(inlined)  // inline 함수를 다른데로 전달하기에 noinline이 되어야 한다

    // partialInline이 누군가에 의해 호출되어 인라이닝 될 때 전달 받은 람다를 그대로 호출하지 않고
    // 어딘가에 저장하고 나중에 사용한다면 어딘가에는 그 람다가 존재해야 하기에 Illegal useage of inline-parameter 컴파일 에러 발생

    // 또 다른 인라인 함수에는 전달 가능하다.
    inlineother(inlined)
}

fun other(inlined: () -> Unit) {

}

inline fun inlineother(inlined: () -> Unit) {

}
