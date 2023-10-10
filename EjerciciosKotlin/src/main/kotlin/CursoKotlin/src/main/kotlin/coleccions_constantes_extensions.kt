fun main() {
    //Leccion 5.1.2 ---------------------------------------------------

    // Pair
    val equipo = "rede" to "pescar"
    println(equipo)
    println("${equipo.first} usado para ${equipo.second}")

    //triple
    val numeros = Triple(6,7,2)
    println(numeros)
    println("${numeros.first} ${numeros.second} ${numeros.third}")

    //Destruir pares e triples
    val (ferramenta, uso) = equipo
    println(ferramenta)
    println(uso)
    val (n1,n2,n3) = numeros
    println("numeros: $n1 $n2 $n3")

    println("----------------------------------")

    //Listas
    val lista = listOf(1,3,4,5)
    println(lista.sum())

    val lista2 = listOf("a", "ss", "dd")
    println(lista2.sumOf { it.length })
    println(lista2.joinToString(" "))
/*    for(elemento in lista2.listIterator()){
        println(elemento)
    }*/

    lista2.forEach { println(it) }

    //Hash maps: lista de pares nos que o primeiro valor e a key
    println("----------------------")
    val froitas = hashMapOf("manzana" to "verde", "cereixa" to "vermella")
    println(froitas.get("manzana"))
    println(froitas["manzana"])

    //Clavas que non existen
    println(froitas["inventada"])
    println(froitas.getOrDefault("inventada","non existe"))
    println(froitas.getOrElse("inventada"){"aqui pode ir codigo"})

    //Engadir elements ao map
    froitas["melon"] = "verde"
    println(froitas)

    froitas.remove("manzana")
    println(froitas)

    // Constantes en tiempo de ejecución
    val unhaconstante = funcionComplexa()


    // Singleton
    var resultado = ConstantesMatematicas.PI
    var resultado2 = ConstantesMatematicas.PI
    // Testeo Singleton

    val obxecto1 = ConstantesMatematicas
    val obxecto2 = ConstantesMatematicas
    obxecto1.unhaPropiedade = "propiedade do obxecto 1"
    obxecto2.unhaPropiedade = "propiedade do obxecto 2"
    println(obxecto1.unhaPropiedade)
    println(obxecto2.unhaPropiedade)

    println(UnhaClase.SingletonDentroCalse.CONSTANTE)

    println("-------------------------")

    println("ola".empezaPorMaiuscula)



}

fun funcionComplexa() = 4

// En tiempo de compilacion
const val unhaconstante = 5

//Singleton
object ConstantesMatematicas{
    var unhaPropiedade = ""

    const val PI = 3.14
    const val E = 2.72
}

class UnhaClase {
    companion object SingletonDentroCalse{
        const val CONSTANTE = "constante dunha clase";
    }

}
// Funcion de extension String
fun String.tenEspacios() = any{it == ' '}

// Propiedade de extension String

val String.empezaPorMaiuscula: Boolean
    get() = this[0].isUpperCase()