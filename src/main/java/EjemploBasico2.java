import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

public class EjemploBasico2 {
     public static void main(String[] args) throws IOException {

          // Fichero de salida para guardar dos lineas de ejemplo.
          Path texto = Paths.get("ficheros/fichero1Analizado.txt");
          Files.write(texto, List.of("Texto a escribir en fichero y una ñ", "nueva línea"));
          
          // Lectura linea a linea para poder procesar cada registro.
          List<String> lineas = Files.readAllLines(texto);
          System.out.println("==Leer por líneas==");
          for (String l : lineas) {
               // Se obtiene el indice para mostrar numero de linea en pantalla.
              int i = lineas.indexOf(l);
               System.out.println("Línea " + (i+1) + " = " + l);
          }
          
          // Tamano del fichero en bytes en disco.
          long bytesLeidos = Files.size(texto);
          System.out.println("leido " + bytesLeidos + " bytes");
          
          // Fecha actual formateada manualmente como dd/mm/aaaa.
          LocalDate fecha =  LocalDate.now();
          String fechaString = String.format("%d/%d/%d", fecha.getDayOfMonth(), fecha.getMonthValue(), fecha.getYear());
          System.out.println("fecha: " + fechaString);
          
          // Numero total de lineas leidas.
          long lineasLeidas = lineas.size();
          System.out.println("leido " + lineasLeidas + " lineas");
     }
}
