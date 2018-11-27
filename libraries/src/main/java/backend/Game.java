package backend;

import org.json.JSONObject;
import javafx.util.*;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player;
    private Difficulty difficulty;
    private TypeMystery typeMystery;
    private Pair<String, List<String>> mystery;
    private ArrayList<Character> letterDisplay;
    private ArrayList<TypeBonus> bonusList = new ArrayList<TypeBonus>();

    public Game(Difficulty difficulty) { //Ajouter Player
        this.difficulty = difficulty;

        this.bonusList.add(new RemoveLetter());
    }

    /* To play an other gameMystery
     *
     * @return void
     */
    public void NextMystery() { typeMystery.NextMystery(this); }

    /* Modifies the letters to display through the interface
     *
     * @param  letterDisplay   the new letters to display
     * @return void
     */
    public void SetLetterDisplay(ArrayList<Character> letterDisplay) { this.letterDisplay = letterDisplay; }

    /* Get the letters to display through the interface
     *
     * @return an ArrayList with the letters to display
     */
    public ArrayList<Character> GetLetterDisplay() { return this.letterDisplay; }

    /* Modifies the letters to display through the interface
     *
     * @param  letterDisplay   the new letters to display
     * @return void
     */
    public void SetTypeMystery(TypeMystery typeMystery) { this.typeMystery = typeMystery; }

    /* Modifies the Difficulty of the game
     *
     * @param  difficulty      the new difficulty that the user has chosen
     * @return void
     */
    public void SetDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }

    /* Gives the Difficulty of the game
     *
     * @return an object Difficulty representing the difficulty of the current game
     */
    public Difficulty GetDifficulty() { return this.difficulty; }

    /* Changes the mystery to display through the interface
     *
     * @param  mystery      the new mystery to display (a map where the key is the response of the mystery and the value is the mystery)
     * @return void
     */
    public void SetMystery(Pair<String, List<String>> mystery) { this.mystery = mystery; }

    /* Gives the current mystery of the game
     *
     * @return void
     */
    public Pair<String, List<String>> GetMystery() { return mystery; }

    /* Gives the available bonuses
     *
     * @return          a ArrayList of TypeBonus representing the available bonuses
     */
    public ArrayList<TypeBonus> GetBonusList() { return bonusList; }

    /* Gives the current player who is playing
     *
     * @return a Player object representing the current player
     */
    public Player GetPlayer() { return player; }

    /* Connect and initialize a player
     *
     * @param  pseudo   the pseudo of the player
     * @param  password the password of the player
     * @return void
     */
    public void Login(String pseudo, String password) {
        JSONObject playerData = CheckLogin(pseudo,password);

        if (playerData.length() != 0) {
            Player player = new Player(pseudo);
            this.player = player;

            try {
                int playerCoins = (int) playerData.get("coins");
                player.SetCoins(playerCoins);

                System.out.print("Connection réussie");

            } catch (Exception e) {
                System.out.print("Connection échouée");

            }
        } else {
            System.out.print("Connection échouée");
        }
    }


    /* Check the pseudo and the password of a player
     *
     * @param  pseudo   the pseudo of the player
     * @param  password the password of the player
     * @return          a JSONObject representing the player's data
     */
    private JSONObject CheckLogin(String pseudo, String password) {
        JSONObject objectNull = new JSONObject();

        try {
            JSONObject db = Utils.ReadDatabase(Utils.url + "/../libraries/src/main/resources/playerDatabase.json");

            JSONObject playerData = db.getJSONObject(pseudo);
            String pass = (String) playerData.get("password");

            if (pass.equals(password)) {
                return playerData;
            } else {
                return objectNull;           //invalid password
            }

        } catch (Exception e) {
            return objectNull;               //invalid pseudo
        }

    }


    /* Update the json which represent the player's data
     *
     * @return void
     */
    public void Save() {
        try {
            JSONObject db = Utils.ReadDatabase(Utils.url + "/../libraries/src/main/resources/playerDatabase.json");
            JSONObject playerData = db.getJSONObject(player.GetPseudo());
            playerData.put("coins",player.GetCoins());

            try (FileWriter files = new FileWriter(Utils.url + "/../libraries/src/main/resources/playerDatabase.json"))
            {
                files.write(db.toString());
                System.out.println("\nSuccessfully updated json object to file !");
            }
        } catch (Exception e) {
            System.out.print(e);
        }

    }


}
