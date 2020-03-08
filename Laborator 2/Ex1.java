
package lab2;

import java.util.*;

public class Ex1 {

    public static void main(String[] args) {
     
        Scanner sc = new Scanner(System.in);
        
        int n = 0;
      
        int s = 0;
        
        while(true) {
         
            int x = sc.nextInt();
            
            if(x == -1)
                break;
            
            s += x;
            
            ++n;
            
        }
        
        System.out.println((float)s / (float)n);
        
    }

}
