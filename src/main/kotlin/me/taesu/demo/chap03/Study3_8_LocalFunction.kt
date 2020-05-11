package me.taesu.demo.chap03

/**
 * Created by taesu on 2020-05-11.
 */
fun main(args: Array<String>) {
    Study3_8_LocalFunction().exam()
}

class Study3_8_LocalFunction {

    private data class User(val key: Long, val name: String, val email: String)

    private fun saveUser(user: User) {
        if (user.name.isEmpty()) {
            throw IllegalArgumentException("${user.key} cannot be saved, name required")
        }

        if (user.email.isEmpty()) {
            throw IllegalArgumentException("${user.key} cannot be saved, email required")
        }
    }

    private fun User.validation() {
        //로컬 함수를 통해 처리할 수 있음
        fun validate(value: String, fieldName: String) {
            if (value.isEmpty()) {
                throw IllegalArgumentException("${this.key} cannot be saved, ${fieldName} required")
            }
        }

        validate(this.name, "name")
        validate(this.email, "email")
    }

    private fun saveUserMoreAdvanced(user: User) {
        //확장 함수 선언을 로컬 함수로도 둘 수 있으나 매우 중첩구조가 길어지기에 하나의 중첩 레벨만 유지하기를 권장
        fun User.validation2() {
            fun validate(value: String, fieldName: String) {
                if (value.isEmpty()) {
                    throw IllegalArgumentException("${this.key} cannot be saved, ${fieldName} required")
                }
            }

            validate(this.name, "name")
            validate(this.email, "email")
        }
        user.validation()
        user.validation2()
    }

    private fun saveUserInKotlin(user: User) {
        //로컬 함수를 통해 처리할 수 있음
        fun validate(value: String, fieldName: String) {
            if (value.isEmpty()) {
                throw IllegalArgumentException("${user.key} cannot be saved, ${fieldName} required")
            }
        }

        validate(user.name, "name")
        validate(user.email, "email")
    }

    private fun saveUserInJava(user: User) {
        validtionField(user, user.name, "name")
        validtionField(user, user.email, "email")
    }

    //아래와 같이 리팩토링 햇을 것...
    //user 계속 넘겨야 함
    private fun validtionField(user: User, value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("${user.key} cannot be saved, ${fieldName} required")
        }
    }

    fun exam() {
        try {
            saveUserInKotlin(User(1L, "", ""))
        } catch (e: Exception) {
            println(e)
        }

        try {
            saveUserInKotlin(User(1L, "awef", ""))
        } catch (e: Exception) {
            println(e)

        }

        try {
            saveUserMoreAdvanced(User(1L, "", ""))
        } catch (e: Exception) {
            println(e)
        }

        try {
            saveUserMoreAdvanced(User(1L, "awef", ""))
        } catch (e: Exception) {
            println(e)
        }

//        User().validation()
//        User().validation2() 못찾음
    }
}