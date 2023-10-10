package xenericas

fun main() {
    val acuario2 = Acuario2(AugaDeGrifo())
    estaAugaLimpa(acuario2)
    acuario2.suministroAuga.engadirProductosQuimicos()
    estaAugaLimpa(acuario2)

    println(acuario2.tenSuministroAugaOTipo<AugaDeGrifo>())

    val acuario3 = Acuario(AugaLago())

    // Evaluacion funcion de extension xenerica
    println(acuario2.suministroAuga.eDoTipo<AugaLago>())

}

fun <T: SuministroAuga> estaAugaLimpa(acuario: Acuario2<T>){
    println("a auga do acuario esta limpa: ${!acuario.suministroAuga.necesitaProcesado}")
}

class Acuario2<T: SuministroAuga>(val suministroAuga: T){
     inline fun< reified R> tenSuministroAugaOTipo() = suministroAuga is R
}

inline fun <reified T: SuministroAuga> SuministroAuga.eDoTipo() = this is T

