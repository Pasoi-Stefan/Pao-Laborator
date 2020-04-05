package Director;

import PachetPrincipal.*;
import Profesor.*;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Clasa {

    private int Numar;
    private char Litera;
    private TreeMap<String, Elev> Elevi;
    private Diriginte diriginte;

    Clasa(int Numar, char Litera) {
        this.Numar = Numar;
        this.Litera = Litera;
        Elevi = new TreeMap<String, Elev>();
    }

    public char getLitera() {
        return Litera;
    }
    public int getNumar() {
        return Numar;
    }
    public TreeMap<String, Elev> getElevi() {
        return Elevi;
    }
    public Diriginte getDiriginte() {
        return diriginte;
    }

    void setDiriginte(Diriginte diriginte) {
        this.diriginte = diriginte;
    }
    public void adaugaElev(Elev elev) {
        Elevi.put(elev.getCNP(), elev);
    }

    public Orar obtineOrarulClasei() {
        Orar orarClasa = new Orar();
        for(String s: ZileLucratoare.getZileLucratoare()){
            OrarPeZi orarPeZiClasa = new OrarPeZi();
            for(Map.Entry<String, Profesor> entry:  diriginte.getLiceu().getProfesori().entrySet()){
                Orar orar= diriginte.getLiceu().getOrarProfesori().getOrarUnProfesor(entry.getKey());
                if(orar != null && orar.getOrarPeZi(s) != null)
                    for(Ora ora: orar.getOrarPeZi(s).getListaOre())
                        if(((OraProfesor)ora).getNumarClasa() == Numar && ((OraProfesor)ora).getLiteraClasa() == Litera){
                            String NumeProfesor = diriginte.getLiceu().getProfesori().get(entry.getKey()).getNume();
                            orarPeZiClasa.adaugaOra(new OraClasa(new Ora(ora.getOraInceput(), ora.getMaterie()), NumeProfesor));
                        }
             }
            orarClasa.setOrarPeZi(s, orarPeZiClasa);
        }
        return orarClasa;
    }

    public void afiseazaClasa() {
        System.out.println("Clasa: " + Numar + " " + Litera);
        System.out.println("Diriginte: " + diriginte.getNume());
        System.out.println("Elevii: ");
        for(Map.Entry<String, Elev> entry: Elevi.entrySet())
            System.out.println(entry.getValue().getNume());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clasa clasa = (Clasa) o;
        return Numar == clasa.Numar && Litera == clasa.Litera;
    }

}
