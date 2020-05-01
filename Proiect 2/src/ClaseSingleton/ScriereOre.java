package ClaseSingleton;

import StructuraLiceu.DateStatice.ZileLucratoare;
import StructuraLiceu.Liceu;
import StructuraLiceu.Orar.Ora;
import StructuraLiceu.Orar.OraProfesor;
import StructuraLiceu.Orar.OrarPeZi;

import java.io.FileWriter;
import java.io.IOException;

public class ScriereOre {

    private static ScriereOre instanta = null;

    private ScriereOre() {

    }

    public static ScriereOre getInstanta() {

        if(instanta == null)
            instanta = new ScriereOre();
        return instanta;

    }

    public void executa(Liceu liceu) throws IOException {

        String caleFisier = "src/FisiereCSV/ore.csv";
        FileWriter csvWriter = new FileWriter(caleFisier);

        for(String cnp: liceu.getProfesori().keySet())
            for(String zi: ZileLucratoare.get()) {

                OrarPeZi orarpezi = liceu.getOrarProfesori().getOrarUnProfesor(cnp).getOrarPeZi(zi);

                if(orarpezi != null)
                    for(Ora ora: orarpezi.getListaOre()) {

                        String format = "";
                        format = format + cnp + ",";
                        format = format + zi + ",";
                        format = format + String.valueOf(ora.getOraInceput()) + ",";
                        format = format + ora.getMaterie() + ",";
                        format = format + String.valueOf(((OraProfesor)ora).getNumarClasa()) + ",";
                        format = format + String.valueOf(((OraProfesor)ora).getLiteraClasa()) + "\n";

                        csvWriter.append(format);

                    }

            }

        csvWriter.flush();
        csvWriter.close();
    }

}
