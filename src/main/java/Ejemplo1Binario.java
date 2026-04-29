import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejemplo1Binario {
     public static void main(String[] args) {
         try {
              // Ruta al archivo binario (imagen) que se va a inspeccionar.
              Path inPath = Paths.get("ficheros/java.webp");
              
              // Tamano del fichero en bytes.
              long bytes = inPath.toFile().length();
              System.out.println("El tamaño del fichero es: " + bytes + " bytes");
              
              // Carga completa del binario en memoria.
              byte[] byteImagen = Files.readAllBytes(inPath);
              
              // Muestra cada byte para ver el contenido bruto del archivo.
              for (Byte b : byteImagen) {
                   System.out.println("byte leido: " +  b);
              }
              
         }catch (Exception e){
              System.err.println("Error al leer el fichero: " + e.getMessage());
         }
   
     }
}
