package PachetPrincipal;

import java.util.ArrayList;
import java.util.TreeSet;

public class OrarPeZi {

    private TreeSet<Ora> Lista;

    public OrarPeZi() {
        Lista = new TreeSet<Ora>();
    }

    public OrarPeZi(OrarPeZi o) {
        Lista = new TreeSet<Ora>();
        for(Ora a: o.getListaOre())
            this.adaugaOra(a);
    }

    public int getNumarOre() {
        return Lista.size();
    }
    public ArrayList<Ora> getListaOre() {
            return new ArrayList<Ora>(Lista);
    }

    public void adaugaOra(Ora a) {
        Lista.add(a);
    }
    public boolean scoateOra(int OraDeInceput) {
        for(Ora a: Lista)
            if(a.getOraInceput() == OraDeInceput) {
                Lista.remove(a);
                return true;
            }
        return false;
    }

    public String ceMaterieLaOra(int OraInceput) {
        for(Ora a: Lista)
            if(a.getOraInceput() == OraInceput)
                return a.getMaterie();

        return "";
    }
    public ArrayList<Integer> ceOreLaMaterie(String Materie) {
        ArrayList<Integer> ore = new ArrayList<Integer>();
        for(Ora a: Lista)
            if(a.getMaterie().equals(Materie))
                ore.add(a.getOraInceput());
        return ore;
    }

    public void afiseazaOrarPeZi() {
        for(Ora ora: Lista)
            ora.afiseazaOra();
    }


}
