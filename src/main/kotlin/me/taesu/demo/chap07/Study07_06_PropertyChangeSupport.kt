package me.taesu.demo.chap07

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.reflect.KProperty

/**
 * Created by itaesu on 2021/02/19.
 *
 * @author Lee Tae Su
 * @version TBD
 * @since TBD
 */
private class Study07_06_PropertyChangeSupport {
    open class PropertyChangeAware {
        protected val changeSupport = PropertyChangeSupport(this)

        fun addPropertyChangeListener(listener: PropertyChangeListener) = changeSupport.addPropertyChangeListener(listener)
        fun removedPropertyChangeListener(listener: PropertyChangeListener) = changeSupport.removePropertyChangeListener(listener)
    }

    class Person(name: String, email: String) : PropertyChangeAware() {
        // 뒷 받침 필드를 이용해서 프로퍼티 변경 감지
        var name: String = name
            get() = field
            set(newValue) {
                val oldValue = field
                field = newValue
                changeSupport.firePropertyChange("name", oldValue, newValue)
            }

        // getValue, setValue 오퍼레이터를 구현하는 Deletagor에 프로퍼티를 위임 할 수 있다.
        // JPA Auditing을 위한 객체 하나에 여러 프로퍼티를 위임하는건 뒷받침 필드가 더 나을 듯 하다
        var email by ObservableProperty(email, changeSupport)
    }

    class ObservableProperty(var value: Any, val changeSupport: PropertyChangeSupport) {
        operator fun getValue(person: Person, property: KProperty<*>): Any = value
        operator fun setValue(person: Person, property: KProperty<*>, newValue: Any) {
            val oldValue = value
            value = newValue
            changeSupport.firePropertyChange(property.name, oldValue, newValue)
        }
    }
}

fun main(args: Array<String>) {
    val taesu = Study07_06_PropertyChangeSupport.Person("taesu", "taesu@crscube.co.kr")
    taesu.addPropertyChangeListener(PropertyChangeListener { evt ->
        println("${evt.propertyName} changed ${evt.oldValue} to ${evt.newValue}")
    });
    taesu.name = "taesu changed"
    taesu.email = "taesu changed"
}