package cat.copernic.jmendezv

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {

    @Test
    fun imc() {
        assertEquals(27.77, 0.001, imc(90.00, 1.80))
    }
}