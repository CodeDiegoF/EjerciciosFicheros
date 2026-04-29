import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Path;
import java.util.List;


public class EjemploBasico3 {
     public static void main(String[] args) throws IOException {
          try {
               // Carga completa del Quijote para medir y buscar palabras.
               Path inPath = Paths.get("ficheros/quijote.txt");
               int contQuijotes = 0;
               String contenido = Files.readString(inPath);
               
               // Diferencia entre bytes (tamano en disco) y caracteres (texto en memoria).
               long bytesLeidos = Files.size(inPath);
               System.out.println("leido " + bytesLeidos + " bytes");
               
               long caracteres = contenido.length();
               System.out.println("leido " + caracteres + " caracteres");
               
               // Separa por espacios/saltos de linea para recorrer palabra a palabra.
               String[] tokens = contenido.split("[\s\n]");
              
               for (String palabras : tokens) {
                    // Busqueda sin distinguir mayusculas/minusculas.
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
