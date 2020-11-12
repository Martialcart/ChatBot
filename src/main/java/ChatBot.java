import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChatBot {
    private ArrayList<String> sentence = new ArrayList<String>();
    private ArrayList<String> log = new ArrayList<String>();
    private Map<String, Integer> word = new HashMap<String, Integer>();

    public ChatBot() {
    }
    public String send(String message) {
        sentence.add(message);

        return "";
    }


}
