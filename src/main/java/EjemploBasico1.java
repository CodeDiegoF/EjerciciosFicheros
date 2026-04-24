import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Path;


public class EjemploBasico1 {
     public static void main(String[] args) throws IOException {
         Path texto = Paths.get("ficheros/fichero1.txt");
         Files.writeString(texto, "Texto a escribir en fichero y una ñ\n");
          
          String contenido = Files.readString(texto);
          System.out.println("==Leer todo==");
          System.out.println(contenido);
     }
}
