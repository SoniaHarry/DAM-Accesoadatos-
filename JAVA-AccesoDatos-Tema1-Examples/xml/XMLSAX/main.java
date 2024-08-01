package xml.XMLSAX;

import java.io.IOException;
import java.nio.file.Path;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class main {
    public static void main(String[] args){
        Path path= Path.of("ficheros/books.xml");
        leerXML(path);
    }

    private static void leerXML(Path path){
        
        SAXParserFactory factory=SAXParserFactory.newInstance();
        SAXParser parser=null;
            try{
                parser= factory.newSAXParser();
            }catch(ParserConfigurationException|SAXException e){
                System.err.println("No se ha podido crear el nuevo SAXParser");
                System.err.println(e.getMessage());
                System.exit(-1);
            }
            XMLReader reader=null;
            try{
                reader=parser.getXMLReader();
            }catch(SAXException e){
                System.err.println("Error al crear el XMLReader");
                System.err.println(e.getMessage());
                System.exit(-2);
            }
            
            reader.setContentHandler((ContentHandler) new MiControladoraXML());
            try{
                reader.parse(path.toString());
            }catch(SAXException|IOException e){
                System.err.println("Error al parsear el documento:" + path.toString());
                System.err.println(e.getMessage());
                System.exit(-3);
            }
       
    }
}
