import java.util.HashMap;

public class Scorer<T> {
    private HashMap<T, Integer> scores = new HashMap<T, Integer>();
    private int temp;
    public Scorer(){}

    public void add(T... args) {
        for (int i = 0; i < args.length; i++) {
            if(scores.containsKey(args[i])) {
                temp = scores.get(args[i]).intValue() + 1;
                scores.replace(args[i], temp);
            } else {
                scores.put(args[i],1);
            }
        }
    }
    public int size() {
        return scores.size();
    }

    public void reset() {
        scores.clear();
    }
}
