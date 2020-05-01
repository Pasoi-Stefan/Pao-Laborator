package StructuraLiceu;

import ClaseSingleton.Audit;

import java.io.IOException;
import java.util.ArrayList;

public class Diriginte extends Profesor {

    int NumarulClasei;
    char LiteraClasei;

    public int getNumarulClasei() {
        return NumarulClasei;
    }

    public char getLiteraClasei() {
        return LiteraClasei;
    }

    public Diriginte(Profesor p, int NumarulClasei, char LiteraClasei) {
        super(p);
        this.NumarulClasei = NumarulClasei;
        this.LiteraClasei = LiteraClasei;
    }

    public boolean daNotalaPurtare(String ElevCNP, int Nota) throws IOException {
        Audit.execute("daNotalaPurtare");

        ArrayList<Clasa> clase = super.laCeClaseTineOre();
        for(Clasa clasa: clase)
            if(clasa.getNumar() == this.NumarulClasei && clasa.getLitera() == this.LiteraClasei && clasa.getElevi().get(ElevCNP) != null) {
                clasa.getElevi().get(ElevCNP).setNotaPurtare(Nota);
                return true;
            }
        return false;
    }

}
