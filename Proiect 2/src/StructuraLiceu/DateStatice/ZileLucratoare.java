package StructuraLiceu.DateStatice;

public final class ZileLucratoare {

    private static String[] List = {"Luni", "Marți", "Miercuri", "Joi", "Vineri"};

    private ZileLucratoare() {}
    public static String[] get() {
        return ZileLucratoare.List.clone();
    }
}
