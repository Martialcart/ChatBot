import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ChatBot {

    private WordLink wl = new WordLink();
    private ArrayList<String> log = new ArrayList<String>();
    private Scorer<String> AnswerScore = new Scorer<>();
    private String temp, lastResponse;
    private final String WELCOME_MESSAGE = "hi, I am chatbot, how are you doing?";



    public String send(String message) {
        String answer = findAnswer(message);
        linkPreviousResponse(message);
        updateLog(message);
        return answer;
    }
    public String welcomeMessage() {
        lastResponse = WELCOME_MESSAGE;
        return WELCOME_MESSAGE;
    }

    private String findAnswer(String message) {
        AnswerScore.reset();
        for(String w: Tools.wordify(message)) {
                for (String s : wl.wordLinks(w)) {
                        AnswerScore.add(s);
                }
        }
        for (int i = log.size()-1; 0 <= i; i--) {
                for (String w :wl.wordLinks(log.get(i))) {
                    AnswerScore.add(w);
                    temp = AnswerScore.winner();
                    if(temp != null) {
                        lastResponse = temp;
                        return temp;
                    }
                }
        }
        return randomMessage();
    }
    private String randomMessage(){
        return wl.randomSentence();
    }

    private void updateLog(String message) {
        log.addAll(Tools.wordify(message));
    }

    private void linkPreviousResponse(String message) {
        for(String s: Tools.wordify(lastResponse)) {
            wl.addLink(s, message);
        }
    }

    public void save() throws IOException {
        wl.save();
    }
}
