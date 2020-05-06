package me.taesu.demo.chap03

/**
 * Created by taesu on 2020-05-06.
 */
fun main(args: Array<String>){
    Study3_2_FunctionCallSugar().exam1()
}

class Study3_2_FunctionCallSugar {
    /**
     * 만약 default 값을 줄려면?
     * Java의 경우는 무수한 Overloading이 필요하다
     * Kotlin은 Default parameter를 통해 불필요한 오버로딩을 막을 수 있다.
     *
     *
     * [if java]
     * joiner(elements)
     * joiner(elements, separator)
     * joiner(elements, separator, prefix)
     * joiner(elements, separator, prefix, postfix)
     */
    fun <T> joiner(elements: Collection<T>,
                   separator: String = ",",
                   prefix: String = "(",
                   postfix: String = ")"): String {

        var result = prefix

        for((index, element) in elements.withIndex()){
            if(index < elements.size-1){
                result += "$element$separator"
            } else {
                result += "$element"
            }
        }

        result += postfix
        return result

    }

    fun exam1(){
        println(joiner(listOf("a", "b", "c", "d"), ",", "(", ")"))
        println(joiner(listOf("a", "b", "c", "d")))
        println(joiner(listOf("a", "b", "c", "d")) == joiner(listOf("a", "b", "c", "d"), ",", "(", ")"))

        //Default 파라미터는 비어있는 우측부터
        println(joiner(listOf("a", "b", "c", "d"), "_"))
        println(joiner(listOf("a", "b", "c", "d"), "_", "(", ")"))
        println(joiner(listOf("a", "b", "c", "d"), "_") == joiner(listOf("a", "b", "c", "d"), "_", "(", ")"))

        //함수의 인자가 많을 때 다 외우기 힘들고 코드 상으로 하나하나 볼 수 없다.
        //아래와 같이 Named parameter를 통해 매칭할 수 있다.
        println(joiner(listOf("a", "b", "c", "d"), separator = ",", prefix = "[", postfix = "]"))
        println(joiner(listOf("a", "b", "c", "d"), prefix = "[", postfix = "]", separator = "."))
    }
}