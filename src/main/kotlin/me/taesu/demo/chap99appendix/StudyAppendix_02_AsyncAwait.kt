package me.taesu.demo.chap99appendix

import kotlinx.coroutines.*

/**
 * Created by itaesu on 2021/02/27.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main() {
    runBlocking {
        log("run blocking start")
        // async는 launch와 동일. 다만 값을 반환하는데에 차이가 있다.
        val task1 = async {
            delay(1000L)
            1
        }
        val task2 = async {
            delay(2000L)
            2
        }
        val task3 = async {
            delay(1000L)
            3
        }

        println("result is ${task1.await() + task2.await() + task3.await()}")
        log("after blocking start")
    }

    runBlocking {
        launch {
            // main runblocking : thread is main
            println("main runblocking : thread is ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Unconfined) {
            // Unconfined : thread is main, 특정 스레드에 종속되지 않음 ?메인스레드
            println("Unconfined : thread is ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Default) {
            // Default : thread is DefaultDispatcher-worker-1, 기본 디스패치
            println("Default : thread is ${Thread.currentThread().name}")
        }

        launch(newSingleThreadContext(("MyOwnThread"))) {
            // MyOwnThread : thread is MyOwnThread, 새 스레드 사용
            println("MyOwnThread : thread is ${Thread.currentThread().name}")
        }
    }

    GlobalScope.launch {
        suspendFunction()
    }
    runBlocking {
        suspendFunction()
    }
}
// delay, yield는 일반 함수에서 호출 불가하고 suspend 함수에서 호출이 가능하다.
suspend fun suspendFunction() {
    delay(1000L)
    println("delay 1000L")
    yield()
    println("yeild")
}

fun CoroutineScope.asyncFunction(): Deferred<Int> = async { 1 }
