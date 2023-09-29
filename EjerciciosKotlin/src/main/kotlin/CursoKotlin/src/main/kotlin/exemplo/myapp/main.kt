package exemplo.myapp


fun main() {
    //construirAcuario()
    construirAcuario2()
}
/*
fun construirAcuario(){
    //Crear unha instancia da clase Acuario
    val acuario = Acuario()
    acuario.lonxitude = 30
    acuario.printTamanho()

    println("------------------------")
    //Instancia da clase pasando parametros no constructor
    val acuario2 = Acuario(anchura = 4)
    acuario2.printTamanho()

    println("---------------------")
    val acuario3 = Acuario(50,50,50)
    acuario3.printTamanho()

    // Usar o segundo constructor
    println("-------------")
    val acuario4 = Acuario(numeroDePeixes = 29)
    acuario4.printTamanho()
}*/

fun construirAcuario2(){
    //Testear o getter

    val acuario = Acuario()
    acuario.printTamanho()


    //Testear o setter

    acuario.volume = 100
    acuario.printTamanho()
    println(acuario.propiedadeInternal)

    println("----------------")

    println(acuario.volumeSoloLectura)



}

/*

fun construirAcuario3(){
    val acuario = AcuarioAberto(lonxitude = 25.0,anchura = 25.0, altura = 25.0)
    acuario.printTamanho()



}*/
