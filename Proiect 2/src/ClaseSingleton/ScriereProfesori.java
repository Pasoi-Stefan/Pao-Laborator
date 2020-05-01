package ClaseSingleton;

import StructuraLiceu.Director;
import StructuraLiceu.Diriginte;
import StructuraLiceu.Liceu;
import StructuraLiceu.Profesor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ScriereProfesori {

    private static ScriereProfesori instanta = null;

    private ScriereProfesori() {

    }

    public static ScriereProfesori getInstanta() {

        if(instanta == null)
            instanta = new ScriereProfesori();
        return instanta;

    }

    public void executa(Liceu liceu) throws IOException {

        String caleFisier = "src/FisiereCSV/profesori.csv";
        FileWriter csvWriter = new FileWriter(caleFisier);

        for(Map.Entry<String, Profesor> entry: liceu.getProfesori().entrySet())
            if(entry.getValue().getClass() == Director.class) {

                String format = "";

                format = format + entry.getValue().getCNP() + ",";
                format = format + entry.getValue().getNume() + ",";
                format = format + entry.getValue().getClass().getSimpleName().toUpperCase();
                format = format + "\n";

                csvWriter.append(format);
                break;

            }

        for(Map.Entry<String, Profesor> entry: liceu.getProfesori().entrySet()) {
            String format = "";

            if(entry.getValue().getClass() == Director.class)
                continue;

            format = format + entry.getValue().getCNP() + ",";
            format = format + entry.getValue().getNume() + ",";
            format = format + entry.getValue().getClass().getSimpleName().toUpperCase();

            if(entry.getValue().getClass() == Diriginte.class) {

                format =  format + "," + String.valueOf(((Diriginte)entry.getValue()).getNumarulClasei()) + ",";
                format =  format + String.valueOf(((Diriginte)entry.getValue()).getLiteraClasei());

            }

            format = format + "\n";

            csvWriter.append(format);

        }

        csvWriter.flush();
        csvWriter.close();

    }

}
