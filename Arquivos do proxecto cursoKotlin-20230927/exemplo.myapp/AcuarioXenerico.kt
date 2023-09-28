package exemplo.myapp

import kotlin.math.pow

//Leccion 4.6 -----------------------------------------------------------------------------

//En Koltin hai que especificar con open que unha clase poida ter subclases
//Tamen hai que especificar como open as propiedades e variables para que poidan ser sobrescritas nunha subclase
open class AcuarioXenerico(
    var lonxitude: Double = 100.0,
    var anchura: Double = 20.0,
    open var altura: Double = 40.0
) {
    open var volume: Double
        get() = anchura * altura * lonxitude / 1000
        set(value){
            altura = (value * 1000) / (anchura * lonxitude)
        }

    //Novas propiedades
    open val forma = "rectangulo"

    open val auga: Double
        get() = volume * 0.9

    //Metodo
    fun printTamanho() {
        println("--------")
        println("forma: $forma")
        println("anchura: $anchura cm "+
                "altura: $altura cm "+
                "lonxitude: $lonxitude cm ")
        println("volume: $volume l")
        //Imprimir a cantidade de auga como porcentaxe do volume
        println("auga: $auga l (${auga/volume*100.0}% cheo)")
        println("--------")
    }

    //Metodo sobrescribible
    open fun istoQueE(){
        println("Isto e un acuario")
    }

}

//Subclase TanqueTorre. Implementacion dun acuario con forma circular
//Hai que chamar ao constructor da superclase
class AcuarioCilindrico(override var altura: Double, var diametro: Double): AcuarioXenerico(altura = altura, anchura = diametro, lonxitude = diametro){
    //Sobrescribir propiedades
    override var volume: Double
        //Volume do cilindro: pi * r^2 * h
        get() = ((diametro / 2.0).pow(2.0) * altura / 1000 * Math.PI)
        set(value){
            altura = ((value * 1000 / Math.PI) / (diametro / 2.0).pow(2.0))
        }

    override val auga: Double
        get() = volume * 0.8 //Este tipo de acuario vai ter menos auga

    override val forma = "cilindro"

    //Sobrescribir metodos
    override fun istoQueE() {
        super.istoQueE()
        println("Tipo: cilindrico")
    }



}


