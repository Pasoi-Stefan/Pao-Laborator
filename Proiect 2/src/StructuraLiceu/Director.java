package StructuraLiceu;

import ClaseSingleton.Audit;
import StructuraLiceu.Clasa;
import StructuraLiceu.Orar.Orar;
import StructuraLiceu.Diriginte;
import StructuraLiceu.Profesor;

import java.io.IOException;


public class Director extends Profesor {

    private OrarProfesori orarProfesori;

    public Director(Profesor p) {
        super(p);
        this.orarProfesori = new OrarProfesori();
    }

    public OrarProfesori getOrarProfesori() {
        return this.orarProfesori;
    }

    public Clasa formeazaClasa(int Numar, char Litera, String ProfesorCNP) throws IOException {
        Audit.execute("formeazaClasa");

        Clasa clasaNoua = new Clasa(Numar, Litera);
        alegeDiriginte(ProfesorCNP, clasaNoua);
        return clasaNoua;
    }

    void alegeDiriginte(String ProfesorCNP, Clasa clasaNoua) throws IOException {
        Audit.execute("alegeDiriginte");

        Profesor diriginte = super.getLiceu().getProfesori().get(ProfesorCNP);
        diriginte = new Diriginte(diriginte, clasaNoua.getNumar(), clasaNoua.getLitera());
        super.getLiceu().getProfesori().put(ProfesorCNP, diriginte);
        clasaNoua.setDiriginte((Diriginte)diriginte);
    }

    public void setOrarUnProfesor(String ProfesorCNP, Orar o) throws IOException {
        Audit.execute("setOrarUnProfesor");

        this.orarProfesori.setOrarUnProfesor(ProfesorCNP, o);
    }

}
