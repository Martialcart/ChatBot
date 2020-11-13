import org.junit.jupiter.api.BeforeAll;
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
    public void onlyOneWinnerSuccesTest() {
        scr.add(12,100,10,25,12, 30, 31, 25, 25);
        assertEquals(25, scr.winner(), "Object counted the most");
    }

    @Test
    public void onlyOneWinnerFailTest() {
        scr.add(1,2,2,3,3,3,4,4,4);
        assertEquals(null, scr.winner());
    }


    @Test
    public void addTest() {
        scr.add(1);
        assertEquals(1, scr.size());
    }
    @Test
    public void addAllTest(){
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < ITERATIONS; i++) {
            numbers.add(i);
        }
        scr.addAll(numbers);
        assertEquals(ITERATIONS, scr.size(), "amount of elements");
    }
    @Test
    public void resetTest() {
        scr.add(1);
        scr.reset();
        assertEquals(0,scr.size());
    }
}
