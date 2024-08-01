package javanio.files;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class BinaryFiles {
    public static void main(String[] args){
        Path path=Path.of("ficheros/fichero_binario");
        escribir(path);
        leer(path);
        
    }
    private static void escribir(Path path){   
        Curso curso=new Curso(1,"DAM-Acceso a Datos",7);
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream=null;
        try{
            objectOutputStream=new ObjectOutputStream(byteArrayOutputStream);
        }catch (IOException e){
            System.err.println("Error al crear el object outputStream");
            System.err.println(e.getMessage());
            System.exit(-1);
        }
        try{
            objectOutputStream.writeObject(curso);
        } catch (IOException e){
            System.err.println("Error al escribir en la memoria RAM");
            System.err.println(e.getMessage());
            System.exit(-2);
        }
        try{
            Files.write(path, byteArrayOutputStream.toByteArray());
        }catch(IOException e){
            System.err.println("Error al escribir en el fichero");
            System.err.println(e.getMessage());
            System.exit(-3);
        }
        System.out.println("Fichero creado correctamente");
       
    }
    private static void leer(Path path){
        byte[] bytesFichero=new byte[]{};
        try{
            bytesFichero=Files.readAllBytes(path);
        }catch (IOException e){
            System.err.println("Error al leer los bytes del fichero: " + path.toString());
            System.err.println(e.getMessage());
            System.exit(-1);
        }
        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(bytesFichero); //Guardamos en la RAM
        ObjectInputStream objectInputStream=null;
        try{
            objectInputStream=new ObjectInputStream(byteArrayInputStream);
        }catch (IOException e){
            System.err.println("Error al crear el objectOutputStream");
            System.err.println(e.getMessage());
            System.exit(-2);
        }
        try{
            Curso curso= (Curso) objectInputStream.readObject();
            System.out.println(curso.toString());
        }catch (IOException| ClassNotFoundException e){
            System.err.println("Error al leer el objeto de la memoria RAM y convertirlo en Curso");
            System.err.println(e.getMessage());
            System.exit(-3);
        }
        System.out.println("Fichero leido correctamente");
        
    }


}
