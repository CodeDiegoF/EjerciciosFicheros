import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Ejemplo2Binario {
     public static void main(String[] args) throws IOException {
          Path inPath = Paths.get("ficheros/salidaBinaria.txt");
          
          byte[] bytes = new byte[10];
          int contador = 100;
          
          for (int i=0; i<10; i++) {
               bytes[i] = (byte) contador++;
          }
          System.out.println(Arrays.toString(bytes));
          
          try {
               Files.write(inPath, bytes);
          }catch(Exception e){
               System.out.println(e);
          }
     }
}
