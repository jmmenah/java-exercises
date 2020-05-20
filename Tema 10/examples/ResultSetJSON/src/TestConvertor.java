/*
 * Teting Convertor.java using SQLite fruits database
 * Nice and simple converter of Java ResultSet into JSONArray or XML
 * Andrew Zakordonets
 * https://biercoff.com/nice-and-simple-converter-of-java-resultset-into-jsonarray-or-xml/
 *
 * How to pretty print XML in Java
 * http://www.topjavatutorial.com/java/java-programs/pretty-print-xml-java/
 */

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class TestConvertor {

    public static void main(String[] args) {
        String sql1 = "SELECT * FROM fruit";
        String sql2 = "SELECT * FROM fruit order by name";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:db/fruits.db");
             Statement stmt1 = conn.createStatement();
             Statement stmt2 = conn.createStatement();
             ResultSet rs1 = stmt1.executeQuery(sql1);
             ResultSet rs2 = stmt2.executeQuery(sql2);) {

            try {
                JSONArray json = Convertor.convertToJSON(rs1);
                //System.out.println(json);
                // Print it with specified indentation
                System.out.println(json.toString(2));
                //System.out.println(Convertor.convertToXML(rs2));
                // http://www.topjavatutorial.com/java/java-programs/pretty-print-xml-java/
                System.out.println(prettyPrint(toXmlDocument(Convertor.convertToXML(rs2))));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String prettyPrint(Document document)
            throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory
                .newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(
                "{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        DOMSource source = new DOMSource(document);
        StringWriter strWriter = new StringWriter();
        StreamResult result = new StreamResult(strWriter);

        transformer.transform(source, result);

        return strWriter.getBuffer().toString();

    }

    private static Document toXmlDocument(String str)
            throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new InputSource(new StringReader(
                str)));

        return document;
    }
}
