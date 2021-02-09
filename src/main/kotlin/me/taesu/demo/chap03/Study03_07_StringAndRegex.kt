package me.taesu.demo.chap03

/**
 * Created by itaesu on 2021/02/08.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    // 만약 Java라면 정규표현식으로 인식됐을 것, 코틀린에선 확장 함수로 모호함을 방어 함
    val split = "12.345-6.A".split(".")
    println(split)

    // 여러 delimiter 적용 가능
    println("12.345-6.A".split(".", "-"))

    // 여러 강력한 문자열을 다루는 것이 있으니 정규표현식 보단 최대한 이런 API를 사용할 것
    val path = "/Users/taesu/kotlin-spring/test.txt"
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")
    println("Directory $directory, fileName: $fileName, extension: $extension")

    // 문자열 to regex
    val regex: Regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchEntire = regex.matchEntire(path)
    if (matchEntire != null) {
        val (dir, fname, fextension) = matchEntire.destructured
        println("Directory $dir, fileName: $fname, extension: $fextension")
    }

}