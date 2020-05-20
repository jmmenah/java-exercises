/*
 * Gson tutorial: http://zetcode.com/java/gson/
 * Java Gson read JSON from URL
 *
 */

package com.zetcode.e08;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class GsonReadWebPage {

    public static void main(String[] args) throws IOException {

        String webPage = "http://time.jsontest.com";

        try (InputStream is = new URL(webPage).openStream();
             Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {

            Gson gson = new Gson();
            TimeData td = gson.fromJson(reader, TimeData.class);

            System.out.println(td);
        }
    }
}