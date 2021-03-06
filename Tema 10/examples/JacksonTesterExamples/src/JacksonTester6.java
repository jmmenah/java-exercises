/*
 * Jackson Tutorial
 * https://www.tutorialspoint.com/jackson/index.htm
 */
// Jackson - Streaming API
// https://www.tutorialspoint.com/jackson/jackson_streaming_api.htm

// Reading JSON using JsonParser

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTester6 {
    public static void main(String args[]) {
        JacksonTester6 tester = new JacksonTester6();
        try {
            JsonFactory jsonFactory = new JsonFactory();

            JsonGenerator jsonGenerator = jsonFactory.createGenerator(new File(
                    "resources/student.json"), JsonEncoding.UTF8);
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("name", "Mahesh Kumar");
            jsonGenerator.writeNumberField("age", 21);
            jsonGenerator.writeBooleanField("verified", false);
            jsonGenerator.writeFieldName("marks");
            jsonGenerator.writeStartArray(); // [
            jsonGenerator.writeNumber(100);
            jsonGenerator.writeNumber(90);
            jsonGenerator.writeNumber(85);
            jsonGenerator.writeEndArray();
            jsonGenerator.writeEndObject();
            jsonGenerator.close();

            //result student.json
            //{
            //   "name":"Mahesh Kumar",
            //   "age":21,
            //   "verified":false,
            //   "marks":[100,90,85]
            //}

            JsonParser jsonParser = jsonFactory.createParser(new File("resources/student.json"));
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                //get the current token
                String fieldname = jsonParser.getCurrentName();
                if ("name".equals(fieldname)) {
                    //move to next token
                    jsonParser.nextToken();
                    System.out.println(jsonParser.getText());
                }
                if ("age".equals(fieldname)) {
                    //move to next token
                    jsonParser.nextToken();
                    System.out.println(jsonParser.getNumberValue());
                }
                if ("verified".equals(fieldname)) {
                    //move to next token
                    jsonParser.nextToken();
                    System.out.println(jsonParser.getBooleanValue());
                }
                if ("marks".equals(fieldname)) {
                    //move to [
                    jsonParser.nextToken();
                    // loop till token equal to "]"
                    while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                        System.out.println(jsonParser.getNumberValue());
                    }
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
