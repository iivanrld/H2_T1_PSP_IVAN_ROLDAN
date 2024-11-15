package psp;

//Servidor.java
import java.io.*;
import java.net.*;

public class Servidor {
 private CapaAccesoDatos accesoDatos; // Instancia de la capa de acceso a datos

 public Servidor() {
     accesoDatos = new CapaAccesoDatos(); // Inicializamos la capa de datos
 }

 // Método para iniciar el servidor en un puerto específico
 public void iniciarServidor(int puerto) {
     try (ServerSocket servidorSocket = new ServerSocket(puerto)) {
         System.out.println("El servidor está escuchando en el puerto " + puerto);

         while (true) {
             Socket socket = servidorSocket.accept(); // Acepta conexiones de clientes
             new ManejadorCliente(socket, accesoDatos).start(); // Crea un hilo para atender cada cliente
         }
     } catch (IOException ex) {
         System.out.println("Error en el servidor: " + ex.getMessage());
         ex.printStackTrace();
     }
 }

 public static void main(String[] args) {
     Servidor servidor = new Servidor();
     servidor.iniciarServidor(5000); // Iniciar el servidor en el puerto 5000
 }
}

class ManejadorCliente extends Thread {
 private Socket socket;
 private CapaAccesoDatos accesoDatos;

 public ManejadorCliente(Socket socket, CapaAccesoDatos accesoDatos) {
     this.socket = socket;
     this.accesoDatos = accesoDatos;
 }

 public void run() {
     try (BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          PrintWriter salida = new PrintWriter(socket.getOutputStream(), true)) {

         // Recibimos la palabra clave del cliente
         String palabraClave = entrada.readLine();
         String resultado = accesoDatos.obtenerInfoLibro(palabraClave); // Buscamos en la capa de datos
         salida.println(resultado); // Enviamos el resultado al cliente

     } catch (IOException ex) {
         System.out.println("Excepción en el servidor: " + ex.getMessage());
         ex.printStackTrace();
     } finally {
         try {
             socket.close(); // Cerramos el socket
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
 }
}
