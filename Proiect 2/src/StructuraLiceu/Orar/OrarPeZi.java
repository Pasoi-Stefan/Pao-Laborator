package StructuraLiceu.Orar;

import ClaseSingleton.Audit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class OrarPeZi {

    private TreeSet<Ora> Lista;

    public OrarPeZi() {
        this.Lista = new TreeSet<Ora>();
    }

    public OrarPeZi(OrarPeZi o) {
        this.Lista = new TreeSet<Ora>();
        for(Ora a: o.getListaOre())
            this.adaugaOra(a);
    }

    public int getNumarOre() {
        return this.Lista.size();
    }
    public ArrayList<Ora> getListaOre() {
            return new ArrayList<Ora>(this.Lista);
    }

    public void adaugaOra(Ora a) {
        this.Lista.add(a);
    }
    public boolean scoateOra(int OraDeInceput) {
        for(Ora a: this.Lista)
            if(a.getOraInceput() == OraDeInceput) {
                this.Lista.remove(a);
                return true;
            }
        return false;
    }

    public String ceMaterieLaOra(int OraInceput) throws IOException {
        Audit.execute("ceMaterieLaOra");

        for(Ora a: this.Lista)
            if(a.getOraInceput() == OraInceput)
                return a.getMaterie();

        return "";
    }
    public ArrayList<Integer> ceOreLaMaterie(String Materie) throws IOException {
        Audit.execute("ceOreLaMaterie");

        ArrayList<Integer> ore = new ArrayList<Integer>();
        for(Ora a: this.Lista)
            if(a.getMaterie().equals(Materie))
                ore.add(a.getOraInceput());
        return ore;
    }

    public void afiseazaOrarPeZi() {
        for(Ora ora: this.Lista)
            ora.afiseazaOra();
    }


}
