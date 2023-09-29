package exemplo.myapp
/*

class Acuario(var anchura: Int = 20,var altura: Int = 40,var lonxitude: Int = 100) {

    //Metodo
    fun printTamanho(){
        println("Anchura: $anchura cm \n" +
                "Altura: $altura cm \n" +
                "Lonxitude: $lonxitude cm \n")
    }

    init{
        println("Inicializando acuario...")
    }

    init{
        //1 litro = 1000 cm^3
        println("Volume: ${altura * anchura * lonxitude / 1000} Litros")
    }

    constructor(numeroDePeixes: Int): this(){
        val volumeNecesario = numeroDePeixes * 2000 * 1.1

        //Calcular a altura necesaria
        altura = (volumeNecesario / (lonxitude * anchura)).toInt()
    }

}*/

class Acuario(var anchura: Int = 20, var altura: Int = 40, var lonxitude: Int = 100) {
    var volume: Int
        get() = anchura * altura * lonxitude / 1000
        set(value){
            altura = (value * 1000 / (anchura * lonxitude))
        }

    fun printTamanho(){
        println("Anchura: $anchura cm \n" +
                "Altura: $altura cm \n" +
                "Lonxitude: $lonxitude cm \n" +
                "volumen: $volume cm\n")
    }

    //Os modificadores de visibilidade son:
    //Internal: visibles dentro do modulo (modulo de compilacion)
    internal val  propiedadeInternal: Int = 1

    //Private: solo visible dentro da clase
    private val propiedadePrivada: Int = 22

    init{
        println(propiedadePrivada)
    }

    var volumeSoloLectura: Int
        get() = anchura * altura * lonxitude /1000
        private set(value){altura = (value * 1000 / (anchura * lonxitude))}

    var propiedad2: Int = 1
        private set

    //Propiedade privada que se poida modificar fora da clase

    private var unhaPropiedadePrivadaModificable: String = "Non estou modificada"

    fun modificarPropiedadePrivada(novoValor: String){
        unhaPropiedadePrivadaModificable = novoValor
    }

    fun obterPropiedadePrivadaModificable(){
        println("Actualmente a propiedade vale: $unhaPropiedadePrivadaModificable")
    }


}
