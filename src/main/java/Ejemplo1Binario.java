import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejemplo1Binario {
     public static void main(String[] args) {
         try {
              Path inPath = Paths.get("ficheros/java.webp");
              
              long bytes = inPath.toFile().length();
              System.out.println("El tamaño del fichero es: " + bytes + " bytes");
              
              byte[] byteImagen = Files.readAllBytes(inPath);
              
              for (Byte b : byteImagen) {
                   System.out.println("byte leido: " +  b);
              }
              
         }catch (Exception e){
              System.err.println("Error al leer el fichero: " + e.getMessage());
         }
   
     }
}
