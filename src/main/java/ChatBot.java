import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatBot {
    private ArrayList<String> sentence = new ArrayList<String>();
    private ArrayList<String> log = new ArrayList<String>();
    private Map<String, List<Integer>> word = new HashMap<String, List<Integer>>();
    private Scorer<Integer> sentenceScore = new Scorer<>();
    private Integer temp;
    private Integer lastResponseIndex;
    private final String WELCOME = "hi, I am chatbot, how are you doing?";

    public ChatBot() {
        sentence.add(WELCOME);
    }
    public String send(String message) {
        recordMessage(message);
        return findAnswer();
    }
    public String welcomeMessage() {
        lastResponseIndex = 0;
        return sentence.get(0);
    }

    private String findAnswer() {
        sentenceScore.reset();
        for (int i = log.size()-1; 0 < i; i--) {
            if(word.containsKey(log.get(i))) {
                for (Integer w :word.get(log.get(i))) {
                    sentenceScore.add(w);
                    if(i%5 == 0) temp = sentenceScore.winner();
                    if(temp != null) {
                        lastResponseIndex = temp;
                        return sentence.get(temp);
                    }
                }
            }
        }
        return randomMessage();
    }

    private String randomMessage() {
        return sentence.get((int)(Math.random() * (sentence.size() - 1)));
    }

    private void recordMessage(String message) {
        linkPreviousResponse(message);
        sentence.add(message);
        log.addAll(Tools.wordify(message));
    }

    private void linkPreviousResponse(String message) {
        if(sentence.contains(message)) {
            temp = sentence.indexOf(message);
            for(String w: Tools.wordify(sentence.get(lastResponseIndex))) {
                if(word.containsKey(w)) {
                    word.get(w).add(temp);
                }else {
                    word.put(w,new ArrayList<>());
                    word.get(w).add(temp);
                }
            }
        }
    }
}
