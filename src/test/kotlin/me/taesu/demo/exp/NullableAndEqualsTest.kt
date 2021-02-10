package me.taesu.demo.exp

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * Created by itaesu on 2021/02/10.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
class NullableAndEqualsTest {
    @Test
    fun `When object's property is null compare result should true`() {
        val user = User(name = "taesu", email = "taesu@crscube.co.kr")
        val user2 = User(name = "taesu", email = "taesu@crscube.co.kr")

        assert(user.key == user2.key)
        assertThat(user.key != null && user.key == user2.key).isFalse()
    }

    @Test
    fun `When objects are nullable, compare result should true`() {
        fun nullableUser(): User? = User(name = "taesu", email = "taesu@crscube.co.kr")

        val user: User? = null
        val user2: User? = nullableUser()

        assert(user?.key == user2?.key)
        assertThat(user?.key != null && user.key == user2?.key).isFalse()
    }

    @Test
    fun `When object is nullable, compare result should true`() {
        fun nullableUser(): User? = User(key = 2L, name = "taesu", email = "taesu@crscube.co.kr")

        val user: User? = null
        val user2: User? = nullableUser()

        assert(user?.key != user2?.key)
    }
    
    @Test
    fun `When object is nullable, type compare result should true`() {
        fun nullableUser(): User? = User(key = 2L, name = "taesu", email = "taesu@crscube.co.kr")

        val user: User? = null
        val user2: User? = nullableUser()
        val user3: Any? = null
        val user4: Any? = nullableUser()

        assertThat(user is User).isFalse()
        assertThat(user2 is User).isTrue()
        assertThat(user3 is User).isFalse()
        assertThat(user4 is User).isTrue()

        if (user4 !is User) {
            return
        }

        // smart casting
        println(user4.name)
    }
}

data class User(
        var key: Long? = null,
        val name: String,
        val email: String
)