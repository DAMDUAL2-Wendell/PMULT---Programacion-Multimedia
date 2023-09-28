package exemplo.myapp

fun main() {
//    construirAcuario()
//    construirAcuario2()
    construirAcuario3()
//    construirPeixe()
}

//Leccion 4.3 -----------------------------------------------------------------------------

//fun construirAcuario() {
//    //Crear unha instancia de clase Acuario.
//    val unAcuario = Acuario() //Chama directamente ao contructor da clase, sen poñer 'new'
//
//    //Chamar a un metodo
//    unAcuario.printTamanho()
//
//    //Acceder as propiedades
//    unAcuario.altura = 100
//    unAcuario.printTamanho()
//
//    //Leccion 4.4 -----------------------------------------------------------------------------
//
//    //Usar o contructor
//    println("----------")
//    val acuario1 = Acuario()
//    acuario1.printTamanho()
//
//    val acuario2 = Acuario(anchura = 10)
//    acuario2.printTamanho()
//
//    val acuario3 = Acuario(altura = 1, anchura = 101, lonxitude = 50)
//    acuario3.printTamanho()
//
//    //Usar o segundo constructor
//    println("----------")
//    val acuario4 = Acuario(numeroDePeixes = 29) //O volume que imprime e o anterior a ser correxido, pq this() chama aos inits
//    acuario4.printTamanho() //Aqui imprime as propiedades axustadas ao numero de peixes
//    println("Volume correxido: ${acuario4.anchura * acuario4.altura * acuario4.lonxitude / 1000} l")
//
//}

//fun construirAcuario2() {
//
//    //Testeo getter
//    val unAcuario = Acuario()
//    unAcuario.printTamanho()
//
//    //Testeo setter
//    unAcuario.volume = 99999
//    unAcuario.printTamanho()
//
//    //Leccion 4.5 -----------------------------------------------------------------------------
//
//    println(unAcuario.propiedadeInterna)
//    //unAcuario.propiedadePrivada //erro
//
//    //Testeo propiedade solo lectura
//    println("--------")
//    println(unAcuario.volumeSoloLectura)
//    //unAcuario.volumeSoloLectura = 80 //erro
//    println(unAcuario.propiedade2)
//    //unAcuario.propiedade2 = 5 //erro
//
//
//
//    //Testeo propiedade privada
//    println("--------")
//    unAcuario.obterPropiedadePrivadaModificable()
//    unAcuario.modificarPropiedadePrivadaModificable("hola")
//    unAcuario.obterPropiedadePrivadaModificable()
//
//
//    //Cambiar o setter do volume a altura = 1 e ver que pasa
////    println("--------")
////    val outroAcuario = Acuario()
////    outroAcuario.printTamanho()
////
////    outroAcuario.volume = 99999
////    outroAcuario.printTamanho()
//
//
//
//}

//Leccion 4.6 -----------------------------------------------------------------------------

fun construirAcuario3(){

    val unAcuario = AcuarioXenerico(lonxitude = 25.0, anchura = 25.0, altura = 40.0)
    unAcuario.printTamanho()

    //Usar a sublclase
    val unAcuarioCilindrico = AcuarioCilindrico(diametro = 25.0, altura = 40.0)
    unAcuarioCilindrico.printTamanho()

    unAcuarioCilindrico.volume = 200.0
    unAcuarioCilindrico.printTamanho()

    unAcuario.istoQueE()
    unAcuarioCilindrico.istoQueE()


}

//Leccion 4.7 -----------------------------------------------------------------------------

fun construirPeixe(){


}