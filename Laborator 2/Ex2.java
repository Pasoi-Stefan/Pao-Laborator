
package lab2;

import java.util.*;

public class Ex2 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
     
        int n = sc.nextInt();
        
        int[] x = new int[0];
        int[] y = new int[0];
        
        while(n > 0) {
         
            int num = sc.nextInt();
            
            if(num % 2 == 1)
                x = Ex2.makeList(x, num);
            else
                y = Ex2.makeList(y, num);
            
            --n;
            
        }
             
        if(x.length > y.length)
            System.out.println("impare");
        else if(x.length < y.length)
            System.out.println("pare");
        else
            System.out.println("amandoua");
        
    }
    
    public static int[] makeList(int[] a, int x) {
        
        int[] b = new int[a.length + 1];
        
        for(int i = 0; i < a.length; ++i)
            b[i] = a[i];
            
        b[a.length] = x;
        
        return b;
        
    }

}
