import java.io.File;
import java.io.IOException;

public class fileCreatorIO {
    public static void main (String[] args) {
        System.out.println("Iniciando programa..."); 
        File directorio= new File("ficheros");
        if (!directorio.mkdir()){ //Crea el directorio
            System.out.println("No se ha podido crear el directorio, probablemente ya exista"); 
        }
        File ficheroDatos = new File(directorio,"fileIO_1.txt");
        try{
            if (ficheroDatos.createNewFile()){ //Crea el fichero
                System.out.println("Creado el fichero "+ ficheroDatos); 
            }
            else {
                System.out.println("No se ha creado el fichero, probablemente ya exista."); 
            }
        }catch(IOException ex){
            System.err.println("No se ha podido crear el fichero"); 
            System.err.println(ex.getMessage()); 
            System.exit(-1);
        }
        
        System.out.println("Finalizando programa..."); 
    }
}
