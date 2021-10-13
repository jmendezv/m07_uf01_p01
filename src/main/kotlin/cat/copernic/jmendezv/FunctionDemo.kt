package cat.copernic.jmendezv

import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

fun foo(vararg strings: String) {
    strings.forEach {
        println(it)
    }
}


fun double(x: Int): Double {
    return x * 2.0
}

fun calcMedia(vararg valores: Int): Double {
    var total = 0.0
    valores.forEach {
        total += it
    }
    return total / valores.size
}

fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts is an Array
        result.add(t)
    return result
}

infix fun Int.shl(x: Int): Int {
    return 0
}


/*

Crea una funcio infix d'extensio de la classe String que contateni

 dues cadenes */

infix fun String.concatenaCon(str: String) = "$this $str"


fun <T> singletonList(item: T): List<T> = listOf(item)


val fromIntToString : (Int) -> String  = { n -> n.toString() }
val fromStringToInt: (String) -> Int = { str -> str.length }
val fromNothingToUnit: () -> Unit = {}
val funcioQuadratica: (Double, Double, Double) -> Pair<Double, Double> = { a, b, c ->
     val r1 = (-b + sqrt(b.pow(2) - 4 * a * c)) / (2 * a)
     val r2 = (-b - sqrt(b.pow(2) - 4 * a * c)) / (2 * a)
    Pair(r1, r2)
}

data class Punt(val x: Double, val y: Double)

val distancia: (Punt, Punt) -> Double = { p1: Punt, p2: Punt ->
    Double
    sqrt((p2.x - p1.x).pow(2) + (p2.y - p1.y).pow(2))
}

fun sumaDosInt(a: Int, b: Int) = a + b

// lambda
val suma1: (Int, Int) -> Int = { a: Int, b: Int -> a + b }
// anonymous function
val suma2: (Int, Int) -> Int = fun(a: Int, b: Int): Int {return a + b}
val suma3: (Int, Int) -> Int = ::sumaDosInt

//data class Cuadrado(val lado: Double)

// Implementa amb lambdas y funcions anónimes

/*  Pendiente entre dos puntos */
/*  Punto medio de una recta entre dos puntos */
/*  Area y perimetro de un cuadrado */
/*  Area y perimetro de un Rectangulo */
/*  Volumen de un cilindro */
/*  Volumen de una esfera */
/*  IMC índice de masa muscular : peso en Kgs / altura en metros ^2 */

/*  Volumen de una esfera */
data class Esfera(val radio: Double)
val volumenEsferaConLambda: (Esfera) -> Double =
    {esfera: Esfera -> 4 / 3 * PI * esfera.radio.pow(3)}

val volumenEsferaConAnonymousFunction:(Esfera) -> Double =
    fun(esfera) = 4 / 3 * PI * esfera.radio.pow(3)


fun Int.suma(other: Int) = this + other

// function literal with receiver
val sum1: Int.(Int) -> Int = { other -> this + other }

// Anonymous function literal with receiver
val sum2 = fun Int.(other: Int): Int = this + other

data class Point(val x: Int, val y: Int)

operator fun Point.unaryMinus() = Point(-x, -y)
operator fun Point.plus(c: Int) = Point(x + c, y + c)
operator fun Point.plus(p: Point) = Point(x + p.x, y + p.y)


/*
* */
fun main() {
    val p1 = Point(2,7)
    val p2 = p1.copy(x=8, y=3)
    val p3 = p1 + p2
    println(p3)
//    println(sum1(1,2))
//    println(sum2(1,2))
//    println(distancia(Punt(-7.0, -4.0), Punt(17.0, 6.5)))
//    println(funcioQuadratica(3.0,9.0,5.0))
//    println(fromStringToInt("pep"))
//    singletonList<Int>(1) // [1]
//    println("Hello".concatenaCon("world"))
//    println("Hello" concatenaCon "world")
    // calling the function using the infix notation
//    1 shl 2

// is the same as
//    1.shl(2)
//    foo(strings = *arrayOf("a", "b", "c"))
//    val a = arrayOf(1, 2, 3)
//    val list = asList<Int>(-1, 0, *a, 4)
}



//typealias twoIntsReturnInt = (Int, Int) -> Int
//
//fun <T,U,V> f(a: T, b: U, g: (T, U) -> V): V = g(a, b)
//
//fun isOdd(n: Int) = n % 2 == 0
//
//val simplelambda: () -> Unit = {}
//
//val stringToInt: (String) -> Int = String::toInt
//
//val fromUnitToString: () -> String = ::String
//
//val fromIntToBoolean: (Int) -> Boolean = ::isOdd
//
//fun builder(f: StringBuilder.(String)->Unit) {
//
//
//}
//
//class PowerOfTwoTransformer: twoIntsReturnInt {
//        override operator fun invoke(x: Int, y: Int): Int = x * x
//}
//
//fun main() {
//    println(f(3, 4) { x, y -> x * y })
//    val p = PowerOfTwoTransformer()
//    println(p(3,0))
//}