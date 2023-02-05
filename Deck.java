import java.util.*;

public class Deck
{
   //instance variables
   ArrayList<Card> deck;
   
   public Deck()  //default constructor
   {
      deck = new ArrayList<Card>(); //arraylist of cards
   
      //instantiates all 52 cards in a deck
      //-1 or null if N/A
      deck.add(new Card("H", 11, "A", 1));
      deck.add(new Card("H", 2, "2", 2));
      deck.add(new Card("H", 3, "3", 3));
      deck.add(new Card("H", 4, "4", 4));
      deck.add(new Card("H", 5, "5", 5));
      deck.add(new Card("H", 6, "6", 6));
      deck.add(new Card("H", 7, "7", 7));
      deck.add(new Card("H", 8, "8", 8));
      deck.add(new Card("H", 9, "9", 9));
      deck.add(new Card("H", 10, "10", 10));
      deck.add(new Card("H", 10, "J", 11));
      deck.add(new Card("H", 10, "Q", 12));
      deck.add(new Card("H", 10, "K", 13));
      deck.add(new Card("C", 11, "A", 14));
      deck.add(new Card("C", 2, "2", 15));
      deck.add(new Card("C", 3, "3", 16));
      deck.add(new Card("C", 4, "4", 17));
      deck.add(new Card("C", 5, "5", 18));
      deck.add(new Card("C", 6, "6", 19)); 
      deck.add(new Card("C", 7, "7", 20));
      deck.add(new Card("C", 8, "8", 21));
      deck.add(new Card("C", 9, "9", 22));
      deck.add(new Card("C", 10, "10", 23));
      deck.add(new Card("C", 10, "J", 24));
      deck.add(new Card("C", 10, "Q", 25));
      deck.add(new Card("C", 10, "K", 26));
      deck.add(new Card("S", 11, "A", 27));
      deck.add(new Card("S", 2, "2", 28));
      deck.add(new Card("S", 3, "3", 29));
      deck.add(new Card("S", 4, "4", 30));
      deck.add(new Card("S", 5, "5", 31));
      deck.add(new Card("S", 6, "6", 32));
      deck.add(new Card("S", 7, "7", 33));
      deck.add(new Card("S", 8, "8", 34));
      deck.add(new Card("S", 9, "9", 35));
      deck.add(new Card("S", 10, "10", 36));
      deck.add(new Card("S", 10, "J", 37));
      deck.add(new Card("S", 10, "Q", 38));
      deck.add(new Card("S", 10, "K", 39));
      deck.add(new Card("D", 11,"A", 40));
      deck.add(new Card("D", 2, "2", 41));
      deck.add(new Card("D", 3, "3", 42));
      deck.add(new Card("D", 4, "4", 43));
      deck.add(new Card("D", 5, "5", 44));
      deck.add(new Card("D", 6, "6", 45));
      deck.add(new Card("D", 7, "7", 46));
      deck.add(new Card("D", 8, "8", 47));
      deck.add(new Card("D", 9, "9", 48));
      deck.add(new Card("D", 10, "10", 49));
      deck.add(new Card("D", 10, "J", 50));
      deck.add(new Card("D", 10, "Q", 51));
      deck.add(new Card("D", 10, "K", 52));
  }
  
  public void shuffle()
  {
     int size = deck.size();
     ArrayList<Card> temp = new ArrayList<Card>();
     for(int i = 0; i < size; i++)
     {
        int index = (int)(Math.random() * deck.size());
        temp.add(deck.remove(index));
     }
     deck = temp;
  }
  
  public void deal(Player player, Dealer dealer)
  {
     //shuffle();
     player.addPlayerCard(deck.get(0));
     System.out.println(deck.get(0).letter);
     deck.remove(0);
     
     dealer.addDealerCard(deck.get(0));
     System.out.println(deck.get(0).letter);
     deck.remove(0);
     
     player.addPlayerCard(deck.get(0));
     System.out.println(deck.get(0).letter);
     deck.remove(0);
      
     dealer.addDealerCard(deck.get(0));
     System.out.println(deck.get(0).letter);
     deck.remove(0); 
  }
  
  public int drawPlayerCard(Player player)
  {
      player.addPlayerCard(deck.get(0));
      int imageNum = deck.get(0).jpg;
      deck.remove(0);
      return imageNum;
  }
  
  public int drawDealerCard(Dealer dealer)
  {
      dealer.addDealerCard(deck.get(0));
      int imageNum = deck.get(0).jpg;
      deck.remove(0);
      return imageNum;
  }
}
