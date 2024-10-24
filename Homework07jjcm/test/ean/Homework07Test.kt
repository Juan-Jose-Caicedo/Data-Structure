package ean

import ean.collections.TList
import ean.data.readDepartamentos
import ean.data.readMuns
import org.testng.Assert.*
import org.testng.annotations.Test

class Homework07Test {

    @Test
    fun testContarDigitos() {
        assertEquals(contarDigitos(1_215_677), 7)
        assertEquals(contarDigitos(1), 1)
        assertEquals(contarDigitos(865_711_981), 9)
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaNumeroDeCeros() {
        assertEquals(numeroDeCeros(2020), 2)
        assertEquals(numeroDeCeros(19_278), 0)
        assertEquals(numeroDeCeros(1_000_000), 6)
        assertEquals(numeroDeCeros(10_100_001), 5)
        assertEquals(numeroDeCeros(0), 1)
        assertEquals(numeroDeCeros(100_200), 4)
        assertEquals(numeroDeCeros(300_000_002), 7)
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaSumarDigitos() {
        assertEquals(sumarDigitos(5712), 15)
        assertEquals(sumarDigitos(1234), 10)
        assertEquals(sumarDigitos(0), 0)
        assertEquals(sumarDigitos(10_901_741), 23)
        assertEquals(sumarDigitos(11), 2)
        println("Prueba superada 👍")
    }

    @Test
    fun probarCantidadDigitosPares() {
        assertEquals(cantidadDigitosPares(816_425), 4)
        assertEquals(cantidadDigitosPares(73_911), 0)
        assertEquals(cantidadDigitosPares(4_816_420), 6)
        assertEquals(cantidadDigitosPares(214_816_420), 7)
        assertEquals(cantidadDigitosPares(7), 0)
        assertEquals(cantidadDigitosPares(71_208), 3)
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaInvertirNumero() {
        assertEquals(invertirNumero(7130), 317)
        assertEquals(invertirNumero(100_786), 687_001)
        assertEquals(invertirNumero(14), 41)
        assertEquals(invertirNumero(9), 9)
        assertEquals(invertirNumero(879_169), 961_978)
        println("Prueba superada 👍")
    }

    @Test
    fun probarEsNumeroBinario() {
        assertTrue(esNumeroBinario(11))
        assertTrue(esNumeroBinario(1_000_110))
        assertFalse(esNumeroBinario(410))
        assertFalse(esNumeroBinario(11_901))
        println("Prueba superada 👍")
    }

    @Test
    fun probarPoseeDigito() {
        assertTrue(poseeDigito(67_810, 7))
        assertTrue(poseeDigito(8_576, 8))
        assertFalse(poseeDigito(98_175, 4))
        assertFalse(poseeDigito(31_578_096, 2))
        println("Prueba superada 👍")
    }

    @Test
    fun probarDigitoMasGrande() {
        assertEquals(9, digitoMasGrande(17_928))
        assertEquals(1, digitoMasGrande(1_000))
        assertEquals(6, digitoMasGrande(26_403))
        assertEquals(4, digitoMasGrande(31_412))
        println("Prueba superada 👍")
    }

    @Test
    fun probarDigitos() {
        assertEquals(digitos(34_219), TList(3, 4, 2, 1, 9))
        assertEquals(digitos(8), TList(8))
        assertEquals(digitos(200_136), TList(2, 0, 0, 1, 3, 6))
        assertEquals(digitos(12_419_877), TList(1, 2, 4, 1, 9, 8, 7, 7))
        println("Prueba superada 👍")
    }

    @Test
    fun probarconvertirDecimalBinario() {
        assertEquals(convertirDecimalBinario(15), TList(1, 1, 1, 1), )
        assertEquals(convertirDecimalBinario(77), TList(1, 0, 0, 1, 1, 0, 1))
        assertEquals(convertirDecimalBinario(1024), TList(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
        assertEquals(convertirDecimalBinario(873), TList(1, 1, 0, 1, 1, 0, 1, 0, 0, 1))
        assertEquals(convertirDecimalBinario(8), TList(1, 0, 0, 0))
        println("Prueba superada 👍")
    }

    @Test
    fun probarContarVerbos1() {
        val pals = TList("comer", "ando", "andar", "partir", "suma", "sumar", "reir", "ir", "dono", "poder")
        assertEquals(contarVerbos1(pals), 7)
        assertEquals(contarVerbos1(TList("amor", "comi", "papa", "guerra")), 0)
        println("Prueba superada 👍")
    }

    @Test
    fun probarContarVerbos2() {
        val pals = TList("comer", "ando", "andar", "partir", "suma", "sumar", "reir", "ir", "dono", "poder")
        assertEquals(contarVerbos2(pals), 7)
        assertEquals(contarVerbos2(TList("amor", "comi", "papa", "guerra")), 0)
        println("Prueba superada 👍")
    }

    @Test
    fun probarPromParesLista() {
        assertEquals(promedioParesLista1(TList(40, 21, 8, 31, 6)), 18.0, 0.0)
        assertEquals(promedioParesLista1(TList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)), 6.0, 0.0)
        assertEquals(promedioParesLista1(TList(11, 21, 31, 41, 51, 61, 71)), 0.0)
        assertEquals(promedioParesLista1(TList(4, 10, 12, 11, 15, 8)), 8.5, 0.1)
        println("Prueba superada 👍")
    }

    @Test
    fun probarExisteElemento() {
        assertFalse(existeElemento(TList<Int>(), 11))
        assertFalse(existeElemento(TList<Int>(20), 11))
        assertTrue(existeElemento(TList("hola", "casa", "tierra", "rojo", "azul"), "casa"))
        assertFalse(existeElemento(TList("hola", "casa", "tierra", "rojo", "azul"), "perro"))
        assertTrue(existeElemento(TList(89, 11, -31, -289, 471, 264, 1000), 471))
        assertFalse(existeElemento(TList(89, 11, -31, -289, 471, 264, 1000), 2000))
        println("Prueba superada ☺️")
    }

    @Test
    fun probarSumaSuperficie() {
        val deptos = readDepartamentos()
        assertEquals(sumaSuperficies(deptos, "ANDINA"), 202_229.0, 0.0)
        assertEquals(sumaSuperficies(deptos, "CARIBE"), 98_105.0, 0.0)
        assertEquals(sumaSuperficies(deptos, "AMAZONÍA"), 402_845.0, 0.0)
        println("Prueba superada ☺️")
    }

    @Test
    fun probarDeptoMenorIDH1() {
        val deptos = readDepartamentos()
        assertEquals(deptoMenorIDH1(deptos, "ANDINA"), "NORTE DE SANTANDER")
        assertEquals(deptoMenorIDH1(deptos, "CARIBE"), "LA GUAJIRA")
        assertEquals(deptoMenorIDH1(deptos, "AMAZONÍA"), "CAQUETÁ")
        assertEquals(deptoMenorIDH1(deptos, "ORINOQUÍA"), "VICHADA")
        assertNull(deptoMenorIDH1(deptos, "COLOMBIA"))
        println("Prueba superada ☺️")
    }

    @Test
    fun probarDeptoMenorIDH2() {
        val deptos = readDepartamentos()
        assertEquals(deptoMenorIDH2(deptos, "ANDINA"), "NORTE DE SANTANDER")
        assertEquals(deptoMenorIDH2(deptos, "CARIBE"), "LA GUAJIRA")
        assertEquals(deptoMenorIDH2(deptos, "AMAZONÍA"), "CAQUETÁ")
        assertEquals(deptoMenorIDH2(deptos, "ORINOQUÍA"), "VICHADA")
        assertNull(deptoMenorIDH2(deptos, "COLOMBIA"))
        println("Prueba superada ☺️")
    }

    @Test
    fun munMayor1() {
        val deptos = readDepartamentos()
        val muns = readMuns(deptos)

        var m = municipioMayorPoblUrbana(muns, "ANDINA")
        assertNotNull(m)
        assertEquals(m?.codigo, 9)
        assertEquals(m?.nombre, "SOACHA")

        m = municipioMayorPoblUrbana(muns, "CARIBE")
        assertNotNull(m)
        assertEquals(m!!.codigo, 4)
        assertEquals(m.departamento.nombre, "ATLÁNTICO")

        m = municipioMayorPoblUrbana(muns, "PACÍFICO")
        assertNotNull(m)
        assertEquals(m!!.codigo, 45)
        assertEquals(m.nombre, "CARTAGO")
        assertEquals(m.poblacionRural, 1904)

        m = municipioMayorPoblUrbana(muns, "SANTANDER")
        assertNull(m)
        println("Prueba superada ☺️")
    }

    @Test
    fun munMayor2() {
        val deptos = readDepartamentos()
        val muns = readMuns(deptos)

        var m = municipioMayorPoblUrbana2(muns, "ANDINA")
        assertNotNull(m)
        assertEquals(m?.codigo, 9)
        assertEquals(m?.nombre, "SOACHA")

        m = municipioMayorPoblUrbana2(muns, "CARIBE")
        assertNotNull(m)
        assertEquals(m!!.codigo, 4)
        assertEquals(m.departamento.nombre, "ATLÁNTICO")

        m = municipioMayorPoblUrbana2(muns, "PACÍFICO")
        assertNotNull(m)
        assertEquals(m!!.codigo, 45)
        assertEquals(m.nombre, "CARTAGO")
        assertEquals(m.poblacionRural, 1904)

        m = municipioMayorPoblUrbana2(muns, "SANTANDER")
        assertNull(m)
        println("Prueba superada ☺️")
    }


}