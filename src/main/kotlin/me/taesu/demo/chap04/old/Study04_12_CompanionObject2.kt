package me.taesu.demo.chap04.old

/**
 * Created by taesu on 2020-05-19.
 */
fun main(args: Array<String>) {
    Study04_12_CompanionObject2().exam()
}

class Study04_12_CompanionObject2 {

//    private fun <T> loadEntity(jsonFactory: JsonFactory<T>, jsonString: String): T {
//        return jsonFactory.fromJson(jsonString)
//    }

    private fun <T> loadEntity(jsonFactory: JsonFactory<T>, jsonString: String): T = jsonFactory.fromJson(jsonString)

    private interface JsonFactory<T> {
        fun fromJson(jsonString: String): T
    }

    //동반객체는 인터페이스를 상속할 수 있다.
    private data class User(val name: String) {
        //Loader 이름 생략 가능
        companion object Loader : JsonFactory<User> {

            //User.Loader.mock()과 같이 객체처럼 쓸 수 있다
            fun mock(): User {
                return User("mock")
            }

            override fun fromJson(jsonString: String): User {
                //parse and return User
                return User(jsonString)
            }
        }
    }

    //동반객체 안에서 정의한 것 같으나 실제로는 클래스 밖에서 정의한 확장함수
    //User라는 핵심 도메인 엔티티에 이러한 규악을 심어주기 실을 때 쓴다
    private fun User.Loader.fromJson2(jsonString: String): User {
        return User(jsonString)
    }

    fun exam() {
        //Loader는 생략 가능
        println(User.mock())

        //User 클래스를 통해 동반 객체를 넘긴다
        println(loadEntity(User, """{"name": "taesu"}"""))

        //동반객체 안에 함수 호출과 같은 코드다
        println(User.fromJson2("""{"name": "taesu"}"""))
    }
}