public class Card
{
   //instance variables
   String suite;
   int faceValue;
   String letter;
   int jpg;
   
   public Card(String s, int fV, String l, int image)   //4-argument constructor
   {  
      suite = s;
      faceValue = fV;
      letter = l;
      jpg = image;
   }
   
   public String getSuite()   //returns suite
   {
      if(suite.equals("H"))
         return "hearts";
      else if(suite.equals("C"))
         return "clubs";
      else if(suite.equals("S"))
         return "spades";
      else if(suite.equals("D"))
         return "diamonds";
      return suite;
   }

   public String getLetter()  //returns letter on card (if at all)
   {
      if(letter == null) 
         return "null";
      else if(letter.equals("A"))
         return "ace";
      else if(letter.equals("J"))
         return "jack";
      else if(letter.equals("Q"))
         return "queen";
      else if(letter.equals("K"))
         return "king";
      return letter;
   }
   public int getFaceValue()  //returns face value
   {
      return faceValue;
   }
   public int getImageNum()
   {
      return jpg;
   }
}