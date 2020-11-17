import java.io.IOException;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ChatBot b = new ChatBot();
        System.out.println(b.welcomeMessage());
        for (int i = 0; i < 5; i++) {
            System.out.println(b.send(in.nextLine()));
        }
        try {
            b.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
