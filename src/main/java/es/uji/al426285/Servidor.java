package es.uji.al426285;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        ServerSocket servidor = null;
        Socket socket = null;
        int puerto = 10000;
        DataInputStream in;
        DataOutputStream out;
        try {
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor conectado");

            while (true) {
                socket = servidor.accept();//Devuelve el socket del cliente
                //concecto el cliente
                System.out.println("Cliente conectado");
                in=new DataInputStream(socket.getInputStream());//recibir mensajes del cliente
                out=new DataOutputStream(socket.getOutputStream());


                //leo mensaje, luego escribo
                String mensaje= in.readUTF();//leo lo que ha dicho el cliente
                System.out.println(mensaje);

                out.writeUTF("Hola, desde el servidor");//le escribo al cliente desde el servidor
                socket.close();//desconecto el cliente
                System.out.println("Cliente desconectado");

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
