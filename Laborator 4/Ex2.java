package lab4;

import java.util.Scanner;
import java.util.ArrayList;

public class Ex2 {

    public static void main(String[] args) {
     
        Scanner sc = new Scanner(System.in);
        
        ArrayList<String> a = new ArrayList<String>();
        int n = Integer.parseInt(sc.nextLine());
        
        for(int i = 0; i < n; ++i) 
            a.add(sc.nextLine());
            
        ArrayList<String> b = new ArrayList<String>();
        for(int i = 0; i < n; ++i)
            if(estePalindrom(a.get(i)))
                b.add(new String(a.get(i)));
                           
        System.out.println(lungimeMaxima(b));
        
    }
    
    public static boolean estePalindrom(String str) {
        
        StringBuilder sb = new StringBuilder(str);
        
        return sb.toString().equals(sb.reverse().toString());
        
    }
    
    public static int lungimeMaxima(ArrayList<String> a) {
        
        int maxim = 0;
        
        for(int i = 0; i < a.size(); ++i) 
            maxim = Math.max(maxim, a.get(i).length());
            
        return maxim;
        
    }
    
}

/* 

input:
5
aerisirea
masa
rotor
aragaz
sodos

output:
9

*/
