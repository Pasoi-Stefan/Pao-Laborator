import StructuraLiceu.DateStatice.MateriilePredate;
import StructuraLiceu.Orar.*;
import StructuraLiceu.*;

import java.io.IOException;

public class Project1Main {

    public static void main(String[] args) throws IOException {

        // Initializam clasa de serviciu
        LiceeleDinJudet liceeleDinJudet = new LiceeleDinJudet();

        // Initializam un liceu
        Liceu liceu = new Liceu("Liceul Spiru Haret");

        // Adaugam profesorii
        liceu.adaugaProfesor("1860801329211", "Lazăr Marian");
        liceu.adaugaProfesor("2870603384351", "Relia Antonescu");
        liceu.adaugaProfesor("1690503430094", "Arsenie Iliescu");
        liceu.adaugaProfesor("1800116320082", "Iulian Simeonescu");

        // Alegem directorul
        liceu.alegeDirector("2870603384351");

        // Adaugam clasele la care sunt asociate dirigintii
        liceu.adaugaClasa(liceu.getDirector().formeazaClasa(10, 'F', "1800116320082"));
        liceu.adaugaClasa(liceu.getDirector().formeazaClasa(11, 'D', "1690503430094"));

        // Afisam profesorii din liceu impreuna cu atributiile lor
        System.out.println("\nProfesorii din " + liceu.getNume().toUpperCase() + ":");
        liceu.afiseazaProfesori();
        System.out.println();

        // Afisam clasele impreuna cu dirigintii lor
        System.out.println("Clasele din liceu sunt: ");
        liceu.afiseazaClasele();
        System.out.println();

        // Adaugam elevi la clasa 10 F
        liceu.adaugaElevLaClasa(new Elev("5030513010054","Danus Musat"), 10,'F');
        liceu.adaugaElevLaClasa(new Elev("5030924060029","Ioan Banciu"), 10,'F');
        liceu.adaugaElevLaClasa(new Elev("6030401020016","Anamaria Mocanu"), 10,'F');

        // Afisam elevii clasei 10 F
        liceu.getClase().get("10 F").afiseazaClasa();
        System.out.println();

        // Adaugam elevi la clasa 11 D
        liceu.adaugaElevLaClasa(new Elev("6020501150042","Dorina Cinca"), 11,'D');
        liceu.adaugaElevLaClasa(new Elev("5020501290060","Nic Munteanu"), 11,'D');
        liceu.adaugaElevLaClasa(new Elev("6021010450051","Carla Cosma"), 11,'D');

        // Afisam elevii clasei 11 D
        liceu.getClase().get("11 D").afiseazaClasa();
        System.out.println();

        // Scriem orarul profesorilor pentru fiecare zi a săptămânii

        Orar prof;
        OrarPeZi ziua;

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Scriem orarul profesorului Lazăr Marian

        prof = new Orar();

        ziua = new OrarPeZi();
        ziua.adaugaOra(new OraProfesor(new Ora(8, "Română"), 10, 'F'));
        ziua.adaugaOra(new OraProfesor(new Ora(9, "Română"), 11, 'D'));
        prof.setOrarPeZi("Luni", ziua);

        ziua = new OrarPeZi();
        ziua.adaugaOra(new OraProfesor(new Ora(8, "Română"), 10, 'F'));
        ziua.adaugaOra(new OraProfesor(new Ora(9, "Română"), 11, 'D'));
        prof.setOrarPeZi("Joi", ziua);

        liceu.getDirector().setOrarUnProfesor("1860801329211", prof);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Scriem orarul profesorului Relia Antonescu

        prof = new Orar();

        ziua = new OrarPeZi();
        ziua.adaugaOra(new OraProfesor(new Ora(9, "Matematică"), 10, 'F'));
        ziua.adaugaOra(new OraProfesor(new Ora(10, "Fizică"), 10, 'F'));
        ziua.adaugaOra(new OraProfesor(new Ora(8, "Matematică"), 11, 'D'));
        prof.setOrarPeZi("Luni", ziua);

        ziua = new OrarPeZi();
        ziua.adaugaOra(new OraProfesor(new Ora(8, "Fizică"), 11, 'D'));
        prof.setOrarPeZi("Marți", ziua);

        ziua = new OrarPeZi();
        ziua.adaugaOra(new OraProfesor(new Ora(8, "Matematică"), 11, 'D'));
        prof.setOrarPeZi("Miercuri", ziua);

        ziua = new OrarPeZi();
        ziua.adaugaOra(new OraProfesor(new Ora(9, "Matematică"), 10, 'F'));
        ziua.adaugaOra(new OraProfesor(new Ora(10, "Matematică"), 10, 'F'));
        prof.setOrarPeZi("Vineri", ziua);

        liceu.getDirector().setOrarUnProfesor("2870603384351", prof);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Scriem orarul profesorului Arsenie Iliescu

        prof = new Orar();

        ziua = new OrarPeZi();
        ziua.adaugaOra(new OraProfesor(new Ora(10, "Chimie"), 11, 'D'));
        prof.setOrarPeZi("Luni", ziua);

        ziua = new OrarPeZi();
        ziua.adaugaOra(new OraProfesor(new Ora(9, "Chimie"), 10, 'F'));
        prof.setOrarPeZi("Marți", ziua);

        ziua = new OrarPeZi();
        ziua.adaugaOra(new OraProfesor(new Ora(8, "Informatică"), 10, 'F'));
        prof.setOrarPeZi("Miercuri", ziua);

        ziua = new OrarPeZi();
        ziua.adaugaOra(new OraProfesor(new Ora(9, "Informatică"), 10, 'F'));
        ziua.adaugaOra(new OraProfesor(new Ora(8, "Informatică"), 11, 'D'));
        prof.setOrarPeZi("Joi", ziua);

        ziua = new OrarPeZi();
        ziua.adaugaOra(new OraProfesor(new Ora(9, "Informatică"), 11, 'D'));
        ziua.adaugaOra(new OraProfesor(new Ora(10, "Informatică"), 11, 'D'));
        prof.setOrarPeZi("Vineri", ziua);

        liceu.getDirector().setOrarUnProfesor("1690503430094", prof);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Scriem orarul profesorului Iulian Simeonescu

        prof = new Orar();

        ziua = new OrarPeZi();
        ziua.adaugaOra(new OraProfesor(new Ora(8, "Biologie"), 10, 'F'));
        ziua.adaugaOra(new OraProfesor(new Ora(9, "Biologie"), 11, 'D'));
        prof.setOrarPeZi("Marți", ziua);

        liceu.getDirector().setOrarUnProfesor("1800116320082", prof);

        // Afisam orarul profesorilor

        System.out.println("Orarul profesorului Lazăr Marian: ");
        liceu.getOrarProfesori().getOrarUnProfesor("1860801329211").afiseazaOrar();
        System.out.println();

        System.out.println("Orarul profesorului Relia Antonescu: ");
        liceu.getOrarProfesori().getOrarUnProfesor("2870603384351").afiseazaOrar();
        System.out.println();

        System.out.println("Orarul profesorului Arsenie Iliescu: ");
        liceu.getOrarProfesori().getOrarUnProfesor("1690503430094").afiseazaOrar();
        System.out.println();

        System.out.println("Orarul profesorului Iulian Simeonescu: ");
        liceu.getOrarProfesori().getOrarUnProfesor("1800116320082").afiseazaOrar();
        System.out.println();

        // Afisam orarul claselor

        System.out.println("Orarul clasei 10 F este: ");
        liceu.getClase().get("10 F").obtineOrarulClasei().afiseazaOrar();
        System.out.println();

        System.out.println("Orarul clasei 11 D este: ");
        liceu.getClase().get("11 D").obtineOrarulClasei().afiseazaOrar();
        System.out.println();

        // Atribuim elevului Danus Musat din clasa 10 F note la materii

        liceu.getProfesori().get("1860801329211").daNotaLaElev("5030513010054", 8, "Română");
        liceu.getProfesori().get("1860801329211").daNotaLaElev("5030513010054", 9, "Română");
        liceu.getProfesori().get("1860801329211").daNotaLaElev("5030513010054", 10, "Română");
        liceu.getProfesori().get("1860801329211").daNotaLaElev("5030513010054", 8, "Română");

        liceu.getProfesori().get("2870603384351").daNotaLaElev("5030513010054", 8, "Matematică");
        liceu.getProfesori().get("2870603384351").daNotaLaElev("5030513010054", 8, "Matematică");
        liceu.getProfesori().get("2870603384351").daNotaLaElev("5030513010054", 7, "Matematică");
        liceu.getProfesori().get("2870603384351").daNotaLaElev("5030513010054", 6, "Matematică");

        liceu.getProfesori().get("2870603384351").daNotaLaElev("5030513010054", 9, "Fizică");
        liceu.getProfesori().get("2870603384351").daNotaLaElev("5030513010054", 6, "Fizică");

        liceu.getProfesori().get("1690503430094").daNotaLaElev("5030513010054", 10, "Informatică");
        liceu.getProfesori().get("1690503430094").daNotaLaElev("5030513010054", 10, "Informatică");
        liceu.getProfesori().get("1690503430094").daNotaLaElev("5030513010054", 10, "Informatică");
        liceu.getProfesori().get("1690503430094").daNotaLaElev("5030513010054", 10, "Informatică");

        liceu.getProfesori().get("1800116320082").daNotaLaElev("5030513010054", 6, "Biologie");
        liceu.getProfesori().get("1800116320082").daNotaLaElev("5030513010054", 7, "Biologie");

        liceu.getProfesori().get("1690503430094").daNotaLaElev("5030513010054", 7, "Chimie");
        liceu.getProfesori().get("1690503430094").daNotaLaElev("5030513010054", 9, "Chimie");

        liceu.getClase().get("10 F").getDiriginte().daNotalaPurtare("5030513010054", 10);

        // Afisam notele elevului

        Elev elev = liceu.getClase().get("10 F").getElevi().get("5030513010054");

        elev.afiseazaNoteleLaMaterii();
        System.out.println();

        // Calculam media la fiecare materie

        System.out.println("Mediile elevului Danus Musat:");
        for(String materie: MateriilePredate.get())
            System.out.println(materie + ": " + elev.calculeazaMediaLaMaterie(materie));
        System.out.println();

        // Calculam media generala

        System.out.println("Media generala a elevului Danus Musat este " + elev.calculeazaMedia());
        System.out.println();

        // Adaugam liceul in lista de licee

        liceeleDinJudet.adaugaLiceu(liceu);

        // Afisam liceele

        liceeleDinJudet.afiseazaLicee();

        liceu.salveaza();

    }
}
