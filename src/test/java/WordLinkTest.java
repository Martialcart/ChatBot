import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class WordLinkTest {

    private WordLink wl;

    @BeforeEach
    public void setup() {
        wl = new WordLink();
    }
    @Test
    public void containsWordTest() {
        wl.addLink("Hei","Heisan!, hyggelig å møte deg.");
        assertTrue(wl.containsWord("Hei"), "WordLink should contain the key \"Hei\"");
        assertFalse(wl.containsWord("test"), "WordLink Should not contain the key \"test\"");
    }
    @Test
    public void noWordDuplicates(){
        wl.addLink("Hei","Heisan!, hyggelig å møte deg.");
        wl.addLink("Hei","Hei!, hvordan går det?");
        assertEquals(1,wl.wordAmount(), "word duplicates");
    }

    @Test
    public void noSentenceDuplicates() {
        wl.addLink("Hei", "Heisan!, hyggelig å møte deg.");
        wl.addLink("hallo", "Heisan!, hyggelig å møte deg.");
        assertEquals(1, wl.sentenceAmount(), "sentence duplicates");
    }
    @Test
    public void noWordLinkDuplicates(){
        wl.addLink("Hei", "Heisan!, hyggelig å møte deg.");
        wl.addLink("Hei", "Heisan!, hyggelig å møte deg.");
        wl.addLink("Hei", "Heisan!, hyggelig å møte deg.");
        wl.addLink("Hei", "Heisan!, hyggelig å møte deg.");
        assertEquals(1, wl.wordLinks("Hei").size(), "Word link duplicates");
    }
    @Test
    public void noSentenceLinkDuplicates(){
        wl.addLink("Hei", "Heisan!, hyggelig å møte deg.");
        wl.addLink("Hei", "Heisan!, hyggelig å møte deg.");
        wl.addLink("Hei", "Heisan!, hyggelig å møte deg.");
        wl.addLink("Hei", "Heisan!, hyggelig å møte deg.");
        assertEquals(1, wl.sentenceLink("Heisan!, hyggelig å møte deg.").size(), "Sentence link duplicates");
    }
    @Test
    public void addLinkTest() {
        wl.addLink("Hei","Heisan!, hyggelig å møte deg.");
        assertEquals(1,wl.wordAmount(), "word links");
        assertEquals(1,wl.sentenceAmount(), "sentence links");
    }

    @Test
    public void randomMessageTest(){
        wl.addLink("Hei", "Heisan!, hyggelig å møte deg.");
        wl.addLink("livet", "Meningen med livet er å underholde meg");
        System.out.println( wl.randomSentence());
    }
}
