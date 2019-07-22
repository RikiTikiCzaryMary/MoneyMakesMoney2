package projekt_z_pieniedzmi;

import java.math.BigDecimal;

import static java.lang.String.format;

public class Pieniadze {

    private BigDecimal kwota;
    private Waluta waluta;


    public Pieniadze(BigDecimal kwotaPoczatkowa, Waluta waluta) {
        this.kwota = kwotaPoczatkowa;
        this.waluta = waluta;
    }

    public Pieniadze przyjmijPieniadze(Pieniadze pieniadz) {
        this.kwota = this.kwota.add(pieniadz.kwota);
        return new Pieniadze(kwota,waluta);
    }

    public Pieniadze pobierzPieniadze(Pieniadze pieniadz) throws JestesBiednyException {

        if (!czyCieStac(pieniadz)) {
            throw new JestesBiednyException();
        }
        this.kwota = this.kwota.remainder(pieniadz.kwota);
        return new Pieniadze(kwota, waluta);
    }

    public boolean czyCieStac(Pieniadze pieniadz) {
        return kwota.compareTo(pieniadz.kwota) >= 0;
    }

    public String toString() {
        return format("%.2f %s", kwota, waluta);
    }

    public Waluta getWaluta() {
        return waluta;
    }
}
