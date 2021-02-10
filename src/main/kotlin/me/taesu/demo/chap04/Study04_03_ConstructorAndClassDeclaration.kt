package me.taesu.demo.chap04

/**
 * Created by itaesu on 2021/02/10.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */

open class Member constructor(
        // 주 생성자
        val nickName: String
)

class Project(
        // 주 생성자 선언은 constructor 키워드 생략 가능
        protocol: String,
        projectId: String,
        val declarationOnConstructor: String
) {
    val anotherWay = "$protocol-$projectId"

    val protocol: String

    init {
        this.protocol = "$protocol-$projectId"
    }
}

fun test1() {
    println(Project("a", "b", "c").protocol)
    println(Project("a", "b", "c").anotherWay)
    println(Project("a", "b", "c").declarationOnConstructor)

    Member(nickName = "Lee")    // 생성자에도 named parameter를 넘길 수 있다
}

open class StudyMember(
        nickName: String,
        val role: String
) : Member(nickName) {
    // 부 생성자를 정의할 수 있지만 보통 주 생성자에 default parameter를 넣는다
    // 부 생성자는 항상 주 생성자를 호출해야 한다
    constructor() : this("", "")
}

// 클래스 상속할 경우 반드시 주 생성자가 부모 클래스의 생성자를 호출하는 코드가 들어가야 한다
class InvestigatorMember() : StudyMember() {
    // constructor(nickName: String) : super(nickName, "")
    constructor(nickName: String) : this()
}
