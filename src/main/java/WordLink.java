import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 *A two way HashMap
 * a word key can open several sentences.
 * a sentence key can open several words.
 */
public class WordLink {
    FileWriter buffer;
    private static final String NEXT_LINE = "\n";
    private static final String SPACE = " ";
    private HashMap<String, HashSet<String>> words = new HashMap<>();
    private HashMap<String, HashSet<String>> sentences = new HashMap<>();
    private List<String> list = new ArrayList<>();

    public void addLink(String word, String sentence) {
        add(word, sentence, words);
        add(sentence, word, sentences);
    }
    public int wordAmount() {
        return words.size();
    }
    public void save() throws IOException {
        File save = new File("text.txt");
        buffer = new FileWriter(save);
        sentences.keySet().iterator().forEachRemaining(s -> {
            write(s + NEXT_LINE);
            sentences.get(s).forEach(w -> {
                write(w + SPACE);
            });
            write(NEXT_LINE);
        });
        buffer.close();
    }

    public int sentenceAmount() {
        return sentences.size();
    }

    public HashSet<String> wordLinks(String word) {
        return clone(words.get(word));
    }
    private void write(String s) {
        try {
            buffer.append(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashSet<String> sentenceLink(String sentence) {
        return clone(sentences.get(sentence));
    }
    private HashSet<String> clone(HashSet<String> original) {
        HashSet<String> set = new HashSet<>();
        if(original != null) set.addAll(original);
        return set;
    }
    private void add(String key, String value, HashMap<String,HashSet<String>> map) {
        if (!map.containsKey(key)) {
            map.put(key, new HashSet<String>());
        }
        map.get(key).add(value);
    }

    public boolean containsWord(String word) {
        return words.containsKey(word);
    }

    public String randomSentence() {
        list = new ArrayList<String>(sentences.keySet());
        int num = (int) Math.random() * (list.size() - 1);
        return list.get(num);
    }
}
