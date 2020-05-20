/*
 * Jackson Tutorial
 * https://www.tutorialspoint.com/jackson/index.htm
 */
/*
 * Jackson - First Application
 * https://www.tutorialspoint.com/jackson/jackson_first_application.htm
 * Before going into the details of the jackson library, let's see an application in action.
 * In this example, we've created Student class. We'll create a JSON string with student details
 * and deserialize it to student object and then serialize it to an JSON String.
 */
// Jackson - ObjectMapper Class
// https://www.tutorialspoint.com/jackson/jackson_objectmapper.htm

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTester1 {
    public static void main(String args[]) {
        // Step 1: Create ObjectMapper object
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";

        //map json to student
        try {
            // Step 2: DeSerialize JSON to Object
            Student student = mapper.readValue(jsonString, Student.class);

            System.out.println(student);

            // Step 3: Serialize Object to JSON.
            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);

            System.out.println(jsonString);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}