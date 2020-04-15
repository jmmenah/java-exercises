// Redferences
// https://www.w3schools.com/xml/tryxslt.asp?xmlfile=cdcatalog&xsltfile=cdcatalog
// http://www.javatechblog.com/java/transform-xml-documents-with-xslt-in-java/


import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLTransformerExample2 {
   public static void main(String[] args) {
     try {
     
       StreamSource stylesource = new StreamSource("https://www.w3schools.com/xml/cdcatalog.xsl");

       StreamSource xmlsource = new StreamSource("https://www.w3schools.com/xml/cdcatalog.xml");
       Transformer transformer = TransformerFactory.newInstance()
                                 .newTransformer(stylesource);
       
       // Transform the document and store it in a file
       transformer.transform(xmlsource, new StreamResult(new File("cdcatalog.html")));
       
       StreamResult consoleOut = new StreamResult(System.out);
       // Transform the document and print the content to console
       transformer.transform(xmlsource, consoleOut);
     } catch (TransformerException e) {
              e.printStackTrace();
     }
   }
}
