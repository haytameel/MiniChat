package es.uji.al426285;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

public class Servidor extends Observable implements Runnable {
    private int puerto;//peurto del servidor donde espera/escucha

    public Servidor(int puerto) {
        this.puerto = puerto;
    }

    // cuando el hilo del servidor se inicia se ejecuta el siguiente metodo
    @Override
    public void run() {
        ServerSocket servidor = null;//socket del servidor
        Socket socket = null; //socket para manejar comunicación con cliente

        DataInputStream in;

        try {
            //ServerSocket que escucha en el puerto
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor conectado");

            // Bucle infinito para manejar conexiones de múltiples clientes
            while (true) {
                // Espera a que un cliente se conecte; cuando se conecta, se acepta la conexión y se devuelve un socket para comunicarse con ese cliente
                socket = servidor.accept();
                //concecto el cliente
                System.out.println("Cliente conectado");
                in = new DataInputStream(socket.getInputStream());//recibir datos del cliente


                //leo mensaje, luego escribo
                String mensaje = in.readUTF();//leo lo que ha dicho el cliente
                System.out.println(mensaje);

                //notificar cambio a todos los observadores
                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();


                //desconecto el cliente
                socket.close();
                System.out.println("Cliente desconectado");

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
