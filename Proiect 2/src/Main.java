import ClaseSingleton.Audit;
import StructuraLiceu.*;
import StructuraLiceu.Orar.OraProfesor;
import StructuraLiceu.Orar.Orar;
import StructuraLiceu.Orar.OrarPeZi;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Audit.initializeaza();

        LiceeleDinJudet liceeleDinJudet = new LiceeleDinJudet();

        Liceu liceu = new Liceu();
        liceeleDinJudet.adaugaLiceu(liceu);

        liceu.citeste();

        // Modificari la fisierele CSV

        liceu.adaugaProfesor("1870203030083", "Serafim Dumitru");

        liceu.adaugaElevLaClasa(new Elev("5020904240059", "Marius Savu"), 11, 'D');
        liceu.adaugaElevLaClasa(new Elev("5021119130023", "Danut Rudeanu"), 11, 'D');
        liceu.adaugaElevLaClasa(new Elev("6030626010010", "Livia Iacobescu"), 10, 'F');

        Orar prof = new Orar();

        OrarPeZi marti = new OrarPeZi();
        marti.adaugaOra(new OraProfesor(10, "Matematică", 10, 'F'));
        prof.setOrarPeZi("Marți", marti);

        OrarPeZi miercuri = new OrarPeZi();
        miercuri.adaugaOra(new OraProfesor(9, "Matematică", 11, 'D'));
        prof.setOrarPeZi("Miercuri", miercuri);

        liceu.getDirector().setOrarUnProfesor("1870203030083", prof);

        liceu.getProfesori().get("1870203030083").daNotaLaElev("5020904240059", 10, "Matematică");
        liceu.getProfesori().get("1870203030083").daNotaLaElev("5021119130023", 10, "Matematică");
        liceu.getProfesori().get("1870203030083").daNotaLaElev("6030626010010", 10, "Matematică");


        liceu.salveaza();
    }
}
