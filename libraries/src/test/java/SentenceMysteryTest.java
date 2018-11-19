package backend;

import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SentenceMysteryTest {
    private SentenceMystery sentenceMystery;

    @Before
    public void setUp() {
        sentenceMystery = new SentenceMystery();
    }

    @Test
    public void TestChoiceMystery() throws Exception {
        Pair<String, List<String>> mystery = sentenceMystery.ChoiceMystery("easy");

        assertTrue("The key is not a string", mystery.getKey() instanceof String);
        assertTrue("The key is empty",mystery.getKey().length() > 0);
        assertTrue("The value is not a list", mystery.getValue() instanceof List);
        assertTrue("The value is empty",mystery.getValue().size() > 0);
    }
}
