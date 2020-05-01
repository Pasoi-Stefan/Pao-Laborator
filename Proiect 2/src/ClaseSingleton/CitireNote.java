package ClaseSingleton;

import StructuraLiceu.Liceu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CitireNote {

    private static CitireNote instanta = null;

    private CitireNote() {

    }

    public static CitireNote getInstanta() {

        if(instanta == null)
            instanta = new CitireNote();
        return instanta;

    }

    public void executa(Liceu liceu) throws IOException {

        String caleFisier = "src/FisiereCSV/note.csv";

        FileReader fisierCitire = new FileReader(caleFisier);
        BufferedReader csvReader = new BufferedReader(fisierCitire);

        String linie = null;
        String[] date = null;

        while((linie = csvReader.readLine()) != null) {

            date = linie.split(",");

            if(date[3].equals("Purtare"))
                liceu.getClase().get(date[0]).getDiriginte().daNotalaPurtare(date[1], Integer.parseInt(date[2]));
            else
                liceu.getClase().get(date[0]).getElevi().get(date[1]).adaugaNota(Integer.parseInt(date[2]), date[3]);

        }

        csvReader.close();
    }

}
