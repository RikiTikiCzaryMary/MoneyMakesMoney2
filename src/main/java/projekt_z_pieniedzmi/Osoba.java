package projekt_z_pieniedzmi;

import java.util.Objects;

import static java.lang.String.format;

public class Osoba {
    private String imie;
    private Portfel portfel;

    public Osoba(String imie) {
        this.portfel = new Portfel();
        this.imie = imie;
    }

    public boolean czyMaszPortfel() {
        return Objects.nonNull(portfel);
    }

    public void zaplac(Osoba komu, Pieniadze ile) {
        try {
            portfel.wyplac(ile);
            komu.przyjmij(ile);
        } catch(JestesBiednyException e) {
            System.out.println("Zabrakło mi pieniędzy!");
        }
    }

    public void przyjmij(Pieniadze ile) {
        portfel.wplac(ile);
    }

    public void audyt() {
        System.out.println(format("Jestem %s", imie));
        System.out.println(portfel.saldo());
    }
}