
package lab1;

import java.util.*;

public class ex7 {
 
    public static void main(String[] args) {
     
         Scanner sc = new Scanner(System.in);
        
         int n = sc.nextInt();        
         
         if(n == 1)
            
            System.out.println("1");
            
         else if(n == 2)
         
            System.out.println("1");
            
         else {
             
             int a = 1;
             int b = 1;
             
             n -= 2;
             
             while(n > 0) {
             
                 int x = a;
                 
                 a = b;
                 b += x;
                 
                 --n;
                 
             }
             
             System.out.println(b);
             
         }
           
    }
    
}