package me.taesu.demo.chap99appendix

import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.JsonNodeFactory
import com.fasterxml.jackson.databind.node.ObjectNode
import me.taesu.demo.chap99appendix.StudyAppendix_JsonDSL.User

/**
 * Created by itaesu on 2021/03/02.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
fun main() {
    println(userBuilder {
        name("taesu")
        email("taesu@crscube.co.kr")
        phoneNumbers {
            +"123"
            +"01099952723"
            +phoneNumber{
                number("01039962723")
            }
        }
    }.content)
    /*
        {
          "name":"taesu",
          "email":"taesu@crscube.co.kr",
          "phoneNumbers":[{
              "number":"123"
            },
            {
              "number":"01099952723"
            },
            {
              "number":"01039962723"
             }
           ]
        }
     */
}

private fun userBuilder(buildAction: User.() -> Unit) = User().apply(buildAction)

private class StudyAppendix_JsonDSL {
    class User {
        val content: ObjectNode = JsonNodeFactory.instance.objectNode()

        fun name(name: String) {
            content.put("name", name)
        }
        fun email(email: String) {
            content.put("email", email)
        }
        fun phoneNumbers(action: PhoneNumberArray.() -> Unit) {
            content.set("phoneNumbers", PhoneNumberArray().apply(action).content)
        }
    }

    class PhoneNumberArray {
        val content: ArrayNode = JsonNodeFactory.instance.arrayNode()

        fun phoneNumber(action: PhoneNumber.() -> Unit) = PhoneNumber().apply(action).content
        operator fun String.unaryPlus() {
            content.add(with(PhoneNumber()) {
                number(this@unaryPlus)
                content
            })
        }
        operator fun ObjectNode.unaryPlus(): ArrayNode = content.add(this)
    }

    class PhoneNumber {
        val content: ObjectNode = JsonNodeFactory.instance.objectNode()
        fun number(value: String) {
            content.put("number", value)
        }
    }
}