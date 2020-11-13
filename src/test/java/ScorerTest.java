import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ScorerTest{
    private Scorer<Integer> scr;
    private final int ITERATIONS = 10;

    @BeforeEach
    public void setup(){
        scr = new Scorer<Integer>();
    }

    @Test
    public void onlyOneWinnerFailTest() {
        scr.add(1,2,2,3,3,3,4,4,4,4);
        assertFalse(scr.winner());
    }
    @Test
    public void onlyOneWinnerSuccesTest() {
        scr.add(1,1,2,2,3,3,3,4,4,4,4);
        assertTrue(scr.winner());
    }

    @Test
    public void addTest() {
        scr.add(1);
        assertEquals(1, scr.size());
    }
    @Test
    public void resetTest() {
        scr.add(1);
        scr.reset();
        assertEquals(0,scr.size());
    }
}
