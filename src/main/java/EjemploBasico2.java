import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

public class EjemploBasico2 {
     public static void main(String[] args) throws IOException {

          Path texto = Paths.get("ficheros/fichero1Analizado.txt");
          Files.write(texto, List.of("Texto a escribir en fichero y una ñ", "nueva línea"));
          
          List<String> lineas = Files.readAllLines(texto);
          System.out.println("==Leer por líneas==");
          for (String l : lineas) {
              int i = lineas.indexOf(l);
               System.out.println("Línea " + (i+1) + " = " + l);
          }
          
          long bytesLeidos = Files.size(texto);
          System.out.println("leido " + bytesLeidos + " bytes");
          
          LocalDate fecha =  LocalDate.now();
          String fechaString = String.format("%d/%d/%d", fecha.getDayOfMonth(), fecha.getMonthValue(), fecha.getYear());
          System.out.println("fecha: " + fechaString);
          
          long lineasLeidas = lineas.size();
          System.out.println("leido " + lineasLeidas + " lineas");
     }
}
