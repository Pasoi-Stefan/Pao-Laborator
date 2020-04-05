package PachetPrincipal;

public class ZileLucratoare {

    private static String[] ZileLucratoare = {"Luni", "Marți", "Miercuri", "Joi", "Vineri"};

    private ZileLucratoare() {}
    public static String[] getZileLucratoare() {
        return ZileLucratoare.clone();
    }
}
