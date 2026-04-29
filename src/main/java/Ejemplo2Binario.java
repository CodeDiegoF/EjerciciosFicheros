import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Ejemplo2Binario {
     public static void main(String[] args) throws IOException {
          // Fichero de destino donde se escriben bytes "crudos".
          Path inPath = Paths.get("ficheros/salidaBinaria.txt");
          
          // Buffer de 10 bytes y valor inicial para rellenarlo.
          byte[] bytes = new byte[10];
          int contador = 100;
          
          // Genera la secuencia 100..109 (cast a byte).
          for (int i=0; i<10; i++) {
               bytes[i] = (byte) contador++;
          }
          System.out.println(Arrays.toString(bytes));
          
          try {
               // Escritura binaria directa del array completo.
               Files.write(inPath, bytes);
          }catch(Exception e){
               System.out.println(e);
          }
     }
}
