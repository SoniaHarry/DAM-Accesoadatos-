import java.io.File;

public class fileDeleteIO {
    public static void main (String[] args) {
        System.out.println("Iniciando programa..."); 
        File ficheroDatos = new File("./ficheros/fileIO_1.txt"); 
        if(ficheroDatos.delete()) {
	        System.out.println("Hemos borrado un fichero, "+ ficheroDatos); 
        }else{
            System.out.println("No se puede borrar el fichero, " + ficheroDatos); 
        }
        System.out.println("Finalizando programa..."); 
    }
}
