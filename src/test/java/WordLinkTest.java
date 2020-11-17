import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class WordLinkTest {

    private WordLink wl;

    @BeforeEach
    public void setup() {
        wl = new WordLink();
    }
    @Test
    public void containsWordTest() {
        wl.addLink("Hei","Heisan!, hyggelig å møte deg.");
        assertTrue(wl.containsWord("Hei"));
        assertFalse(wl.containsWord("test"));
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
}
