package backend;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RemoveLetterTest {
    private Difficulty difficulty;
    private SentenceMystery sentenceMystery;
    private Game game;

    @Before
    public void setUp() {
        difficulty = new Difficulty("easy");
        sentenceMystery = new SentenceMystery();

        game = new Game(difficulty);
        game.SetTypeMystery(sentenceMystery);
        game.Login("Houda", "cool");
        game.NextMystery();
    }

    @Test
    public void TestApplyBonus() throws Exception {
        game.GetBonusList().get(0).ApplyBonus(game);
        ArrayList<Character> displayLetters = game.GetLetterDisplay();

        assertTrue("The displayLetter list does not egale to 12", displayLetters.size() == 12);
        assertTrue("displayLetter does not a instance of ArrayList<Character>", displayLetters instanceof List);
    }
}
