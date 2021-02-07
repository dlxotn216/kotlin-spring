package me.taesu.demo.chap02

/**
 * Created by itaesu on 2021/02/07.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    // 4 + (3 + 8)
    val expr = Sum(Num(4), Sum(Num(3), Num(8)))
    val result = eval(expr)
    println(result)

    println(evalWithWhen(expr))
}

fun eval(expr: Expr): Int {
    if (expr is Num) {  // 타입체크 후엔 해당 블록 내에서 알아서 캐스팅 됨
        return expr.number
    }

    if (expr is Sum) {
        val sumAs = expr as Sum     // 타입이 확실한 경우 as로 캐스팅 가
        return eval(sumAs.left) + eval(sumAs.right)
    }

    throw IllegalArgumentException("${expr}")
}

fun evalWithWhen(expr: Expr): Int{
    return when (expr) {
        is Num -> expr.number
        is Sum -> evalWithWhen(expr.left) + evalWithWhen(expr.right)
        else -> throw IllegalArgumentException("${expr}")
    }
}

interface Expr
class Num (val number: Int): Expr
class Sum (val left: Expr, val right: Expr) : Expr