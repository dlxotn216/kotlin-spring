package me.taesu.demo.chap05

/**
 * Created by itaesu on 2021/02/10.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
data class Person(val name: String, val age: Int)

class Book(val name: String, val authors: ArrayList<Person> = ArrayList())