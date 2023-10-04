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
abstract class VehiculoTerrestre(var marca: String?, var caracteristicas: Map<String,String>?):FuncionalidadesVehiculo{

    abstract var tipo: String?
    abstract protected var tipoConArtigo: String?

    fun verCaracteristicas() {
        if(caracteristicas!=null){
            println("As caracteristicas adicionais son:")
            caracteristicas?.forEach { entry -> println("\t-${entry.key}: ${entry.value}") }
        }else{
            println("$tipoConArtigo non ten ninguna caracteristica adicional definida")
        }
    }
    override fun acelerar() {
        println("Accelerando $tipoConArtigo${if(marca.isNullOrEmpty()) " de marca desconhecida" else "de marca $marca"}")
    }
    override fun frear() {
        println("Freando $tipoConArtigo${if(marca.isNullOrEmpty()) "" else " de marca $marca"}")
    }
}

class Coche(marca: String?, var numeroPortas: Int?,
            caracteristicas: Map<String,String>?)
    : VehiculoTerrestre(marca, caracteristicas),FuncionalidadesVehiculo,VehiculoDeMotor {
    override var tipo: String?
        get() = "coche"
        set(value) {}
    override var tipoConArtigo: String?
        get() = "O $tipo"
        set(value) {}

    override var estaEncendido: Boolean = false

    override fun apagar() {
        TODO("Not yet implemented")
    }

}

class Moto(marca: String?, caracteristicas: Map<String, String>?
): VehiculoTerrestre(marca, caracteristicas),FuncionalidadesVehiculo,VehiculoDeMotor {

    override var estaEncendido: Boolean = false
    override var tipo: String?
        get() = "moto"
        set(value) {}
    override var tipoConArtigo: String?
        get() = "A $tipo"
        set(value) {}

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

class Bicicleta(marca: String?,var numeroMarchas: Int?,
                caracteristicas: Map<String, String>?)
    : VehiculoTerrestre(marca, caracteristicas) {

    override var tipo: String?
        get() = "bicicleta"
        set(value) {}
    override var tipoConArtigo: String?
        get() = "A $tipo"
        set(value) {}

}

