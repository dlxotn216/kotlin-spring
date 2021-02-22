package me.taesu.demo.chap08

/**
 * Created by itaesu on 2021/02/22.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    val discountCalculator = getDiscountCalculator(Delivery.EXPEDITED)
    println(discountCalculator(Order(4)))

    val siteVisitLogs = listOf(SiteVisit("/", 12.0, OS.WINDOWS),
            SiteVisit("/about", 2.62, OS.WINDOWS),
            SiteVisit("/career", 21.3, OS.WINDOWS),
            SiteVisit("/", 6.1, OS.MAC),
            SiteVisit("/about", 28.1, OS.MAC),
            SiteVisit("/career", 27.1, OS.MAC))

    // OS별 사용자의 평균 접속 시간
    println(siteVisitLogs.filter { it.os == OS.WINDOWS }.map { it.duration }.average())
    println(siteVisitLogs.filter { it.os == OS.MAC }.map { it.duration }.average())

    // 람다를 활용한 중복 제거
    println(siteVisitLogs.averageByOS(OS.WINDOWS))
    println(siteVisitLogs.averageByOS(OS.MAC))

    // Predicate 람다를 활용
    println(siteVisitLogs.averageByOS {
        it.os in setOf(OS.MAC, OS.WINDOWS) && it.path == "/about"
    })
}

enum class Delivery { STANDARD, EXPEDITED }

data class Order(val itemCount: Int)

// 전달 받은 인자에 따라서 람다를 반환한다.
fun getDiscountCalculator(delivery: Delivery): (Order) -> Double {
    return when (delivery) {
        Delivery.STANDARD -> { order -> order.itemCount * 1.6 }
        Delivery.EXPEDITED -> { order -> order.itemCount * 1.9 }
    }
}

data class SiteVisit(
        val path: String,
        val duration: Double,
        val os: OS
)

enum class OS { WINDOWS, MAC, IOS }

fun List<SiteVisit>.averageByOS(os: OS) = filter { it.os == os }.map { it.duration }.average()
fun List<SiteVisit>.averageByOS(predicate: (SiteVisit) -> Boolean) = filter(predicate).map { it.duration }.average()