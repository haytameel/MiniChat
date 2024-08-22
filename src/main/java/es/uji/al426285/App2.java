package es.uji.al426285;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;


/**
 * JavaFX App1
 */
public class App2 extends Application implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        chat.appendText((String) arg);

    }
    TextArea chat=new TextArea();

    TextField mensaje=new TextField();

    Button enviar =new Button("Enviar");

    @Override
    public void start(Stage stage) {
        //lanzamos el servidor en un hilo
        Servidor servidor=new Servidor(60000);
        servidor.addObserver(this);
        Thread thread=new Thread(servidor);
        thread.start();

        Label titulo = new Label("Bienvenido al chat");
        titulo.setFont(Font.font("System", FontWeight.BOLD, 20));
        chat.setEditable(false);
        chat.setWrapText(true);

        enviar.setOnAction(e->{
            String msj="User2: "+mensaje.getText()+"\n";
            chat.appendText(msj);

            Cliente c=new Cliente(50000,msj);
            Thread thread1=new Thread(c);
            thread1.start();
        });
        mensaje.setPrefWidth(400);
        HBox hBox=new HBox(mensaje,enviar);
        VBox vBox=new VBox(titulo,chat,hBox);
        vBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setPadding(new Insets(10, 10, 10, 0));
        BorderPane borderPane=new BorderPane();
        borderPane.setCenter(vBox);
        var scene = new Scene(borderPane, 800, 560);
        stage.setScene(scene);
        stage.setTitle("Mini-Chat");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}