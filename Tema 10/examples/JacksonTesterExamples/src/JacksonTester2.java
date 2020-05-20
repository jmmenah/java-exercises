/*
 * Jackson Tutorial
 * https://www.tutorialspoint.com/jackson/index.htm
 */
/*
 * let's serialize a java object to a json file and then read that json file to get the object back.
 * In this example, we've created Student class. We'll create a student.json file which will have
 * a json representation of Student object.
 */
// Jackson - Object Serialization
// https://www.tutorialspoint.com/jackson/jackson_object_serialization.htm

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTester2 {
    public static void main(String args[]) {
        JacksonTester2 tester = new JacksonTester2();
        try {
            Student student = new Student();
            student.setAge(10);
            student.setName("Mahesh");
            tester.writeJSON(student);

            Student student1 = tester.readJSON();


            System.out.println(student1);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeJSON(Student student) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("resources/student.json"), student);
    }

    private Student readJSON() throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.readValue(new File("resources/student.json"), Student.class);
        return student;
    }
}