package CatalogoCanciones

class Song (var titulo:String,
            var artista: String,
            var anho: Int,
            var reproducciones: Int
)
{
    var isPopular: Boolean = false
        get() {
            if (reproducciones > 1000) return true else return false
        }

    fun printDescripcion(){
        println("titulo: $titulo\n" +
                "artista: $artista\n"+
                "anho: $anho\n"+
                "reproducciones: $reproducciones\n"+
                "isPopular: $isPopular")
    }
}