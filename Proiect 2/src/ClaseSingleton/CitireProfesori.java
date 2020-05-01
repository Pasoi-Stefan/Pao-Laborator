package ClaseSingleton;

import StructuraLiceu.Liceu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CitireProfesori {

    private static CitireProfesori instanta = null;

    private CitireProfesori() {

    }

    public static CitireProfesori getInstanta() {

        if(instanta == null)
            instanta = new CitireProfesori();
        return instanta;

    }

    public void executa(Liceu liceu) throws IOException {

        String caleFisier = "src/FisiereCSV/profesori.csv";

        FileReader fisierCitire = new FileReader(caleFisier);
        BufferedReader csvReader = new BufferedReader(fisierCitire);

        String linie = csvReader.readLine();
        String[] date = linie.split(",");

        liceu.adaugaProfesor(date[0], date[1]);
        liceu.alegeDirector(date[0]);

        while((linie = csvReader.readLine()) != null) {

            date = linie.split(",");
            liceu.adaugaProfesor(date[0], date[1]);

            if(date[2].equals("DIRIGINTE"))
                liceu.adaugaClasa(liceu.getDirector().formeazaClasa(Integer.parseInt(date[3]), date[4].charAt(0), date[0]));

        }

        csvReader.close();

    }

}