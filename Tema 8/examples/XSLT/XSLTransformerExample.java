// http://www.javatechblog.com/java/transform-xml-documents-with-xslt-in-java/

import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLTransformerExample {
   public static void main(String[] args) {
     try {
       File stylesheet = new File("employees.xsl");
       File xmlfile = new File("employees.xml");
       StreamSource stylesource = new StreamSource(stylesheet);
       StreamSource xmlsource = new StreamSource(xmlfile);
       Transformer transformer = TransformerFactory.newInstance()
                                 .newTransformer(stylesource);
       
       // Transform the document and store it in a file
       transformer.transform(xmlsource, new StreamResult(new File("employees.html")));
       
       StreamResult consoleOut = new StreamResult(System.out);
       // Transform the document and print the content to console
       transformer.transform(xmlsource, consoleOut);
     } catch (TransformerException e) {
              e.printStackTrace();
     }
   }
}
