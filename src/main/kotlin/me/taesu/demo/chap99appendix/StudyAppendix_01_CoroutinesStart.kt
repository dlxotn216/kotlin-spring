package me.taesu.demo.chap99appendix

import kotlinx.coroutines.*
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

/**
 * Created by itaesu on 2021/02/26.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    launchGlobalTest()
    println()
    runBlockingTest()
    println()
}

private fun launchGlobalTest() {
    log("main() started")
    launchInGlobalScope()
    log("after launch global scope()")
    Thread.sleep(500L)      // 없으면 바로 종료되버린다
    log("main() terminated")

    println()
    println("yield start")
    yieldTest()
    println("yield end")
}

private fun runBlockingTest() {
    log("main() started")
    runBlockingExam()   // run block이 있어서 대기한다, 모두 메인스레드에서 실행 된다.
    log("after runBlockingExam scope()")
    log("main() terminated")
}

fun now() = ZonedDateTime.now().toLocalDateTime().truncatedTo(ChronoUnit.MILLIS)
fun log(msg: String) = println("${now()}:${Thread.currentThread()}:${msg}")

fun launchInGlobalScope() {
    GlobalScope.launch {
        log("Coroutines started")
    }
}

fun runBlockingExam() {
    runBlocking {
        launch {
            log("GlobalScope.launch started")
        }
    }
}

// 1, 2, 3, 5, 4, 6
fun yieldTest() {
    runBlocking {   // 내부 모든 코루틴이 끝나야 함수가 종료 된다.
        launch {
            log("1")
            yield()
            log("3")
            yield()
            log("5")
        }
        log("first launch in yield finish")
        launch {
            log("2")
            delay(1000L)    // 대기하는 동안 다른 코루틴에 양보 함, 1초 대기하는 동안 1번 런쳐에서 두번의 yield를 했으나 아직 대기중이므로 위의 런쳐가 먼저 끝남
            log("4")
            delay(1000L)
            log("6")
        }
        log("second launch in yield finish")
    }
}