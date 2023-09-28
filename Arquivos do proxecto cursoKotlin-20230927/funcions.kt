//A funcion main e o punto de entrada da execucion
//Se main non usa parameteros, no fai falta definir args
//Podense pasar argumentos a main en run/edit configuration/Program arguments
fun main(args: Array<String>) {
    //println("Ola mundo! ${args[0]}")

    //---------- kotlin.Unit

    //Inda que non tenhan return, as funcions en Kotlin sempre devolven un dato tipo kotlin.Unit
    //En Kotlin casi to-do e unha expresion e ten valor, inda que sexa kotlin.Unit
    //val unhaUnit = println("Isto e unha expresion") //Asignar o print a unha variable
    //println(unhaUnit)

    val temperatura = 10
    val faiCalor = if (temperatura > 25 ) true else false //Podemos facer esto gracias a que o if e unha expresion, non un statment (linhas de codigo sin valor)
    //println(faiCalor)

    val mensaxe = "A auga esta ${ if (temperatura > 25) "quente" else "fria"}"
    //println(mensaxe)



    alimentarAosPeixes()


    //nadar()
    //nadar("rapidisimo")
    //nadar(velocidade = "a modo")

}

//---------- Funcions
/*
fun alimentarAosPeixes(){
    val dia = diaRandom()
    val comida = "penso"
    println("Hoxe e $dia e os peixes comen $comida")
}
*/

fun alimentarAosPeixes(){
    val dia = diaRandom()
    //val comida = "penso"
    val comida = comidaDosPeixes(dia)
    println("Hoxe e $dia e os peixes comen $comida")
    println("Cambiar a auga: ${cambiarAuga(dia)}")
}

fun diaRandom(): String {
    val semana = arrayOf("Luns","Martes","Mercores","Xoves","Venres","Sabado","Domingo")
    return semana.random()
}

//O when e como un switch que fai breaks automaticos ao final de cada linha
fun comidaDosPeixes(dia: String) : String {
    //var comida = ""
    val comida : String
    /*
    when(dia){
        "Luns" -> comida = "comida1"
        "Martes" -> comida = "comida2"
        "Mercores" -> comida = "comida3"
        "Xoves" -> comida = "comida4"
        "Venres" -> comida = "comida5"
        in arrayOf("Sabado","Domingo") -> comida = "comida dos findes"
        else -> comida = "nada" //Se usas else aseguras que a variable toma un valor e non fai falta inicializala
    }
    */

    //En Kotlin, como toda expresion ten un valor, faise asi:

    comida = when(dia) {
        "Luns" -> "comida1"
        "Martes" -> "comida2"
        "Mercores" -> "comida3"
        "Xoves" -> "comida4"
        "Venres" -> "comida5"
        in arrayOf("Sabado", "Domingo") -> "comida dos findes"
        else -> "nada"
    }


    return comida

}


//---------- Parametros das funcions
//
fun nadar(velocidade: String = "rapido"){
    println("nadando $velocidade")
}

//Sempre hai que pasar o que non ten default
//Boa practica: parametros sin default primeiro
/*
fun cambiarAuga(dia: String, temperatura: Int = 22, suciedade: Int = 20): Boolean { //dia requerido, o resto non

    return when {
        temperatura > 30 -> true
        suciedade > 30 -> true
        dia == "Domingo" -> true
        else -> false
    }
}
*/

//Funcions compactas (sin chaves nin return)
fun estaQuente(temperatura: Int) = temperatura > 30
fun estaSucio(suciedade: Int) = suciedade > 30
fun eDomingo(dia: String) = dia == "Domingo"

fun cambiarAuga(dia: String, temperatura: Int = 22, suciedade: Int = 20): Boolean { //dia requerido, o resto non

    return when {
        estaQuente(temperatura) -> true
        estaSucio(suciedade) -> true
        eDomingo(dia) -> true
        else -> false
    }
}
