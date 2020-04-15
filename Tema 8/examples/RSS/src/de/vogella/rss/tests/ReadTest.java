/*
 * RSS feeds with Java - Tutorial by Lars Vogel
 * https://www.vogella.com/tutorials/RSSFeed/article.html#read
 * https://github.com/vogellacompany/codeexamples-java
 */

// Read RSS Feeds with Stax
// Test the code

package de.vogella.rss.tests;


import de.vogella.rss.model.Feed;
import de.vogella.rss.model.FeedMessage;
import de.vogella.rss.read.RSSFeedParser;


public class ReadTest {
    public static void main(String[] args) {

        //RSSFeedParser parser = new RSSFeedParser("https://www.vogella.com/article.rss");
        //RSSFeedParser parser = new RSSFeedParser("https://www.diariojaen.es/rss/provincia.xml");
        //RSSFeedParser parser = new RSSFeedParser("http://feeds.weblogssl.com/xataka2");
        RSSFeedParser parser = new RSSFeedParser("http://www.ign.es/ign/RssTools/sismologia.xml");

        Feed feed = parser.readFeed();
        System.out.println(feed);
        for (FeedMessage message : feed.getMessages()) {
            System.out.println(message);

        }

    }
}