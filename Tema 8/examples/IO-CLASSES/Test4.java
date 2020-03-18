
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test4 {

    public static void main(String[] args) throws IOException {
        File parentDir = new File("ParentDir");
        if (parentDir.exists()) {
            parentDir.delete();
        }
        parentDir.mkdir();

        File childDir = new File("ParentDir/ChildDir");
        if (childDir.exists()) {
            childDir.delete();
        }
        childDir.mkdir();

        FileWriter writer = new FileWriter(new File(childDir.getAbsolutePath() + "/TheFile.txt"));
        writer.write("Hello world!");
        writer.close();

        BufferedReader reader = new BufferedReader(new FileReader("ParentDir/ChildDir/TheFile.txt"));
        System.out.println(reader.readLine());
        reader.close();
        
        System.out.println(new String(Files.readAllBytes(Paths.get("ParentDir/ChildDir/TheFile.txt"))));

    }

}
