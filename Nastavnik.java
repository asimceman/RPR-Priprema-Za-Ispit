package ba.unsa.etf.rpr;

public class Nastavnik extends Osoba {
    public Nastavnik(String imePrezime) {
        super(imePrezime);
    }

    @Override
    public String toString() {
        return "Nastavnik osnovne škole " + getImePrezime();
    }
}
