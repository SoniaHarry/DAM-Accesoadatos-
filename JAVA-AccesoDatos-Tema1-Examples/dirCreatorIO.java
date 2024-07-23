import java.io.File;

public class dirCreatorIO {
        public static void main (String[] args) {
            System.out.println("Iniciando programa..."); 
            File directorio= new File("./directorioIO");
           
            if (directorio.mkdir()){ //Crea el directorio
                System.out.println("Creado el directorio"+ directorio); 
            } else {
                System.out.println("No se ha podido crear el directorio, probablemente ya exista"); 
            }

            System.out.println("Finalizando programa..."); 
        }
}
