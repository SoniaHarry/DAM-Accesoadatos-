import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class dirCreatorNIO {
    public static void main (String[] args) {
        System.out.println("Iniciando programa..."); 
        String nombre = ".pepe/directorioNIO";
        Path ruta = Paths.get(nombre); 
        try{
            Files.createDirectories(ruta);
            System.out.println("Creado el directorio"+ ruta); 
        }catch(IOException ex){
            System.err.println("Se ha producido un error"); 
            System.exit(-1);
        }
        System.out.println("Finalizando programa..."); 
    }

}
