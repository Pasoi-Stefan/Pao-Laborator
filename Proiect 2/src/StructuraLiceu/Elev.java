package StructuraLiceu;

import ClaseSingleton.Audit;
import StructuraLiceu.DateStatice.MateriilePredate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeMap;

public class Elev {

    private String Nume;
    private String CNP;
    private int NumarulClasei;
    private char LiteraClasei;
    private int NotaPurtare;
    private TreeMap<String, ArrayList<Integer>> Note;

    public Elev(String CNP, String Nume) {
        this.Nume = Nume;
        this.CNP = CNP;
        this.Note = new TreeMap<String, ArrayList<Integer>>();
        for(String materie: MateriilePredate.get())
            this.Note.put(materie, new ArrayList<Integer>());
    }

    public String getNume() {
        return this.Nume;
    }
    public String getCNP() {
        return this.CNP;
    }
    public int getNumarulClasei() {
        return this.NumarulClasei;
    }
    public char getLiteraClasei() {
        return this.LiteraClasei;
    }
    public int getNotaPurtare() {
        return this.NotaPurtare;
    }
    public ArrayList<Integer> getNoteleLaMaterie(String Materie) {
        ArrayList<Integer> copie = new ArrayList<Integer>();
        for(Integer nota: this.Note.get(Materie))
            copie.add(nota);
        return copie;
    }
    public TreeMap<String, ArrayList<Integer>> getNote() {
        return this.Note;
    }

    public void setNumarulClasei(int numarulClasei) {
        this.NumarulClasei = numarulClasei;
    }
    public void setLiteraClasei(char literaClasei) {
        this.LiteraClasei = literaClasei;
    }
    public void adaugaNota(int Nota, String Materie) {
        this.Note.get(Materie).add(Nota);
    }

    void setNotaPurtare(int notaPurtare) {
        this.NotaPurtare = notaPurtare;
    }
    boolean primesteNotaLaMaterie(int Nota, String Materie) throws IOException {
        Audit.execute("primesteNotaLaMaterie");

        for(String materie: MateriilePredate.get())
            if(Objects.equals(materie, Materie)){
                this.Note.get(Materie).add(Nota);
                return true;
            }
        return false;
    }

    public int calculeazaMediaLaMaterie(String Materie) throws IOException {
        Audit.execute("calculeazaMediaLaMaterie");

        ArrayList<Integer> note = this.Note.get(Materie);
        if(note == null)
            return 0;

        double Media = 0;
        for(Integer nota: note)
            Media += nota;
        Media /= note.size();

        if(Math.ceil(Media) - Media <= 0.5)
            return (int)Math.ceil(Media);
        else
            return (int)Math.floor(Media);
    }

    public double calculeazaMedia() throws IOException {
        Audit.execute("calculeazaMedia");

        double Media = this.NotaPurtare;
        int NumarMaterii = 1;
        for(String materie: MateriilePredate.get()) {
            Media += this.calculeazaMediaLaMaterie(materie);
            NumarMaterii++;
        }
        Media /= NumarMaterii;
        return Media;

    }

    public void afiseazaNoteleLaMaterii() {
        System.out.println("Elevul " + this.Nume.toUpperCase() + " are urmatoarele note:");
        for(String materie: MateriilePredate.get()) {
            System.out.println(materie + ":");
            if(this.Note.get(materie).size() == 0)
                System.out.println("NICIO NOTA");
            else
                for (Integer nota : this.Note.get(materie))
                  System.out.println(nota);
        }
        System.out.println("Purtare: ");
        if(this.NotaPurtare == 0)
            System.out.println("NICIO NOTA");
        else
            System.out.println(this.NotaPurtare);
    }
}
