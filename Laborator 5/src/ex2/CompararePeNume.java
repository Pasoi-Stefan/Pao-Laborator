package ex2;

import java.util.Comparator;

public class CompararePeNume implements Comparator<Album> {
    public int compare(Album a, Album b) {
        return a.getNume().compareTo(b.getNume());
    }
}
