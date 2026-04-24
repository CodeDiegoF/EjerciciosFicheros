import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Path;
import java.util.List;

import static java.awt.geom.Path2D.contains;


public class EjemploBasico3 {
     public static void main(String[] args) throws IOException {
          try {
               Path inPath = Paths.get("ficheros/quijote.txt");
               int contQuijotes = 0;
               String contenido = Files.readString(inPath);
               
               long bytesLeidos = Files.size(inPath);
               System.out.println("leido " + bytesLeidos + " bytes");
               
               long caracteres = contenido.length();
               System.out.println("leido " + caracteres + " caracteres");
               
               String[] tokens = contenido.split("[\s\n]");
              
               for (String palabras : tokens) {
                    if (palabras.toLowerCase().contains("quijote")){
                         contQuijotes++;
                    }
               }
               
                System.out.println("Encontrado " + contQuijotes + " veces la palabra quijote");
               
               
          }catch (Exception e) {
               System.out.println("Error al leer el fichero: " + e.getMessage());
          }
         
     }
}
