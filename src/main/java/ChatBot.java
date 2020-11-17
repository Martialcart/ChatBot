import java.util.ArrayList;

public class ChatBot {
    private WordLink wl = new WordLink();
    private ArrayList<String> log = new ArrayList<String>();
    private Scorer<String> AnswerScore = new Scorer<>();
    private String temp;
    private String lastResponse;
    private final String WELCOME_MESSAGE = "hi, I am chatbot, how are you doing?";


    public void save(){

    }
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
            if(wl.containsWord(w));
                for(String s: wl.wordLinks(w)) {
                    AnswerScore.add(s);
                }
            }
        for (int i = log.size()-1; 0 < i; i--) {
                for (String w :wl.wordLinks(log.get(i))) {
                    AnswerScore.add(w);
                    temp = AnswerScore.winner();
                    if(temp != null) {
                        lastResponse = temp;
                        return temp;
                    }
                }
        }
        return welcomeMessage();
    }

    private void updateLog(String message) {
        log.addAll(Tools.wordify(message));
    }

    private void linkPreviousResponse(String message) {
        for(String s: Tools.wordify(lastResponse)) {
            wl.addLink(s, message);
        }
    }
}
