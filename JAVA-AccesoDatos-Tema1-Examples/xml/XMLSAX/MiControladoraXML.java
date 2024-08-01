package xml.XMLSAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MiControladoraXML extends DefaultHandler{
    @Override
    public void startDocument() throws SAXException{
        super.startDocument();
        System.out.println("Iniciando documentos...");
    }
    // @Override
    // public void endDocument() throws SAXException{
    //     super.endDocument();
    //     System.out.println("Finalizando documentos...");
    // }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri,localName,qName,attributes);
        switch (qName) {
            case "Catalog":
                System.out.println(qName);
                break;
            case "Book":
                System.out.print("\t" + qName + ":\t");
                String id= attributes.getValue("id");
                System.out.println(id);
                break;
            case "Author":
                System.out.print("\t\tAutor:" + qName);
                break;
            case "Title":
                System.out.print("\t\tTitle:" + qName);
                break;
            case "Genre":
                System.out.print("\t\tGenre:" + qName);
                break;
            case "Price":
                System.out.print("\t\tPrice:" + qName);
                break;
            case "PublishDate":
                System.out.print("\t\tPublishDate:" + qName);
                break;
            case "Description":
                System.out.print("\t\tDescription:" + qName);
                break;
            default:
                break;
        }
        
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException{
        super.characters(ch,start,length);
        String texto= new String(ch, start, length).trim();
        if(texto.length()>0)
            System.out.println( texto);
    }
    // @Override
    // public void endElement(String uri, String localName, String qName) throws SAXException{
    //     super.endElement(uri,localName,qName);
    //     System.out.println("Finalizando elemento " );
    // }


}