package me.bingbingpa.common

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.reflect.KClass
import kotlin.reflect.full.companionObject

// Return logger for Java class, if companion object fix the name
fun <T : Any> logger(forClass: Class<T>): Logger {
    return LoggerFactory.getLogger(unwrapCompanionClass(forClass).name)
}

// unwrap companion class to enclosing class given a Java Class
fun <T : Any> unwrapCompanionClass(ofClass: Class<T>): Class<*> {
    return ofClass.enclosingClass?.takeIf {
        ofClass.enclosingClass.kotlin.companionObject?.java == ofClass
    } ?: ofClass
}

// unwrap companion class to enclosing class given a Kotlin Class
fun <T : Any> unwrapCompanionClass(ofClass: KClass<T>): KClass<*> {
    return unwrapCompanionClass(ofClass.java).kotlin
}

// Return logger for Kotlin class
fun <T : Any> logger(forClass: KClass<T>): Logger {
    return logger(forClass.java)
}

// return logger from extended class (or the enclosing class)
fun <T : Any> T.logger(): Logger {
    return logger(this.javaClass)
}

// return a lazy logger property delegate for enclosing class
fun <R : Any> R.lazyLogger(): Lazy<Logger> {
    return lazy { logger(this.javaClass) }
}

// return a lazy logger by parameter
fun <R : Any> R.lazyLogger(loggerName: String): Lazy<Logger> {
    return lazy { logger(loggerName) }
}

// return a logger property delegate for enclosing class
fun <R : Any> R.injectLogger(): Lazy<Logger> {
    return lazyOf(logger(this.javaClass))
}

fun logger(loggerName: String): Logger {
    return LoggerFactory.getLogger(loggerName)
}

fun lazyLogger(loggerName: String): Lazy<Logger> {
    return lazy { logger(loggerName) }
}
