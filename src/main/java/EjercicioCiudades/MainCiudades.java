package EjercicioCiudades;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;



public class MainCiudades {

     private static Ciudad parseCiudad(String linea) {
          String[] tokens = linea.split(",", 4);
          if (tokens.length != 4) {
               return null;
          }

          String nombreCiudad = tokens[0].trim();
          String nombrePais = tokens[1].trim();
          double latitud = Double.parseDouble(tokens[3].trim());
          double longitud = Double.parseDouble(tokens[2].trim());

          return new Ciudad(nombreCiudad, nombrePais, latitud, longitud);
     }

     public static String ObtenerDatos(HashSet<Ciudad> ciudades) throws IOException {
          
          long norte = ciudades.stream().filter(c -> c.getLatitud() > 0).count();
          long sur = ciudades.stream().filter(c -> c.getLatitud() < 0).count();
          long este = ciudades.stream().filter(c -> c.getLongitud() > 0 && c.getLongitud() <= 180).count();
          long oeste = ciudades.stream().filter(c -> c.getLongitud() < 0 && c.getLongitud() >= -180).count();
          long espana = ciudades.stream().filter(c -> c.getNombrePaís().equalsIgnoreCase("Spain")).count();
          long china = ciudades.stream().filter(c -> c.getNombrePaís().equalsIgnoreCase("China")).count();

          String analisis = "Nº de ciudades del norte: " + norte + "\n"
                  + "Nº de ciudades del sur: " + sur + "\n"
                  + "Nº de ciudades del este: " + este + "\n"
                  + "Nº de ciudades del oeste: " + oeste + "\n"
                  + "Nº de ciudades de españa: " + espana + "\n"
                  + "Nº de ciudades de china: " + china + "\n";
          return analisis;
     }

     public static void main(String[] args) throws IOException {
          HashSet<Ciudad> ciudades = new HashSet<>();
          Path inPath = Paths.get("ficheros/ciudades.csv");
          Path outPath = Paths.get("ficheros/ciudadesAnalisis.txt");

          List<String> lineas = Files.readAllLines(inPath);

          for (int i = 1; i < lineas.size(); i++) {
               
               String linea = lineas.get(i);
               
               Ciudad ciudad = parseCiudad(linea);
               if (ciudad != null) {
                    ciudades.add(ciudad);
               }
          }

          System.out.println("Leídas " + ciudades.size() + " ciudades");
          try{
               Files.writeString(outPath,ObtenerDatos(ciudades));
               System.out.printf("Escritos %d en el fichero %s%n", Files.size(outPath), outPath);
          }catch (IOException e) {
               System.out.println("Error al escribir el fichero: " + e.getMessage());
          }

          ObtenerDatos(ciudades);

     }
     
}
