import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * returns
 * @param <T> object to be counted
 */
public class Scorer<T> {
    private HashMap<T, Integer> scores = new HashMap<T, Integer>();
    private int temp;
    private T winner = null;
    public Scorer(){}

    /**
     *
     * @param args of element T are scored
     */
    public void add(T... args) {
        for (int i = 0; i < args.length; i++) {
            count(args[i]);
        }
    }

    /**
     *
     * @param key is counted, and stored value is amount of time it has been counted
     */
    private void count(T key) {
        if(scores.containsKey(key)) {
            temp = scores.get(key) + 1;
            scores.replace(key, temp);
        } else {
            scores.put(key,1);
        }
    }

    /**
     * @param list of elements to be scored
     */
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
        winner = null;
    }
    public T winner() {
        int first = 0;
        int second= 0;

        for(T s: scores.keySet()) {
            temp = scores.get(s);
            if (second < temp) {
                if(first < temp) {
                    second = first;
                    first = temp;
                    winner = s;
                }else {
                    second = temp;
                }
            }
        }
        if(second < first) return winner;
        winner = null;
        return null;
    }
}
