public class Card implements Comparable<Card>
{
    private int suit, rank;
    
    public static final String[] SUITS = {"Diamonds", "Clubs", "Hearts", "Spades"};
    public static final String[] RANKS = {null, "Ace", "Two", "Three", "Four", "Five",
                              "Six", "Seven", "Eight", "Nine", "Ten", 
                              "Jack", "Queen", "King"};

    public Card (int suit, int rank) throws IllegalArgumentException
    { 
        if (suit<0 || suit> Card.SUITS.length-1)
        {
            throw new IllegalArgumentException("Incorrect suit value " + suit);
    }
        
    if (rank<1 || rank> Card.RANKS.length-1)
    {
         throw new IllegalArgumentException("Incorrect rank value " + rank);
    }
        
        this.suit = suit;  this.rank = rank;
    }
    
    @Override
    public boolean equals(Object object)
    {
        if (object == null)
        {
            return false;
        }
        
        if (object instanceof Card)
        {
            Card card = (Card) object;
            
            if (suit == card.getSuit() && rank == card.getRank())
            {
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public int compareTo(Card card)
    {
        if (this.equals(card)) return 0;
        
        if (this.suit > card.getSuit()) return 1;
        
        if (this.suit < card.getSuit()) return -1;
        
        if (this.rank > card.getRank()) return 1;
        
        return -1;
    }
    
    public int getSuit()
    {
        return suit;
    }
    
    public int getRank()
    {
        return rank;
    }
    
    @Override
    public String toString()
    {
        return Card.RANKS[rank] + " of " + Card.SUITS[suit]; //returns rank of suit
    } 
}