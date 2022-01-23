package ch07.ex5_3_4_ImplementingDelegatedProperties3

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

class Person(val name: String, age: Int, salary: Int): PropertyChangeAware() {
//    private val observer = {
//        prop: KProperty<*>, oldValue: Int, newValue: Int -> {
//            changeSupport.firePropertyChange(prop.name, oldValue, newValue)
//        }
//    }

    var age: Int by Delegates.observable(age) {property, oldValue, newValue -> changeSupport.firePropertyChange(property.name, oldValue, newValue) }
    var salary: Int by Delegates.observable(salary) {property, oldValue, newValue -> changeSupport.firePropertyChange(property.name, oldValue, newValue)}
}

fun main() {
    val p = Person("Dmitry", 34, 2000)
    p.addPropertyChangeListener { event ->
        println(
            "Property ${event.propertyName} changed " +
                    "from ${event.oldValue} to ${event.newValue}"
        )
    }
    p.age = 35
    p.salary = 2100
}