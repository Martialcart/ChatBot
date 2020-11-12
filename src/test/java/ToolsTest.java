import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ToolsTest {

    @Test
    public void WordifyRemoveSignsTest(){
        String signs = "|§!\"#¤%&/()=?`^¨'*_-:~´´}][{€$£@";
        String[] expected = {""};
        String[] result = Tools.wordify(signs);
        equalArray(expected, result);
    }

    @Test
    public void WordifySentenceToWordsTest(){
        String sentence = "this is a test";
        String[] expected = {"this", "is", "a", "test"};
        String[] result = Tools.wordify(sentence);
        equalArray(expected, result);
    }

    @Test
    public void WordifyUpperToLowerCaseTest() {
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        String[] expected = {"abcdefghijklmnopqrstuvwxyzæøå"};
        String[] result = Tools.wordify(uppercase);
        equalArray(expected, result);
    }

    private void equalArray(String[] s1, String[] s2) {
        if (s1.length != s2.length) fail("Array's have different lengths");
        for (int i = 0; i < s1.length; i++) {
            assertEquals(s1[i], s2[i]);
        }
    }
}
