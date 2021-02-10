package me.taesu.demo.chap03

/**
 * Created by itaesu on 2021/02/10.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {

}

internal fun validation(key: Long, request: UserUpdateRequest) {
    if (request.name.isEmpty()) {
        throw IllegalArgumentException("Can't update user($key): User name is empty")
    }

    if (request.email.isEmpty()) {
        throw IllegalArgumentException("Can't update user($key): User email is empty")
    }
}

internal fun validationWithLocalFunction(key: Long, request: UserUpdateRequest) {
    // 재사용성이 거의 없는 함수 같은 경우 private으로 선언해도 좋지만 로컬함수로 선언 하는 것이 더 좋을 것
    fun validationField(value: String, fieldName: String) {
        if (value.isEmpty()) {
            // 로컬함수는 바깥 함수의 모든 파라미터와 변수를 참조 할 수 있음
            throw IllegalArgumentException("Can't update user($key): User $fieldName is empty")
        }
    }

    validationField(request.name, "name")
    validationField(request.email, "email")
}

// 확장함수로 조금 더 원본 클래스를 간결하게 유지시키면서 필요 로직을 응집시킬 수 있다
internal fun UserUpdateRequest.validation(key: Long) {
    fun validationField(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't update user($key): User $fieldName is empty")
        }
    }

    validationField(name, "name")
    validationField(email, "email")
}

internal data class UserUpdateRequest(
        val name: String,
        val email: String
)