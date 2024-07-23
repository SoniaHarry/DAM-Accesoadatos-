import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

class QuickStart {
    public static void main (String[] args) {
        System.out.println("Hello, World.");
         
        try (FileWriter fichero = new FileWriter("prueba.txt"))
        {
            PrintWriter pw = new PrintWriter(fichero);
            System.out.println("Sooooooo");
            for (int i = 0; i < 10; i++)
                pw.println("Linea " + i);

        } catch (Exception e) {
            e.printStackTrace();
        } 

    }

    
    
}