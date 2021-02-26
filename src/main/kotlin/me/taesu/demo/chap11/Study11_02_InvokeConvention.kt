package me.taesu.demo.chap11

/**
 * Created by itaesu on 2021/02/25.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main(args: Array<String>) {
    val greeter = Study11_02_InvokeConvention.Greeter("taesu")
    greeter("Hello") // -> greeter.invoke("Hello")

    val filter = Study11_02_InvokeConvention.IssueFilter("pro1")
    println(arrayListOf(Study11_02_InvokeConvention.Issue("pro1", "OPENED", "des1"),
            Study11_02_InvokeConvention.Issue("pro1", "CANCELED", "des1"),
            Study11_02_InvokeConvention.Issue("pro1", "IN PROGRESS", "des1"))
            .filter(filter))

    val lambda: (String) -> Boolean = { it.length > 0 }
    println(lambda.invoke("aefaf"))
    println(arrayOf("1", "2", "3").filter(predicate = lambda))

    val dependencies = Study11_02_InvokeConvention.Dependencies()

    // 일반적인 메서드 호출
    dependencies.compile("jackson")
    // Gradle의 DSL을 아래처럼 흉내낼 수 있다.
    // invoke 관례와 수신 객체 지정 람다가 적용 됐다
    dependencies {
        compile("junit")
        compile("spring")
    }
}

private class Study11_02_InvokeConvention {
    class Greeter(val name: String) {
        operator fun invoke(message: String) {
            println("$message $name !")
        }
    }

    data class Issue(val project: String, val status: String, val description: String)
    class IssueFilter(val project: String) : (Issue) -> Boolean {
        companion object {
            private val inProgressStatuses = setOf("OPENED", "IN PROGRESS")
        }

        override fun invoke(issue: Issue): Boolean {
            return issue.project == project && issue.status in inProgressStatuses
        }
    }

    class Dependencies {
        private val artifacts: MutableList<Artifact> = mutableListOf()
        fun compile(artifactName: String) {
            artifacts.add(Artifact(artifactName))
        }

        operator fun invoke(action: Dependencies.() -> Unit) = action()
    }

    class Artifact(val name: String)
}