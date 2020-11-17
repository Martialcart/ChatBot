import java.util.HashMap;
import java.util.HashSet;

/**
 *A two way HashMap
 * a word key can open several sentences.
 * a sentence key can open several words.
 */
public class WordLink {
    private HashMap<String, HashSet<String>> words = new HashMap<>();
    private HashMap<String, HashSet<String>> sentences = new HashMap<>();

    public void addLink(String word, String sentence) {
        add(word, sentence, words);
        add(sentence, word, sentences);
    }
    public int wordAmount() {
        return words.size();
    }

    public int sentenceAmount() {
        return sentences.size();
    }

    public HashSet<String> wordLinks(String word) {
        System.out.println("word");
        return clone(words.get(word));
    }

    public HashSet<String> sentenceLink(String sentence) {
        System.out.println("sentence");
        return clone(sentences.get(sentence));
    }
    private HashSet<String> clone(HashSet<String> original) {
        HashSet<String> set = new HashSet<>();
        set.addAll(original);
        return set;
    }
    private void add(String key, String value, HashMap<String,HashSet<String>> map) {
        if (!map.containsKey(key)) {
            map.put(key, new HashSet<String>());
        }
        map.get(key).add(value);
    }
}
