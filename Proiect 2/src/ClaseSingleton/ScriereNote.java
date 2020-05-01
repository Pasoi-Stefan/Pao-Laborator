package ClaseSingleton;

import StructuraLiceu.Clasa;
import StructuraLiceu.Liceu;
import StructuraLiceu.Elev;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class ScriereNote {

    private static ScriereNote instanta = null;

    private ScriereNote() {

    }

    public static ScriereNote getInstanta() {

        if(instanta == null)
            instanta = new ScriereNote();
        return instanta;

    }

    public void executa(Liceu liceu) throws IOException {

        String caleFisier = "src/FisiereCSV/note.csv";
        FileWriter csvWriter = new FileWriter(caleFisier);

        for(Map.Entry<String, Clasa> entry1: liceu.getClase().entrySet())
            for(Map.Entry<String, Elev> entry2: entry1.getValue().getElevi().entrySet()) {
                for(Map.Entry<String, ArrayList<Integer>> entry3: entry2.getValue().getNote().entrySet())
                    for(Integer nota: entry3.getValue()) {

                        String format = "";

                        format = format + entry1.getKey() + ",";
                        format = format + entry2.getKey() + ",";
                        format = format + String.valueOf(nota) + ",";
                        format = format + entry3.getKey() + "\n";

                        csvWriter.append(format);
                    }

                if(entry2.getValue().getNotaPurtare() != 0) {

                    String format = "";

                    format = format + entry1.getKey() + ",";
                    format = format + entry2.getKey() + ",";
                    format = format + String.valueOf(entry2.getValue().getNotaPurtare()) + ",";
                    format = format + "Purtare\n";

                    csvWriter.append(format);
                }

            }

        csvWriter.flush();
        csvWriter.close();
    }

}
