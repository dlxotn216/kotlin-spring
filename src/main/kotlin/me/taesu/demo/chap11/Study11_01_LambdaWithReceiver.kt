package me.taesu.demo.chap11

/**
 * Created by itaesu on 2021/02/25.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    println(buildString {
        it.append("awef")
        it.append("awef")
        it.append("awef")
    })

    // 함수 안에서 수신 객체를 지정 해줬기 때문에 it.을 붙이지 않아도 된다.
    println(buildStringWithReceiver {
        append("aewfaf")
        this.append("aewfaf")
    })

    // 변수에 대입
    val lambda: StringBuilder.() -> Unit = { append("!") }
    // 확장함수처럼 쓸 수 있음
    println(StringBuilder("awefaf").lambda())
    // 함수에도 넘길 수 있음
    println(buildStringWithReceiver(lambda))

    val map = mutableMapOf(1 to "one")
    val with = with(map) {
        this[2] = "two"
        this[3] = "three"
        "clear"     // 반환 값
    }
    println(map)
    println(with)

    val apply = map.apply {
        this[4] = "four"
        this[5] = "five"
    }
    println(map)
    println(apply)  // 수신 객체가 반환 값

    println(createTable())
    test()
}

fun buildString(action: (StringBuilder) -> Unit): String {
    val sb = StringBuilder()
    action(sb)
    return sb.toString()
}

// action에 StringBuilder.()을 통해서 수신 객체라는 상태를 부여함
// {수신객체타입}.(파라미터) -> 반환타입
fun buildStringWithReceiver(action: StringBuilder.() -> Unit): String {
    val sb = StringBuilder()
    action(sb)
    return sb.toString()
}

open class Tag(val name: String) {
    private val children = mutableListOf<Tag>()
    protected fun <T : Tag> doInit(child: T, init: T.() -> Unit) {
        child.init()
        children.add(child)
    }

    override fun toString(): String = "<$name>${children.joinToString("")}</$name>"
}

fun table(init: TABLE.() -> Unit) = TABLE().apply(init)

class TABLE : Tag("table") {
    fun tr(init: TR.() -> Unit) {
        doInit(TR(), init)
    }
}

class TR : Tag("tr") {
    fun td(init: TD.() -> Unit) {
        doInit(TD(), init)
    }
}

class TD : Tag("td")

// <table><tr><td></td><td></td></tr><tr><td></td><td></td></tr></table>
fun createTable() = table {
    tr {
        td {

        }
        td {

        }
    }
    tr {
        td {

        }
        td {

        }
    }
}


open class HtmlTag(val name: String) {
    private val children: MutableList<HtmlTag> = mutableListOf()
    protected fun <T : HtmlTag> add(element: T) {
        children.add(element)
    }

    override fun toString(): String = "<$name>${children.joinToString("")}</$name>"
}

fun htmlTable(action: HtmlTable.() -> Unit) = HtmlTable().apply(action)

class HtmlTable : HtmlTag("table") {
    fun tr(action: HtmlTr.() -> Unit) {
        val tr = HtmlTr()
        add(tr)
        action(tr)
    }
}

class HtmlTr : HtmlTag("tr") {
    fun td(action: HtmlTd.() -> Unit) {
        val td = HtmlTd()
        add(td)
        action(td)
    }
}

class HtmlTd : HtmlTag("td")

fun test() {
    println(htmlTable {
        tr {
            td {}
        }
        tr {
            td { }
            td { }
        }
    })
}







