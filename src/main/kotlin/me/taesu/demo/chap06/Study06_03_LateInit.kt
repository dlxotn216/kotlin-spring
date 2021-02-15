package me.taesu.demo.chap06

/**
 * Created by itaesu on 2021/02/15.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
private class Study06_03_LateInit {
    class UserCreateController {
        // DI Container 등에서 모든 주입받는 필드를 아래와 같이 사용해야한다 (constructor injection이 아닌 field, setter injection 일 때)
        // null이 대부분 아닐건데 다른데서 userCreateServiceNullable?.와 같이 접근해야 해서 코드가 가독성이 떨어짐
        private var userCreateServiceNullable: UserCreateService? = null

        // lateinit을 선언하면 nullable 타입으로 표기하고 null 초기화를 하지 않아도 된다
        private lateinit var userCreateService: UserCreateService
    }
    class UserCreateService {

    }
}