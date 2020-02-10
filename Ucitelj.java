package ba.unsa.etf.rpr;

import java.time.LocalDate;

public class Ucitelj extends Nastavnik {
    public Ucitelj(String imePrezime) {
        super(imePrezime);
    }

    @Override
    public String toString() {
        return "Učitelj "+getImePrezime();
    }

    public String rodjendan(LocalDate datum){
        if(datum.getMonth().equals(LocalDate.now().getMonth()) && datum.getDayOfMonth() == LocalDate.now().getDayOfMonth())
            return "Sretan rodjendan!";
        return "";
    }
}
