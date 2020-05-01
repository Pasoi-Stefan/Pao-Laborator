package StructuraLiceu;

import ClaseSingleton.*;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Liceu{

    private String Nume;
    private TreeMap<String, Profesor> Profesori;
    private TreeMap<String, Clasa>  Clase;
    private OrarProfesori orarProfesori;
    private Director director;

    public Liceu() {
        this.Profesori = new TreeMap<String, Profesor>();
        this.Clase = new TreeMap<String, Clasa>();
    }

    public Liceu(String Nume) {
        this.Nume = Nume;
        this.Profesori = new TreeMap<String, Profesor>();
        this.Clase = new TreeMap<String, Clasa>();
    }

    public OrarProfesori getOrarProfesori() {
        return this.orarProfesori;
    }
    public String getNume() {
        return this.Nume;
    }
    public TreeMap<String, Profesor> getProfesori() {
        return this.Profesori;
    }
    public TreeMap<String, Clasa> getClase() {
        return this.Clase;
    }
    public Director getDirector() {
        return this.director;
    }

    public void adaugaProfesor(String CNP, String Nume) {
        Profesor profesorNou = new Profesor(Nume, CNP, this);
        this.Profesori.put(CNP, profesorNou);
    }

    public void adaugaClasa(Clasa clasaNoua) {
        this.Clase.put(clasaNoua.getNumar() + " " + clasaNoua.getLitera(), clasaNoua);
    }
    public boolean alegeDirector(String ProfesorCNP) throws IOException {
        Audit.execute("alegeDirector");

        for(Map.Entry<String,Profesor> entry : this.Profesori.entrySet())
            if(entry.getValue().getClass() == Director.class)
                return false;
        if(!Profesori.containsKey(ProfesorCNP))
            return false;

        Profesor director = this.Profesori.get(ProfesorCNP);
        director = new Director(director);
        if(this.orarProfesori == null)
            this.orarProfesori = ((Director)director).getOrarProfesori();
        this.Profesori.put(ProfesorCNP, director);
        this.director = (Director)director;
        return true;
    }
    public void adaugaElevLaClasa(Elev elev, int NumarClasa, char LiteraClasa) throws IOException {
        Audit.execute("adaugaElevLaClasa");

        elev.setNumarulClasei(NumarClasa);
        elev.setLiteraClasei(LiteraClasa);
        this.Clase.get(NumarClasa + " " + LiteraClasa).adaugaElev(elev);
    }

    public void afiseazaProfesori() {
        for(Map.Entry<String, Profesor> entry: this.Profesori.entrySet())
            System.out.println(entry.getValue().getNume() + " " + entry.getValue().getClass().getSimpleName().toUpperCase());
    }
    public void afiseazaClasele() {
        for(Map.Entry<String, Clasa> entry: this.Clase.entrySet())
            System.out.println(entry.getValue().getNumar() + " " + entry.getValue().getLitera() + " " + entry.getValue().getDiriginte().getNume());
    }

    public void citeste() throws IOException {

        this.Nume = "Liceul Spiru Haret";

        CitireProfesori inProfi = CitireProfesori.getInstanta();
        inProfi.executa(this);

        CitireElevi inElevi = CitireElevi.getInstanta();
        inElevi.executa(this);

        CitireOre inOre = CitireOre.getInstanta();
        inOre.executa(this);

        CitireNote inNote = CitireNote.getInstanta();
        inNote.executa(this);

    }
    public void salveaza() throws IOException{

        ScriereProfesori outProfi = ScriereProfesori.getInstanta();
        outProfi.executa(this);

        ScriereElevi outElevi = ScriereElevi.getInstanta();
        outElevi.executa(this);

        ScriereOre outOre = ScriereOre.getInstanta();
        outOre.executa(this);

        ScriereNote outNote = ScriereNote.getInstanta();
        outNote.executa(this);

    }


}
