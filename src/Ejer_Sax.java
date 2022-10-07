import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.sql.rowset.spi.XmlReader;
import java.io.IOException;

public class Ejer_Sax {
    public static void main(String[] args) throws SAXException, IOException {
        XmlReader procesadorXml = (XmlReader) XMLReaderFactory.createXMLReader();
        GestionContenido gestor = new GestionContenido();
        ((XMLReader) procesadorXml).setContentHandler(gestor);
        InputSource fileXml = new InputSource("Becario.xml");
        ((XMLReader) procesadorXml).parse(fileXml);
    }
}

class GestionContenido extends DefaultHandler {
    public GestionContenido() {
        super();
    }

    public void startDocument() {
        System.out.println("Comienzo del Documento XML");
    }

    public void endDocument(){
        System.out.println("Final del Documento XML");
    }

    public void startElement(String uri, String nombre, String nombreC, Attributes atts) {
        System.out.printf("\tPrincipio Elemento: %s %n", nombre);
    }

    public void endElement(String uri, String nombre, String nombreC) {
        System.out.printf("\tFin Elemento: %s %n", nombre);
    }

    public void characters(char[] chars, int inicio, int longitud) throws SAXException {
        String caracter = new String(chars, inicio, longitud);
        caracter = caracter.replaceAll("[\t\n]", "");
        System.out.printf("\t Caracteres: %s %n", caracter);
    }
}