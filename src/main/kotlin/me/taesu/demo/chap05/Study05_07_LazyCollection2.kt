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


        println()
        //이름의 길이가 3 보다 큰 사람 이름 출력 (Map -> filter)
        val namesLonggerthanThree1 = listOf(Person("taesu"),
                Person("aef"),
                Person("awefwaf"),
                Person("Kim"),
                Person("yoon"),
                Person("Lee"),
                Person("You"),
                Person("Park"))
                .map {
                    println("""namesLonggerthanThree1 >>> map $it""")
                    it.name
                }
                .filter {
                    println("""namesLonggerthanThree1 >>> filter $it""")
                    it.length > 3
                }
                .toList()
        println(namesLonggerthanThree1)
        /*
        namesLonggerthanThree1 >>> map Person(name=taesu)
        namesLonggerthanThree1 >>> map Person(name=aef)
        namesLonggerthanThree1 >>> map Person(name=awefwaf)
        namesLonggerthanThree1 >>> map Person(name=Kim)
        namesLonggerthanThree1 >>> map Person(name=yoon)
        namesLonggerthanThree1 >>> map Person(name=Lee)
        namesLonggerthanThree1 >>> map Person(name=You)
        namesLonggerthanThree1 >>> map Person(name=Park)
        namesLonggerthanThree1 >>> filter taesu
        namesLonggerthanThree1 >>> filter aef
        namesLonggerthanThree1 >>> filter awefwaf
        namesLonggerthanThree1 >>> filter Kim
        namesLonggerthanThree1 >>> filter yoon
        namesLonggerthanThree1 >>> filter Lee
        namesLonggerthanThree1 >>> filter You
        namesLonggerthanThree1 >>> filter Park
        [taesu, awefwaf, yoon, Park]
         */

        println()
        //이름의 길이가 3 보다 큰 사람 이름 출력 (Filter -> Map)
        val namesLonggerthanThree2 = listOf(Person("taesu"),
                Person("aef"),
                Person("awefwaf"),
                Person("Kim"),
                Person("yoon"),
                Person("Lee"),
                Person("You"),
                Person("Park"))
                .filter {
                    println("""namesLonggerthanThree2 >>> filter $it""")
                    it.name.length > 3
                }
                .map {
                    println("""namesLonggerthanThree2 >>> map $it""")
                    it.name
                }
                .toList()
        println(namesLonggerthanThree2)

        /*
        namesLonggerthanThree2 >>> filter Person(name=taesu)
        namesLonggerthanThree2 >>> filter Person(name=aef)
        namesLonggerthanThree2 >>> filter Person(name=awefwaf)
        namesLonggerthanThree2 >>> filter Person(name=Kim)
        namesLonggerthanThree2 >>> filter Person(name=yoon)
        namesLonggerthanThree2 >>> filter Person(name=Lee)
        namesLonggerthanThree2 >>> filter Person(name=You)
        namesLonggerthanThree2 >>> filter Person(name=Park)

        Filter 된 것들에 대해서만 Map을 처리한다. -> 연산회수 감소.
        namesLonggerthanThree2 >>> map Person(name=taesu)
        namesLonggerthanThree2 >>> map Person(name=awefwaf)
        namesLonggerthanThree2 >>> map Person(name=yoon)
        namesLonggerthanThree2 >>> map Person(name=Park)
        [taesu, awefwaf, yoon, Park]
         */


        println()
        //이름의 길이가 3 보다 큰 사람 이름 출력 (Map -> filter), Sequence
        val namesLonggerthanThree3 = listOf(Person("taesu"),
                Person("aef"),
                Person("awefwaf"),
                Person("Kim"),
                Person("yoon"),
                Person("Lee"),
                Person("You"),
                Person("Park"))
                .asSequence()
                .map {
                    println("""namesLonggerthanThree3 >>> map $it""")
                    it.name
                }
                .filter {
                    println("""namesLonggerthanThree3 >>> filter $it""")
                    it.length > 3
                }
                .toList()
        println(namesLonggerthanThree3)
        /*
        namesLonggerthanThree3 >>> map Person(name=taesu)
        namesLonggerthanThree3 >>> filter taesu
        namesLonggerthanThree3 >>> map Person(name=aef)
        namesLonggerthanThree3 >>> filter aef
        namesLonggerthanThree3 >>> map Person(name=awefwaf)
        namesLonggerthanThree3 >>> filter awefwaf
        namesLonggerthanThree3 >>> map Person(name=Kim)
        namesLonggerthanThree3 >>> filter Kim
        namesLonggerthanThree3 >>> map Person(name=yoon)
        namesLonggerthanThree3 >>> filter yoon
        namesLonggerthanThree3 >>> map Person(name=Lee)
        namesLonggerthanThree3 >>> filter Lee
        namesLonggerthanThree3 >>> map Person(name=You)
        namesLonggerthanThree3 >>> filter You
        namesLonggerthanThree3 >>> map Person(name=Park)
        namesLonggerthanThree3 >>> filter Park
        [taesu, awefwaf, yoon, Park]
         */


        println()
        //이름의 길이가 3 보다 큰 사람 이름 출력 (Filter -> Map), Sequence
        val namesLonggerthanThree4 = listOf(Person("taesu"),
                Person("aef"),
                Person("awefwaf"),
                Person("Kim"),
                Person("yoon"),
                Person("Lee"),
                Person("You"),
                Person("Park"))
                .asSequence()
                .filter {
                    println("""namesLonggerthanThree4 >>> filter $it""")
                    it.name.length > 3
                }
                .map {
                    println("""namesLonggerthanThree4 >>> map $it""")
                    it.name
                }
                .toList()
        println(namesLonggerthanThree4)
        /*
        namesLonggerthanThree4 >>> filter Person(name=taesu)
        namesLonggerthanThree4 >>> map Person(name=taesu)
        namesLonggerthanThree4 >>> filter Person(name=aef)
        namesLonggerthanThree4 >>> filter Person(name=awefwaf)
        namesLonggerthanThree4 >>> map Person(name=awefwaf)
        namesLonggerthanThree4 >>> filter Person(name=Kim)
        namesLonggerthanThree4 >>> filter Person(name=yoon)
        namesLonggerthanThree4 >>> map Person(name=yoon)
        namesLonggerthanThree4 >>> filter Person(name=Lee)
        namesLonggerthanThree4 >>> filter Person(name=You)
        namesLonggerthanThree4 >>> filter Person(name=Park)
        namesLonggerthanThree4 >>> map Person(name=Park)
        [taesu, awefwaf, yoon, Park]
         */
    }
}