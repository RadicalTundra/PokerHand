package pokerhand;

/**
 *
 * @author Tyler, Bryce
 */
public class PokerCard {
    //card numbers go from 0-13. 0 is an ace and 13 is a king.
    private int cardNumber, cardSuit;
    
    /**
     *
     * @param cardNumber
     * @param cardSuit
     */
    public PokerCard(int cardNumber, int cardSuit)
    {
        if(cardSuit > 3 && cardSuit < 0){
            System.out.println("Please enter a proper suit number! (0-3)");
        }
        if(cardNumber > 13 && cardNumber < 0){
            System.out.println("Please enter in a proper card number! (0-13)");
        }
        this.cardNumber = cardNumber;
        this.cardSuit = cardSuit;
    }
    
    /**
     * getCardNumber
     * @return
     */
    public int getCardNumber()
    {
        return cardNumber;
    }
    
    /**
     * setCardNumber
     * @param cardNumber
     */
    public void setCardNumber(int cardNumber)
    {
        if(cardNumber > 13 && cardNumber < 0){
            System.out.println("Please enter in a proper card number! (0-13)");
        }
        this.cardNumber = cardNumber;
    }
    
    /**
     * getCardSuit
     * @return
     */
    public int getCardSuit()
    {
        return cardSuit;
    }
    
    /**
     * setCardSuit
     * @param cardSuit
     */
    public void setCardSuit(int cardSuit)
    {
        if(cardSuit > 3 && cardSuit < 0){
            System.out.println("Please enter a proper suit number! (0-3)");
        }
        this.cardSuit = cardSuit;
    }
}
