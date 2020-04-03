package ex2;

public class Album{

    private String Nume;
    private int AnulPublicarii;
    private double Rating;

    public Album(String Nume, int AnulPublicarii, double Rating) {
        this.Nume = Nume;
        this.AnulPublicarii = AnulPublicarii;
        this.Rating = Rating;
    }
    public String getNume(){
        return Nume;
    }
    public int getAnulPublicarii() {
        return AnulPublicarii;
    }
    public double getRating() {
        return Rating;
    }
    public void setNume(String Nume) {
        this.Nume = Nume;
    }
    public void setAnulPublicarii(int AnulPublicarii) {
        this.AnulPublicarii = AnulPublicarii;
    }
    public void setRating(double Rating) {
        this.Rating = Rating;
    }


}
