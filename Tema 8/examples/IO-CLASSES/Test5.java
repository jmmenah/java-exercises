
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.io.Writer;

public class Test5 {

    public static void main(String[] args) throws Exception {
        File file = new File("numbers.txt");
        try (Writer writer = new FileWriter(file)) {
            for (int i = 1; i <= 15; i++) {
                writer.write("" + i);
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            System.out.println(reader.readLine());
        }

        RandomAccessFile rFile = new RandomAccessFile(file, "rwd");

        int offset = 0;
        while (true) {
            rFile.seek(offset);
            char character = (char) rFile.read();
            if (character == '#') {
                break;
            }
            System.out.println();
            rFile.seek(offset + 9);
            rFile.write('#');

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                System.out.println(reader.readLine());
            }
            offset++;
        }
        rFile.close();
    }
}
