package ClaseSingleton;

import StructuraLiceu.Liceu;
import StructuraLiceu.Orar.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CitireOre {

    private static CitireOre instanta = null;

    private CitireOre() {

    }

    public static CitireOre getInstanta() {

        if(instanta == null)
            instanta = new CitireOre();
        return instanta;

    }

    public void executa(Liceu liceu) throws IOException {

        String caleFisier = "src/FisiereCSV/ore.csv";

        FileReader fisier_citire = new FileReader(caleFisier);
        BufferedReader csvReader = new BufferedReader(fisier_citire);

        String linie = csvReader.readLine();
        String[] date = linie.split(",");

        String cnpCurent = date[0], cnpAnterior;
        String ziCurenta = date[1], ziAnterioara;

        Orar orarProf = new Orar();
        OrarPeZi orarZiua = new OrarPeZi();

        orarZiua.adaugaOra(new OraProfesor(new Ora(Integer.parseInt(date[2]), date[3]), Integer.parseInt(date[4]), date[5].charAt(0)));

        while((linie = csvReader.readLine()) != null) {

            date = linie.split(",");

            cnpAnterior = cnpCurent;
            ziAnterioara = ziCurenta;

            cnpCurent = date[0];
            ziCurenta = date[1];

            if(cnpCurent.equals(cnpAnterior)) {

                if(!ziCurenta.equals(ziAnterioara)) {

                    orarProf.setOrarPeZi(ziAnterioara, orarZiua);
                    orarZiua = new OrarPeZi();
                }
            }
            else {

                orarProf.setOrarPeZi(ziAnterioara, orarZiua);
                liceu.getDirector().setOrarUnProfesor(cnpAnterior, orarProf);

                orarZiua = new OrarPeZi();
                orarProf = new Orar();
            }

            orarZiua.adaugaOra(new OraProfesor(new Ora(Integer.parseInt(date[2]), date[3]), Integer.parseInt(date[4]), date[5].charAt(0)));
        }

        orarProf.setOrarPeZi(ziCurenta, orarZiua);
        liceu.getDirector().setOrarUnProfesor(cnpCurent, orarProf);

        csvReader.close();
    }

}
