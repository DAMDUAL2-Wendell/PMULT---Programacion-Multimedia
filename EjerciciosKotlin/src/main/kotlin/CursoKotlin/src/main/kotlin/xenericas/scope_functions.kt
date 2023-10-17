package xenericas
fun main() {

    val obxecto = AMinhaApp()
    println(obxecto.i)
    println(obxecto.getIAoCadrado())
    println(obxecto.i)

}

class AMinhaApp{

    private var numero: Int? = null
    var i = 2

    fun unMetodo(){

        if(numero != null){
            val numero2 = numero!! + 1
        }

        val x = numero?.let{
            val numero2 = it + 1
            numero2// let devolve a última línea
        }

    }

    // o utilizar also devolve o obxecto anterior ao punto
    fun getIAoCadrado() = (i*i).also {
        i ++
    }

    fun outroMetodo(){
        val unhaColeccionPersonalizada = ColeccionPersonalizada().apply {
            descripcion = "Ola"
            engadirDato("dato",0)
            engadirDato("outroDato",1)
        }

        val unhaColeccionPersonalizada2 = ColeccionPersonalizada().run {
            descripcion = "Ola"
            engadirDato("dato",0)
            engadirDato("outroDato",1)
            this
        }

        with(ColeccionPersonalizada()){} // Equivalente a ColeccionPersonalizada().run

    }

    // let - also -----------------------apply - run (with)
}

class ColeccionPersonalizada{
    var descripcion: String = "default"
    fun engadirDato(nome: String, valor: Int){

    }
}