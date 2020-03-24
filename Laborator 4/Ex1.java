package lab4;


import java.util.Arrays;
import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {
     
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Primul cuvant: ");
        StringBuilder str1 = new StringBuilder(sc.nextLine());
        
        System.out.println("Al doilea cuvant: ");
        StringBuilder str2 = new StringBuilder(sc.nextLine());

        System.out.println(suntAnagrame(str1, str2));
        
    }
    
    public static boolean suntAnagrame(StringBuilder str1, StringBuilder str2) {
        
        char[] c1 = str1.toString().toCharArray();
        char[] c2 = str2.toString().toCharArray();
     
        Arrays.sort(c1);
        Arrays.sort(c2);
        
        str1 = new StringBuilder(new String(c1));
        str2 = new StringBuilder(new String(c2));
  
        return str1.toString().equals(str2.toString());
        
    }
    
}
