package lab2;

import java.util.Scanner;

public class Ex4 {
    
    public static void main(String[] args) {
     
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        sc.nextLine();
        
        Student[] lista = new Student[n];
        
        for(int i = 0 ; i < n; ++i) {
            
            String[] line = sc.nextLine().split(" ");
            
            lista[i] = new Student(line[0], Float.parseFloat(line[1]));
            
        }
        
        for(int i = 0; i < n; ++i) 
            System.out.println(lista[i].getNume() + " " + Float.toString(lista[i].getNota()));
            
    }
   
}
