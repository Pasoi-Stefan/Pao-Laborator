package Profesor;

import Director.Clasa;
import Profesor.Profesor;

import java.util.ArrayList;

public class Diriginte extends Profesor {

    int NumarulClasei;
    char LiteraClasei;

    public Diriginte(Profesor p, int NumarulClasei, char LiteraClasei) {
        super(p);
        this.NumarulClasei = NumarulClasei;
        this.LiteraClasei = LiteraClasei;
    }

    public boolean daNotalaPurtare(int Nota, String ElevCNP) {
            ArrayList<Clasa> clase = super.laCeClaseTineOra();
            for(Clasa clasa: clase)
                if(clasa.getNumar() == NumarulClasei && clasa.getLitera() == LiteraClasei && clasa.getElevi().get(ElevCNP) != null) {
                    clasa.getElevi().get(ElevCNP).setNotaPurtare(Nota);
                    return true;
                }
            return false;
    }

}
