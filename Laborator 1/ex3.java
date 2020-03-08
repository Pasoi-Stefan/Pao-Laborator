
package lab1;

import java.util.*;

public class ex3 {
 
    public static void main(String[] args) {
     
         Scanner sc = new Scanner(System.in);
        
         int n = sc.nextInt();        
        
         System.out.println("Divizorii lui n sunt: ");
        
        for(int i = 1; i <= n; ++i) 
            
            if(n % i == 0)
            
                System.out.println(i);
                       
    }
    
}