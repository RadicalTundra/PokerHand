package pokerhand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Tyler, Bryce
 */
public class PokerHand {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String highCard = "";
        List<PokerCard> hand = new ArrayList();
        Random rand = new Random();
        //for random testing
        /*int cardNumber1 = rand.nextInt(14);
        int cardNumber2 = rand.nextInt(14);
        int cardNumber3 = rand.nextInt(14);
        int cardNumber4 = rand.nextInt(14);
        int cardNumber5 = rand.nextInt(14);
        int cardSuit1 = rand.nextInt(4);
        int cardSuit2 = rand.nextInt(4);
        int cardSuit3 = rand.nextInt(4);
        int cardSuit4 = rand.nextInt(4);
        int cardSuit5 = rand.nextInt(4);
        PokerCard card1 = new PokerCard(cardNumber1, cardSuit1);
        PokerCard card2 = new PokerCard(cardNumber2, cardSuit2);
        PokerCard card3 = new PokerCard(cardNumber3, cardSuit3);
        PokerCard card4 = new PokerCard(cardNumber4, cardSuit4);
        PokerCard card5 = new PokerCard(cardNumber5, cardSuit5);*/
        
        //for non-random testing
        PokerCard card1 = new PokerCard(0, 1);
        PokerCard card2 = new PokerCard(10, 1);
        PokerCard card3 = new PokerCard(11, 1);
        PokerCard card4 = new PokerCard(12, 1);
        PokerCard card5 = new PokerCard(13, 1);
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        //must sort before every test to make sure the card are in the right order. Lowest first (goes ace at 0 and king at 13).
        hand = sortCardHand(hand);
        int result = testRoyalFlush(hand);
        int result2 = testStraightFlush(hand);
        int result3 = testFullHouse(hand);
        int result4 = 0;
        if(result == 0)
        {
            result4 = testFlush(hand);
        }
        int result5 = 0;
        int result6 = 0;
        int result7 = 0;
        int result8 = 0;
        int result9 = 0;
        int result10 = 0;
        //make sure it's not a straight flush, or a royal flush 
        if(result2 == 0 && result == 0)
        {
            result5 = testStraight(hand);
        }
        //make sure it's not a flush, no others needed for four of a kind
        if(result4 == 0)
        {
            result6 = testFourOfAKind(hand);
        }
        //make sure it's not a flush or a full house or four of a kind
        if(result3 == 0 && result4 == 0 && result6 == 0){
            result7 = testThreeOfAKind(hand);
        }
        //make sure it's not a flush or a full house, or four of a kind (four of a kind because technically there are two pairs of the same card, so it'll trigger)
        if(result4 == 0 && result3 == 0 && result6 == 0)
        {
            result8 = testTwoPair(hand);
        }
        //make sure it's not a flush, fullhouse, four of a kind, three of a kind, or two pair
        if(result4 == 0 && result3 == 0 && result8 == 0 && result6 == 0 && result7 == 0)
        {
            result9 = testPair(hand);
        }
        if((result + result2 + result3 + result4 + result5 + result6 + result7 + result8 + result9) == 0)
        {
            //this will return the hightest value card, this time aces are 14
            result10 = getHighCard(hand);
        }
        //just a lonely high card
        if(result10 > 0)
        {
            System.out.println("Hey, at least you got a high card of some value that I'm too lasy to program right now! (" + result10 + ")");
        }
        //single pair
        else if(result9 > 0){
            System.out.println("You got a pair... of cards. Come on, get your head out of the gutter.");
        }
        //two pairs
        else if(result8 > 0){
            System.out.println("You got two pairs of cards! Nice, you can win now about 33% of games.");
        }
        //three of a kind
        else if(result7 > 0){
            System.out.println("You got three of a kind! Your own three kings.");
        }
        //four of a kind
        else if(result6 > 0){
            System.out.println("Four of a kind! That's inasne! You must collect that card");
        }
        //Straight
        else if(result5 > 0){
            System.out.println("A nice clean row of cards. A clean straight.");
        }
        //flush
        else if(result4 > 0){
            System.out.println("A flush! Man, the random assortment of cards were looking scarry there for a second.");
        } 
        // full house
        else if(result3 > 0){
            System.out.println("Our house! In the middle of the street. Our house, it is full and it is sweet!");
        }
        // straight flush
        else if(result2 > 0){
            System.out.println("Woo wee! One of the best hands in poker, a straight flush.");
        }
        //royal flush, nearly impossible to get goes last
        else if(result > 0)
        {
            System.out.println("Wowser! You absolute mad lad, you got yourself a Royal Flush! The odds of that are 1 in 649,740... would you like to show me what's inside your sleeves?");
        }
        //These System.out's are used for seeing which test's return. You can use them if you'd like!
        //System.out.println(result);
        //System.out.println(result2);
        //System.out.println(result3);
        //System.out.println(result4);
        //System.out.println(result5);
        //System.out.println(result6);
        //System.out.println(result7);
        //System.out.println(result8);
        //System.out.println(result9);
        //System.out.println(result10);

        
    }
    
    /**
     * testRoyalFlush
     * @param hand
     * @return
     */
    public static int testRoyalFlush(List<PokerCard> hand)
    {
        //testing if the hand of cards is a 10, a jack, a queen, a king, and an ace (10, 11, 12, 13, 0 respectively).
        if((hand.get(0).getCardNumber() == 0) 
            && (hand.get(1).getCardNumber() == 10) 
            && (hand.get(2).getCardNumber() == 11) 
            && (hand.get(3).getCardNumber() == 12) 
            && (hand.get(4).getCardNumber() == 13) 
            && hand.get(0).getCardSuit()== hand.get(1).getCardSuit() 
            &&  hand.get(1).getCardSuit()== hand.get(2).getCardSuit() 
            &&  hand.get(2).getCardSuit()== hand.get(3).getCardSuit() 
            &&  hand.get(3).getCardSuit()== hand.get(4).getCardSuit())  
        {
            return 1;
        }
        return 0;
    }
    
    /**
     *
     * @param hand
     * @return
     */
    public static int testStraightFlush(List<PokerCard> hand)
    {
        //testing if all the cards are one after another and if they're all the same suit
        int firstCardNumber = hand.get(0).getCardNumber();
        if((hand.get(1).getCardNumber() == (firstCardNumber + 1)) 
            && (hand.get(2).getCardNumber() == (firstCardNumber + 2)) 
            && (hand.get(3).getCardNumber() == (firstCardNumber + 3)) 
            && (hand.get(4).getCardNumber() == (firstCardNumber + 4)) 
            && hand.get(0).getCardSuit() == hand.get(1).getCardSuit() 
            &&  hand.get(1).getCardSuit() == hand.get(2).getCardSuit() 
            &&  hand.get(2).getCardSuit() == hand.get(3).getCardSuit() 
            &&  hand.get(3).getCardSuit() == hand.get(4).getCardSuit()) 
        {
            return 2;
        }
        return 0;
    }
    
    /**
     *
     * @param hand
     * @return
     */
    public static int testFullHouse(List<PokerCard> hand)
    {
        int firstCardNumber = hand.get(0).getCardNumber();
        int fourthCardNumber = hand.get(3).getCardNumber();
        //Here we're checking if either the first three and last two are the same, or the first two and last three. We can do this because it's sorted already.
        if((hand.get(1).getCardNumber() == firstCardNumber) 
            && (hand.get(2).getCardNumber() == firstCardNumber) 
            && (hand.get(4).getCardNumber() == fourthCardNumber)
            ||(hand.get(1).getCardNumber() == firstCardNumber) 
            && (hand.get(2).getCardNumber() == fourthCardNumber) 
            && (hand.get(4).getCardNumber() == fourthCardNumber)) 
        {
            return 3;
        }
        
        return 0;
    }
    
    /**
     *
     * @param hand
     * @return
     */
    public static int testFlush(List<PokerCard> hand)
    {
        //need to test card 3 against card 2 since the first and second card won't be one right after another number wise (aces are 0, tens are 10) in a royal flush.
       if( hand.get(0).getCardSuit() == hand.get(1).getCardSuit() 
          &&  hand.get(1).getCardSuit() == hand.get(2).getCardSuit() 
          &&  hand.get(2).getCardSuit() == hand.get(3).getCardSuit() 
          &&  hand.get(3).getCardSuit() == hand.get(4).getCardSuit())
       {
           return 4;
       }
        return 0;
    }
    
    /**
     *
     * @param hand
     * @return
     */
    public static int testStraight(List<PokerCard> hand)
    {
        //seting the first card to 9 if it's an ace since ace, 10, jack, queen, king is still a valid hand for a straight.
        int firstCardNumber;
        if(hand.get(0).getCardNumber() == 0)
        {
            firstCardNumber = 9;
        }
        else
        {
            firstCardNumber = hand.get(0).getCardNumber();
        }
        if((hand.get(1).getCardNumber() == (firstCardNumber + 1)) 
            && (hand.get(2).getCardNumber() == (firstCardNumber + 2)) 
            && (hand.get(3).getCardNumber() == (firstCardNumber + 3)) 
            && (hand.get(4).getCardNumber() == (firstCardNumber + 4)))
        {
            return 5;
        }
        return 0;
    }
    
    /**
     *
     * @param hand
     * @return
     */
    public static int testFourOfAKind(List<PokerCard> hand)
    {
        //need to test cards 1,2,3,4 and cards 2,3,4,5
        int thirdCardNumber = hand.get(2).getCardNumber();
        if(hand.get(0).getCardNumber() == thirdCardNumber
           && hand.get(1).getCardNumber() == thirdCardNumber
           && hand.get(3).getCardNumber() == thirdCardNumber
           || hand.get(1).getCardNumber() == thirdCardNumber
           && hand.get(3).getCardNumber() == thirdCardNumber
           && hand.get(4).getCardNumber() == thirdCardNumber)
        {
            return 6;
        }
        return 0;
    }
    
    /**
     *
     * @param hand
     * @return
     */
    public static int testThreeOfAKind(List<PokerCard> hand)
    {
        //the third card is in all three of the possible options for three of a kind. testing cards 1,2,3 and 2,3,4, and 3,4,5. this is because the numbers are sorted
        int thirdCardNumber = hand.get(2).getCardNumber();
        if(hand.get(0).getCardNumber() == thirdCardNumber
           && hand.get(1).getCardNumber() == thirdCardNumber
           || hand.get(1).getCardNumber() == thirdCardNumber
           && hand.get(3).getCardNumber() == thirdCardNumber
           || hand.get(3).getCardNumber() == thirdCardNumber
           && hand.get(4).getCardNumber() == thirdCardNumber)
        {
            return 7;
        }
        return 0;
    }
    
    /**
     *
     * @param hand
     * @return
     */
    public static int testTwoPair(List<PokerCard> hand)
    {
        //getting the seond and fourth card numbers since they're both used in all options. They are (1,2) (3,4) and (1,2) (4,5) and (2,3) (4,5) this is because the numbers are sorted
        int secondCardNumber = hand.get(1).getCardNumber();
        int fourthCardNumber = hand.get(3).getCardNumber();
        if(hand.get(0).getCardNumber() == secondCardNumber
           && hand.get(2).getCardNumber() == fourthCardNumber
           || hand.get(0).getCardNumber() == secondCardNumber
           && hand.get(4).getCardNumber() == fourthCardNumber
           || hand.get(2).getCardNumber() == secondCardNumber
           && hand.get(4).getCardNumber() == fourthCardNumber)
        {
            return 8;
        }
        return 0;
    }
    
    /**
     *
     * @param hand
     * @return
     */
    public static int testPair(List<PokerCard> hand)
    {
        //getting the seond and fourth card numbers since they're both used in all options. They are (1,2) (2,3) (3,4) (4,5) this is because the numbers are sorted
        int secondCardNumber = hand.get(1).getCardNumber();
        int fourthCardNumber = hand.get(3).getCardNumber();
        if(hand.get(0).getCardNumber() == secondCardNumber
           || hand.get(2).getCardNumber() == secondCardNumber
           || hand.get(2).getCardNumber() == fourthCardNumber
           || hand.get(4).getCardNumber() == fourthCardNumber)
        {
            return 9;
        }
        return 0;
    }
    
    //this can be used to find the highest card when comparing hands.

    /**
     *
     * @param hand
     * @return
     */
    public static int getHighCard(List<PokerCard> hand)
    {
        //we assume we're calling this function because none of the other tests have passed, so we'll just get the highest rank of card.
        if(hand.get(0).getCardNumber() == 0)
        {
            //if it's an ace we'll return 14 so we don't confuse with the other error messages.
            return 14;
        }
        else
        {
            //the fourth card will always have the highest value (besides an ace) because we sort for that.
            return hand.get(4).getCardNumber();
        }
    }
    
    //just a basic sort to make sure the lowest number card is on the bottom

    /**
     *
     * @param hand
     * @return
     */
    public static List sortCardHand(List<PokerCard> hand)
    {
        for(int i = 0; i < hand.size() - 1; i++) {
            for (int j = 0; j < hand.size() - 1; j++) {
                if (hand.get(j).getCardNumber() > hand.get(j + 1).getCardNumber()) {
                    PokerCard oldCard = hand.get(j);
                    hand.set(j, hand.get(j + 1));
                    hand.set(j + 1, oldCard);
                }
            }
        }
        return hand;
    }
    
}
