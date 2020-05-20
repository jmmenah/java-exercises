// https://github.com/RicardoMoya/Gson_Example
// https://jarroba.com/gson-json-java-ejemplos/

import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;

/***
 * Manual deserialization example
 *
 * @author RicardoMoya
 *
 */
public class ReadJson1 {

    public static void main(String[] args) {

        String json1 = "[{\"dorsal\":6," + "\"name\":\"Iniesta\","
                + "\"demarcation\":[\"Right winger\",\"Midfielder\"]," + "\"team\":\"FC Barcelona\"}]";

        System.out.println(json1);

        JsonElement jsonElement = JsonParser.parseString(json1);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        System.out.println(gson.toJson(jsonElement));

        // Obtain Array
        JsonArray gsonArr = jsonElement.getAsJsonArray();

        // for each element of array
        for (JsonElement obj : gsonArr) {

            // Object of array
            JsonObject gsonObj = obj.getAsJsonObject();

            // Primitives elements of object
            int dorsal = gsonObj.get("dorsal").getAsInt();
            String name = gsonObj.get("name").getAsString();
            String team = gsonObj.get("team").getAsString();

            // List of primitive elements
            JsonArray demarcation = gsonObj.get("demarcation").getAsJsonArray();
            List<String> listDemarcation = new ArrayList<String>();
            for (JsonElement demarc : demarcation) {
                listDemarcation.add(demarc.getAsString());
            }

            // Object Constructor
            FootballPlayer iniesta = new FootballPlayer(dorsal, name, listDemarcation, team);
            System.out.println(iniesta);
        }

    }
}
