package StructuraLiceu;

import StructuraLiceu.Orar.Orar;
import java.util.TreeMap;

public class OrarProfesori {

    private TreeMap<String, Orar> orar;

    OrarProfesori() {
        this.orar = new TreeMap<String, Orar>();
    }

    public Orar getOrarUnProfesor(String ProfesorCNP) {
        if(this.orar.get(ProfesorCNP) == null)
            return null;
        else return new Orar(this.orar.get(ProfesorCNP));
    }

    void setOrarUnProfesor(String ProfesorCNP, Orar o) {
        this.orar.put(ProfesorCNP, new Orar(o));
    }

}
