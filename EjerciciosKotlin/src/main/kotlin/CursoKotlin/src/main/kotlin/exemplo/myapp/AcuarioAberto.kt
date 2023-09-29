package exemplo.myapp

open class AcuarioAberto (
    var lonxitude: Double = 100.0,
    var anchura: Double = 20.0,
    open var altura: Double = 40.0
)
{
    open var volume: Double
        get() = anchura * altura * lonxitude / 1000
        set(value){
            altura = (value * 1000) / (anchura * lonxitude)
        }

    //Novas Propiedades
    open val forma = "rectangulo"

    open val auga: Double
        get() = volume * 0.9

    fun printTamanho(){
        println("-----------------")
        println("forma: $forma\n")
        println("Anchura: $anchura cm \n" +
                "Altura: $altura cm \n" +
                "Lonxitude: $lonxitude cm \n" +
                "volumen: $volume cm\n" +
                "auga: $auga l (${auga/volume * 100.0} %) cheo")
        println("-----------------")
    }
}