package me.taesu.demo.chap05

/**
 * Created by taesu on 2020-05-26.
 */

fun main(args: Array<String>) {
    Study05_07_LazyCollection2().exam()
}

class Study05_07_LazyCollection2 {
    private data class Person(val name: String)

    fun exam() {
        listOf(Person("taesu"),
                Person("aef"),
                Person("awefwaf"),
                Person("Kim"),
                Person("yoon"),
                Person("Lee"),
                Person("You"),
                Person("Park"))
                .asSequence()
                .map {
                    println("""in map $it""")
                    it.name
                }
                .filter {
                    println("""in filter $it""")
                    it.startsWith("K")
                }
        //위의 시퀀스의 중간 연산은 실행되지 않는다.

        listOf(Person("taesu"),
                Person("aef"),
                Person("awefwaf"),
                Person("Kim"),
                Person("yoon"),
                Person("Lee"),
                Person("You"),
                Person("Park"))
                .asSequence()
                .map {
                    println("""in second map $it""")
                    it.name
                }
                .filter {
                    println("""in second filter $it""")
                    it.startsWith("K")
                }
                .toList()

        //최종연산이 존재하는 경우에만 중간연산이 실행된다
        // -> Lazy 연산
        /*

        각각의 중간연산이 다 적용디고 다음 요소로 넘어간다

        in second map Person(name=taesu)
        in second filter taesu

        in second map Person(name=aef)
        in second filter aef

        in second map Person(name=awefwaf)
        in second filter awefwaf

        in second map Person(name=Kim)
        in second filter Kim
        in second map Person(name=yoon)
        in second filter yoon
        in second map Person(name=Lee)
        in second filter Lee
        in second map Person(name=You)
        in second filter You
        in second map Person(name=Park)
        in second filter Park
         */


        println()
        println(listOf(1, 2, 3, 4)
                .map {
                    println("""map -> $it""")
                    it * it
                }.find {
                    println("""find -> $it""")
                    it > 3
                })
        /*
        모두 다 돈다

        map -> 1
        map -> 2
        map -> 3
        map -> 4
        find -> 1
        find -> 4
         */

        println(listOf(1, 2, 3, 4)
                .asSequence()
                .map {
                    println("""map -> $it""")
                    it * it
                }.find {
                    println("""find -> $it""")
                    it > 3
                })
        /*
        대상 찾으면 연산 그만한다.

        map -> 1
        find -> 1
        map -> 2
        find -> 4
        4
         */
    }
}