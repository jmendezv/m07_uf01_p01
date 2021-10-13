package cat.copernic.jmendezv
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

typealias Cadena = String
typealias llistaenters = List<Int>

// lazy
fun connect() {
    println("Connecting")
    Thread.sleep(1_000)
    println("conectado")
}

fun getData() = "Data from server"
// ***************
 // observable delegate



//class User {
//    var name: String by Delegates.observable("<no name>") {
//            prop, old, new ->
//        println("${prop.name} $old -> $new")
//    }
//}

/*
*
* CuentaCorriente que tiene una propiedad saldo: Double
*
* Queremos que cuando la propiedad saldo sea mayor de 1000
* invertir en bolsa
*
* */

class CuentaBancaria(saldoInicial: Double) {
    private var saldo: Double by Delegates.vetoable(saldoInicial) { property, oldValue, newValue ->
        println("$oldValue $newValue")
        if (newValue > oldValue && saldo > 1_000.0) invierteEnBolsa()
        (newValue > oldValue - 50)
    }

    fun ingresa(ingreso: Double) {
        saldo += ingreso
    }

    fun abona(ingreso: Double) {
        saldo -= ingreso
    }

    private fun invierteEnBolsa() {
        println("inverting en bolsa ...")
    }

    override fun toString(): String {
        return "$saldo"
    }
}



class Almacen(existenciasInciales: Int) {
    private var existencias: Int by Delegates.observable(existenciasInciales) { property, oldValue, newValue ->
        println("$oldValue $newValue")
        if (existencias < 25) compraExistencias()
    }

    fun reservaExistencia(cantidad: Int) {
        existencias -= cantidad
    }

    private fun compraExistencias() {
        println("Compando existencias...")
        existencias += 50
    }
}



fun main() {

    val cc = CuentaBancaria(500.0)
    cc.ingresa(350.0)
    println(cc)
    cc.abona(10.0)
    println(cc)
    cc.abona(49.0)
    println(cc)

//    cc.abona(60.0)
//    cc.ingresa(350.0)
//    cc.abona(10.0)
//    val almacen = Almacen(100)
//    almacen.reservaExistencia(10)
//    almacen.reservaExistencia(20)
//    almacen.reservaExistencia(30)
//    almacen.reservaExistencia(35)
//    val user = User()
//    user.name = "first"
//    user.name = "second"

//    val data: String by lazy {
//        connect()
//        getData()
//    }
//
//    println(data)
//    // .....
//    println(data)
}