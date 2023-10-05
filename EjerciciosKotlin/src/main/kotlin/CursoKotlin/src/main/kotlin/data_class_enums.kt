fun main() {
    val decoracion1 = Decoracion("granito")
    println(decoracion1)

    val decoracion2 = Decoracion("pizarra")

    val decoracion3 = Decoracion("pizarra")

    //Metodos dos dataclases
    println(decoracion1.rocha)

    println(decoracion1.equals(decoracion2))
    println(decoracion1 == decoracion2) //sintaxe recomendada

    println(decoracion2 == decoracion3)

    println("----------------")
    val decoracion4 = decoracion3
    println(decoracion4 == decoracion3)


    val decoracion5 = Decoracion2("granito","caoba","cousa")
    println(decoracion5)
    val(rocha, madeira, outra) = decoracion5

    println(rocha)
    println(madeira)
    println(outra)

    println("--------------------")
    println(Direccion.SUR.graos)
    println(Direccion.SUR.name)
    println(Direccion.SUR.ordinal)


}

data class Decoracion(val rocha: String)

data class Decoracion2(val rocha:String, val madeira: String, val outra: String)

enum class Direccion(val graos: Int){
    NORTE(0), SUR(180), ESTE(90), OESTE(270)
}