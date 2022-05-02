package ch10

import kotlin.reflect.KClass

/*********************************************************************************************************************/

annotation class MyAnnotation(val text: String)

@MyAnnotation("Some useful Info")
fun annotatedFun() { }

annotation class Dependency(val arg:String, val componentNames: String = "Core")
annotation class Component(val name: String = "Core")

@Component("I/O")
class IO

@Component("Log")
@Dependency("I/O")
class Logger

@Component
@Dependency("I/O", "Log")
class Main

/*********************************************************************************************************************/

annotation class Dependency2(vararg val componentNames: String)

annotation class Component2(
    val name: String = "Core",
    val dependency: Dependency2 = Dependency2()
)

@Component2("I/O")
class IO2

@Component2("Log", Dependency2("I/O"))
class Logger2

@Component2(dependency = Dependency2("I/O", "Log"))
class Main2

/*********************************************************************************************************************/

annotation class Dependency3(val componentNames: Array<String>)

annotation class Component3(
    val name: String = "Core",
    val dependency: Dependency3
)

@Component3(dependency = Dependency3(arrayOf("I/O", "Log")))
class Main3

/*********************************************************************************************************************/

annotation class Dependency4(vararg val componentClass: KClass<*>)

annotation class Component4(
    val name: String = "Core",
    val dependency: Dependency4 = Dependency4()
)

@Component4("I/O")
class IO4

@Component4("Log", Dependency4(IO4::class))
class Logger4

@Component4(dependency = Dependency4(IO4::class, Logger4::class))
class Main4

/*********************************************************************************************************************/
