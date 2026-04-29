import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Path;


public class EjemploBasico1 {
     public static void main(String[] args) throws IOException {
          // Ruta del fichero de texto que vamos a crear/sobrescribir.
         Path texto = Paths.get("ficheros/fichero1.txt");

          // Escritura completa en una sola llamada.
         Files.writeString(texto, "Texto a escribir en fichero y una ñ\n");
          
          // Lectura completa del contenido como un String.
          String contenido = Files.readString(texto);
          System.out.println("==Leer todo==");
          System.out.println(contenido);
     }
}
