import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class fileMoveFU {
    public static void main (String[] args) {
        System.out.println("Iniciando programa...");
        File destDir = new File("./directorioIO");
        File srcFile = new File("./ficheros/fileIO_2.txt");
        try { 
            //Se pueden utilizar las variables creadas ó 
            //directamente poner los ficheros creados; como realmente se crean en memoria RAM podemos hacerlo asi
            //FileUtils.moveFileToDirectory(new File("./ficheros/fileIO_2.txt"), new File("./directorioIO"), true); 
            FileUtils.moveFileToDirectory(srcFile, destDir, true); 
            System.out.println("Fichero movido"); 
        } catch (IOException ex) { 
            System.err.println("Error al mover el archivo"); 
            ex.printStackTrace(); 
        }
        System.out.println("Finalizando programa..."); 
    }
}
