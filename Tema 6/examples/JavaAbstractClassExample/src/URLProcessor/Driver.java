package URLProcessor;

import java.io.IOException;
import java.net.URL;

public class Driver {
    public static void main(String[] args) throws IOException {
        System.out.println("Driver Code for URL Processor Application using Abstract Class Method");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println();
        URLProcessorImpl urlProcessor = new URLProcessorImpl();

        urlProcessor.process(new URL("https://abhiit89.github.io/"));
        System.out.println();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
