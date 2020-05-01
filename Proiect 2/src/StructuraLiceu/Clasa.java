package StructuraLiceu;

import ClaseSingleton.Audit;
import StructuraLiceu.DateStatice.ZileLucratoare;
import StructuraLiceu.Orar.*;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Clasa {

    private int Numar;
    private char Litera;
    private TreeMap<String, Elev> Elevi;
    private Diriginte diriginte;

    Clasa(int Numar, char Litera) {
        this.Numar = Numar;
        this.Litera = Litera;
        this.Elevi = new TreeMap<String, Elev>();
    }

    public char getLitera() {
        return this.Litera;
    }
    public int getNumar() {
        return this.Numar;
    }
    public TreeMap<String, Elev> getElevi() {
        return this.Elevi;
    }
    public Diriginte getDiriginte() {
        return this.diriginte;
    }

    void setDiriginte(Diriginte diriginte) {
        this.diriginte = diriginte;
    }
    public void adaugaElev(Elev elev) {
        this.Elevi.put(elev.getCNP(), elev);
    }

    public Orar obtineOrarulClasei() throws IOException {
        Audit.execute("obtineOrarulClasei");

        Orar orarClasa = new Orar();
        for(String s: ZileLucratoare.get()){
            OrarPeZi orarPeZiClasa = new OrarPeZi();
            for(Map.Entry<String, Profesor> entry:  this.diriginte.getLiceu().getProfesori().entrySet()){
                Orar orar= this.diriginte.getLiceu().getOrarProfesori().getOrarUnProfesor(entry.getKey());
                if(orar != null && orar.getOrarPeZi(s) != null)
                    for(Ora ora: orar.getOrarPeZi(s).getListaOre())
                        if(((OraProfesor)ora).getNumarClasa() == this.Numar && ((OraProfesor)ora).getLiteraClasa() == this.Litera){
                            String NumeProfesor = this.diriginte.getLiceu().getProfesori().get(entry.getKey()).getNume();
                            orarPeZiClasa.adaugaOra(new OraClasa(new Ora(ora.getOraInceput(), ora.getMaterie()), NumeProfesor));
                        }
             }
            orarClasa.setOrarPeZi(s, orarPeZiClasa);
        }
        return orarClasa;
    }

    public void afiseazaClasa() {
        System.out.println("Clasa: " + this.Numar + " " + this.Litera);
        System.out.println("Diriginte: " + this.diriginte.getNume());
        System.out.println("Elevii: ");
        for(Map.Entry<String, Elev> entry: this.Elevi.entrySet())
            System.out.println(entry.getValue().getNume());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clasa clasa = (Clasa) o;
        return this.Numar == clasa.Numar && this.Litera == clasa.Litera;
    }

}
