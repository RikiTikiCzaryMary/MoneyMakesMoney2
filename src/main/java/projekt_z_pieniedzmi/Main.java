package projekt_z_pieniedzmi;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Osoba osoba1 = new Osoba("Franciszek");
        Osoba osoba2 = new Osoba("Zenon");

        osoba1.przyjmij(new Pieniadze(BigDecimal.TEN, Waluta.PLN));

        osoba1.audyt();
        osoba2.audyt();

        osoba1.zaplac(osoba2, new Pieniadze(BigDecimal.TEN, Waluta.PLN));

        osoba1.audyt();
        osoba2.audyt();
    }
}
