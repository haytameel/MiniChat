package es.uji.al426285;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente implements  Runnable{
    private int puerto;//puerto al que se conectará el cliente
    private String mensaje;//mensaje a enviar

    public Cliente(int puerto, String mensaje) {
        this.puerto = puerto;
        this.mensaje = mensaje;
    }

    // cuando el hilo del cliente se inicia se ejecuta el siguiente metodo
    @Override
    public void run() {
        String host="127.0.0.1";//ip del host, localhost vaya
        DataOutputStream out=null;
        try {
            //socket para conectarse el cliente al servidor
            Socket socket=new Socket(host,puerto);

            //la salida
            out=new DataOutputStream(socket.getOutputStream());

            ///Escribe/envia el mensaje al servidor
            out.writeUTF(mensaje);

            //cierra la conexion del socket
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
