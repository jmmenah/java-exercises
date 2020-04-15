
// https://www.rgagnon.com/javadetails/java-0669.html
// The code (using SAX parser) to validate an XML file using the referenced XSD.

import java.io.IOException;
// SAX
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.InputSource;

public class XMLUtils3 {

  private XMLUtils3() {}
  
  // validate SAX and internal XSD
  public static boolean validateWithIntXSDWithSAX(String xml) 
  throws ParserConfigurationException, IOException 
  {
    try {
      
      SAXParserFactory factory = SAXParserFactory.newInstance();
      factory.setValidating(true);
      factory.setNamespaceAware(true);

      SAXParser parser = factory.newSAXParser();
      parser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage", 
            "http://www.w3.org/2001/XMLSchema");

      XMLReader reader = parser.getXMLReader();
      reader.setErrorHandler(
          new ErrorHandler() {
            public void warning(SAXParseException e) throws SAXException {
              System.out.println("WARNING: " + e.getMessage()); // do nothing
            }

            public void error(SAXParseException e) throws SAXException {
              System.out.println("ERROR: " + e.getMessage());
              throw e;
            }

            public void fatalError(SAXParseException e) throws SAXException {
              System.out.println("FATAL: " + e.getMessage());
              throw e;
            }
          }
          );
      reader.parse(new InputSource(xml));
      return true;
    }    
    catch (ParserConfigurationException pce) {
      throw pce;
    } 
    catch (IOException io) {
      throw io;
    }
    catch (SAXException se){
      return false;
  }
}

  public static void main (String args[]) throws Exception{ 
    System.out.println(XMLUtils3.validateWithIntXSDWithSAX("howto2.xml"));
  }
}

