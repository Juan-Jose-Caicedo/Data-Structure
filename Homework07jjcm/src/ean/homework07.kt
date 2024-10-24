package ean

import ean.collections.TList
import ean.data.Departamento
import ean.data.Municipio
import ean.utils.pow

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 *
 * Taller Funciones Recursivas
 * Fecha: 15 de octubre de 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~
 */

/**
 * Función recursiva que
 * Permite saber la cantidad de digitos
 * que posee un número entero positivo n
 * Use recursión directa.
 */
fun contarDigitos(n: Int): Int =
    when {
        n < 10 -> 1
        else -> 1 + contarDigitos(n / 10)
    }

/**
 * Función recursiva que
 * Permite saber el número de ceros que tiene un número.
 * Por ejemplo: 2020 tiene dos ceros.
 * Use recursión directa.
 */
fun numeroDeCeros(n: Int): Int =
    when {
        n < 10 -> if (n==0) 1 else 0
        else -> {
            val resto = n/10
            val ult = n%10
            numeroDeCeros(resto) + if(ult==0) 1 else 0
        }
    }

/**
 * Función recursiva que
 * permite hallar la suma de los dígitos de un
 * número entero positivo n
 * Use acumulación de parámetros.
 */
fun sumarDigitos(n: Int): Int =
    when {
        n < 10 -> n
        else -> {
            val r = n/10
            val ult = n%10
            sumarDigitos(r) + ult
        }
    }
fun sumarDigitos2(n: Int): Int {
    fun sumDigitosAux(n:Int,suma:Int):Int=
        when {
            n == 0 -> suma
            else -> {
                val r = n/10
                val ult = n%10
                sumDigitosAux(r,suma+ult)
            }

        }
    return sumDigitosAux(n,0)
}
/**
 * Función recursiva que
 * Cuenta el número de dígitos pares que tiene
 * un número entero positivo >= 0. (0 es par)
 * Use recursión directa.
 */
fun cantidadDigitosPares(n: Int): Int =
    when {
        n == 0 -> 0
        else -> {
            val r = n / 10
            val ult = n % 10
            if (ult % 2 == 0) {
                1 + cantidadDigitosPares(r)
            } else {
                cantidadDigitosPares(r)
            }
        }
    }

/**
 * Función recursiva que retorna el número
 * entero dado, pero con los dígitos en el
 * orden inverso. Ejemplo: si el número
 * es 61781 debe retornar 18_716
 * Use recursión directa
 */
fun invertirNumero(n: Int): Int =
    when {
        n < 10 -> n
        else -> {
            val r = n / 10
            val ult = n % 10
            (ult * 10.pow(contarDigitos(r))) + invertirNumero(r)
        }
    }

/**
 * Función recursiva que
 * Determina si el número dado es binario o no.
 * Los números binarios solo contienen
 * los dígitos 1 y 0. Por ejemplo: el numero 100011110
 * es binario, pero 231 no lo es
 * Use recursión directa
 */
fun esNumeroBinario(n: Int): Boolean =
    when {
        n < 10 && n == 1 || n == 0 -> true
        n < 10 && n > 1 -> false
        else -> {
            val r = n / 10
            val ult = n%10
            esNumeroBinario(r) && (ult == 1 || ult == 0)
        }
    }

/**
 * Función recursiva que
 * Permite saber si el número dado posee el dígito indicado
 * Use el algoritmo de recursión directa
 * que se presenta a continuación.
 */
fun poseeDigito(n: Int, digito: Int): Boolean =
    /*
    si el numero n posee un solo digito, entonces
       si n y el digito son iguales ->
         retorne true
       sino
         retorne false
    sino si el número n tiene más de un dígito, entonces
       si el ultimo dígito del número n es igual al dígito, entonces
         listo, lo encontramos, retorne true
       sino
         halle el resto de n
         mire si el resto de n posee el dígito indicado
     */
    when {
        n < 10 && n == digito -> true
        n < 10 && n != digito -> false
        else -> {
            val r = n/10
            val ult = n%10
            if (ult == digito){
                true
            } else {
                poseeDigito(r, digito)
            }
        }
    }

/**
 * Escriba una función recursiva que
 * Retorne el dígito más grande que hace parte del número n
 * Ejemplo: el dígito más grande del númer 381704 es el 8
 * El algoritmo de recursión directa es el siguiente:
 * Si el número tiene un solo dígito,
 *   el digito más grande es el numero, retórnelo
 * sino
 *    halle el resto y el último
 *    halla el digito mas grande del resto
 *    retorne el mayor entre el último y el dígito más grande del resto
 */
fun digitoMasGrande(n: Int): Int =
    when {
        n < 10 -> n
        else -> {
            val r = n / 10
            val ult = n % 10
            val maxR = digitoMasGrande(r)
            maxOf(maxR, ult)
        }
    }

/**
 * Obtiene recursivamente la lista de los dígitos
 * del número entero positivo n
 * Ejemplo: digitos(351804) == [3, 5, 1, 8, 0, 4]
 * Use recursión directa
 */
fun digitos(n: Int): TList<Int> =
    when {
        n < 10 -> TList(n)
        else -> {
            val r = n / 10
            val ult = n % 10
            val lr = digitos(r)
            lr.append(ult)
            lr
        }
    }
/**
 * Escriba una función recursiva en la que
 * Dado un número entero positivo >= 0,
 * retorna una lista con la representación binaria
 * del número dado.
 * Ejemplo: convertirDecimalBinario(231) = [1, 1, 0, 0, 1, 1, 1, 1, 1, 1]
 * Use recursión por acumulación de parámetros
 */
fun convertirDecimalBinario(n: Int): TList<Int> =
    when {
        n < 2 -> TList(n)
        else -> {
            val r = n/2
            val ult = n%2
            val binario = convertirDecimalBinario(r)
            binario.append(ult)
            binario
        }
    }
/**
 * Escriba una función recursiva que
 * retorne cuantas palabras en la lista son verbos.
 * Use recursión directa
 */
fun contarVerbos1(palabras: TList<String>): Int =
     when {
         palabras.isEmpty -> 0
         else -> {
             val pal = palabras.first
             val r = palabras.rest
             if (pal.endsWith("ar") || pal.endsWith("er") || pal.endsWith("ir")) {
                 contarVerbos1(r) + 1
             } else {
                 contarVerbos1(r)
             }
         }
     }

/**
 * Escriba una función recursiva que
 * retorne cuantas palabras en la lista son verbos.
 * Use recursión por acumulación de parámetros
 */
fun contarVerbos2(palabras: TList<String>): Int {
    fun contaraux(palabras: TList<String>, cont:Int): Int {
        if (palabras.isEmpty) {
            return cont
        }
        val pal = palabras.first
        val r = palabras.rest
        if ( pal.endsWith("ar") || pal.endsWith("er") || pal.endsWith("ir")) {
            return contaraux(r, cont+1)
        }
        return contaraux(r, cont)
    }
    return contaraux(palabras, 0)
}

/**
 * Recursion con listas:
 * Hallar el promedio de los números pares de la lista que
 * se recibe como parámetro.
 * Ejemplo: promedioParesLista1([40, 21, 8, 31, 6]) == 18.0
 * Use recursión por acumulación de parámetros
 */
fun promedioParesLista1(lista: TList<Int>): Double {
    fun promedioParesAux(lista: TList<Int>, c: Int): Int {
        return when {
            lista.isEmpty -> c
            else -> {
                when {
                    lista.first % 2 == 0 ->
                        promedioParesAux(lista.rest, c+1)
                    else ->
                        promedioParesAux(lista.rest, c)
                }
            }
        }
    }
    fun suma(lista:TList<Int>, c:Int): Int {
        return when {
            lista.isEmpty -> c
            else -> {
                when {
                    lista.first % 2 == 0 ->
                        suma(lista.rest, c+lista.first)
                    else ->
                        suma(lista.rest, c)
                }
            }
        }
    }
    val c = promedioParesAux(lista, 0)
    val s = suma(lista, 0)
    return if (s == 0) 0.0 else s.toDouble() / c
}

/**
 * Función genérica y recursiva que permite saber si un
 * elemento está dentro de la lista. No debe usarse la
 * función find o contains. Debe ser recursiva.
 * Para saber si existe un elemento con recursión directa:
 * - si la lista está vacía, el elemento no está, retorne falso
 * - si el primero de la lista es igual al elemento, retornamos true (el elemento está)
 * - en cualquier otro caso, entonces hay que ver si el elemento existe en el resto de la lista
 */
fun <T> existeElemento(lista: TList<T>, elem: T): Boolean =
    when {
        lista.isEmpty -> false
        lista.first == elem -> true
        else -> {
            val ultimo = lista.last
            val resto = lista.rest
            existeElemento(resto, elem)
        }
    }

/**
 * Escriba una función recursiva
 * que reciba una lista de departamentos
 * y retorne la suma de la superficie de
 * aquellos departamentos que pertenecen
 * a la región que se pasa como parámetro
 * y cuyo nombre tiene más de 5 letras
 * Use recursión por acumulación de parámetros
 */
fun sumaSuperficies(deptos: TList<Departamento>, region: String): Double {
    fun aux(deptos: TList<Departamento>, region: String, suma: Double): Double {
        return when {
            deptos.isEmpty -> suma
            else -> {
                val d = deptos.first
                if (d.region == region && d.nombre.length > 5) {
                    aux(deptos.rest, region, suma + d.superficie)
                } else {
                    aux(deptos.rest, region, suma)
                }
            }
        }
    }
    return aux(deptos, region, 0.0)
}

/**
 * Función recursiva que retorna el nombre
 * del departamento con el menor IDH y que
 * pertenece a la región que se recibe
 * como parámetro.
 * Retorne null cuando la lista sea vacía
 * Use recursión por acumulación de parámetros
 */
fun deptoMenorIDH1(deptos: TList<Departamento>, region: String): String? {
    fun aux(deptos: TList<Departamento>, region: String, menor: Departamento?): Departamento? {
        return when {
            deptos.isEmpty -> menor
            else -> {
                val d = deptos.first
                if (d.region == region &&
                    (menor == null || d.idh < menor.idh)
                ) {
                    aux(deptos.rest, region, d)
                } else {
                    aux(deptos.rest, region, menor)
                }
            }
        }
    }
    return aux(deptos, region, null)?.nombre
}

/**
 * Función recursiva que retorna el nombre
 * del departamento con el menor IDH y que
 * pertenece a la región que se recibe
 * como parámetro.
 * Retorne null cuando la lista sea vacía
 * Use recursión directa
 */
fun deptoMenorIDH2(deptos: TList<Departamento>, region: String): String? {
    fun aux(deptos:TList<Departamento>, region: String): Departamento? {
        return when {
            deptos.isEmpty -> null
            else -> {
                val f = deptos.first
                val idh = aux(deptos.rest, region)
                if(f.region == region && (idh == null || f.idh < idh.idh)) {
                    f
                } else {
                    idh
                }

            }
        }
    }
    return aux(deptos, region)?.nombre
}

/**
 * Escriba una función recursiva
 * que halle el municipio que tenga una población
 * rural inferior a 10 mil habitantes
 * y que pertenece aun departamento que
 * está en la región igual a la región que se
 * pasa como parámetro y que tiene la población
 * urbana más grande de toda la lista.
 * Retorne null si la lista es vacía
 * Use recursión por acumulación de parámetros
 */
fun municipioMayorPoblUrbana(muns: TList<Municipio>, region: String): Municipio? {
    fun aux(muns: TList<Municipio>, region: String, mayor: Municipio?): Municipio? {
        return when {
            muns.isEmpty -> mayor
            else -> {
                val m = muns.first
                if(m.poblacionRural < 10000 && m.departamento.region == region && (mayor == null || m.poblacionUrbana > mayor.poblacionUrbana)) {
                    aux(muns.rest, region, m)
                    }
                else {
                    aux(muns.rest,region, mayor)
                }
            }
        }
    }
    return aux(muns, region, null)
}

/**
 * Escriba una función recursiva
 * que halle el municipio que tenga una población
 * rural inferior a 10 mil habitantes
 * y que pertenece aun departamento que
 * está en la región igual a la región que se
 * pasa como parámetro y que tiene la población
 * urbana más grande de toda la lista.
 * Retorne null si la lista es vacía
 * Use recursión directa
 */
fun municipioMayorPoblUrbana2(muns: TList<Municipio>, region: String): Municipio? =
    when {
        muns.isEmpty -> null
        else -> {
            val m = muns.first
            val m2 = municipioMayorPoblUrbana2(muns.rest, region)
            if (m.poblacionRural < 10000 && m.departamento.region == region && (m2 == null || m.poblacionUrbana > m2.poblacionUrbana)) {
                m
            } else {
                m2
            }
        }
    }


class match(val gf: Int, val ga: Int, val ot: String) {
    fun won(): Boolean {
        return gf > ga
    }
    fun drawn(): Boolean {
        return gf == ga
    }
    fun lost(): Boolean {
        return gf < ga
    }
}
class soccerteam(val name: String) {
    fun puntostotales(m: TList<match>): Int {
        return when {
            m.isEmpty -> 0
            else -> {
                val f = m.first
                val p = puntostotales(m.rest)
                if (f.won()) {
                    p + 3
                } else if (f.drawn()) {
                    p + 1
                } else {
                    p
                }
            }
        }
    }
    fun ganoPartido(otherteam: String, m: TList<match>): Boolean? {
        return when {
            m.isEmpty -> null
            else -> {
                val f = m.first
                val l = m.rest
                if (f.ot == otherteam && f.won()) {
                    true
                } else {
                    ganoPartido(otherteam, l)
            }
        }
        }
}