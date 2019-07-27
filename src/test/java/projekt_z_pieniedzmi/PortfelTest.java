package projekt_z_pieniedzmi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.Port;
import java.math.BigDecimal;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.*;

class PortfelTest {

    @org.junit.jupiter.api.Test
    void wplac() throws JestesBiednyException {

        Portfel portfel = new Portfel();
        portfel.wplac(new Pieniadze(BigDecimal.valueOf(100), Waluta.PLN));
        portfel.wplac(new Pieniadze(BigDecimal.valueOf(50), Waluta.PLN));
        portfel.wyplac(new Pieniadze(BigDecimal.valueOf(30), Waluta.PLN));
        portfel.wplac(new Pieniadze(BigDecimal.valueOf(40), Waluta.USD));
        portfel.wyplac(new Pieniadze(BigDecimal.valueOf(15), Waluta.USD));

        Assertions.assertEquals(portfel.saldo(), "W portfelu jest: {USD=25,00 USD, PLN=120,00 PLN}");
    }

    @Test
    void wplacInaczej() {
        Pieniadze pieniadze1 = new Pieniadze(BigDecimal.valueOf(360), Waluta.PLN);
        Pieniadze pieniadze2 = new Pieniadze(BigDecimal.valueOf(140), Waluta.PLN);
        Assertions.assertEquals(pieniadze1.przyjmijPieniadze(pieniadze2), new Pieniadze(BigDecimal.valueOf(500),Waluta.PLN));

    }

    @org.junit.jupiter.api.Test
    void wyplac() throws JestesBiednyException {

        Portfel portfel = new Portfel();
        portfel.wplac(new Pieniadze(BigDecimal.valueOf(100), Waluta.PLN));
        portfel.wplac(new Pieniadze(BigDecimal.valueOf(50), Waluta.PLN));
        portfel.wyplac(new Pieniadze(BigDecimal.valueOf(30), Waluta.PLN));
        portfel.wplac(new Pieniadze(BigDecimal.valueOf(80), Waluta.USD));
        portfel.wyplac(new Pieniadze(BigDecimal.valueOf(25), Waluta.USD));


        Assertions.assertEquals(portfel.saldo(), "W portfelu jest: {USD=55,00 USD, PLN=120,00 PLN}");
    }
}