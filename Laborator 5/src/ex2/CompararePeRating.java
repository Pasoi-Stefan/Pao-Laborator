package ex2;

import java.util.Comparator;

public class CompararePeRating implements Comparator<Album> {
    public int compare(Album a, Album b) {
        if(a.getRating() < b.getRating())
            return -1;
        else if(a.getRating() > b.getRating())
            return 1;
        else return 0;
    }
}
