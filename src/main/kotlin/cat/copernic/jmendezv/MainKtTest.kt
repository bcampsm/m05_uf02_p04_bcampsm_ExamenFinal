package cat.copernic.jmendezv

import org.junit.jupiter.api.*

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.awt.Point
import java.time.Duration
import java.util.stream.Stream


internal class MainKtTest {

    @BeforeEach
    @DisplayName("Inici de cada test")
    fun iniciCada() {
        System.out.println("Inicio test ...")
    }

    @AfterEach
    @DisplayName("Final de cada test")
    fun finalCada() {
        System.out.println("Final test...")
    }

    //FUN imc
    @Test
    @DisplayName("imc test 1 simple")
    fun imcTes1t() {
        assertEquals(27.77, 0.001, IMC(90.00, 1.80))
    }

    @ParameterizedTest
    @DisplayName("imc test 2 parametrizado methodsource")
    @MethodSource("provide")
    fun imcTest2(resultado: Double,a: Double, b:Double) {
        assertEquals(resultado, IMC(a, b))
    }

    @ParameterizedTest
    @DisplayName("imc test 3 parametrizado valuesource")
    @ValueSource(doubles = [27.77,25.00,16.00,10.00])
    fun imctest3(n: Double) {
        assertEquals(n, IMC(90.00, 1.80))
    }

    @ParameterizedTest
    @DisplayName("imc test 4 csvsource")
    @CsvSource("90.0, 1.8,27.77","50.0, 1.8,25.00","120.0, 1.8,16.00")
    fun imcTest4(peso: Double, altura:Double, resultat: Double) {
        assertEquals(resultat, 0.001, IMC(peso, altura))
    }

    @Test //test de timeout: si el test no se realiza en 2 milisegundos, nos muestra por pantalla "timeout"
    @DisplayName("Timeout ejemplo")
    fun `testing imc for timeout`() {
        val result =
            org.junit.jupiter.api.assertTimeout(
                Duration.ofMillis(2)) {
                assertEquals(27.77, 0.001, IMC(90.00, 1.80))
            }
    //        assert(true) { result }
        println("Timeout")
    }


//FUN equSegundoGrado
    @Test
    @DisplayName("equSegundoGrado test 1 simple")
    fun equSegundoGradoTes1t() {
        assertEquals(Pair(3,2), equSegundoGrado(1.00,-5.00,6.00))
    }

//FUN distanciaEntre2Puntos
    @Test
    @DisplayName("distanciaEntre2Puntos test 1 simple")
    fun ddistanciaEntre2PuntosTest1() {
        assertEquals(1.0, distanciaEntre2Puntos(Punto(3.0,0.0),Punto(4.0,0.0)))
    }

//FUN Pendiente
    @Test
    @DisplayName("Pendiente test 1 simple")
    fun PendienteTest1() {
        assertEquals(0.5333333333333332, Pendiente(Punto(3.0,5.4),Punto(6.0,7.0)))
        assertNotEquals(3.4, Pendiente(Punto(3.0,5.4),Punto(6.0,7.0)))

    }

//FUN puntoMedio
    @Test
    @DisplayName("puntoMedio test 1 simple")
    fun puntoMedioTest1() {
        assertEquals(Punto(2.0,2.0), puntoMedio(Punto(3.0,3.0),Punto(1.0,1.0)))//aqui el valor actual es diferente a FUN Pendiente y FUN distanciaEntre2Puntos, el actual ya no es un Double,es un valor de tipo Punto

    }

//FUN maxMin
    @Test
    fun maxMin() {
        assertEquals(Pair(1,7), maxMin(listOf(2,3,1,4,7,6,5)) )
        assertEquals(Pair(1,8), maxMin(listOf()) )// al pasar una lista vacia, tal como esta especificado en la funcion, nos devuelve un exception: java.lang.IllegalArgumentException: Empty list
    }

//FUN masCercano
    @Test
    @DisplayName("masCercano test 1 simple")
    fun masCercanoTest1() {
        assertEquals(Punto(2.0,2.0), masCercano(Punto(3.0,0.0), ))// no se como enviar points
    }

    companion object{

        @BeforeAll
        @JvmStatic
        @DisplayName("Inici de tots els tests")
        fun inici() {
            System.out.println("*** Inicio tests... ")
        }

        @AfterAll
        @JvmStatic
        @DisplayName("Final de tots els tests")
        fun final() {
            System.out.println("Final tests... ***")
        }

        @JvmStatic
        fun provide(): Stream<Arguments> {

            return Stream.of(
                Arguments.of(27.777777777777775, 90.00,1.80),//correcta
                Arguments.of(27.777777777777775,80.00,1.70),
                Arguments.of(27.777777777777775,50.00,1.50),
            )

        }
    }
}