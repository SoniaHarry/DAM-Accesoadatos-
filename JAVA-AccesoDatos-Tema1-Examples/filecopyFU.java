import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class filecopyFU {
    public static void main (String[] args) {
        System.out.println("Iniciando programa..."); 
        File destDir = new File("./directorioIO");
        File srcFile = new File("./ficheros/fileIO_2.txt");
        try{
            FileUtils.copyFileToDirectory(srcFile, destDir); 
            System.out.println("Fichero copiado");
        } catch (IOException ex) 
            { System.err.println("Error al copiar el archivo"); 
            ex.printStackTrace();
        }
        System.out.println("Finalizando programa..."); 
    }

}
