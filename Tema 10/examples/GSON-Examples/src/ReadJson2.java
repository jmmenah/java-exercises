// https://github.com/RicardoMoya/Gson_Example
// https://jarroba.com/gson-json-java-ejemplos/

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/***
 * Automatic deserialization example
 *
 * @author RicardoMoya
 *
 */
public class ReadJson2 {

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

        String jsonAll = "[{\"dorsal\":1,\"name\":\"Casillas\",\"demarcation\":[\"Goalkeeper\"],\"team\":\"Real Madrid\"},"
                + "{\"dorsal\":15,\"name\":\"Ramos\",\"demarcation\":[\"Right back\",\"Centre-back\"],\"team\":\"Real Madrid\"},"
                + "{\"dorsal\":3,\"name\":\"Pique\",\"demarcation\":[\"Centre-back\"],\"team\":\"FC Barcelona\"},"
                + "{\"dorsal\":5,\"name\":\"Puyol\",\"demarcation\":[\"Centre-back\"],\"team\":\"FC Barcelona\"},"
                + "{\"dorsal\":11,\"name\":\"Capdevila\",\"demarcation\":[\"Left back\"],\"team\":\"Villareal\"},"
                + "{\"dorsal\":14,\"name\":\"Xabi Alonso\",\"demarcation\":[\"Defensive midfield\",\"Midfield\"],\"team\":\"Real Madrid\"},"
                + "{\"dorsal\":16,\"name\":\"Busquets\",\"demarcation\":[\"Defensive midfield\"],\"team\":\"FC Barcelona\"},"
                + "{\"dorsal\":8,\"name\":\"Xavi Hernandez\",\"demarcation\":[\"Midfielder\"],\"team\":\"FC Barcelona\"},"
                + "{\"dorsal\":18,\"name\":\"Pedrito\",\"demarcation\":[\"Left winger\",\"False forward\"],\"team\":\"FC Barcelona\"},"
                + "{\"dorsal\":6,\"name\":\"Iniesta\",\"demarcation\":[\"Right winger\",\"Midfielder\"],\"team\":\"FC Barcelona\"},"
                + "{\"dorsal\":7,\"name\":\"Villa\",\"demarcation\":[\"Centre forward\"],\"team\":\"FC Barcelona\"}]";

        //  prettyPrint(jsonAll);

        Gson gson = new Gson();
        FootballPlayer[] footballPlayers = gson.fromJson(jsonAll,
                FootballPlayer[].class);
        for (FootballPlayer footballPlayer : footballPlayers) {
            System.out.println(footballPlayer);
        }

    }
}
