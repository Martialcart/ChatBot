import com.sun.org.apache.xalan.internal.xsltc.dom.MultiValuedNodeHeapIterator;
import com.sun.scenario.effect.impl.HeapImage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatBot {
    private ArrayList<String> sentence = new ArrayList<String>();
    private ArrayList<String> log = new ArrayList<String>();
    private ArrayList<String> sentenceScores = new ArrayList<String>();
    private Map<String, List<Integer>> word = new HashMap<String, List<Integer>>();
    private int lastBotMessageIndex;

    public ChatBot() {
    }
    public String send(String message) {
        sentence.add(message);
        log.addAll(Tools.wordify(message));

        for (int i = log.size(); 0 < i; i--) {
            if(word.containsKey(log)) {
                for (Integer w :word.get(log.get(i))) {
                   //create sentence scores
                }
            }
        }

        return "";
    }


}
