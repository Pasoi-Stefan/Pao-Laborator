package PachetPrincipal;

import java.util.Objects;

public class Ora implements Comparable<Ora>{

    private int OraInceput;
    private String Materie;

    public Ora(int OraInceput, String Materie) {
        this.OraInceput = OraInceput;
        this.Materie = Materie;
    }
    public Ora(Ora a) {
        OraInceput = a.OraInceput;
        Materie = a.Materie;
    }

    public int getOraInceput() {
        return OraInceput;
    }
    public String getMaterie(){
        return Materie;
    }

    @Override
    public int compareTo(Ora a) {
        return OraInceput - a.OraInceput;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ora ora = (Ora) o;
        return OraInceput == ora.OraInceput &&
                Objects.equals(Materie, ora.Materie);
    }

    public void afiseazaOra() {
        System.out.println(OraInceput + " " + Materie);
    }


}

