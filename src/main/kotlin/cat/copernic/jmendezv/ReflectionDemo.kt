package cat.copernic.jmendezv

import kotlin.reflect.KClass
import kotlin.reflect.KFunction1
import kotlin.reflect.KProperty1

data class MyClass(val id: Long, var name: String) {

}

fun <T : Any> reflectClass(c: KClass<T>) {
    println("Constructors")
    println("------------")
    c.constructors.forEach {
        println(it)
    }
    println("Super types")
    println("------------")
    c.supertypes.forEach {
        println(it)
    }

}

fun esPar(x: Int): Boolean = x % 2 == 0

val esPar2: KFunction1<Int, Boolean> = ::esPar

val esPar3: (Int) -> Boolean = { n: Int -> n % 2 == 0 }

val esPar4: (Int) -> Boolean = fun(n: Int) = n % 2 == 0

val esPar5: (Int) -> Boolean = ::esPar

val isEmptyStringList: List<String>.() -> Boolean = List<String>::isEmpty

fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x: A -> f(g(x)) }
}

fun String.hide(): String = "*".repeat(length)

const val x = 1

fun special(): () -> Unit = fun(){ println("I'm a high order function")}

class Foo

fun createFoo(factory: () -> Foo): Foo = factory()

fun main(args: Array<String>) {
    val numberRegex: Regex = "\\d+".toRegex()
    val strings = listOf("abc", "124", "a70")
    println(strings.filter(numberRegex::matches))
//    val numberRegex: Regex = "\\d+".toRegex()
//    println(numberRegex.matches("29"))
//
//    val isNumber: KFunction1<CharSequence, Boolean> = numberRegex::matches
//    println(isNumber("29"))
//    createFoo(::Foo)
//    createFoo {
//        Foo()
//    }
//    special()()
    // To access a property that is a member of a class, qualify it
//    class A(val p: Int)
//    val prop: KProperty1<A, Int> = A::p
//    println(prop.get(A(1)))

//    println(::x.get())
//    println(::x.name)
//    println(::x.returnType)

//    val evenLength = compose(::esPar, String::length)
//    val hideLength = compose(String::hide, String::trim)
//
//    val strings = listOf(" a ", " abc de", "abc ")
//    println(strings.map(hideLength))
//    println(strings.filter(evenLength))

//    val c1: (String) -> Double = compose<String, Long, Double>( f = { l: Long -> l.toDouble()}, g = { s: String -> s.length.toLong()})
//    println(c1("Hola"))
//    val rang: IntRange = 1..10
//    val enters = (1..10).toList()
//    enters.filter(esPar5).also { print(it) }
//    val myclass = MyClass(1L, "myclass")
//    reflectClass(myclass::class)
}