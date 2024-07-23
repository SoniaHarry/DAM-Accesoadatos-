import java.io.File;

public class fileRename {
    public static void main (String[] args) {
        System.out.println("Iniciando programa..."); 
        File file = new File("ficheros/fileIO_1.txt"); 
        File rename = new File("ficheros/fileIO_2.txt"); 
        if (file.renameTo(rename)){
            System.out.println("Fichero renombrado con éxito"); 
        }else{
            System.out.println("Fichero NO renombrado"); 
        }
        System.out.println("Finalizando programa..."); 
    }
    
}
