package StructuraLiceu.DateStatice;

public final class MateriilePredate {

    private static String[] List = {"Română", "Matematică", "Fizică", "Informatică", "Biologie", "Chimie"};

    private MateriilePredate() {}
    public static String[] get() {
        return MateriilePredate.List.clone();
    }
}
