package projekt_z_pieniedzmi;

import java.math.BigDecimal;
import java.util.Objects;

import static java.lang.String.format;

public class Pieniadze {

    private BigDecimal kwota;
    private Waluta waluta;

    public Pieniadze(BigDecimal kwotaPoczatkowa, Waluta waluta) {
        this.kwota = kwotaPoczatkowa;
        this.waluta = waluta;
    }

    public Pieniadze przyjmijPieniadze(Pieniadze pieniadz) {
        sprawdzWalute(pieniadz);
        kwota = kwota.add(pieniadz.kwota);
        return new Pieniadze(kwota, waluta);
    }

    public Pieniadze pobierzPieniadze(Pieniadze pieniadz) throws JestesBiednyException {
        sprawdzWalute(pieniadz);
        if (!czyCieStac(pieniadz)) {
            throw new JestesBiednyException();
        }
        kwota = kwota.subtract(pieniadz.kwota);
        return new Pieniadze(kwota, waluta);
    }

    public boolean czyCieStac(Pieniadze pieniadz) {
        sprawdzWalute(pieniadz);
        return kwota.compareTo(pieniadz.kwota) >= 0;
    }

    public String toString() {
        return format("%.2f %s", kwota, waluta);
    }

    public Waluta getWaluta() {
        return waluta;
    }

    private void sprawdzWalute(Pieniadze pieniadz) {
        if (!waluta.equals(pieniadz.waluta)) {
            throw new NieTaWalutaException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pieniadze pieniadze = (Pieniadze) o;
        return Objects.equals(kwota, pieniadze.kwota) &&
                waluta == pieniadze.waluta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kwota, waluta);
    }
}