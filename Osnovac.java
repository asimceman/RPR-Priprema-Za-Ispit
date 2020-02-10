package ba.unsa.etf.rpr;

public class Osnovac extends Ucenik {
    public Osnovac(String imePrezime) {
        super(imePrezime);
    }



    @Override
    public String toString() {
        return "Učenik osnovne škole " + getImePrezime()+ " (" + getBrojKnjizice() + "), prosjek ocjena: " +prosjek();
    }
}
