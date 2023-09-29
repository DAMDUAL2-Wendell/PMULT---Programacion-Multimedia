package CursoKotlin.src.main.kotlin.abstraccionEinterfaces

fun main(){
    val tiburon = Tiburon()
    val peixePallaso = PeixePallaso()
    val delfin = Delfin()

    tiburon.printPropiedades()
    peixePallaso.printPropiedades()
    delfin.printPropiedades()


}

abstract class PeixeDeAcuario(open val especie: String = "peixe"){
    //Propiedade abstracta
    abstract val cor: String
    fun printPropiedades(){
        println("------------\nEspecie: $especie\nCor: $cor")
    }
}

class Tiburon(): PeixeDeAcuario(){
    override val cor = "gris"
}

class PeixePallaso(): PeixeDeAcuario(especie = "peixe pallaso"){
    override val cor = "verde"
}

class Delfin(): PeixeDeAcuario(){
    override val cor = "gris"
    override val especie = "mamifero"
}