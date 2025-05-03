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

public class ServidorEco {
    public static void main(String[] args) {
        try {
            // 1. Crear ServerSocket en puerto 5000
            ServerSocket servidor = new ServerSocket(5000);
            System.out.println("Servidor iniciado. Esperando conexiones...");
            
            // 2. Aceptar conexión de cliente
            Socket socket = servidor.accept();
            System.out.println("Cliente conectado: " + socket.getInetAddress());
            
            // 3. Configurar flujos de entrada/salida
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            
            // 4. Recibir mensaje del cliente
            String mensaje = in.readUTF();
            System.out.println("Mensaje recibido del cliente: " + mensaje);
            
            // 5. Enviar respuesta al cliente
            String respuesta = "Mensaje recibido: " + mensaje;
            out.writeUTF(respuesta);
            
            // 6. Cerrar conexiones
            socket.close();
            servidor.close();
            System.out.println("Conexión cerrada.");
            
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}