package projekt_z_pieniedzmi;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Osoba osoba1 = new Osoba();
        Osoba osoba2 = new Osoba();

        osoba1.zaplac(osoba2, new Pieniadze(BigDecimal.TEN));
    }
}
