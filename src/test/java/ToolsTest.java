import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToolsTest {
    @BeforeAll
    public void setup(){

    }

    @Test
    public void WordifyRemoveSignsTest(){
        String signs = "|§!\"#¤%&/()=?`^¨'*_-:~´´}][{€$£@";
        String[] expected = {""};
        String[] result = Tools.wordify(signs);
        assertEquals(expected, result);
    }

    @Test
    public void WordifySentenceToWordsTest(){
        String sentence = "this is a test";
        String[] expected = {"this", "is", "a", "test"};
        String[] result = Tools.wordify(sentence);
        assertEquals(expected, result);
    }

    @Test
    public void WordifyUpperToLowerCaseTest() {
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        String[] expected = {"abcdefghijklmnopqrstuvwxyzæøå"};
        String[] result = Tools.wordify(uppercase);
        assertEquals(expected, result);
    }
}
