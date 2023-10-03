package CursoKotlin.src.main.kotlin.abstraccionEinterfaces

fun main(){
    val tiburon = Tiburon()
    val peixePallaso = PeixePallaso()
    val delfin = Delfin()
    delfin.comer()
    delfin.nadarRapido()

    tiburon.printPropiedades()
    peixePallaso.printPropiedades()
    delfin.printPropiedades()


}

abstract class PeixeDeAcuario(open val especie: String = "peixe"): AccionsDosAcuarios{
    //Propiedade abstracta
    abstract val cor: String
        fun printPropiedades(){
        println("------------\nEspecie: $especie\nCor: $cor")
    }
}

class Tiburon(): PeixeDeAcuario(){
    override val cor = "gris"

    override fun comer() {
        TODO("Not yet implemented")
    }
}

class PeixePallaso(): PeixeDeAcuario(especie = "peixe pallaso"){
    override val cor = "verde"
    override fun comer() {
        TODO("Not yet implemented")
    }
}

class Delfin(): PeixeDeAcuario(){
    override val cor = "gris"
    override val especie = "mamifero"
    override fun comer() {
        println("O Delfin está comendo")
    }
}

interface  AccionsDosAcuarios{
    fun comer()
    fun nadarRapido() = println("nadando rapido")
}