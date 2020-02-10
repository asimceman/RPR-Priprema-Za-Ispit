package ba.unsa.etf.rpr;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Srednjoskolac extends Ucenik {
    public Srednjoskolac(String imePrezime) {
        super(imePrezime);
    }
    private int nizSrednja[] = new int[100];
    private int brojac=0;
    public void dodajOcjenuSrednja(int ocjena){
        if(ocjena<1 || ocjena>5)
            throw new IlegalnaOcjena("Ilegalna ocjena "+ocjena);
        if(brojac==100)
            throw new IllegalArgumentException("Dosegnut maksimalan broj ocjena");
        nizSrednja[brojac++]=ocjena;
    }
    double prosjekSrednja(){
        if(brojac==0)
            return 0;
        int suma=0;
        for(int i=0; i<brojac; i++)
            suma+=nizSrednja[i];
        return (double)suma/brojac;
    }

    @Override
    public double prosjek() {
        int suma=0;
        for(int i=0; i<super.brojac; i++)
            suma+=ocjene[i];
        for(int i=0; i<brojac; i++)
            suma+=nizSrednja[i];
        if(suma==0)
            return 0;
        double prosjek = (double)suma/(brojac+super.brojac);
        DecimalFormat df = new DecimalFormat("#.#");
        prosjek = Double.valueOf(df.format(prosjek));
        return prosjek;
    }

    @Override
    public String toString() {
        return "Učenik srednje škole " + getImePrezime()+ " (" + getBrojKnjizice() + "), prosjek ocjena: " +prosjek();
    }

    public String rodjendan(LocalDate datum){
        if(datum.getMonth().equals(LocalDate.now().getMonth()) && datum.getDayOfMonth() == LocalDate.now().getDayOfMonth())
            return "Sretan rodjendan!";
        return "";
    }
}
