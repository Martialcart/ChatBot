import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class ChatbotTest {
    @Test
    public void AnswerTest() {
        ChatBot bot = new ChatBot();
        if (bot.send("Hello") == "") fail("empty message");
    }
}
