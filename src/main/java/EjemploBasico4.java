import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class EjemploBasico4 {
     public static void main(String[] args) throws IOException {
          Path inPath = Paths.get("ficheros/numbers.txt");
          
          double media = 0.0;
          try (Stream<String> stream = Files.lines(inPath)) {
                media = stream.mapToDouble(Double::parseDouble)
                       .average()
                       .orElse(0.0);
               
               System.out.println("Promedio: " + media);

          } catch (IOException e) {
               throw new RuntimeException(e);
          }
          
          try (Stream<String> stream = Files.lines(inPath)) {
               double suma =
                       stream.mapToDouble(Double::parseDouble)
                       .sum();
               System.out.println("Suma de números menores que la media: " + suma);
               
          }
          
          try (Stream<String> stream = Files.lines(inPath)) {
               double finalMedia = media;
               int valoresMenoresMedia =
                       (int) stream.mapToDouble(Double::parseDouble)
                       .filter(n -> n < finalMedia)
                       .count();
               
               System.out.println("Cantidad de números menores que la media: " + valoresMenoresMedia);
          }
     }
}
