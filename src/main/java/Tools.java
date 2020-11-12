import java.util.ArrayList;

public class Tools {
    private static StringBuilder strBld = new StringBuilder();
    private static ArrayList<String> words = new ArrayList<String>();
    private static char c;
    private static String s;


    public static ArrayList<String> wordify(String sentence) {
        words.clear();
        s = sentence.toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);

            if(letter(c) || number(c)) {
                strBld.append(c);
            }
            if(c == ' ' || i == s.length() - 1) {
                words.add(strBld.toString());
                strBld.setLength(0);
            }
        }
        return (ArrayList<String>) words.clone();
    }
    private static boolean letter(char c) {
        return c <= 'z' && 'a' <= c;
    }
    private static boolean number(char c) {
        return c <= '0' && '9' <= c;
    }
}
