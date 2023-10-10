package functional_manipulation
import kotlin.reflect.full.*

fun main() {

    val obxectoClasePeixe = Peixe::class
    println(obxectoClasePeixe.simpleName)
    println("------------------")
    for (metodo in obxectoClasePeixe.declaredFunctions){
        println(metodo.name)
    }

/*    for(metodo in Peixe::class.declaredFunctions){
        println(metodo.name)
    }*/

    val peixe = Peixe("nemo")

    // With acceder o propio obxecto que lle pasamos como argumento para non repetir codigo
    with(peixe){
        nome = "Nemo2"
    }

    // run, let, apply
    val unString = "ola mundo"

    val resultado = unString.run{capitalize()}

    println(resultado)

    val peixe2 = peixe.apply {nome = "pepinho"}

    println(peixe2)


    val resultado2 = unString.let { it[0].uppercase() }
    println(resultado2)


}

data class Peixe(var nome: String){
    fun nadar(){}
    fun comer(){}
}