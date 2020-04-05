package Profesor;

import PachetPrincipal.MateriilePredate;

import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeMap;

public class Elev {

    private String Nume;
    private String CNP;
    private int NumarulClasei;
    private char LiteraClasei;
    private double MediaAdmitere;
    private int NotaPurtare;
    private TreeMap<String, ArrayList<Integer>> Note;

    public Elev(String Nume, String CNP, double MediaAdmitere) {
        this.Nume = Nume;
        this.CNP = CNP;
        this.MediaAdmitere = MediaAdmitere;
        Note = new TreeMap<String, ArrayList<Integer>>();
        for(String materie: MateriilePredate.getMateriilePredate())
            Note.put(materie, new ArrayList<Integer>());
    }

    public String getNume() {
        return Nume;
    }
    public String getCNP() {
        return CNP;
    }
    public int getNumarulClasei() {
        return NumarulClasei;
    }
    public char getLiteraClasei() {
        return LiteraClasei;
    }
    public int getNotaPurtare() {
        return NotaPurtare;
    }
    public ArrayList<Integer> getNoteleLaMaterie(String Materie) {
        ArrayList<Integer> copie = new ArrayList<Integer>();
        for(Integer nota: Note.get(Materie))
            copie.add(nota);
        return copie;
    }
    public TreeMap<String, ArrayList<Integer>> getNote() {
        return Note;
    }

    public void setNumarulClasei(int numarulClasei) {
        NumarulClasei = numarulClasei;
    }
    public void setLiteraClasei(char literaClasei) {
        LiteraClasei = literaClasei;
    }
    public void setNotaPurtare(int notaPurtare) {
        NotaPurtare = notaPurtare;
    }

    boolean primesteNotaLaMaterie(int Nota, String Materie) {
        for(String materie: MateriilePredate.getMateriilePredate())
            if(Objects.equals(materie, Materie)){
                Note.get(Materie).add(Nota);
                return true;
            }
        return false;
    }

    public int calculeazaMediaLaMaterie(String Materie) {
        ArrayList<Integer> note = Note.get(Materie);
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

    public double calculeazaMedia() {

        double Media = NotaPurtare;
        int NumarMaterii = 1;
        for(String materie: MateriilePredate.getMateriilePredate()) {
            Media += calculeazaMediaLaMaterie(materie);
            NumarMaterii++;
        }
        Media /= NumarMaterii;
        return Media;

    }

    public void afiseazaNoteleLaMaterii() {
        System.out.println("Elevul " + Nume.toUpperCase() + " are urmatoarele note:");
        for(String materie: MateriilePredate.getMateriilePredate()) {
            System.out.println(materie + ":");
            if(Note.get(materie).size() == 0)
                System.out.println("NICIO NOTA");
            else
                for (Integer nota : Note.get(materie))
                  System.out.println(nota);
        }
        System.out.println("Purtare: ");
        if(NotaPurtare == 0)
            System.out.println("NICIO NOTA");
        else
            System.out.println(NotaPurtare);
    }
}
