import java.util.ArrayList;
import java.util.HashMap;

public class Scorer<T> {
    private HashMap<T, Integer> scores = new HashMap<T, Integer>();
    private int temp;
    public Scorer(){}

    public void add(T... args) {
        for (int i = 0; i < args.length; i++) {
            count(args[i]);
        }
    }
    private void count(T key) {
        if(scores.containsKey(key)) {
            temp = scores.get(key) + 1;
            scores.replace(key, temp);
        } else {
            scores.put(key,1);
        }
    }
    public void addAll(ArrayList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            count(list.get(i));
        }
    }
    public int size() {
        return scores.size();
    }

    public void reset() {
        scores.clear();
    }
    public boolean winner() {
        return true;
    }
}
