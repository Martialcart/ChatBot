import java.util.HashMap;

public class Scorer<T> {
    private HashMap<T, Integer> scores = new HashMap<T, Integer>();
    public Scorer(){}

    public void add(T... args) {
        for (int i = 0; i < args.length; i++) {
            if(scores.containsKey(args[i])) {
                scores.get(args[i]) = scores.get(args[i]) + 1;
            }
            scores.put()
        }
    }
}
