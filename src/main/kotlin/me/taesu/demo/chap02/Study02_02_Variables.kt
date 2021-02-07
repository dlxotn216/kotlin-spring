package me.taesu.demo.chap02

/**
 * Created by itaesu on 2021/02/07.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    val study0202Variables = Study02_02_Variables()

    val immutable = 24;
    val immutableAny: Int   // 초기화를 하지 않으려면 타입 명시해야 함
    immutableAny = 123      // 딱 한 번 초기화 가능

    val immutableInIf: String
    if(immutable > 0) {
        immutableInIf = "case 1"
    } else {
        immutableInIf = "case 2"
    }

    // compile error
//    immutableAny = 123
//    immutable = 123

    val question = "Who are you"


}

class Study02_02_Variables {
}