package StructuraLiceu.Orar;

// import OrarPeZi;
import StructuraLiceu.DateStatice.ZileLucratoare;

import java.util.Objects;
import java.util.TreeMap;

public class Orar {

    private TreeMap<String, OrarPeZi> Set;

    public Orar() {
        this.Set = new TreeMap<String, OrarPeZi>();
        for(String s: ZileLucratoare.get())
            this.Set.put(s, null);
    }

    public Orar(Orar o) {
        this.Set = new TreeMap<String, OrarPeZi>();
        for(String s: ZileLucratoare.get())
            this.Set.put(s, o.getOrarPeZi(s));
    }


    public OrarPeZi getOrarPeZi(String s) {
        if(this.Set.get(s) == null)
            return null;
        return new OrarPeZi(this.Set.get(s));
    }

    public boolean setOrarPeZi(String s, OrarPeZi o) {
        for(String zi: ZileLucratoare.get())
            if(Objects.equals(s, zi)) {
                this.Set.put(s, new OrarPeZi(o));
                return true;
            }
        return false;
    }

    public void afiseazaOrar() {
        for(String zi: ZileLucratoare.get()){
            System.out.println(zi + ":");
            if(this.Set.get(zi) != null)
                this.Set.get(zi).afiseazaOrarPeZi();
            else
                System.out.println("__LIBER__");
        }
    }

}
