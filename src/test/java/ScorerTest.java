import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScorerTest{
    private Scorer<Integer> scr;
    private final int ITERATIONS = 10;

    @BeforeEach
    public void setup(){
        scr = new Scorer<Integer>();
    }

    @Test
    public void onlyOneWinnerTest() {
        scr.add(1,1,2,2,3,3,4,4,5,5);
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
