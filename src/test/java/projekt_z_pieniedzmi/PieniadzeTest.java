package projekt_z_pieniedzmi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PieniadzeTest {

    @org.junit.jupiter.api.Test
    void czyCieStac() {
        Pieniadze hajsBiedaka = new Pieniadze(BigDecimal.valueOf(20), Waluta.PLN);
        Pieniadze hajsBogacza = new Pieniadze(BigDecimal.valueOf(80), Waluta.PLN);
        Assertions.assertTrue(hajsBiedaka.czyCieStac(hajsBiedaka));
        }

        @Test
    void czyCieNieStac() {
        Pieniadze hajsBiedaka = new Pieniadze(BigDecimal.valueOf(20), Waluta.PLN);
        Pieniadze hajsBogacza = new Pieniadze(BigDecimal.valueOf(80), Waluta.PLN);
        Assertions.assertTrue(hajsBiedaka.czyCieStac(hajsBogacza));
    }

        @Test
    void CzyCieStacGdyMamyTyleSamo() {
        Pieniadze hajsBiedaka = new Pieniadze(BigDecimal.valueOf(20), Waluta.PLN);
        Pieniadze hajsBogacza = new Pieniadze(BigDecimal.valueOf(20), Waluta.PLN);
        Assertions.assertTrue(hajsBogacza.czyCieStac(hajsBiedaka));
    }
        @Test
    void CzyWalutaJestTaSama(){
        Pieniadze hajsBiedaka = new Pieniadze(BigDecimal.valueOf(20), Waluta.PLN);
        Pieniadze hajsBogacza = new Pieniadze(BigDecimal.valueOf(20), Waluta.PLN);
        Assertions.assertEquals(hajsBiedaka.getWaluta(),hajsBogacza.getWaluta());
        }
    }
