package cat.copernic.jmendezv

import java.lang.Math.abs
import kotlin.random.Random

/*
*
* Scope functions
*
* Are functions whose sole purpose is to execute a block of code within the context
* of an object.
*
* Basically, these functions do the same: execute a block of code on an object.
* What's different is how this object becomes available inside the block and what
* is the result of the whole expression.
*
* Function  Object ref     Return value       When to use
* let         it           lambda result      exec lambda on non-null values, introducing an expression as a variable in local scope
* run        this          lambda result      object config & computing result
* with       this          lambda result      grouping function calls
* apply      this          context object     object config
* also        it           context object     additional effects
*
* */

data class Cliente(var id: Long = kotlin.math.abs(Random.nextLong())) {
    lateinit var nombre: String
    lateinit var apellidos: String
    override fun toString(): String = "$id $apellidos, $nombre"
}

fun main() {
    println("\"\"\\\n\"")
//    val cliente1 = Cliente().apply {
//        nombre = "Joan"
//        apellidos = "Martinez Lopez"
//    }.also {
//        println(it)
//    }
//    var cliente2 = Cliente()
//    with (cliente2) {
//        id = 123456L
//        nombre = "Ana Maria"
//        apellidos = "Sanchez Esteve"
//    }.also {
//        println(cliente2)
//    }
//    val cliente3: Cliente? = Cliente()
//    cliente3?.nombre = "Eva"
//    cliente3?.apellidos = "Dalmau Jimenez"
//    cliente3?.let {
//        println(it)
//    }
//
//    val nombre = cliente1.run {
//        nombre.length
//    }

}