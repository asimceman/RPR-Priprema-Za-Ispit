package ba.unsa.etf.rpr;

import java.text.DecimalFormat;

import static java.lang.Math.floor;

public class Ucenik extends Osoba implements Comparable {
    String brojKnjizice = "";
    int ocjene[] = new int[100];
    int brojac = 0;


    void dodajOcjenu(int ocjena){
        if(ocjena<1 || ocjena>5)
            throw new IlegalnaOcjena("Ilegalna ocjena "+ocjena);
        if(brojac==100)
            throw new IllegalArgumentException("Dosegnut maksimalan broj ocjena");
        ocjene[brojac++]=ocjena;
    }


    public double prosjek(){
        if(brojac==0)
            return 0;
        int suma=0;
        for(int i=0; i<brojac; i++)
            suma+=ocjene[i];
        double prosjek = (double)suma/brojac;
        if(prosjek*100 == floor (prosjek*100))
            return prosjek;
        DecimalFormat df = new DecimalFormat("#.#");
        prosjek = Double.valueOf(df.format(prosjek));
        return prosjek;
    }

    public int[] getOcjene() {
        return ocjene;
    }

    public void setOcjene(int[] ocjene) {
        this.ocjene = ocjene;
    }

    public String getBrojKnjizice() {
        return brojKnjizice;
    }

    public void setBrojKnjizice(String brojKnjizice) {
        this.brojKnjizice = brojKnjizice;
    }

    public Ucenik(String imePrezime) {
        super(imePrezime);
    }

    @Override
    public String toString() {
        return super.toString();
    }


    @Override
    public int compareTo(Object o) {
        Ucenik ucenik = (Ucenik) o;
        if(this.prosjek()>((Ucenik) o).prosjek())
            return -1;
        return 1;
    }
}
