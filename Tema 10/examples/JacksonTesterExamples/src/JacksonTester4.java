/*
 * Jackson Tutorial
 * https://www.tutorialspoint.com/jackson/index.htm
 */
/*
 * Tree Model prepares a in-memory tree representation of the JSON document.
 * ObjectMapper build tree of JsonNode nodes. It is most flexible approach.
 * It is analogus to DOM parser for XML.
 */
// Jackson - Tree Model
// https://www.tutorialspoint.com/jackson/jackson_tree_model.htm

import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTester4 {
    public static void main(String args[]) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = "{\"name\":\"Mahesh Kumar\",  \"age\":21,\"verified\":false,\"marks\": [100,90,85]}";
            JsonNode rootNode = mapper.readTree(jsonString);

            JsonNode nameNode = rootNode.path("name");
            System.out.println("Name: " + nameNode.textValue());

            JsonNode ageNode = rootNode.path("age");
            System.out.println("Age: " + ageNode.intValue());

            JsonNode verifiedNode = rootNode.path("verified");
            System.out.println("Verified: " + (verifiedNode.booleanValue() ? "Yes" : "No"));

            JsonNode marksNode = rootNode.path("marks");
            Iterator<JsonNode> iterator = marksNode.elements();
            System.out.print("Marks: [ ");

            while (iterator.hasNext()) {
                JsonNode marks = iterator.next();
                System.out.print(marks.intValue() + " ");
            }

            System.out.println("]");
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
