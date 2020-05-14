package me.taesu.demo.chap04

/**
 * Created by itaesu on 14/05/2020.
 *
 * @author Lee Tae Su
 * @version 1.2.0
 * @since 1.2.0
 */

class Study04_05_SealedClass {
    private interface Expr
    private class Num(val value: Int) : Expr
    private class Sum(val left: Expr, val right: Expr) : Expr

    private fun eval(e: Expr): Int =
            when (e) {
                is Num -> e.value
                is Sum -> eval(e.right) + eval(e.left)
            //언제 어떤 클래스가 상속되어 들어올 지 모르기 때문에 반드시 else 구문이 강제 됨
                else -> throw IllegalArgumentException("Unknown")
            }


    //Sealed 클래스는 해당 클래스를 상속하는 하위클래스를 제한할 수 있음
    private sealed class SealedExpr {
        internal class SealedNum(val value: Int) : SealedExpr()
        internal class SealedSum(val left: Expr, val right: Expr) : SealedExpr()

        //아래 클래스가 추가 되면 when 절에서 컴파일 에러 발생
//        internal class SealedSum2(val left: Expr, val right: Expr) : SealedExpr()
    }

    //this type is sealed, it can be inherited by only its own nested class or objects
//    private class SealedTest : SealedExpr()

    private fun eval(e: SealedExpr): Int =
            when (e) {
                is SealedExpr.SealedNum -> e.value
                is SealedExpr.SealedSum -> eval(e.right) + eval(e.left)
            }

}