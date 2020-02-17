package URLProcessor;

import java.io.IOException;
import java.io.InputStream;

public class URLProcessorImplToExtractDataLength extends URLProcessorBase {

    @Override
    protected void processURLData(InputStream input) throws IOException {
        byte[] data = input.readAllBytes();
        System.out.print(data.length);
    }
}
