public class Run {
    public static void main(String[] args) {
        String[] test = Tools.wordify("testing dette her");
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }
}
