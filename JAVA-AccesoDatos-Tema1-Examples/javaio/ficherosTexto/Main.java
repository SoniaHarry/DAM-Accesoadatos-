package javaio.ficherosTexto;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main (String[] args) {
        System.out.println("Iniciando programa..."); 
        File file=new File("./ficheros/ficherocaracteres.txt");
        escribir (file);
        leer(file);
        System.out.println("Finalizando programa..."); 
    }

    private static void escribir(File file){    
        FileWriter fileWriter=null;
        try {
            //fileWriter= new FileWriter(file,true);
            fileWriter= new FileWriter(file);
            
        } catch (IOException e) {
            System.err.println("Error de apertura en el fichero" + file.getName());
            System.err.println(e.getMessage());
            System.exit(-1);
        }
        try{
            fileWriter.write("ABCD");
        }
        catch (IOException e) {
            System.err.println("Error de escritura en el fichero" );
            System.err.println(e.getMessage());
            System.exit(-2);
        }
        try{
            fileWriter.close();
        }
        catch (IOException e) {
            System.err.println("Error de cierre del fichero" + file.getName());
            System.err.println(e.getMessage());
            System.exit(-3);
        }
        

    }
     private static void leer (File file){
        FileReader fileReader =null;
        try{
            fileReader=new FileReader(file);
        }catch (IOException e){
            System.err.println("No se ha podido crear el FileReader");
            System.err.println(e.getMessage());
            System.exit(-1);
        }
        try {
            int read;
            while ((read=fileReader.read())!= -1){
                System.out.println((char)read);
            }
            System.out.println();
        } catch (Exception e) {
            System.err.println("Error al leer");
            System.err.println(e.getMessage());
            System.exit(-2);
        }
        try{
            fileReader.close();
        }
        catch (IOException e) {
            System.err.println("Error de cierre del fichero" + file.getName());
            System.err.println(e.getMessage());
            System.exit(-3);
        }

     }
}
