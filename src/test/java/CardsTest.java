import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.EnumSet;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class CardsTest {

    @BeforeAll
    Cards cards;

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, names = { "DAYS", "HOURS" })
    void testWithEnumSourceInclude(TimeUnit timeUnit) {
        assertTrue(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
    }

    @org.junit.jupiter.api.Test
    void drawCard() {
    }

    @org.junit.jupiter.api.Test
    void drawTwoCard() {
    }

    @org.junit.jupiter.api.Test
    void getChoice() {
    }

    @org.junit.jupiter.api.Test
    void totalScore() {
    }

    @org.junit.jupiter.api.Test
    void outputForCheckScore() {
    }

    @org.junit.jupiter.api.Test
    void checkScore() {
    }

    @org.junit.jupiter.api.Test
    void play() {
    }

    @org.junit.jupiter.api.Test
    void ifTwentyOne() {
    }

    @org.junit.jupiter.api.Test
    void opponentsTurn() {
    }
}