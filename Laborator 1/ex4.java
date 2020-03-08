
package lab1;

import java.util.*;

public class ex4 {
 
    public static void main(String[] args) {
     
         Scanner sc = new Scanner(System.in);
        
         int n = sc.nextInt();        
        
         System.out.println("Factorialul lui n este: ");
        
         System.out.println(ex4.factorial(n));
                       
    }
    
    public static int factorial(int n) {
        
        int p = 1;
        
        for(int i = 1; i <= n; ++i)
            
            p *= i;
            
        return p;
        
    }
    
}