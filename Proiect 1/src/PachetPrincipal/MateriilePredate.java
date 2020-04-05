package PachetPrincipal;

public final class MateriilePredate {
    private static String[] MateriilePredate = {"Română", "Matematică", "Fizică", "Informatică", "Biologie", "Chimie"};

    private MateriilePredate() {}
    public static String[] getMateriilePredate() {
        return MateriilePredate.clone();
    }
}
