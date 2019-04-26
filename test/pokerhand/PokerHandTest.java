/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerhand;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static pokerhand.PokerHand.*;

/**
 *
 * @author tgrady4
 */
public class PokerHandTest {
    List<PokerCard> hand;
    PokerCard card1;
    PokerCard card2;
    PokerCard card3;
    PokerCard card4;
    PokerCard card5;
    @Before
    public void setup(){
        hand = new ArrayList();
        card1 = new PokerCard(0, 1);
        card2 = new PokerCard(10, 1);
        card3 = new PokerCard(11, 1);
        card4 = new PokerCard(12, 1);
        card5 = new PokerCard(13, 1);
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
    }
    
    @Test
    public void canTestRoyalFlush()
    {
        hand = sortCardHand(hand);
        assertEquals(1, testRoyalFlush(hand));
    }
    
    @Test
    public void canTestStraightFlush()
    {
        card1.setCardNumber(2);
        card1.setCardSuit(0);
        card2.setCardNumber(3);
        card2.setCardSuit(0);
        card3.setCardNumber(4);
        card3.setCardSuit(0);
        card4.setCardNumber(5);
        card4.setCardSuit(0);
        card5.setCardNumber(6);
        card5.setCardSuit(0);
        hand = sortCardHand(hand);
        assertEquals(2, testStraightFlush(hand));
        
    }
    @Test
    public void canTestFullHouse()
    {
        card1.setCardNumber(2);
        card2.setCardNumber(2);
        card3.setCardNumber(2);
        card4.setCardNumber(3);
        card5.setCardNumber(3);
        hand = sortCardHand(hand);
        assertEquals(3, testFullHouse(hand)); 
    }
    @Test
    public void canTestFlush()
    {
        card1.setCardSuit(0);
        card2.setCardSuit(0);
        card3.setCardSuit(0);
        card4.setCardSuit(0);
        card5.setCardSuit(0);
        hand = sortCardHand(hand);
        assertEquals(4, testFlush(hand)); 
    }
    
    @Test
    public void canTestStraight()
    {
        card1.setCardNumber(5);
        card2.setCardNumber(6);
        card3.setCardNumber(7);
        card4.setCardNumber(8);
        card5.setCardNumber(9);
        hand = sortCardHand(hand);
        assertEquals(5, testStraight(hand)); 
    }
    
    @Test
    public void canTestFourOfAKind()
    {
        card1.setCardNumber(5);
        card2.setCardNumber(5);
        card3.setCardNumber(5);
        card4.setCardNumber(5);
        card5.setCardNumber(13);
        hand = sortCardHand(hand);
        assertEquals(6, testFourOfAKind(hand)); 
    }
    
    @Test
    public void canTestThreeOfAKind()
    {
        card1.setCardNumber(5);
        card2.setCardNumber(5);
        card3.setCardNumber(6);
        card4.setCardNumber(5);
        card5.setCardNumber(13);
        hand = sortCardHand(hand);
        assertEquals(7, testThreeOfAKind(hand)); 
    }
    
    @Test
    public void canTestTwoPair()
    {
        card1.setCardNumber(5);
        card2.setCardNumber(5);
        card3.setCardNumber(6);
        card4.setCardNumber(5);
        card5.setCardNumber(5);
        hand = sortCardHand(hand);
        assertEquals(8, testTwoPair(hand)); 
    }
    
    @Test
    public void canTestPair()
    {
        card1.setCardNumber(5);
        card2.setCardNumber(5);
        card3.setCardNumber(6);
        card4.setCardNumber(7);
        card5.setCardNumber(9);
        hand = sortCardHand(hand);
        assertEquals(9, testPair(hand)); 
    }
    
    @Test
    public void canGetHighCard()
    {
        card1.setCardNumber(5);
        card2.setCardNumber(5);
        card3.setCardNumber(6);
        card4.setCardNumber(7);
        card5.setCardNumber(12);
        hand = sortCardHand(hand);
        assertEquals(12, getHighCard(hand)); 
    }
}
