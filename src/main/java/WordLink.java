import java.util.ArrayList;
import java.util.HashMap;
/**
 *A two way HashMap
 * a word key can open several sentences, and opposite.
 */
public class WordLink {
    private HashMap<String, ArrayList<Integer>> word = new HashMap<>();
    private ArrayList<String> sentence = new ArrayList<>();
}
