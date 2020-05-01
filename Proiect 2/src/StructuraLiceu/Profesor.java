package StructuraLiceu;

import ClaseSingleton.Audit;
import StructuraLiceu.DateStatice.ZileLucratoare;
import StructuraLiceu.Orar.*;

import java.io.IOException;
import java.util.ArrayList;

public class Profesor {

    private String Nume;
    private String CNP;
    private Liceu liceu;

    public Profesor(String Nume, String CNP, Liceu liceu) {
        this.Nume = Nume;
        this.CNP = CNP;
        this.liceu = liceu;
    }

    public Profesor(Profesor p) {
        this.Nume = p.Nume;
        this.CNP = p.CNP;
        this.liceu = p.liceu;
    }

    public void clasa() {
        System.out.println(this.getClass());
    }

    public Liceu getLiceu() {
        return this.liceu;
    }
    public String getCNP() {
        return this.CNP;
    }
    public String getNume() {
        return this.Nume;
    }
    public Orar getOrar() {
        return this.liceu.getOrarProfesori().getOrarUnProfesor(this.CNP);
    }

    public ArrayList<Clasa> laCeClaseTineOre() throws IOException {
        Audit.execute("laCeClaseTineOre");

        ArrayList<Clasa> clase = new ArrayList<Clasa>();
        Orar orar = getOrar();
        for(String s: ZileLucratoare.get())
            if(orar.getOrarPeZi(s) != null)
                for(Ora ora: orar.getOrarPeZi(s).getListaOre()) {
                    String cheie = ((OraProfesor)ora).getNumarClasa() + " " + ((OraProfesor)ora).getLiteraClasa();
                    Clasa clasa = this.liceu.getClase().get(cheie);
                    if(!clase.contains(clasa))
                        clase.add(clasa);
                }
        return clase;
    }

    public boolean daNotaLaElev(String ElevCNP, int Nota, String Materie) throws IOException {
        Audit.execute("daNotaLaElev");

        ArrayList<Clasa> clase = this.laCeClaseTineOre();
        for(Clasa clasa: clase)
            if(clasa.getElevi().containsKey(ElevCNP))
                return clasa.getElevi().get(ElevCNP).primesteNotaLaMaterie(Nota, Materie);
        return false;
    }


}
