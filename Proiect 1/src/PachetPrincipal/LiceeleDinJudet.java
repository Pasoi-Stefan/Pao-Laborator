package PachetPrincipal;

import java.util.ArrayList;

public class LiceeleDinJudet {

    ArrayList<Liceu> listaLicee;

    public LiceeleDinJudet() {
        listaLicee = new ArrayList<Liceu>();
    }

    public void adaugaLiceu(Liceu liceu) {
        listaLicee.add(liceu);
    }

    public void afiseazaLicee() {
        System.out.println("Liceele din județ sunt:");
        for(Liceu liceu: listaLicee)
            System.out.println(liceu.getNume());
    }

}
