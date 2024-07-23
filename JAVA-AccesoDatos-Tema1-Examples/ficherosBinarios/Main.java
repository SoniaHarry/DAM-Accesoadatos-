package ficherosBinarios;

import java.io.*;
import java.util.Scanner;  // Import the Scanner class

public class Main {
    public static void main(String[] args) {
        //Crear el fichero donde guardaremos el fichero
        File file=new File("ficheros/objeto");
        guardarObjeto(file);
        recuperarObjeto(file);
    }
    private static void guardarObjeto(File file){
        try{
            file.createNewFile();
        }catch (IOException ex){
            System.err.println("No se ha podido crear el fichero " + file.getName()); 
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
        //1.Crear el objeto que deseamos guardar
        //Pedimos los datos de Persona por consola
        Scanner scanner= new Scanner(System.in);
        
        System.out.println("Introduce el id de la persona");
        int id=scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introduce el nombre de la persona");
        String nombre=scanner.nextLine();

        System.out.println("Introduce la edad de la persona");
        int edad= scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introduce la dirección de la persona");
        String direccion=scanner.nextLine();

        Persona persona= new Persona(id,nombre,edad,direccion);
       
        //2.Crear el fileOutStream para guardar información en el fichero -> flujo de datos de salida
        FileOutputStream fileOutputStream=null;
        try{
            fileOutputStream=new FileOutputStream(file);
        }catch(FileNotFoundException ex){
            System.err.println("No se ha encontrado el fichero: " + file.getName());
            System.err.println(ex.getMessage());
            System.exit(-2);
        }

        //Convertir el objeto en bytes
        ObjectOutputStream objectOutputStream=null;
        try{
            //Utiliza el fileOutputStream para saber donde escribir
            objectOutputStream=new ObjectOutputStream(fileOutputStream);
        }catch(IOException ex){
            System.err.println("No se ha podido crear el ObjectOutputStream:");
            System.err.println(ex.getMessage());
            System.exit(-3); 
        }
        //Guardar los bytes en el fichero
        try{
            //Escribimos el objeto en el fichero ligado al FileOutputStream
            objectOutputStream.writeObject(persona);
        }catch (IOException ex){
            System.err.println("No se ha podido escribir en el fichero: " + file.getName());
            System.err.println(ex.getMessage());
            System.err.println(ex);
            System.exit(-4); 
        }
        //Cerrar el fichero
        try{
            fileOutputStream.close();
            objectOutputStream.close();
        }catch (IOException ex){
            System.err.println("No se ha podido cerrar correctamente el fichero: " + file.getName());
            System.err.println(ex.getMessage());
            System.exit(-5); 
        }

    }

    private static void recuperarObjeto(File file){
        FileInputStream fileInputStream=null;
        try {
            //De donde debe leer
            fileInputStream=new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            System.err.println("Error al abrir el FileInputStream");
            System.err.println(ex.getMessage());
            System.exit(-6);
        }
        ObjectInputStream objectInputStream=null;
        try {
            //Utiliza el FileInputStream para saber de donde leer
            objectInputStream=new ObjectInputStream(fileInputStream);
        } catch (IOException ex) {
            System.err.println("Error al crear el ObjectInputStream");
            System.err.println(ex.getMessage());
            System.exit(-7);
        }
        try {
            //Lee el fichero y lo convierte en una persona 
            //IMPORTANTE:Hacer el casteo ->(Persona)
            Persona persona=(Persona) objectInputStream.readObject();
            System.out.println(persona);
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Error al recuperar el objeto del fichero");
            System.err.println(ex.getMessage());
            System.exit(-8);
        }
        try {
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException ex) {
            System.err.println("Error al cerrar los InputStream");
            System.err.println(ex.getMessage());
            System.exit(-9);
        }
    }
}
