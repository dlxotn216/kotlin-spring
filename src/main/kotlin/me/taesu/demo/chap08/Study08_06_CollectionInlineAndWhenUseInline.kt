package me.taesu.demo.chap08

/**
 * Created by itaesu on 2021/02/23.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */


private class Study08_06_CollectionInlineAndWhenUseInline {
    class Person(
            val name: String,
            val email: String
    )
}

fun main(args: Array<String>) {
    // filter, map은 인라인 함수이며 또 다른 인라인 함수에 단순 전달하고 최종 인라인 함수에선 호출만 하기에
    // filter, map은 전달된 람다와 함께 인라이닝 된다.
    arrayListOf(Study08_06_CollectionInlineAndWhenUseInline.Person("taesu", "lee"), Study08_06_CollectionInlineAndWhenUseInline.Person("soyoung", "sysygo"))
            .filter { it.name.length > 4 }
            .map(Study08_06_CollectionInlineAndWhenUseInline.Person::name)
    // filter, map 뿐 아니라 람다도 인라이닝 되기때문에 추가적인 객체나 익명 클래스가 생성되지는 않는다.
    // 하지만 매 단계의 결과로 컬렉션이 생성된다. 최적화를 위해 시퀀스를 사용할 수 있다.

    arrayListOf(Study08_06_CollectionInlineAndWhenUseInline.Person("taesu", "lee"), Study08_06_CollectionInlineAndWhenUseInline.Person("soyoung", "sysygo"))
            .asSequence()
            .filter { it.name.length > 4 }
            .map(Study08_06_CollectionInlineAndWhenUseInline.Person::name)
            .toList()
    // 시퀀스의 filter, map은 중간연산이므로 lazy 하다. 따라서 최종연산이 호출 되기 전까지 컬렉션을 생성하지 않는다.
    // 하지만 filter, map의 각 단계에선 FilteringSequence, TransformingSequence 등 객체를 생성하면서
    // 전달받은 람다를 넘긴다.
    // 따라서 인라인 함수가 될 수 없으며 실제 인라인 함수가 아니다.
    // 이 경우엔 매번 객체나 익명 클래스가 생길 수 있다.
    // 지연계산을 통해 성능 향상을 하려고 무조건 sequence를 사용하지 말아야 한다.
    // 크기가 작은 컬렉션인 경우 일반 컬렉션 연산이 더 나은 경우가 있다.

    whenUseInlineFunction{
        "hi"
    }
}

// 람다를 인자로 받는 함수를 인라이닝 하는 것이 좋다
inline fun whenUseInlineFunction(passed: () -> String): String {
    return "Use inline function when it received lambda ${passed()}"
}

