package projekt_z_pieniedzmi;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class Portfel {
    private Map<Waluta, Pieniadze> pieniadze;

    public Portfel() {
        pieniadze = new HashMap<>();
    }

    public void wplac(Pieniadze ile) {
        if (pieniadze.containsKey(ile.getWaluta())) {
            pieniadze.get(ile.getWaluta()).przyjmijPieniadze(ile);
        } else {
            pieniadze.put(ile.getWaluta(), ile);
        }
    }

    public void wyplac(Pieniadze ile) throws JestesBiednyException {
        Pieniadze pieniadz = pieniadze.getOrDefault(ile.getWaluta(),
                new Pieniadze(BigDecimal.ZERO, ile.getWaluta()));
        pieniadz.pobierzPieniadze(ile);
    }

    public String saldo() {
        return format("W portfelu jest: %s", pieniadze);
    }
}
