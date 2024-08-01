package javanio.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class CharacterFiles {
    public static void main(String[] args){
        Path path=Path.of("ficheros/fichero_caracter.txt");
        escribir(path);
        leer(path);
        
    }
    private static void escribir(Path path){ 
        try{
            Files.writeString(path, "Hi Word!!\n");
            Files.writeString(path, "Hi Word 2!!\n", StandardOpenOption.APPEND);
            Files.writeString(path, "Hi Word 3!!\n",StandardOpenOption.APPEND);
            Files.writeString(path, "Hi Word 4!!\n",StandardOpenOption.APPEND);
        }catch (IOException e){
            System.err.println("Error al escribir een el fichero: " + path.toString());
            System.err.println(e.getMessage());
            System.exit(-1);
        }
        System.out.println("Fichero creado correctamente");
    }
    private static void leer(Path path){ 
        try{
            List<String> textos=Files.readAllLines(path);
            for (String texto:textos){
                System.out.println(texto);
            }
        }catch (IOException e){
            System.err.println("Error al leer  del fichero: " + path.toString());
            System.err.println(e.getMessage());
            System.exit(-1);
        }
        System.out.println("Fichero leido correctamente");
    }
}
