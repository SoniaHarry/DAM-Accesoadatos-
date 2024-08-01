package javaio.ficherosAleatorios;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
    public static void main(String[] args){
        File file=new File("ficheros/aleatorio.txt");

        //Leer
        //Leer-Escribir
        RandomAccessFile randomAccessFile=null;
        try{
            randomAccessFile=new RandomAccessFile(file,"rw");
        }catch (IOException e){
            System.err.println("No se ha encontrado el fichero");
            System.err.println(e.getMessage());
            System.exit(-1);
        }
        
        //Escribir
        pointer(randomAccessFile);

        escribir(randomAccessFile, "Hola Mundo!!");
        
        pointer(randomAccessFile);
        seek(randomAccessFile,0);
        pointer(randomAccessFile);
        
        leer(randomAccessFile);
        
        pointer(randomAccessFile);
        seek(randomAccessFile,6);
        pointer(randomAccessFile);
        escribir(randomAccessFile, "123");
        seek(randomAccessFile,0);
        leer(randomAccessFile);
    }

    private static void leer(RandomAccessFile randomAccessFile){
        try {
            String leido;
            while ((leido= randomAccessFile.readLine())!=null) {
                System.out.println(leido);   
            }
            
        } catch (IOException e) {
            System.err.println("No se ha podido leer del fichero" );
            System.err.println(e.getMessage());
            System.exit(-1);
        }
    }
    private static void escribir(RandomAccessFile randomAccessFile, String texto){
        System.out.println("Escribiendo:\n\t" + texto );
        try{
            randomAccessFile.writeBytes(texto);
        }catch (IOException e){
            System.err.println("No se ha podido escribir en el fichero" );
            System.err.println(e.getMessage());
            System.exit(-2);
        }
    }

    private static void pointer(RandomAccessFile randomAccessFile){
        try {
            System.out.println("POS: " + randomAccessFile.getFilePointer());
        } catch (IOException e) {
            System.err.println("No se ha podido comprobar la ubicación del puntero"); 
        }
    }
    private static void seek(RandomAccessFile randomAccessFile, int pos){
        try {
            randomAccessFile.seek(pos);
        } catch (IOException e) {
            System.err.println("No se ha podido establecer la ubicación del puntero"); 
        }
    }
}
