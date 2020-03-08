package lab2;

public class Ex3_Dog {
    
    private boolean isHungry;
    private String foodGiven;
    
    public Ex3_Dog(boolean isHungry, String foodGiven) {
        
        this.isHungry = isHungry;
        this.foodGiven = foodGiven;
        
    }
    
    boolean getIfHungry() {
     
        return this.isHungry;
        
    }
    
    void setIfHungry(boolean value) {
     
        this.isHungry = value;
        
    }
    
    String getFoodGiven() {
     
        return this.foodGiven;
        
    }
    
    void setFoodGiven(String value) {
     
        this.foodGiven = value;
        
    }
    
    void status() {
        
        System.out.println("The dog is " + (this.isHungry == true ? "hungry " : "not hungry ") + "and the food it was given is " + this.foodGiven);
        
    }

}
