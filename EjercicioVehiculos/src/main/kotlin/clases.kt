interface FuncionalidadesVehiculo{
    fun acelerar()
    fun frear()
}

interface VehiculoDeMotor{
    var estaEncendido: Boolean
    fun encender(){
        estaEncendido = true
    }
    fun apagar()
}
abstract class VehiculoTerrestre:FuncionalidadesVehiculo{
    abstract var marca: String?
    abstract val caracteristicas: Map<String,String>?
    private var tipo: String? = ""
    protected var tipoConArtigo: String = "o " + tipo

    fun verCaracteristicas() {
        if(VehiculoTerrestre is String){

        }
        if(caracteristicas!=null){
            caracteristicas.forEach { entry -> println("\t${entry.key}: ${entry.value}") }
        }else{
            println("A moto non ten ninguna caracteristica adicional definida")
        }
    }

}

class Coche(override var marca: String?, var numeroPortas: Int?,
            override val caracteristicas: Map<String,String>?)
    : VehiculoTerrestre(),FuncionalidadesVehiculo,VehiculoDeMotor {

    fun verCaracteristicas() {
        if(marca!=null){
            println("As caracteristicas adicionais son:")
        }
        if(caracteristicas!=null){
            caracteristicas.forEach { entry -> println("\t${entry.key}: ${entry.value}") }
        }else{
            println("O coche non ten ninguna caracteristica adicional definida")
        }
    }

    override fun acelerar() {
        println("Accelerando o coche de marca $marca")
    }

    override fun frear() {
        println("Freando o coche")
    }

    override var estaEncendido: Boolean = false

    override fun apagar() {
        TODO("Not yet implemented")
    }

}

class Moto(override var marca: String?,
           override val caracteristicas: Map<String, String>?
)
    : VehiculoTerrestre(),FuncionalidadesVehiculo,VehiculoDeMotor {

    override var estaEncendido: Boolean = false

    override fun acelerar() {
        println("Accelerando a moto de marca $marca")
    }

    override fun frear() {
        println("Freando a moto")
    }

    fun verCaracteristicas() {
        if(caracteristicas!=null){
            caracteristicas.forEach { entry -> println("\t${entry.key}: ${entry.value}") }
        }else{
            println("A moto non ten ninguna caracteristica adicional definida")
        }
    }

    override fun encender(){
        if(estaEncendido){
            println("A moto xa esta encendida")
        }else{
            estaEncendido = true
        }

    }

    override fun apagar() {
        estaEncendido = false
    }

}

class Bicicleta(override var marca: String?,var numeroMarchas: Int?,
                override val caracteristicas: Map<String, String>?)
    : VehiculoTerrestre() {

    override fun acelerar() {
        println("Accelerando a bicicleta de marca $marca")
    }

    override fun frear() {
        println("Freando a bicicleta")
    }

    fun verCaracteristicas() {
        println("As caracteristicas adicionais son:")
        if(caracteristicas!=null){
            caracteristicas.forEach { entry -> println("\t${entry.key}: ${entry.value}") }
        }else{
            println("A bicicleta non ten ninguna caracteristica adicional definida")
        }
    }

}

