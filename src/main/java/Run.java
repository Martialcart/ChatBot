import java.io.IOException;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ChatBot b = new ChatBot();
        System.out.println(b.welcomeMessage());
        for (int i = 0; i < 2; i++) {
            System.out.println(b.send(in.nextLine()));
        }
        try {
            b.save("test1.txt");
            b.load("test1.txt");
            b.save("test2.txt");
            b.load("test2.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
