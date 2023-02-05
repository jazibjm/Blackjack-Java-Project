import java.util.ArrayList;

public class Player
{
    ArrayList<Card> playerCards;
    int cardTotalValue;
    
    public Player()
    {
        playerCards = new ArrayList<>();
        cardTotalValue = 0;
    }
    public void addPlayerCard(Card e)
    {
        playerCards.add(e);
    }
    public void removeAllCards()
    {
        for(int i = playerCards.size()-1; i >= 0; i--)
        {
            playerCards.remove(i);
        }
    }
    









} 