package me.taesu.demo.chap04.old

/**
 * Created by taesu on 2020-05-19.
 */
fun main(args: Array<String>) {
    Study04_12_ObjectDeclartion().exam()
}

class Study04_12_ObjectDeclartion {
    private data class User(val name: String, val email: String) {
        //객체 선언은 클래스나 인터페이스를 상속받을 수 있기에
        // 구현 내부에 상태가 필요하지 않은 경우에 적합하다
        //또한 아래 객체 선언들은 User 클래스 내부에 위치하는게 더 적합하다
        object UserNameComparator : Comparator<User> {
            override fun compare(o1: User, o2: User): Int = o1.name.compareTo(o2.name)
        }

        object UserEmailComparator : Comparator<User> {
            override fun compare(o1: User, o2: User): Int = o1.email.compareTo(o2.email)
        }


        //클래스 안에 정의된 객체에 companion을 붙이면 동반 객체로 할 수 있다
        //동반 객체의 프로퍼티느 메소드는 Java의 정적 메소드 호출이나 정적 필드 참조와 같아진다
        //kotlin에는 static 없어 이처럼 사용한다
        companion object {
            val USER_NAME_LENGTH: Int = 40
            val USER_EMAIL_LENGTH: Int = 60

            fun fromUnknown(): User {
                return User("UNKNOWN", "UNKNOWN")
            }

            fun fromEmail(email: String): User {
                return User(email.substringBefore("@"), email)
            }
        }

        //하나의 companion object만 허용 된다
        //아래와 같이 동반객체에 이름을 붙일 수 있다.
//        companion object CONST_FIELD {
//            val USER_NAME_LENGTH: Int = 40
//            val USER_EMAIL_LENGTH: Int = 60
//        }
    }

    //objects(객체선언)을 통해 싱글턴을 쉽게 만들 수 있다.
    private object Payroll {
        val alUsers = arrayListOf<User>(User("tesu", "awefaw"), User("wafe", "awefawf"))

        fun calculateName(): String {
            return alUsers.map { it.name }.joinToString(",")
        }
    }

    fun exam() {
        println(Payroll.calculateName())

        println("sort by user name")
        listOf(User("taesu1", "ataesu1@crscube.co.kr"),
                User("qwer", "taesu1@crscube.co.kr"))
                .sortedWith(User.UserNameComparator).forEach { println(it) }

        println("sort by user email")
        listOf(User("taesu1", "ataesu1@crscube.co.kr"),
                User("qwer", "taesu1@crscube.co.kr"))
                .sortedWith(User.UserEmailComparator).forEach { println(it) }

        println(User.fromEmail("taesu@crscube.co.kr"))
        println(User.USER_NAME_LENGTH)

    }
}