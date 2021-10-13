package cat.copernic.jmendezv

class Outer {
    private val bar: Int = 1
    inner class Nested {
        fun foo() = bar
    }
}

val helloWorld: Any = object {
    val hello = "Hello"
    val world = "World"
    // object expressions extend Any, so `override` is required on `toString()`
    override fun toString() = "$hello $world"

}

interface Figura

open class Cuadrado(val lado: Double) : Figura

class CAD(val cuadrado: Cuadrado) : Figura by cuadrado

fun main(args: Array<String>) {
//    val demo1 = Outer.Nested().foo() // == 2
    val demo2 = Outer().Nested().foo() // == 2
}
