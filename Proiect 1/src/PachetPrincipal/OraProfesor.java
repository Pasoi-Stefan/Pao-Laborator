package PachetPrincipal;

public class OraProfesor extends Ora{

    private int NumarClasa;
    private char LiteraClasa;

    public OraProfesor(int OraInceput, String Materie, int NumarClasa, char LiteraClasa) {
        super(OraInceput, Materie);
        this.NumarClasa = NumarClasa;
        this.LiteraClasa = LiteraClasa;
    }

    public OraProfesor(Ora a, int NumarClasa, char LiteraClasa) {
        super(a);
        this.NumarClasa = NumarClasa;
        this.LiteraClasa = LiteraClasa;
    }

    public char getLiteraClasa() {
        return LiteraClasa;
    }
    public int getNumarClasa() {
        return NumarClasa;
    }

    @Override
    public void afiseazaOra() {
        System.out.println(getOraInceput() + " " + getMaterie() + " " + NumarClasa + " " + LiteraClasa);
    }

}
