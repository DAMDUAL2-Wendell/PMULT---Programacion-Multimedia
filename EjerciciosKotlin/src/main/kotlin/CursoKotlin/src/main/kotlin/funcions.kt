//A funcion e o punto de entrada de execucion
//Se main non usa parametros, non fai falta definir args
fun main(args: Array<String>) {
    //println("Ola mundo!: ${args[0]}")

    //----------kotlin.Unit

    //val unhaUnit = println("Isto e unha expresion")
    //println(unhaUnit)

    val temperatura = 10
    val faiCalor = if(temperatura > 25) true else false
    println(faiCalor)

    val mensaxe = "A auga esta ${ if (temperatura > 25) "quente" else "fria"}"
    println(mensaxe)

    alimentarPeixes()

    nadar()
    nadar( "moi rapido")

    println(cambiarAuga(diaRandom()))

}

fun alimentarPeixes(){
    val dia = diaRandom()
    val comida = comidaDosPeixes(dia)
    println("Hoxe e $dia e os peixes comen $comida")
}

fun diaRandom(): String {
    val semana = arrayOf<String>("Luns","Martes","Mercores","Xoves","Venres","Sabado","Domingo")
    return semana.random()
}

fun comidaDosPeixes(dia: String) : String{
    //val comida: String
    /*
    when(dia){
        "Luns" -> comida = "comida1"
        "Martes" -> comida = "comida2"
        "Mercores" -> comida = "comida3"
        "Xoves" -> comida = "comida4"
        "Venres" -> comida = "comida5"
        in arrayOf("Sabado","Domingo") -> comida = "comida dos findes"
        else -> comida = "nada"
    }*/
   val comida = when(dia){
        "Luns" -> "comida1"
        "Martes" -> "comida2"
        "Mercores" -> "comida3"
        "Xoves" -> "comida4"
        "Venres" -> "comida5"
        in arrayOf("Sabado","Domingo") -> "comida dos findes"
        else -> "nada"
    }
    return comida
}

//Boa practica: parametros sin default primeiro
fun nadar(velocidade: String = "rapido"){
    println("nadando $velocidade")
}

fun cambiarAuga(dia: String, temperatura: Int = 22, suciedade: Int = 20): Boolean{
    /*
    return when{
        temperatura > 30 -> true
        suciedade > 30 -> true
        dia == "Domingo" -> true
        else -> false
    }*/

    return when{
        estaQuente(temperatura) -> true
        estaSucio(suciedade) -> true
        eDomingo(dia) -> true
        else -> false
    }

}

fun estaQuente(temperatura: Int) = temperatura > 30
fun estaSucio(suciedade: Int) = suciedade > 30
fun eDomingo(dia: String) = dia == "Domingo"