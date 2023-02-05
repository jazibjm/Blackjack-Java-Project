import java.util.*;

public class Dealer
{
   int totalCardValue;
   ArrayList<Card> dealerCards;
   
   public Dealer()
   {
      totalCardValue = 0;
      dealerCards = new ArrayList<>();
   }

   public void addDealerCard(Card e)
   {
      dealerCards.add(e);
   }
}