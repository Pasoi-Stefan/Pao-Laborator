
package lab1;

import java.util.*;

public class ex5 {
 
    public static void main(String[] args) {
     
         Scanner sc = new Scanner(System.in);
        
         int n = sc.nextInt();        
        
         if(ex5.este_prim(n) == true)
         
            System.out.println("true");
            
         else
         
            System.out.println("false");
         
                       
    }
    
    public static boolean este_prim(int n) {
     
            for(int i = 2; i <= n / 2; ++i)
            
                if(n % i == 0) 
                    
                    return false;
                   
            return true;
        
    }
    
}