fun main() {
    val caracteristicasCoche = mapOf("Cor" to "Vermello", "Potencia" to "150 CV")
    val caracteristicasBicicleta = mapOf("Tipo" to "Montanha")

    val coche = Coche("Toyota", 4, caracteristicasCoche)
    val moto = Moto("Honda", null)
    val bicicleta = Bicicleta("Trek", 21, caracteristicasBicicleta)
    val todoNull = Coche(null, null, null)


    println("------Acelerando----------")
    println()
    coche.acelerar()
    moto.acelerar()
    bicicleta.acelerar()
    todoNull.acelerar()

    println()
    println("-----Frenando---------")
    println()
    coche.frear()
    moto.frear()
    bicicleta.frear()
    todoNull.frear()

    println()
    println("--------Caracteristicas-----------")
    println()
    coche.verCaracteristicas()
    moto.verCaracteristicas()
    bicicleta.verCaracteristicas()
    todoNull.verCaracteristicas()

    println()
    println("---------Encendido---------")
    println()
    println(moto.estaEncendido)
    moto.encender()
    moto.encender()
    println(moto.estaEncendido)
    moto.apagar()
    println(moto.estaEncendido)

}