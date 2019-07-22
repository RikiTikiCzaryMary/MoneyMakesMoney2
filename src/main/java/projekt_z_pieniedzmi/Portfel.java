package projekt_z_pieniedzmi;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


import static java.lang.String.format;

public class Portfel {

    Map<Waluta, Pieniadze> kasa = new HashMap<>();


    public Portfel() {

    }

    public void wplac(Pieniadze ile) {
        kasa.get(ile.getWaluta()).przyjmijPieniadze(ile); 
    }

    public void wyplac(Pieniadze ile) throws JestesBiednyException {

        if (kasa.containsKey(Waluta.PLN)) {
            kasa.get(ile.getWaluta()).pobierzPieniadze(ile);
        }

        public String saldo () {
            return format("W portfelu jest: %s", kasa);
        }


    }
}