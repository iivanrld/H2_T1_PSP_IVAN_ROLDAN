package psp;

//CapaAccesoDatos.java
import java.util.HashMap;
import java.util.Map;

public class CapaAccesoDatos {
 private Map<String, String> libros; // Mapa para almacenar palabras clave y títulos de libros

 public CapaAccesoDatos() {
     libros = new HashMap<>();
     cargarDatos(); // Inicializamos los datos
 }

 // Simulación de carga de datos, aquí podríamos cargar desde una base de datos
 private void cargarDatos() {
     libros.put("Java", "Effective Java, Head First Java, Java: The Complete Reference");
     libros.put("Python", "Learning Python, Python Crash Course");
 }

 // Método para obtener información de los libros según la palabra clave
 public String obtenerInfoLibro(String palabraClave) {
     return libros.getOrDefault(palabraClave, "No se encontraron libros para esta palabra clave.");
 }
}
