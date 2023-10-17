import kotlin.reflect.full.declaredMemberProperties

fun main() {
    val perfil = Perfil("s","s",EstadisticasImprimiblesEmpresa(1,1))
    println(perfil.imprimirInformacionPerfil())
    println(EstadisticasImprimiblesEmpresa(100,40).toString())
    println("-----------------------")

    val aplicacion = ConfiguracionApp
    println(aplicacion.temaInterfaz)
    aplicacion.temaInterfaz = "Oscuro"
    println(aplicacion.temaInterfaz)

    println("-----------------")

    val perfilPersoal = Perfil(
        "Usuario123",
        "Usuario persoal",
        EstadisticasImprimiblesPersoales(100, 50)
    )

    val perfilEmpresa = Perfil(
        "Empresa123",
        "Empresa de tecnoloxia",
        EstadisticasImprimiblesEmpresa(5000, 200)
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
    println(perfilPersoal.tenEstadisticas<EstadisticasImprimiblesEmpresa>())
    println(perfilPersoal.tenEstadisticas<EstadisticasImprimiblesPersoales>())


    println("----------------")

    perfilEmpresa.configurarPerfil {
        seguidores = 6000
        empleados = 250
    }

    perfilPersoal.configurarPerfil {
        seguidores = 6000
        publicacions = 250
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
        if(tipo !is EstadisticasImprimibles){
            println("\t - ${tipo.toString()}")
        }else{
            tipo.imprimirEstadisticas()
        }
    }


    val singleton = ConfiguracionApp
}

inline fun<reified T> Perfil<*>.tenEstadisticas() = this.estadisticas is T

interface EstadisticasImprimibles{
    fun imprimirEstadisticas(){
        for(propiedade in this::class.declaredMemberProperties){
            println(" - ${propiedade.name}: ${propiedade.getter.call(this)}")
        }
    }
}

data class EstadisticasImprimiblesPersoales(var seguidores: Int, var publicacions: Int):EstadisticasImprimibles{
    override fun imprimirEstadisticas() {
            println("Estadisticas:" +
                    "\n\t- Seguidores: $seguidores" +
                    "\n\t- Empleados: $publicacions")
    }
}

data class EstadisticasImprimiblesEmpresa(var seguidores: Int, var empleados: Int):EstadisticasImprimibles{
    override fun imprimirEstadisticas() {
        println("Estadisticas:" +
                "\n\t- Seguidores: $seguidores" +
                "\n\t- Empleados: $empleados")
    }
}

object ConfiguracionApp{
    var NOME_APLICACION: String = "prueba"
    var temaInterfaz: String = "Claro"
    private fun cambiarTema(novoTema: String){println("Tema da interfaz cambiado a: $novoTema")}
    private fun realizarLog(mensaxe: String){println("LOG: Tema da interfaz modificado")}
}

// Funcion de extension xenerica para modificar as estadisticas deun perfil
fun <T>Perfil<T>.configurarPerfil(configuracion: T.() -> Unit){
    estadisticas.configuracion()
}

