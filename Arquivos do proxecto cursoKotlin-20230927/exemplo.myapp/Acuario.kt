package exemplo.myapp

//Leccion 4.3 -----------------------------------------------------------------------------

//class Acuario {
//
//    var anchura: Int = 20
//    var altura: Int = 40
//    var lonxitude: Int =  100
//
//    //Definir un metodo
//    fun printTamanho() {
//        println("anchura: $anchura cm "+
//                "altura: $altura cm "+
//                "lonxitude: $lonxitude cm ")
//    }
//}

//Leccion 4.4 -----------------------------------------------------------------------------

//Engadir un constructor a clase
//class Acuario(var anchura: Int = 20, var altura: Int = 40, var lonxitude: Int = 100) {
//
//    //Definir un metodo
//    fun printTamanho() {
//        println("anchura: $anchura cm "+
//                "altura: $altura cm "+
//                "lonxitude: $lonxitude cm ")
//    }
//
//    //Engadir bloques init de codigo
//    //Executanse por orde cando se chama ao constructor
//    init {
//        println("Inicializando acuario...")
//    }
//    init {
//        //1 litro = 1000 cm^3
//        println("Volume: ${altura * anchura * lonxitude / 1000} l")
//    }
//
//    //Engadir un segundo constructor
//    constructor(numeroDePeixes: Int): this() { //this chama ao primeiro constructor
//
//        //2_000 cm^3 por peixe + algo extra para que non se desborde a auga
//        val volumeNecesario = numeroDePeixes * 2000 * 1.1
//
//        //Calcular a altura necesaria
//        altura = (volumeNecesario / (lonxitude * anchura)).toInt()
//    }
//
//}

//Propiedades: definir getters e setters
class Acuario(var anchura: Int = 20, var altura: Int = 40, var lonxitude: Int = 100){

    //O volume e unha propiedade que ten que ser calculada a partir de outras
    var volume: Int
        //Cando solo hai un getter, o volume e unha constante porque si cambiases o valor poderia non cumplirse a expresion do get()
        //O get executase cada vez se se accede a propiedade
        get() = anchura * altura * lonxitude / 1000
        //Engadir un setter (que facer cando se cambia o volume)
        //Cando engades un setter, volume ten que pasar a ser unha variable (estas dicindo que pode variar)
        //O set executase cando se cambia o valor da propiedade
        set(value) { //Uso de value por convencion
            altura = (value * 1000) / (anchura * lonxitude)
        }

    init{
        println("Inicializando acuario...")
    }

    //Metodo
    fun printTamanho() {
        println("anchura: $anchura cm "+
                "altura: $altura cm "+
                "lonxitude: $lonxitude cm ")
        println("volume: $volume l")
    }

    //Leccion 4.5 -----------------------------------------------------------------------------

    //As variables, clases, metodos, propiedades... son public (visible fora da clase) por default en Kotlin
    //Os modificadores de visiblidade son:

    //Internal: visible dentro do modulo (refierese ao modulo de compilacion, no noso caso e a carpeta src)
    internal val propiedadeInterna: Int = 1

    //Private: solo visible dentro da clase
    private val propiedadePrivada: Int = 1

    //Propiedade que se porde ler e escribir na clase (ou codigo), pero fora da clase solo ler
    var volumeSoloLectura: Int
        get() = anchura * altura * lonxitude / 1000
        private set(value){
            altura = (value * 1000) / (anchura * lonxitude)
        }

    //Outra propiedade solo de lectura
    var propiedade2: Int = 1
        private set

    //Propiedade privada que se pode modificar desde fora da clase
    private var unhaPropiedadePrivadaModificable: String = "Non estou modificada"
        set(value) {
            //field e o campo de respaldo dunha propiedade, i.e, a variable real que almacena o valor actual da propiedade
            //Polo tanto e o valor que ten a propiedade antes da modificacion
            //value representa o novo valor que se intenta asignar a propiedade
            println("Modificando a propiedade privada...")
            println("O valor actual e field: $field")
            println("O novo valor que quero cambiar e value: $value")
            field = value + " extra"
        }

    fun modificarPropiedadePrivadaModificable(novoValor: String){
        unhaPropiedadePrivadaModificable = novoValor
    }

    fun obterPropiedadePrivadaModificable() {
        println("Actualmente a propiedade vale: " + unhaPropiedadePrivadaModificable)
    }

    //Protected: como privado pero tamen visible nas subclases
    protected val propiedadeProtexida: Int = 1 //xa veremos o porque do warning
}