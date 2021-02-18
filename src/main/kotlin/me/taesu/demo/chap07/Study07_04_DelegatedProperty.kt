package me.taesu.demo.chap07

/**
 * Created by itaesu on 2021/02/17.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
private class Study07_04_DelegatedProperty {
    // 위임 프로퍼티가 실제 컴파일 된 모습
    private val delegate = Delegate()
    var realValue: String?
        get() = delegate.innerValue
        set(value) {
            delegate.innerValue = value
        }


    class Delegate {
        var innerValue: String? = null
    }
}

fun main(args: Array<String>) {

}
