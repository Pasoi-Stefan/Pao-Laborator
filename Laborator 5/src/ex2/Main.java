package ex2;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Album[] a = new Album[5];
        a[0] = new Album("Nevermind", 1991, 95);
        a[1] = new Album("The Beatles", 1968, 97);
        a[2] = new Album("Abbey Road", 1969, 96);
        a[3] = new Album("The Dark Side of the Moon", 1973, 98);
        a[4] = new Album("Blackstar", 2016, 97);

        System.out.println("Inainte de sortare:\n");
        for(int i = 0; i < 5; ++i) {
            System.out.println(a[i].getNume() + " " + a[i].getAnulPublicarii() + " " + a[i].getRating());
        }
        System.out.println();

        CompararePeNume cmp1 = new CompararePeNume();
        Arrays.sort(a, cmp1);

        System.out.println("Dupa sortare pe nume:\n");
        for(int i = 0; i < 5; ++i) {
            System.out.println(a[i].getNume() + " " + a[i].getAnulPublicarii() + " " + a[i].getRating());
        }
        System.out.println();

        CompararePeRating cmp2 = new CompararePeRating();
        Arrays.sort(a, cmp2);

        System.out.println("Dupa sortare pe rating:\n");
        for(int i = 0; i < 5; ++i) {
            System.out.println(a[i].getNume() + " " + a[i].getAnulPublicarii() + " " + a[i].getRating());
        }
        System.out.println();

    }
}
