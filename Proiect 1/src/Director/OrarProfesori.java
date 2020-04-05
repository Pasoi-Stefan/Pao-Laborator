package Director;

import PachetPrincipal.Orar;
import java.util.TreeMap;

public class OrarProfesori {

    private TreeMap<String, Orar> orar;

    OrarProfesori() {
        orar = new TreeMap<String, Orar>();
    }

    public Orar getOrarUnProfesor(String ProfesorCNP) {
        if(orar.get(ProfesorCNP) == null)
            return null;
        else return new Orar(orar.get(ProfesorCNP));
    }

    void setOrarUnProfesor(String ProfesorCNP, Orar o) {
        orar.put(ProfesorCNP, new Orar(o));
    }

}
