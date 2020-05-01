package StructuraLiceu;

import java.util.ArrayList;

public class LiceeleDinJudet {

    ArrayList<Liceu> listaLicee;

    public LiceeleDinJudet() {
        this.listaLicee = new ArrayList<Liceu>();
    }

    public void adaugaLiceu(Liceu liceu) {
        this.listaLicee.add(liceu);
    }

    public void afiseazaLicee() {
        System.out.println("Liceele din județ sunt:");
        for(Liceu liceu: this.listaLicee)
            System.out.println(liceu.getNume());
    }

}
