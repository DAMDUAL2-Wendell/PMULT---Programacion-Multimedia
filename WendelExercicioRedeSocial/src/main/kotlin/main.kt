import java.lang.reflect.Type

fun main() {
    val perfil = Perfil("s","s",EstadisticasEmpresa(1,1))
    println(perfil.imprimirInformacionPerfil())
    println(EstadisticasEmpresa(100,40).toString())
    println("-----------------------")

    val aplicacion = ConfiguracionApp
    println(aplicacion.temaInterfaz)
    aplicacion.temaInterfaz = "Oscuro"
    println(aplicacion.temaInterfaz)

    println("-----------------")

    val perfilPersoal = Perfil(
        "Usuario123",
        "Usuario persoal",
        EstadisticasPersoales(100, 50)
    )

    val perfilEmpresa = Perfil(
        "Empresa123",
        "Empresa de tecnoloxia",
        EstadisticasEmpresa(5000, 200)
    )

    val outroPerfil = Perfil(
        "Usuario321",
        "Usuario persoal",
        hashMapOf("seguidores" to 3, "outro" to false)
    )

    perfilPersoal.imprimirInformacionPerfil()
    println("--------")
    perfilEmpresa.imprimirInformacionPerfil()
    println("--------")
    outroPerfil.imprimirInformacionPerfil()

    println("--------------")
    println(perfilPersoal.tenEstadisticas<EstadisticasEmpresa>())
    println(perfilPersoal.tenEstadisticas<EstadisticasPersoales>())


    println("----------------")

    perfilEmpresa.configurarPerfil {
        seguidores = 6000
        empleados = 250
    }

}

class Perfil<T>(var nome2: String, var descricion2: String, val tipo: T){
    var nome: String = nome2
    var descricion: String = descricion2
    var estadisticas = tipo
    fun imprimirInformacionPerfil(){
        println("A minha App ${singleton.NOME_APLICACION}\n" +
                "Nome: $nome\n" +
                "Descricion: $descricion")
        if(tipo !is Estadisticas){
            println("\t - ${tipo.toString()}")
        }else{
            tipo.imprimirEstadisticas()
        }
    }


    val singleton = ConfiguracionApp
}

inline fun<reified T> Perfil<*>.tenEstadisticas() = this.estadisticas is T

interface Estadisticas{
    fun imprimirEstadisticas(){ }
}

data class EstadisticasPersoales(var seguidores: Int, var publicacions: Int):Estadisticas{
    override fun imprimirEstadisticas() {
            println("Estadisticas:" +
                    "\n\t- Seguidores: $seguidores" +
                    "\n\t- Empleados: $publicacions")
    }
}

data class EstadisticasEmpresa(var seguidores: Int, var publicacions: Int):Estadisticas{
    override fun imprimirEstadisticas() {
        println("Estadisticas:" +
                "\n\t- Seguidores: $seguidores" +
                "\n\t- Empleados: $publicacions")
    }
}

object ConfiguracionApp{
    var NOME_APLICACION: String = "prueba"
    var temaInterfaz: String = "Claro"
    private fun cambiarTema(novoTema: String){println("Tema da interfaz cambiado a: $novoTema")}
    private fun realizarLog(mensaxe: String){println("LOG: Tema da interfaz modificado")}
}

fun Perfil<*>.configurarPerfil():(Int, Int) -> Int =  { first, second ->
    if(this.estadisticas is Estadisticas){}
}
