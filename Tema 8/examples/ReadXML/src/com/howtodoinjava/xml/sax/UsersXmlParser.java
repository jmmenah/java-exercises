/*
 * Java SAX Parser – Read XML Example
 * By Lokesh Gupta
 * https://howtodoinjava.com/xml/sax-parser-read-xml-example/
 */

package com.howtodoinjava.xml.sax;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
// import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class UsersXmlParser {
    public ArrayList<User> parseXml(InputStream in) {
        //Create a empty link of users initially
        ArrayList<User> users = new ArrayList<User>();
        try {
            //Create default handler instance
            UserParserHandler handler = new UserParserHandler();

            //Create parser from factory
            //XMLReader parser = XMLReaderFactory.createXMLReader();
            // https://stackoverflow.com/questions/51072419/how-use-xmlreaderfactory-now-because-this-is-deprecated
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = parserFactory.newSAXParser();
            XMLReader parser = saxParser.getXMLReader();

            //Register handler with parser
            parser.setContentHandler(handler);

            //Create an input source from the XML input stream
            InputSource source = new InputSource(in);

            //parse the document
            parser.parse(source);

            //populate the parsed users list in above created empty list; You can return from here also.
            users = handler.getUsers();

        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } finally {

        }
        return users;
    }
}
