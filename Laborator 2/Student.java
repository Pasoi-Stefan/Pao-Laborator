package lab2;

public class Student {
    
    private String Nume;
    private float Nota;
    
    public Student(String Nume, float Nota) {
        
        this.Nume = Nume;
        this.Nota = Nota;
        
    }
    
    String getNume() {
        
        return this.Nume;
        
    }
    
    float getNota() {
        
        return this.Nota;
        
    }
   
}
