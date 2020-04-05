package PachetPrincipal;

import java.util.Objects;
import java.util.TreeMap;

public class Orar {

    private TreeMap<String, OrarPeZi> Set;

    public Orar() {
        Set = new TreeMap<String, OrarPeZi>();
        for(String s: ZileLucratoare.getZileLucratoare())
            Set.put(s, null);
    }

    public Orar(Orar o) {
        Set = new TreeMap<String, OrarPeZi>();
        for(String s: ZileLucratoare.getZileLucratoare())
            Set.put(s, o.getOrarPeZi(s));
    }


    public OrarPeZi getOrarPeZi(String s) {
        if(Set.get(s) == null)
            return null;
        return new OrarPeZi(Set.get(s));
    }

    public boolean setOrarPeZi(String s, OrarPeZi o) {
        for(String zi: ZileLucratoare.getZileLucratoare())
            if(Objects.equals(s, zi)) {
                Set.put(s, new OrarPeZi(o));
                return true;
            }
        return false;
    }

    public void afiseazaOrar() {
        for(String zi: ZileLucratoare.getZileLucratoare()){
            System.out.println(zi + ":");
            if(Set.get(zi) != null)
                Set.get(zi).afiseazaOrarPeZi();
            else
                System.out.println("__LIBER__");
        }
    }

}
