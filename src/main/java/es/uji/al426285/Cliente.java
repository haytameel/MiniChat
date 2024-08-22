package es.uji.al426285;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        String host="localhost";
        int puerto=10000;
        DataInputStream in=null;
        DataOutputStream out=null;
        try {
            Socket socket=new Socket(host,puerto);

            in=new DataInputStream(socket.getInputStream());
            out=new DataOutputStream(socket.getOutputStream());

            //escribo mensaje, luego leo
            out.writeUTF("Hola, desde el cliente!!");
            //leo lo que me dice el servidor
            String mensaje=in.readUTF();
            System.out.println(mensaje);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
