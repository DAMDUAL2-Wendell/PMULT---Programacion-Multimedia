package primeiros.exercicios

fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}

class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")

        var mensaxe0: String = hobby?.let { "Likes to $it. " } ?: ""
        //var mensaxe2 = if(hobby!=null) "Likes to $hobby. " else ""

        if(hobby != null) {
            print(mensaxe0)
        }

        var mensaxe = referrer?.let {
            val mensaxe1 = "Has a referrer named ${referrer.name}"
            val mensaxe2 = it.hobby?.let {", who likes to ${referrer.hobby}."} ?: "."
            mensaxe1 + mensaxe2
        } ?: "Doesn't have a referrer."

        print(mensaxe)
        print("\n\n")


    }
}