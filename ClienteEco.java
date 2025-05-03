/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.norbertwieners;

/**
 *
 * @author LUCIANO
 */
import java.net.*;
import java.io.*;

public class ClienteEco {
    public static void main(String[] args) {
        try {
            // 1. Conectar al servidor en localhost:5000
            Socket socket = new Socket("127.0.0.1", 5000);
            System.out.println("Conectado al servidor.");
            
            // 2. Configurar flujos de entrada/salida
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            
            // 3. Enviar mensaje al servidor
            String mensaje = "HOLA SOY ZEVALLOS";
            out.writeUTF(mensaje);
            System.out.println("Mensaje enviado al servidor: " + mensaje);
            
            // 4. Recibir respuesta del servidor
            String respuesta = in.readUTF();
            System.out.println("Respuesta del servidor: " + respuesta);
            
            // 5. Cerrar conexión
            socket.close();
            System.out.println("Conexión cerrada.");
            
        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}