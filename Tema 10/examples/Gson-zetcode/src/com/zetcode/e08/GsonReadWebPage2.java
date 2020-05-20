/*
 * Gson tutorial: http://zetcode.com/java/gson/
 * Java Gson read JSON from URL
 *
 */

package com.zetcode.e08;

import com.google.gson.Gson;
import org.jsoup.Jsoup;

import java.io.IOException;

public class GsonReadWebPage2 {

    public static void main(String[] args) throws IOException {
        
        String webPage = "http://time.jsontest.com";

        String data = Jsoup.connect(webPage).ignoreContentType(true).execute().body();
        
        Gson gson = new Gson();
        TimeData td = gson.fromJson(data, TimeData.class);
        
        System.out.println(td);
    }
}
