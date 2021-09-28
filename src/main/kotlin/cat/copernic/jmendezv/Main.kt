package cat.copernic.jmendezv

import java.math.BigInteger
import kotlin.IllegalArgumentException
import kotlin.math.*

class Studiant

class Rectangle constructor(var height: Double = 1.0, var length: Double = 1.0) {
    var perimeter = (height + length) * 2
}

fun maxOf(a: Int, b: Int) = if (a > b) a else b

// Define la clase Circulo, con una propiedad: radio
// crea el metodo perimetro y area

class Circulo(val radi: Double = 1.0) {
    //    fun area() = PI * radi.pow(2.0)
//    fun perimetre() =  2 * PI * radi
    val area = PI * radi.pow(2.0)
    val perimetre = 2 * PI * radi
}

// Define una clase CuentaCorriente con dos propiedades: titular y saldo
// define dos métodos ingresa(Double) y abona(Double).
// ingresa incrementa el saldo y abona decrementa el saldo en una cantidad
// Debemos verificar que el saldo es suficiente para hacer un abona

data class CuentaCorriente(val titular: String, var saldo: Double = 0.0) {

    fun ingresa(ingreso: Double): Unit {
        if (ingreso <= 0) throw IllegalArgumentException("ingreso no puede ser negativo")
        saldo += ingreso
    }

    fun abona(abono: Double): Unit {
        if (saldo < abono) throw IllegalArgumentException("saldo insuficiente")
        saldo -= abono
    }

    override fun toString(): String = "Titular = $titular, Saldo = $saldo"

}

enum class SEXE { HOME, DONA }

enum class ESTUDIS {
    PRIMARIA, SECUNDARIA, GRAU_MIG, BATXILLERAT,
    GRAU_SUPERIRO, UNIVERSITAT, PHD
}

enum class TENDENCIA { HETERO, GAY_LESBIAN, BISEXUAL }

data class Persona(
    val nom: String, val edat: Int, val sexe: SEXE, val tendencia: TENDENCIA,
    val estudis: ESTUDIS = ESTUDIS.SECUNDARIA, val fumador: Boolean = false
)

class PersonMatcher {

    private fun sonComptatibles(p1: Persona, p2: Persona): Boolean =
        when (p1.tendencia) {
            TENDENCIA.HETERO ->
                (p2.tendencia == TENDENCIA.HETERO || p2.tendencia == TENDENCIA.BISEXUAL)
                        && p1.sexe != p2.sexe
            TENDENCIA.GAY_LESBIAN ->
                (p2.tendencia == TENDENCIA.GAY_LESBIAN || p2.tendencia == TENDENCIA.BISEXUAL)
                        && p1.sexe == p2.sexe
            TENDENCIA.BISEXUAL -> TODO()

        }
    fun eval(persones1: Array<Persona>, persones2: Array<Persona>): Unit {

    }

    // Retorna un numero entre 0 i 100 que representa l'afinitat
    fun eval(p1: Persona, p2: Persona): Double {
        if (p1.edat < 18 || p2.edat < 18) throw
        IllegalArgumentException("Minores no gracias")
        if (p1 == p2) return 0.0
        if (!sonComptatibles(p1, p2)) return 0.0

        var afinity = 100.0
        val edatDiff = abs(p1.edat - p2.edat) * 2.5
        afinity -= edatDiff
        val estudisDiff = abs(p1.estudis.ordinal - p2.estudis.ordinal) * 5
        afinity -= estudisDiff
        return max(afinity, 0.0)
    }

    fun print(p1: Persona, p2: Persona) =
        println("$p1\n$p2\n${eval(p1, p2)}% compatibles.")
}


fun String.aMayus() = this.toUpperCase()

fun main() {

    val nums: Array<Int> = arrayOf(1,2,3,4)


    val nombre: String? = "pepe"

    if (nombre != null) println(nombre.length)

    nombre?.let {
        println(it)
    }

    println(nombre?.length)

    println("pepe".aMayus())

    val pm = PersonMatcher()

    val p1 = Persona("joan", 34, SEXE.HOME, TENDENCIA.HETERO, ESTUDIS.UNIVERSITAT)
    val p2 = Persona("anna", 34, SEXE.DONA, TENDENCIA.HETERO, ESTUDIS.UNIVERSITAT)

    pm.print(p1, p2)

//    val cc1 = CuentaCorriente("pepe", 1000.0)
//    val cc2 = CuentaCorriente("pepe", 1000.0)
//    println(cc1 === cc2)
//    println(cc1)
//    cc1.ingresa(250.0)
//    println(cc1.saldo)
//    cc1.abona(700.0)
//    println(cc1.saldo)
//    cc1.abona(700.0)
//    println(cc1.saldo)


//    val c1 = Circulo(3.5)
//
//    println("Area = ${c1.area}, Perimetre = ${c1.perimetre}")


//    var edad: Int? = null
//
//    val items = listOf("apple", "banana", "kiwifruit")
//    for (index in items.indices) {
//        println("item at $index is ${items[index]}")
//    }
}


fun incrementa(n: Int) = n + 1
fun incrementa(n: Double) = n + 1

fun review() {
    (1..10L).forEach(fun(n: Long) {
        if (!BigInteger.valueOf(n).isProbablePrime(2)) return
        println(n)
    })
}

fun foo1() {
    listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
        if (value == 3) return// local return to the caller of the anonymous function - the forEach loop
        print(value)
    })
    print(" done with anonymous function")
}

fun foo2() {
    run loop@{
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@loop // non-local return from the lambda passed to run
            print(it)
        }
    }
    print(" done with nested loop")
}

fun redondea(n: Double, pos: Int): Double = round(n * 10.0.pow(pos)) / 10.0.pow(pos)

//fun main() {
//    val pi = 3.145
//    println(redondea(pi, 2))
//    val input = "1"
//    val a: Int? = try { input.toInt() } catch (e: NumberFormatException) { null }
//    println(a)
//    foo2()
//    var i = 9
//    i = incrementa(i)
//    println("El valor de i es ${i}z.")
//}