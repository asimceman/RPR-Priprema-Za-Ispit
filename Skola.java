package ba.unsa.etf.rpr;

import java.sql.Wrapper;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Skola {
    private List<Osoba> osobe = new ArrayList<>();

    public void dodajOsobu(Osoba osoba) {
        osobe.add(osoba);
    }

    @Override
    public String toString() {
        int i=0;
        String s="";
        for(Osoba o : osobe){
            s+=o.toString();
            if(i==osobe.size()-1)
                break;
            i++;
            s+="\n";
        }
        return s;
    }

    public Set<Ucenik> ucenici() {
        Set<Ucenik> ucenici = new TreeSet<>();
        for(Osoba o : osobe){
            if(o instanceof Ucenik)
                ucenici.add((Ucenik) o);
        }
        return ucenici;
    }

    public List<Osoba> filtriraj(Predicate<Osoba> func) {
        return osobe.stream().filter(osoba -> func.test(osoba)).collect(Collectors.toList());
    }

    public List<Osnovac> topOsnovac() {
        List<Osoba> osnovci = filtriraj(osoba -> osoba instanceof Osnovac && ((Osnovac) osoba).prosjek()>=4);
        return osnovci.stream().map(osoba -> (Osnovac) osoba).collect(Collectors.toList());
    }

    public List<Slavljenik> slavljenici() {
        List<Osoba> slavljenici = filtriraj(osoba -> (osoba instanceof Ucitelj || osoba instanceof Srednjoskolac));

        List<Slavljenik> s = new ArrayList<>();
        slavljenici = slavljenici.stream().map(osoba -> (Osoba) osoba).collect(Collectors.toList());
        s=slavljenici.stream().map(osoba -> (Slavljenik) osoba).collect(Collectors.toList());

        //.addAll(slavljenici);
        return s;

    }
}
