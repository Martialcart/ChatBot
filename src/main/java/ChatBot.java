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
    public void save(){

    }
    public String send(String message) {
        String answer = findAnswer(message);
        recordMessage(message);
        return answer;
    }
    public String welcomeMessage() {
        lastResponseIndex = 0;
        return sentence.get(0);
    }

    private String findAnswer(String message) {
        sentenceScore.reset();
        for(String w: Tools.wordify(message)) {
            if (word.containsKey(w)) {
                for(Integer i: word.get(w)) {
                    sentenceScore.add(i);
                }
            }
        }

        for (int i = log.size()-1; 0 < i; i--) {
            if(word.containsKey(log.get(i))) {
                for (Integer w :word.get(log.get(i))) {
                    sentenceScore.add(w);
                    temp = sentenceScore.winner();
                    if(temp != null) {
                        lastResponseIndex = temp;
                        return sentence.get(temp);
                    }
                }
            }
        }
        return randomMessage() + "random message";
    }

    private String randomMessage() {
        temp = (int)(Math.random() * (sentence.size() - 1));
        lastResponseIndex = temp;
        return sentence.get(temp);
    }

    private void recordMessage(String message) {
        linkPreviousResponse(message);
        log.addAll(Tools.wordify(message));
    }

    private void linkPreviousResponse(String message) {
        if(!sentence.contains(message)) {
            sentence.add(message);
        }
        temp = sentence.indexOf(message);
        for(String w: Tools.wordify(sentence.get(lastResponseIndex))) {
            if(word.containsKey(w) && !word.get(w).contains(w)) {
                this.word.get(w).add(temp);
            }else {
                System.out.println("added new word " + w);
                word.put(w,new ArrayList<>());
                word.get(w).add(temp);
            }
        }
    }
}
