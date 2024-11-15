package psp;

//Cliente.java
import java.io.*;
import java.net.*;

public class Cliente {
 public void solicitarInfoLibro(String palabraClave) {
     try (Socket socket = new Socket("localhost", 5000);
          PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
          BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

         // Enviamos la palabra clave al servidor
         salida.println(palabraClave);
         // Recibimos la respuesta del servidor
         String respuesta = entrada.readLine();
         System.out.println("Respuesta del servidor: " + respuesta);

     } catch (UnknownHostException ex) {
         System.out.println("Servidor no encontrado: " + ex.getMessage());
     } catch (IOException ex) {
         System.out.println("Error de entrada/salida: " + ex.getMessage());
     }
 }

 public static void main(String[] args) {
     Cliente cliente = new Cliente();
     cliente.solicitarInfoLibro("Java"); // Solicitamos información para la palabra clave "Java"
 }
}
