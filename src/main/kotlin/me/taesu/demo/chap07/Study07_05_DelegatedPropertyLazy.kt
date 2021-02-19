package me.taesu.demo.chap07

import java.time.LocalDate

/**
 * Created by itaesu on 2021/02/19.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
private class Study07_05_DelegatedPropertyLazy {

    class Person(val name: String) {
        private var _emails: List<Email>? = null
        val emails: List<Email>
          get() {
              _emails?.let {
                  _emails = loadEmails(this)
              }
              return _emails!!
          }

        // 뒷받침 하는 필드 대신 아래와 같이 by lazy를 통해서 한 번만 초기화 할 수 있다
        val friends by lazy { loadFriends(this) }

        private fun loadEmails(person: Person): List<Email> = arrayListOf(Email("${person.name}@gmail.com"))

        private fun loadFriends(person: Person): List<Friend> = arrayListOf()
    }

    data class Email(val address: String)
    data class Friend(val name: String, val birthDate: LocalDate)
}