import java.util.ArrayList;

public class Chip 
{ 
   //instance variables 
    private String color;
    private int price;           
    private int quantity;
    
    public Chip(String col, int p, int q)   //3 Argument Constructor and sets instance variables  
    {
        price = p;
        color = col;
        quantity = q;
        
        

    }
    
    public String getColor()      //Returns the color using a string 
    {
        return color;
    }
    
    public int getPrice()     //Returns the price 
    {
        return price;
    }
    
    public int getQuantity()       //Returns the quantity
    {
        return quantity;
    }
    
    public void changeQuantity(int q)
    {
        quantity = q;
    }
}