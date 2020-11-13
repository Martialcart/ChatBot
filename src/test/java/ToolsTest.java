import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ToolsTest {
    private static ArrayList<String> expected = new ArrayList<String>();
    private static ArrayList<String> result = new ArrayList<String>();

    @BeforeEach
    public void setup() {
        expected.clear();
    }

    @Test
    public void WordifyRemoveSignsTest(){
        String signs = "|§!\"#¤%&/()=?`^¨'*_-:~´´}][{€$£@";
        expected.add("");
        result = Tools.wordify(signs);
        equalArray(expected, result);
    }

    @Test
    public void WordifySentenceToWordsTest(){
        String sentence = "this is a test";
        expected.add("this");
        expected.add("is");
        expected.add("a");
        expected.add("test");
        result = Tools.wordify(sentence);
        equalArray(expected, result);
    }

    @Test
    public void WordifyUpperToLowerCaseTest() {
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        expected.add("abcdefghijklmnopqrstuvwxyz");
        result = Tools.wordify(uppercase);
        equalArray(expected, result);
    }

    private static void equalArray(ArrayList<String> s1, ArrayList<String> s2) {
        if (s1.size()!= s2.size()) fail(   "\nexpected size = " + s1.size() +
                                            "\nresult size = " + s2.size());
        for (int i = 0; i < s1.size(); i++) {
            assertEquals(s1.get(i), s2.get(i));
        }
    }
}
