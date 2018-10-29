import jdk.nashorn.internal.ir.annotations.Ignore;
import org.apache.commons.compress.utils.Iterators;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;

import static org.junit.jupiter.api.Assertions.*;

class CardsTest {
    static ArrayList<Cards> c;


    @BeforeAll
    static public void init() {
        c = new ArrayList<Cards>();
    }

    @ParameterizedTest
    @EnumSource(value = Cards.Rank.class, names = {"TWO", "THREE", "ACE"})
    void testWithEnumSourceInclude(Cards.Rank cardRank) {
        assertTrue(EnumSet.of(Cards.Rank.TWO, Cards.Rank.THREE, Cards.Rank.ACE).contains(cardRank));
    }

    @Test
    void testNewDeck() {
        ArrayList<Cards> c = Cards.newDeck();
        System.out.println(c + "\n" + c.size());
    }
//        Iterators.addAll(c, (Iterator<? extends Cards>) cc);
//        assertThat(cc,
//                IsIterableContainingInAnyOrder.containsInAnyOrder(c));
//        for (List<Card> previouslySeen : c){
//            assertThat(cc,
//                    CoreMatchers.not(
//                            IsIterableContainingInOrder.contains(previouslySeen )));
//        }

    @Test
    void testDrawCard() {
        ArrayList<Cards> c = Cards.newDeck();
        int i = Cards.drawCard();
        System.out.println(c);
        System.out.println(i);
        assertEquals(c.get(0).rank().getNumVal(), i);
    }

    @Ignore
    @Test
    void drawTwoCard() {
    }

    @org.junit.jupiter.api.Test
    void getChoice() {
        //Throwable

    }

    @org.junit.jupiter.api.Test
    void testTotalScore() {
        ArrayList<Integer> p = new ArrayList<Integer>();
        for (int u = 0; u < 52; u++) {
            p.add(Cards.drawCard());
        }
        int b = Cards.totalScore(p);
        assertTrue(b == 296);

    }

    @Ignore
    @org.junit.jupiter.api.Test
    void outputForCheckScore() {


    }

    @org.junit.jupiter.api.Test
    void checkScore() {
        ArrayList<Integer> deck = new ArrayList<Integer>();
        deck.add(11);
        deck.add(10);
        int a = Cards.checkScore(deck);
        assertEquals(0, a);
    }

    @org.junit.jupiter.api.Test
    void play() {
    }

    @org.junit.jupiter.api.Test
    void testIfTwentyOne() {
        ArrayList<Integer> deck = new ArrayList<Integer>();
        deck.add(5);
        deck.add(10);
        boolean isTwOne = Cards.ifTwentyOne(deck);
        assertFalse(isTwOne);
    }

    @org.junit.jupiter.api.Test
    void opponentsTurn() {
    }


}