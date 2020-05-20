
// https://github.com/RicardoMoya/Gson_Example
// https://jarroba.com/gson-json-java-ejemplos/

import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

/***
 * Automatic serialization example
 *
 * @author RicardoMoya
 *
 */
public class WriteJson {

    public static void prettyPrint(String json) {
        /*
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement jsonElement = JsonParser.parseString(json);
        String prettyJsonString = gson.toJson(jsonElement);
		System.out.println (prettyJsonString);
         */
        // One line code
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(JsonParser.parseString(json)));
    }

    public static void main(String[] args) {

        List<FootballPlayer> spanishTeam = Arrays.asList(
                new FootballPlayer(1, "Casillas", Arrays.asList("Goalkeeper"), "Real Madrid"),
                new FootballPlayer(15, "Ramos", Arrays.asList("Right back", "Centre-back"), "Real Madrid"),
                new FootballPlayer(3, "Pique", Arrays.asList("Centre-back"), "FC Barcelona"),
                new FootballPlayer(5, "Puyol", Arrays.asList("Centre-back"), "FC Barcelona"),
                new FootballPlayer(11, "Capdevila", Arrays.asList("Left back"), "Villareal"),
                new FootballPlayer(14, "Xabi Alonso", Arrays.asList("Defensive midfield", "Midfield"), "Real Madrid"),
                new FootballPlayer(16, "Busquets", Arrays.asList("Defensive midfield"), "FC Barcelona"),
                new FootballPlayer(8, "Xavi Hernandez", Arrays.asList("Midfielder"), "FC Barcelona"),
                new FootballPlayer(18, "Pedrito", Arrays.asList("Left winger", "False forward"), "FC Barcelona"),
                new FootballPlayer(6, "Iniesta", Arrays.asList("Right winger", "Midfielder"), "FC Barcelona"),
                new FootballPlayer(7, "Villa", Arrays.asList("Centre forward"), "FC Barcelona"));

        String json = new Gson().toJson(spanishTeam);
        System.out.println(json);
        prettyPrint(json);
    }
}
