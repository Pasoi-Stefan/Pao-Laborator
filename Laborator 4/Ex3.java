package lab4;

import java.util.Arrays;
import java.util.Scanner;

public class Ex3 {

    public static void main(String[] args) {
     
        Scanner sc = new Scanner(System.in);
        int numarLinii = Integer.parseInt(sc.nextLine());
        int numarColoane = Integer.parseInt(sc.nextLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= numarLinii * numarColoane; ++i) {
            
            int x = Integer.parseInt(sc.nextLine());
            sb.append(nuEstePrim(x));
            
        }
        
        int dimensiune = 0;
        for(int i = 0; i < sb.length(); ++i)
            if(sb.charAt(i) == '1')
                ++dimensiune;
                
        System.out.println(dimensiune);
        
    }
    
    public static int nuEstePrim(int x) {
        
        if(x < 2 || x > 2 && x % 2 == 0)
            return 1;
        if(x == 2)
            return 0;
            
        for(int d = 3; d <= Math.sqrt(x); d += 2) 
            if(x % d == 0)
                return 1;
                
        return 0;

    }
    
}

/*

Input:
4
4
3
4
4
2
7
5
6
2
3
2
2
5
2
4
11
7

Output:
4

*/
