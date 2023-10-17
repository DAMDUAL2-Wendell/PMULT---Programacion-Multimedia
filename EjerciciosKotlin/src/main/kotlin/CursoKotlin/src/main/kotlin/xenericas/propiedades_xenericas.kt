package xenericas

fun main() {



}

class ClaseXenerica<T>(val datos: T){
    fun unMetodo(){
        // Chamar un metodo dunha propiedade de tipo xenerico
        // Opcion 1:
        if( datos is Interfaz){
            datos.metodoInterfaz()
        }


        // Opcion 2:
        //datos.metodoInterfaz() // Erro
/*        check(datos is Interfaz){"mensaxe de excepcion"}
        datos.metodoInterfaz()*/

        //Opcion 3:
        when(datos){
            is ClaseDatos1 -> datos.metodoClaseDatos1()
            //is ClaseDatos2, is ClaseDatos3 -> datos.metodoInterfaz()
            is ClaseDatosNonInterfaz -> datos.metodoClaseDatosNonInterfaz()
            else -> Unit
        }

        // Opcion 4:
        (datos as Interfaz)?.metodoInterfaz()


    }
}

interface Interfaz{
    fun metodoInterfaz() = println("metodo da interfaz")
}

class ClaseDatos1(val unhaPropiedade: String): Interfaz{
    fun metodoClaseDatos1() = println("metodo de ClaseDatos1")
}

class ClaseDatos2(val unhaPropiedade: String): Interfaz{
    fun metodoClaseDatos2() = println("metodo de ClaseDatos2")
}

class ClaseDatos3(val unhaPropiedade: String): Interfaz{
    fun metodoClaseDatos3() = println("metodo de ClaseDatos3")
}

class ClaseDatosNonInterfaz(val unhaPropiedade: String){
    fun metodoClaseDatosNonInterfaz() = println("metodo de ClaseDatosNonInterfaz")
}