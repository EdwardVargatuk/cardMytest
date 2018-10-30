import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardsTest {


    @ParameterizedTest
    @EnumSource(value = Cards.Rank.class, names = {"TWO", "THREE", "ACE"})
    void testWithEnumSourceInclude(Cards.Rank cardRank) {
        assertTrue(EnumSet.of(Cards.Rank.TWO, Cards.Rank.THREE, Cards.Rank.ACE).contains(cardRank));
    }

    @org.junit.jupiter.api.Test
    void testCalcTotalScore() {
        List<Cards> c = Cards.newDeck();
        ArrayList<Integer> deck = new ArrayList<Integer>();
        for (int i = 0; i < c.size(); i++) {
            deck.add(Cards.drawCard());
        }
        int totalScoreOfWholeDeck = Cards.calcTotalScore(deck);
        assertTrue(totalScoreOfWholeDeck == 296);

    }


    @Test
    void testNewDeck() {
        List<Cards> deck = Cards.newDeck();
        assertEquals(52, deck.size());
    }

    @Test
    void testDrawCard() {
        List<Cards> c = Cards.newDeck();
        int i = Cards.drawCard();
        assertEquals(c.get(0).rank().getNumVal(), i);
    }

    @Test
    void testDrawTwoCard() {
        List<Integer> deck = Cards.drawTwoCard();
        assertEquals(2, deck.size());
    }

    @Ignore
    @Test
    void getChoice() {
    }

    @Ignore
    @org.junit.jupiter.api.Test
    void testCheckToContinueGameAndPrintMessage() {
    }

    @ParameterizedTest
//  @ValueSource(ints = {2,2,1} )  don`t works
    @CsvSource(value = {"2, 2, 1", "11,11,2"})
    void testCheckScore(int val1, int val2, int expected_res) {
        ArrayList<Integer> deck = new ArrayList<Integer>();
        deck.add(val1);
        deck.add(val2);
        assertEquals(expected_res, Cards.checkScore(deck));
    }

    @ParameterizedTest
    @CsvSource(value = {"10, 11, true", "11,11,false"})
    void testIfTwentyOne(int val1, int val2, boolean expected_res) {
        ArrayList<Integer> deck = new ArrayList<Integer>();
        deck.add(val1);
        deck.add(val2);
        assertEquals(expected_res, Cards.ifTwentyOne(deck));
    }


    @Ignore
    @org.junit.jupiter.api.Test
    void play() {
    }

    @Ignore
    @org.junit.jupiter.api.Test
    void opponentsTurn() {
    }


}