package xenericas

fun main() {

    //val acuario = Acuario(suministroAuga = AugaDeGrifo())
    val acuario = Acuario(AugaDeGrifo())

    println("auga necesita procesado ${acuario.suministroAuga.necesitaProcesado}")
    //acuario.suministroAuga.engadirProductosQuimicos();
    acuario.encher()

}

// Clase xenerica
class Acuario<T: SuministroAuga>(val suministroAuga: T){
    fun encher(){

        // Se o argumento do check e false -> excepcion con mensaxe {}
        check(!suministroAuga.necesitaProcesado){"a auga ten que ser procesada primeiro"}
        println("Engadindo auga de $suministroAuga")
    }
}

//class Acuario(val suministroAuga: SuministroAuga)

// Facer que T poida ser calqueira clase menos null
class AcuarioConSuministroNonNulo<T: Any>(val suministroAuga: T)


// Clase para facer subclases
open class  SuministroAuga(var necesitaProcesado: Boolean)

class AugaDeGrifo : SuministroAuga(true){
    fun engadirProductosQuimicos(){necesitaProcesado = false}
}

class AugaTendaPeixes : SuministroAuga(false)

class AugaLago : SuministroAuga(true){
    fun filtrar(){necesitaProcesado = false}
}



