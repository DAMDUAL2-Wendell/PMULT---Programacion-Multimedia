fun main() {
    //filters()
    lambdas()
}

// Filtros

fun filters(){
    val decoracions = listOf("rocha","pagoda", "planta","xarron","maceta")
   //o filtro itera na lista, se a {condicion} e true inclue o elemento

    //println(decoracions.filter { it[0] == 'p'})

    //Crear unha nova lista, (eager = impaciente)
    val eager = decoracions.filter { it[0] == 'p'}
    println("eager: $eager")

    //lazy list (lazy = vago), espera a que lle pidan que sexa evaluada para calcular os elementos. Faise cunha sequence
    //unha sequence so pode 'mirar' un elemento a vez

    val filtrada = decoracions.asSequence().filter { it[0]=='p' }

    //evaluacion lazy

    println("filtrada $filtrada")

    //forzar a evaluacion
    val novaLista = filtrada.toList()

    println("novaLista: $novaLista")

    //map{} fai unha transformacion sobre cada un dos elementos dunha lista, sequence...
    val unhaLista = listOf(1,2,3)
    //println(unhaLista.map { it + 1 })

    val lazyMap = decoracions.asSequence().map {
        println("accesso: $it")
        it
    }

    println("lazy: $lazyMap")
    println("-----------")
    println("primeiro: ${lazyMap.first()}")
    println("---------")
    println("todos: ${lazyMap.toList()}")

    println("---------")

    val lazymap2 = decoracions.asSequence().filter { it[0] == 'p' }.map {
        println("acceso: $it")
        it
    }
    println("---------")
    println("filtrada: ${lazymap2.toList()}")



}

//Lambda

fun lambdas(){
    //Unha lambda e una expresion que crea unha funcion
    //O util e que a podes pasar como dato

    //Nunha lambda: {parametros -> codigo a executar}
    var nivelImpureza = 20
    //val filtroAuga = {impureza: Int -> impureza/2}
    val filtroAuga: (Int) -> Int = {impureza: Int -> impureza/2}

    //Evaluar a lambda
    println(filtroAuga(nivelImpureza))

    //Evaluar a funcion de orde superior
    println(actualizarImpureza(30,filtroAuga)) //Esto non se suele facer


    println(actualizarImpureza(30, {it + 30})) //Esto non se usa así
    //Pasar unha lambda como argumento, sintaxe recomendada
    nivelImpureza = actualizarImpureza(30) {it + 30 }
    println(nivelImpureza)


    //Pasar funcion como argumento a unha funcio de orde superior
    println(actualizarImpureza(30, ::aumentarImpureza))

    //Usando a funcion de orde superior mais complicada
    println(operar(1,2){a,b -> a*2 + b+1})
    val resultado = operar(1,2){a,b ->
        println("Facendo unha lambda")
        if(b>a){
            return@operar b
        }
        3*a
    }
    println(resultado)

    //Lambdas nos filtros
    val unhaListaSenFiltrar = listOf("Rocha", "Pagoda","planta","xarron")
    val estaListaFiltrada = unhaListaSenFiltrar.asSequence().filter{nomeQueNonSexaIt ->
        println(nomeQueNonSexaIt)
        if(nomeQueNonSexaIt == "xarron"){
            return@filter true
        }
        nomeQueNonSexaIt[0] == 'p'
    }
    println("Lista filtrada: ${estaListaFiltrada.toList()}")

    //Testeo de testeo de funcion con duas lambdas
    ordeSuperior(1,{it*2},{it*3})

}

//Funcion de orde superior
fun actualizarImpureza(impureza: Int, operacion: (Int) -> Int): Int {
    return operacion(impureza)
}

//Funcion para pasar como argumento
fun aumentarImpureza(impureza: Int) = impureza + 1

//funcion de orde complexa mais complicada
fun operar(a: Int, b: Int, operacion: (Int, Int) -> Int): Int = operacion(a,b)

//Funcio de orde superior con duas lambdas de parametros
fun ordeSuperior(a: Int, lambda1: (Int) -> Int, lambda2: (Int) -> Int){
    println(lambda1(a))
    println(lambda2(a))
}

