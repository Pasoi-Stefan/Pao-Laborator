package Director;

import PachetPrincipal.Orar;
import Profesor.*;


public class Director extends Profesor{

    private OrarProfesori orarProfesori;

    public Director(Profesor p) {
        super(p);
        orarProfesori = new OrarProfesori();
    }

    public OrarProfesori getOrarProfesori() {
        return orarProfesori;
    }

    public Clasa formeazaClasa(int Numar, char Litera, String ProfesorCNP) {
        Clasa clasaNoua = new Clasa(Numar, Litera);
        alegeDiriginte(ProfesorCNP, clasaNoua);
        return clasaNoua;
    }

    void alegeDiriginte(String ProfesorCNP, Clasa clasaNoua) {
        Profesor diriginte = super.getLiceu().getProfesori().get(ProfesorCNP);
        diriginte = new Diriginte(diriginte, clasaNoua.getNumar(), clasaNoua.getLitera());
        super.getLiceu().getProfesori().put(ProfesorCNP, diriginte);
        clasaNoua.setDiriginte((Diriginte)diriginte);
    }

    public void setOrarUnProfesor(String ProfesorCNP, Orar o) {
        orarProfesori.setOrarUnProfesor(ProfesorCNP, o);
    }

}
