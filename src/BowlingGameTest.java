import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {
    //Creating a Bowling Game Object

    private BowlingGame gameObj;

    @Before
    public void createGameObject() {
        gameObj = new BowlingGame();
    }

    @Test
    public void rollBall() {
        gameObj.roll(0); // Number of pins we knocked down
    }


    @Test
    public void allZeros() {
        gameObj.roll(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        assertEquals(gameObj.getScore(), 0); // All Throws 0
    }

    @Test
    public void allOnes() {
        gameObj.roll(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        assertEquals(gameObj.getScore(), 20); //All Throws 1
    }

    @Test
    public void spareFollowedByNextElementScore() {
        gameObj.roll(5, 5, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        assertEquals(gameObj.getScore(), 18);
    }

    @Test
    public void strikeFollowedByNextTwoScores() {
        gameObj.roll(10, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        assertEquals(gameObj.getScore(), 26);
    }

    @Test
    public void perfectGame() {
        gameObj.roll(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        assertEquals(gameObj.getScore(), 300);
    }

}
