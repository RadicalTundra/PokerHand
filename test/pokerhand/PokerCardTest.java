package pokerhand;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author tgrady4
 */
public class PokerCardTest {
    PokerCard card1;
    
    @Before
    public void setup(){
        card1 = new PokerCard(0, 10);
    }
    
    @Test
    public void canSetAndGetCardNumber()
    {
        card1.setCardNumber(4);
        assertEquals(4, card1.getCardNumber()); 
    }
    
    @Test
    public void canSetAndGetCardSuit()
    {
        card1.setCardSuit(2);
        assertEquals(2, card1.getCardSuit()); 
    }
}
