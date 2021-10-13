package cat.copernic.jmendezv

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream


internal class MainKtTest {

    @Test
    fun imcTes1t() {
        assertEquals(27.77, 0.001, imc(90.00, 1.80))
    }

    @ParameterizedTest
    @MethodSource("provide")
    fun imcTest2(resultado: Double,a: Double, b:Double) {
        assertEquals(resultado, imc(a, b))
    }


    companion object{
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