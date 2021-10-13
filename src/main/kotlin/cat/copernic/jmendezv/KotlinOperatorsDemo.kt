package cat.copernic.jmendezv

import java.lang.IllegalArgumentException

data class Coordenada(
    var x: Double = 0.0,
    var y: Double = 0.0,
    var z: Double = 0.0,
)

operator fun Coordenada.inc() = Coordenada(x + 1, y + 1, z + 1)
operator fun Coordenada.dec() = Coordenada(x - 1, y - 1, z - 1)
operator fun Coordenada.plus(c: Coordenada) =
    Coordenada(x + c.x, y + c.y, z + c.z)

operator fun Coordenada.plus(c: Double) =
    Coordenada(x + c, y + c, z + c)

operator fun Coordenada.invoke(despl: Double) {
    println(this + despl)
}

operator fun Coordenada.get(i: Int) = when(i) {
    0 -> x
    1 -> y
    2 -> z
    else -> throw IllegalArgumentException("Only three dimensions so far")
}
operator fun Coordenada.set(i: Int, value: Double) = when(i) {
    0 -> x = value
    1 -> y = value
    2 -> z = value
    else -> throw IllegalArgumentException("Only three dimensions so far")
}

fun String.method() = this

fun main() {
    val doubled = List(3) { it * 2 }  // or MutableList if you want to change its content later
    println(doubled)
//    val lista: List<String>? = listOf<String>("alfa", "bravo", "charlie")
//
//    val s: Int = lista?.size ?: -1
    println(-1/0.0)
//    var c1: Coordenada? = null //Coordenada(2.0, 3.0, 4.0)
//    c1(4.9)
//    val c2 = Coordenada(1.0, 1.0, 1.0)
//    c1[2] = 9.0
//    println(c1)
}

