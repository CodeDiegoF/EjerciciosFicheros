package EjercicioCiudades;

import java.util.Objects;

public class Ciudad {
     // Datos base de cada ciudad leida del CSV.
     private String NombreCiudad;
     private String NombrePaís;
     private double longitud;
     private double latitud;
     
     public Ciudad(String nombreCiudad, String nombrePaís, double latitud, double longitud) {
          this.NombreCiudad = nombreCiudad;
          this.NombrePaís = nombrePaís;
          this.latitud = latitud;
          this.longitud = longitud;
     }
     
     public String getNombreCiudad() {
          return NombreCiudad;
     }
     
     public void setNombreCiudad(String nombreCiudad) {
          NombreCiudad = nombreCiudad;
     }
     
     public String getNombrePaís() {
          return NombrePaís;
     }
     
     public void setNombrePaís(String nombrePaís) {
          NombrePaís = nombrePaís;
     }
     
     public double getLongitud() {
          return longitud;
     }
     
     public void setLongitud(double longitud) {
          this.longitud = longitud;
     }
     
     public double getLatitud() { return latitud;}
     
     public void setLatitud(double latitud) {
          this.latitud = latitud;
     }
     
     @Override
     public boolean equals(Object o) {
          if (o == null || getClass() != o.getClass()) return false;
          Ciudad ciudad = (Ciudad) o;
          // En este ejemplo, dos ciudades se consideran iguales por su nombre.
          return Objects.equals(NombreCiudad, ciudad.NombreCiudad);
     }
     
     @Override
     public int hashCode() {
          // Debe ser coherente con equals para que HashSet funcione correctamente.
          return Objects.hashCode(NombreCiudad);
     }
     
     @Override
     public String toString() {
          // Formato legible para consola/fichero de analisis.
          StringBuilder sb = new StringBuilder();
          sb.append(NombreCiudad)
                  .append(" || " + NombrePaís)
                  .append(" || Long: " + longitud)
                  .append(" || Lat: " + latitud).append("\n");
          
          return sb.toString();
     }
}
