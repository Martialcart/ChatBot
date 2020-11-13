import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ChatBot b = new ChatBot();
        System.out.println(b.welcomeMessage());
        while(true) {
            System.out.println(b.send(in.nextLine()));
        }
    }
}
