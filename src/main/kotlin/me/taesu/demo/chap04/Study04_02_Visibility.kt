package me.taesu.demo.chap04

/**
 * Created by itaesu on 2021/02/10.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */

internal open class User {
    private fun lock() = println("lock")
    protected fun delete() = println("delete")
}

// // internal 클래스를 public 함수에서 확장 불가
// fun User.hello() {
//     println("hello")
//
//     // private member이므로 확장함수에선 사용 불가
//     lock()
//
//     // 상속 관계가 아니므로 확장함수에선 사용 불가
//     delete()
// }

// 같이 internal이 되어야 함
internal fun User.hello() = println("hello")

internal interface State {
    fun print()
}


/**
 * 내부, 중첩 클래스
 */
internal class Document(val key: Long = 1L) {
    fun getState() = DocumentState()

    // 내부 클래스가 아닌 중첩 클랙스가 된다 (public static class)
    class DocumentState : State {
        override fun print() {
            // 외부 클래스에 참조를 가지지 않는다
            // println(key)
        }

    }

    // 내부 클래스가 된다 (public class)
    inner class DocumentInnerState : State {
        override fun print() {
            // 외부 클래스에 대한 참조를 가진다
            println(key)
        }
    }
}

fun test(args: Array<String>) {
    // 외부 클래스를 생성하지 않아도 생성 가능
    Document.DocumentState()

    // 외부 클래스의 참조가 가능하기 때문에 인스턴스가 생성 되어야 생성 가능
    // Document.DocumentInnerState()
    Document().DocumentInnerState()
}


// Sealed 클래스, 상속을 제한한다
interface Dish
class Sushi: Dish
class Pizza: Dish

fun typeofDish(dish: Dish): String {
    return when (dish) {
        is Sushi -> "Sushi"
        is Pizza -> "Pizza"

        // 반드시 else 절이 필요 함
        else -> "Unknown"
    }
}

sealed class FootCategory {
    object Asian : FootCategory()
    object Chinese : FootCategory()

    // object American: FootCategory()
}

// 외부에도 정의 가능
object Korean : FootCategory()

fun typeOfFoodCategory(footCategory: FootCategory): String {
    return when (footCategory) {
        is FootCategory.Asian -> "Asian"
        is FootCategory.Chinese -> "Chinese"
        is Korean -> "Korean"
        // else 절이 필요 없음, 새로 추가 되면 컴파일 에러를 일으킴, else 절이 있으면 컴파일 에러가 나지는 않음
        // else -> "Unknown"
    }
}