package projekt_z_pieniedzmi;

import java.util.Objects;

public class Osoba {
    private Portfel portfel;

    public Osoba() {
        portfel = new Portfel();
    }

    public boolean czyMaszPortfel() {

        Objects.nonNull(portfel);
    }

    public void zaplac(Osoba komu, Pieniadze ile) {

        try {
            portfel.wyplac(ile);
            komu.przyjmij(ile);
        } catch(JestesBiednyException e) {
            System.out.println("Nie śmierdzę groszem");
        }

    }

    public void przyjmij(Pieniadze ile) {
        portfel.wplac(ile);
    }
}
