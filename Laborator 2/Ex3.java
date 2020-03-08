
package lab2;

import java.util.Arrays;

public class Ex3 {
    
    public static void main(String[] args) {
       
        Dog example = new Dog(true, "meat");
        
        // example.setIfHungry(false);
        // example.setFoodGiven("carrot");
        
        System.out.println(example.getIfHungry());
        System.out.println(example.getFoodGiven());
        
        example.status();
        
        
    }
    
}
