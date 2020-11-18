import java.io.*;
import java.util.*;

/**
 *A two way HashMap
 * a word key can open several sentences.
 * a sentence key can open several words.
 */
public class WordLink {
    FileWriter writer;
    Scanner reader;
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

    public void save(String fileName) throws IOException {
        File save = new File(fileName);
        writer = new FileWriter(save);

        sentences.keySet().iterator().forEachRemaining(sentence -> {
            write(sentence + NEXT_LINE);
            sentences.get(sentence).forEach(word -> {
                write(word + SPACE);
            });
            write(NEXT_LINE);
        });
        writer.close();
    }

    public int sentenceAmount() {
        return sentences.size();
    }

    public HashSet<String> wordLinks(String word) {
        return clone(words.get(word));
    }
    private void write(String s) {
        try {
            writer.append(s);
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
        if(list.isEmpty()) return null;
        int num = (int) Math.random() * (list.size() - 1);
        return list.get(num);
    }

    public void combine(String fileName) throws FileNotFoundException {
        String sentence;
        File load  = new File(fileName);
        reader = new Scanner(load);
        while(reader.hasNextLine()) {
            sentence = reader.nextLine();
            for(String word: Tools.wordify(reader.nextLine())) {
                addLink(word, sentence);
            }
        }
        reader.close();
    }

    public void load(String filename) throws FileNotFoundException {
        reset();
        combine(filename);
    }

    private void reset() {
        words.clear();
        sentences.clear();
    }
}
