package URLProcessor;

import java.io.IOException;
import java.net.URL;

public class LengthDriver {
    public static void main(String[] args) throws IOException {
        System.out.println("Driver Code for URL Processor Application to Extract length of Retrieved Data using Abstract Class Method");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println();
        URLProcessorImplToExtractDataLength metaProcessor = new URLProcessorImplToExtractDataLength();

        metaProcessor.process(new URL("https://abhiit89.github.io/"));
        System.out.println();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
