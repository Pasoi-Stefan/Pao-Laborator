package PachetPrincipal;

import Director.*;
import Profesor.*;

import java.util.Map;
import java.util.TreeMap;

public class Liceu {

    private String Nume;
    private TreeMap<String, Profesor> Profesori;
    private TreeMap<String, Clasa>  Clase;
    private OrarProfesori orarProfesori;
    private Director director;

    Liceu(String Nume) {
        this.Nume = Nume;
        Profesori = new TreeMap<String, Profesor>();
        Clase = new TreeMap<String, Clasa>();
    }

    public OrarProfesori getOrarProfesori() {
        return orarProfesori;
    }
    public String getNume() {
        return Nume;
    }
    public TreeMap<String, Profesor> getProfesori() {
        return Profesori;
    }
    public TreeMap<String, Clasa> getClase() {
        return Clase;
    }
    public Director getDirector() {
        return director;
    }

    public void adaugaProfesor(String Nume, String CNP) {
        Profesor profesorNou = new Profesor(Nume, CNP, this);
        Profesori.put(CNP, profesorNou);
    }

    public void adaugaClasa(Clasa clasaNoua) {
        Clase.put(clasaNoua.getNumar() + " " + clasaNoua.getLitera(), clasaNoua);
    }
    public boolean alegeDirector(String ProfesorCNP) {
        for(Map.Entry<String,Profesor> entry : Profesori.entrySet())
            if(entry.getValue().getClass() == Director.class)
                return false;
        if(!Profesori.containsKey(ProfesorCNP))
            return false;

        Profesor director = Profesori.get(ProfesorCNP);
        director = new Director(director);
        if(orarProfesori == null)
            orarProfesori = ((Director)director).getOrarProfesori();
        Profesori.put(ProfesorCNP, director);
        this.director = (Director)director;
        return true;
    }
    public void adaugaElevLaClasa(Elev elev, int NumarClasa, char LiteraClasa) {
        elev.setNumarulClasei(NumarClasa);
        elev.setLiteraClasei(LiteraClasa);
        Clase.get(NumarClasa + " " + LiteraClasa).adaugaElev(elev);
    }

    public void afiseazaProfesori() {
        for(Map.Entry<String, Profesor> entry: Profesori.entrySet())
            System.out.println(entry.getValue().getNume() + " " + entry.getValue().getClass().getSimpleName().toUpperCase());
    }

    public void afiseazaClasele() {
        for(Map.Entry<String, Clasa> entry: Clase.entrySet())
            System.out.println(entry.getValue().getNumar() + " " + entry.getValue().getLitera() + " " + entry.getValue().getDiriginte().getNume());
    }


}
