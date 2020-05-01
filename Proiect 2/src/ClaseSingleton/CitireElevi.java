package ClaseSingleton;

import StructuraLiceu.Liceu;
import StructuraLiceu.Elev;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CitireElevi {

    private static CitireElevi instanta = null;

    private CitireElevi() {

    }

    public static CitireElevi getInstanta() {

        if(instanta == null)
            instanta = new CitireElevi();
        return instanta;

    }

    public void executa(Liceu liceu) throws IOException {

        String caleFisier = "src/FisiereCSV/elevi.csv";

        FileReader fisier_citire = new FileReader(caleFisier);
        BufferedReader csvReader = new BufferedReader(fisier_citire);

        String linie = null;
        String[] date = null;

        while((linie = csvReader.readLine()) != null) {

            date = linie.split(",");

            liceu.adaugaElevLaClasa(new Elev(date[0], date[1]), Integer.parseInt(date[2]), date[3].charAt(0));

        }

        csvReader.close();

    }

}
