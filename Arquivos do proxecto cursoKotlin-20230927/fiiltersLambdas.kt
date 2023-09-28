fun main() {
//    filters()
    lambdas()
}

//---------- Filtros
fun filters() {
    val decoracions = listOf("rocha","pagoda","planta de plastico","xarron","maceta")

    //O filtro itera na lista, se a {condicion} e true inclue o elemento
    println(decoracions.filter { it[0] == 'p' })

    //Crear unha nova lista, (eager = impaciente)
    val eager = decoracions.filter { it[0] == 'p' }
    println("eager: $eager")

    //lazy list (lazy = vaga), espera a que lle pidan que sexa evaluada para calcular os elementos. Faise cunha sequence
    //Unha sequence e unha estrutura de datos que solo pode 'mirar' un elemento a vez, desde o principio ao final
    val filtrada = decoracions.asSequence().filter { it[0] == 'p' }

    //evaluacion 'vaga' dunha sequence. Solo aparece a referencia. Vese que esta filtrada
    println("filtrada: $filtrada")

    //Forzar a evaluacion da lazy list
    val novaLista = filtrada.toList()
    println("nova lista: $novaLista")

    //map{} fai unha transformacion sobre cada un dos elementos dunha lista, sequence...
    val unhaLista = listOf(1,2,3)
    //println(unhaLista.map { it + 1 })

    //Este map non fai nada solo accede en memoria a cada elemento it (imprimese en pantalla cando se accede)
    val lazyMap = decoracions.asSequence().map {
        println("acceso: $it")
        it//Se aqui fose algo moi costoso computacionalmente e mellor usar una sequence a unha lista

    }

    //Invocamos a sequence mapeada, imprimese a referencia
    println("lazy: $lazyMap")
    println("------")
    //first() imprime o primeiro elemento
    println("primeiro: ${lazyMap.first()}") //Accedese solo ao primeiro elemento
    println("------")
    //Convertindo en lista, accedese a todos os elementos
    println("todo: ${lazyMap.toList()}")

    val lazyMap2 = decoracions.asSequence().filter {it[0] == 'p'}.map {
        println("acceso: $it")
        it
    }

    //Solo se accede ao elementos previamente filtrados
    println("------")
    println("filtrada: ${lazyMap2.toList()}") //O println interno solamente se chama para os elementos que se acceden

}
//---------- Lambdas
fun lambdas(){
    //Unha lambda e unha expresion que crea unha funcion. En vez de declarar unha funcion nomeada, declaras unha 'sen nome'
    //O que e util desto e que a podes pasar como un dato

    // A un filter, pasaslle unha lambda, por exemplo: { it[0] == 'p' }
    // A un map tamen lle pasas unha lambda como argumento
    // filter, map ... chamanse funcions de orde superior

    //Nunha lambda: {parametros -> codigo a executar}
    var nivelImpureza = 20
    //val filtroAuga = {impureza: Int -> impureza/2}

    //Boa practica: usar esta sintaxe
    val filtroAuga: (Int) -> Int = {impureza -> impureza/2}
    println(filtroAuga(nivelImpureza))

    println(actualizarImpureza(30,filtroAuga))

    //Podese pasar unha funcion tamen como argumento, coa seguinte sintaxe
    println(actualizarImpureza(15, ::aumentarImpureza))

    //A sintaxe recomendada para traballar con funcions de orde superior
    nivelImpureza = actualizarImpureza(nivelImpureza) {impureza -> impureza + 23}
    println(nivelImpureza)

    //Se solo hai un parametro na lambda, podese usar it
    nivelImpureza = actualizarImpureza(nivelImpureza) {it + 23}

    println(nivelImpureza)

    //lambda suma
    val sumaLambda : (Int, Int) -> Int = { a , b -> a + b}
    println(operar(1,2, sumaLambda)) //Non se usa, as lambdas non se suelen asignar a variables
    println(operar(1,2, ::suma))
    println(operar(1,2) { a, b -> 2*a + b})
    println("------")
    val resultado = operar(5,4) { a, b ->
        println("Facendo unha lambda chunga...")
        if(b > a) {
            return@operar b
        }
        3*a

    }
    println("O resultado e: $resultado")

    //Orde do return nas funcions lambda
    println("------")
    val unhaListaSenFiltrar = listOf("rocha","pagoda","planta de plastico","xarron","maceta")
    val outroFiltro = unhaListaSenFiltrar.filter { nomeQueNonSexaIt -> //se usamos it esto non fai falta
        //Se convertimos en sequence esta lista, este print non se executa hasta que forces a evaluacion
        println(nomeQueNonSexaIt)
        //Este filtro devolve xarron ademais dos elementos que empezan por 'p'
        if(nomeQueNonSexaIt == "xarron"){
            return@filter true
        }
        nomeQueNonSexaIt[0] == 'p'
    }
    println("outro filtro: ${outroFiltro}")

}

//Funcion de orde superior
fun actualizarImpureza(impureza: Int, operacion: (Int) -> Int): Int {
    return operacion(impureza)
}

//Fucion para pasar como argumento
fun aumentarImpureza(impureza: Int) = impureza + 1

//Funcion de orde superior mais complexa
fun operar(a: Int, b: Int, operacion: (Int, Int) -> Int): Int {
    return operacion(a,b)
}

//Funcion suma
fun suma(a: Int, b: Int): Int = a + b