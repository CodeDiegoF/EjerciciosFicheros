import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class EjemploBasico4 {
     public static void main(String[] args) throws IOException {
          // Fichero con un numero por linea.
          Path inPath = Paths.get("ficheros/numbers.txt");
          
          double media = 0.0;
          try (Stream<String> stream = Files.lines(inPath)) {
                // Convierte cada linea a double y calcula la media.
                media = stream.mapToDouble(Double::parseDouble)
                       .average()
                       .orElse(0.0);
               
               System.out.println("Promedio: " + media);

          } catch (IOException e) {
               throw new RuntimeException(e);
          }
          
          try (Stream<String> stream = Files.lines(inPath)) {
               // Segunda lectura para calcular suma (el stream anterior ya se consumio).
               double suma =
                       stream.mapToDouble(Double::parseDouble)
                       .sum();
               System.out.println("Suma de números menores que la media: " + suma);
               
          }
          
          try (Stream<String> stream = Files.lines(inPath)) {
               // Tercera lectura para contar cuantos valores quedan por debajo de la media.
               double finalMedia = media;
               int valoresMenoresMedia =
                       (int) stream.mapToDouble(Double::parseDouble)
                       .filter(n -> n < finalMedia)
                       .count();
               
               System.out.println("Cantidad de números menores que la media: " + valoresMenoresMedia);
          }
     }
}
