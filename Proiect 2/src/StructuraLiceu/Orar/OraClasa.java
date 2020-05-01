package StructuraLiceu.Orar;

public class OraClasa extends Ora {

    private String ProfesorNume;

    public OraClasa(int OraInceput, String Materie, String ProfesorNume) {
        super(OraInceput, Materie);
        this.ProfesorNume = ProfesorNume;
    }

    public OraClasa(Ora a, String ProfesorNume) {
        super(a);
        this.ProfesorNume = ProfesorNume;
    }

    public String getProfesorCNP() {
        return this.ProfesorNume;
    }

    @Override
    public void afiseazaOra() {
        System.out.println(getOraInceput() + " " + getMaterie() + " " + this.ProfesorNume.toUpperCase());
    }
}
