import java.util.*;

public class Money 
{
    private ArrayList<Chip> money;      //Instance variables
    
    public Money()  //Creates the chip values with the corresponding color   
    {
        money = new ArrayList<>(); 
        money.add(new Chip("red", 5, 0));
        money.add(new Chip("green", 25, 0));
        money.add(new Chip("black", 100, 0));        
        money.add(new Chip("purple", 500, 0));
    }
    
    public void buyTokens(int red, int green, int black, int purple)  //simulates buying tokens for the user with inputted amounts 
    {
        money.get(0).changeQuantity(money.get(0).getQuantity()+red);
        money.get(1).changeQuantity(money.get(1).getQuantity()+green);           
        money.get(2).changeQuantity(money.get(2).getQuantity()+black);
        money.get(3).changeQuantity(money.get(3).getQuantity()+purple);
    }
    
    public void changeRedQuantity(int red)              //Changes the red quantity (not sure if needed )
    { 
        money.get(0).changeQuantity(red);
    }
    
    public void changeGreenQuantity(int green)           //Changes the green quantity (not sure if needed)
    {
        money.get(1).changeQuantity(green);
    }
    
    public void changeBlackQuantity(int black)          //Changes the black quantity (not sure if needed)
    {
        money.get(2).changeQuantity(black);
    }
    
    public void changePurpleQuantity(int purple)            //Changes the purple quantity (not sure if needed)
    {
        money.get(3).changeQuantity(purple);
    }
    
    public int getTotalValue()         //returns the total value of all the tokens 
    {
        int value = 0;
        for(Chip i : money)
        {
            value += i.getQuantity() * i.getPrice();
        }
        return value;
    }
}
