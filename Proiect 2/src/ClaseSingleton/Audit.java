package ClaseSingleton;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Audit {

    private static Audit instanta = null;
    private static boolean activat = false;

    private Audit() {

    }

    public static Audit getInstanta() {

        if(instanta == null)
            instanta = new Audit();
        return instanta;

    }

    public static void execute(String numeFunctie) throws IOException {

        if(!activat) return;

        String caleFisier = "src/FisiereCSV/audit.csv";
        FileWriter csvWriter = new FileWriter(caleFisier, true);

        LocalDateTime dataActuala = LocalDateTime.now();
        DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String timestamp = dataActuala.format(dataFormat);

        csvWriter.append(numeFunctie + "," + timestamp + "\n");

        csvWriter.flush();
        csvWriter.close();
    }

    public static void initializeaza() throws IOException {
        activat = true;

        String caleFisier = "src/FisiereCSV/audit.csv";
        FileWriter csvWriter = new FileWriter(caleFisier);
        csvWriter.close();
    }
}
