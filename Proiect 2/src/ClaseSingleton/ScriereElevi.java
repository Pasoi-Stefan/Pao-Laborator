package ClaseSingleton;

import StructuraLiceu.Clasa;
import StructuraLiceu.Liceu;
import StructuraLiceu.Elev;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ScriereElevi {

    private static ScriereElevi instanta = null;

    private ScriereElevi() {

    }

    public static ScriereElevi getInstanta() {

        if(instanta == null)
            instanta = new ScriereElevi();
        return instanta;

    }

    public void executa(Liceu liceu) throws IOException {

        String caleFisier = "src/FisiereCSV/elevi.csv";
        FileWriter csvWriter = new FileWriter(caleFisier);

        for(Map.Entry<String, Clasa> entry1: liceu.getClase().entrySet())
            for(Map.Entry<String, Elev> entry2: entry1.getValue().getElevi().entrySet()) {

                String format = "";
                format = format + entry2.getValue().getCNP() + ",";
                format = format + entry2.getValue().getNume() + ",";
                format = format + String.valueOf(entry2.getValue().getNumarulClasei()) + ",";
                format = format + String.valueOf(entry2.getValue().getLiteraClasei()) + "\n";

                csvWriter.append(format);

            }

        csvWriter.flush();
        csvWriter.close();

    }

}
