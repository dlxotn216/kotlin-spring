package me.taesu.demo.chap02

/**
 * Created by itaesu on 04/05/2020.
 *
 * @author Lee Tae Su
 * @version 1.2.0
 * @since 1.2.0
 */

fun main(args: Array<String>) {
    Study2_5().exam1()
}

class Study2_5 {

    private interface Expr {
        fun expr(): Int
    }

    private data class Number(val value: Int) : Expr {
        override fun expr(): Int {
            return value
        }
    }

    private data class Sum(val expr1: Expr, val expr2: Expr) : Expr {
        override fun expr(): Int {
            return expr1.expr() + expr2.expr()
        }

    }

    private fun calculate(expr: Expr): Int {
        return expr.expr()
    }

    //Smart Casting
    private fun calculate2(expr: Expr): Int {
        if (expr is Number) {
            return expr.value
        }

        if (expr is Sum) {
            return expr.expr()
        }

        throw IllegalArgumentException("Unexpected Expr $expr")
    }

    //좀 더 코틀린 답게 (if - elseif - else로 반드시 엮여야 함)
    private fun calculate3(expr: Expr): Int =
            if (expr is Number) {
                expr.value
            } else if (expr is Sum) {
                expr.expr()
            } else {
                throw IllegalArgumentException("Unexpected Expr $expr")
            }

    //if를 when으로
    private fun calculate4(expr: Expr): Int =
            when (expr) {
                is Number -> expr.value
                is Sum -> expr.expr()
                else -> throw IllegalArgumentException("Unexpected Expr $expr")
            }

    //When 절에 block 사용
    private fun calculate5(expr: Expr): Int =
            when (expr) {
                is Number -> {
                    println("is number ${expr.value}")
                    expr.value                          //block의 마지막 식이 블록의 결과이다
                }
                is Sum -> {
                    val expr1 = calculate5(expr.expr1)
                    val expr2 = calculate5(expr.expr2)
                    println("calculate $expr1 + $expr2")
                    expr1 + expr2                       //block의 마지막 식이 블록의 결과이다
                }
                else -> {
                    println("Unexpected expr")
                    throw IllegalArgumentException("Unexpected Expr $expr")
                }
            }
    //만약 함수라면 블록의 마지막 식이 결과는 될 수 없으며 반드시 리턴이 존재해야 한다.


    fun exam1() {
        println(calculate(Sum(Sum(Number(123), Number(41)), Sum(Number(10), Sum(Number(17), Number(24))))))
        println(calculate2(Sum(Sum(Number(123), Number(41)), Sum(Number(10), Sum(Number(17), Number(24))))))
        println(calculate3(Sum(Sum(Number(123), Number(41)), Sum(Number(10), Sum(Number(17), Number(24))))))
        println(calculate4(Sum(Sum(Number(123), Number(41)), Sum(Number(10), Sum(Number(17), Number(24))))))
        println(calculate5(Sum(Sum(Number(123), Number(41)), Sum(Number(10), Sum(Number(17), Number(24))))))
    }

}