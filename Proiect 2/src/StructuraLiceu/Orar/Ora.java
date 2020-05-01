package StructuraLiceu.Orar;

import java.util.Objects;

public class Ora implements Comparable<Ora>{

    private int OraInceput;
    private String Materie;

    public Ora(int OraInceput, String Materie) {
        this.OraInceput = OraInceput;
        this.Materie = Materie;
    }
    public Ora(Ora a) {
        this.OraInceput = a.OraInceput;
        this.Materie = a.Materie;
    }

    public int getOraInceput() {
        return this.OraInceput;
    }
    public String getMaterie(){
        return this.Materie;
    }

    @Override
    public int compareTo(Ora a) {
        return this.OraInceput - a.OraInceput;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ora ora = (Ora) o;
        return this.OraInceput == ora.OraInceput &&
                Objects.equals(this.Materie, ora.Materie);
    }

    public void afiseazaOra() {
        System.out.println(this.OraInceput + " " + this.Materie);
    }


}

