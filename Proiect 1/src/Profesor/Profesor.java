package Profesor;

import Director.Clasa;
import PachetPrincipal.*;

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
        Nume = p.Nume;
        CNP = p.CNP;
        liceu = p.liceu;
    }

    public Liceu getLiceu() {
        return liceu;
    }
    public String getCNP() {
        return CNP;
    }
    public String getNume() {
        return Nume;
    }
    public Orar getOrar() {
        return liceu.getOrarProfesori().getOrarUnProfesor(CNP);
    }

    public ArrayList<Clasa> laCeClaseTineOra() {
        ArrayList<Clasa> clase = new ArrayList<Clasa>();
        Orar orar = getOrar();
        for(String s: ZileLucratoare.getZileLucratoare())
            if(orar.getOrarPeZi(s) != null)
                for(Ora ora: orar.getOrarPeZi(s).getListaOre()) {
                    String cheie = ((OraProfesor)ora).getNumarClasa() + " " + ((OraProfesor)ora).getLiteraClasa();
                    Clasa clasa = liceu.getClase().get(cheie);
                    if(!clase.contains(clasa))
                        clase.add(clasa);
                }
        return clase;
    }

    public boolean daNotaLaElev(int Nota, String Materie, String ElevCNP) {
        ArrayList<Clasa> clase = laCeClaseTineOra();
        for(Clasa clasa: clase)
            if(clasa.getElevi().containsKey(ElevCNP))
                return clasa.getElevi().get(ElevCNP).primesteNotaLaMaterie(Nota, Materie);
        return false;
    }


}
