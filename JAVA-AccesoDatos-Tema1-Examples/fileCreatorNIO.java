import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class fileCreatorNIO {
    public static void main (String[] args) {
        System.out.println("Iniciando programa...");
        Path directorio = Paths.get("./ficheros/fileNIO_1.txt");
        if (Files.notExists(directorio)) { //Comprueba que no exista el fichero
            try{
                directorio = Files.createFile(directorio); //Crea el fichero
                System.out.println("Creado el fichero "+ directorio); 
                System.out.println("exists: " + Files.exists(directorio));
                System.out.println("isReadable: " + Files.isReadable(directorio));
                System.out.println("isWritable: " + Files.isWritable(directorio));
                System.out.println("isExecutable: " + Files.isExecutable(directorio));

            }catch(IOException ex){
                System.err.println("No se ha creado el fichero, probablemente el directorio no existe."); 
                System.exit(-1);
            }
            
        }
        System.out.println("Finalizando programa..."); 
    }

}
   
