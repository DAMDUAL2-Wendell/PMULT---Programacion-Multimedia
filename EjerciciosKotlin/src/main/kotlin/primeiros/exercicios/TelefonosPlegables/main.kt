package primeiros.exercicios.TelefonosPlegables

fun main() {
    var telefonoNormal = Phone()
    println("Telefono Normal")
    telefonoNormal.checkPhoneScreenLight()
    telefonoNormal.switchOn()
    println("Pulsamos boton encendido")
    telefonoNormal.checkPhoneScreenLight()

    println("--------------")
    var telefonoPlegable = FoldablePhone()
    println("Telefono Plegable")
    telefonoPlegable.checkPhoneScreenLight()
    println("Pulsamos boton encendido")
    telefonoPlegable.switchOn()
    telefonoPlegable.checkPhoneScreenLight()
    println("Abrir telefono")
    telefonoPlegable.changeFoldStatus()
    telefonoPlegable.checkPhoneScreenLight()
    println("Pulsamos boton encendido")
    telefonoPlegable.switchOn()
    telefonoPlegable.checkPhoneScreenLight()

}
