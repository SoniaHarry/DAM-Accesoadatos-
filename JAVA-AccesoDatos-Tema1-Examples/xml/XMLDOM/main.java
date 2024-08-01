package xml.XMLDOM;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.nio.file.Path;

//import javax.swing.text.html.parser.Element;
//import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class main {
    public static void main(String[] args) {
        //leerXML();
        escribirXML();
    }

    public static void leerXML(){
        Path path=Path.of("ficheros/books.xml");
        File xml=path.toFile();
        try{
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document document=builder.parse(xml);

            NodeList listaInicial=document.getElementsByTagName("Catalog").item(0).getChildNodes();
            switchElement(listaInicial);

        }catch (ParserConfigurationException|SAXException|IOException e){
            System.err.println("Error");
            System.err.println(e.getMessage());
        }
    }
    private static void switchElement(NodeList list){
        for (int i=0; i<list.getLength();i++){
            Node node=list.item(i);
            if (node.getNodeType()==Node.ELEMENT_NODE){
                switch (node.getNodeName()) {
                    case "Book":
                        String id= node.getAttributes().getNamedItem("id").getNodeValue();
                        System.out.println(node.getNodeName() + "\t-\t"+ id);
                        System.out.println();
                        NodeList listaHijos= node.getChildNodes();
                        switchElement(listaHijos);
                        break;
                    case "Author":
                        System.out.println("\t"+ node.getNodeName() + "->" + node.getTextContent());
                        break;
                    case "Title":
                        System.out.println("\t"+ node.getNodeName() + "->" + node.getTextContent());
                        break;
                    case "Genre":
                        System.out.println("\t"+ node.getNodeName() + "->" + node.getTextContent());
                        break;
                    case "Price":
                        System.out.println("\t"+ node.getNodeName() + "->" + node.getTextContent());
                        break;
                    case "PublishDate":
                        System.out.println("\t"+ node.getNodeName() + "->" + node.getTextContent());
                        break;
                    case "Description":
                        System.out.println("\t"+ node.getNodeName() + "->" + node.getTextContent());
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public static void escribirXML(){
        DocumentBuilder builder = createBuilder();
        DOMImplementation implementation=builder.getDOMImplementation();
        Document document=implementation.createDocument(null, null, null);
        document.setXmlVersion("1.0");
        document.setXmlStandalone(true);
      
        Element alumnos= document.createElement("Alumnos");
        document.appendChild(alumnos);

        Element alumno=document.createElement("Alumno");
        alumno.setAttribute("nombre","Raúl");
        alumno.setAttribute("edad","20");

        Element direccion=document.createElement("direccion");
        direccion.setTextContent("C/Poprito 3");

        Element telefono=document.createElement("telefono");
        telefono.setTextContent("94123123123");

        alumno.appendChild(direccion);
        alumno.appendChild(telefono);
        alumnos.appendChild(alumno);

        Source origen=new DOMSource(document);
        Result result=new StreamResult(new File("ficheros/alumnos.xml"));
        Transformer transformer=null;
        try{ 
            transformer=TransformerFactory.newInstance().newTransformer();
            
        }catch(TransformerConfigurationException ex){
            System.err.println("Error al crear el Tranformer");
            System.err.println(ex.getMessage());
            System.exit(-2);
        }
        try{
            transformer.transform(origen, result);
        }catch(TransformerException ex){
            System.err.println("Error al crear el Tranformer");
            System.err.println(ex.getMessage());
            System.exit(-3);
        }
        
    }

    public static DocumentBuilder createBuilder(){
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=null;
        try{
            builder=factory.newDocumentBuilder();
        }catch(ParserConfigurationException ex){
            System.err.println("Error al crear el DocumentBuilder");
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
        return builder;
    }
}
