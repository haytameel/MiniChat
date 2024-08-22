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


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Label titulo = new Label("Bienvenido al chat");
        titulo.setFont(Font.font("System", FontWeight.BOLD, 20));
        TextArea chat=new TextArea();
        chat.setEditable(false);
        chat.setWrapText(true);
        TextField mensaje=new TextField();
        Button confirmar=new Button("Enviar");
//        chat.setPrefHeight(400);chat.setPrefWidth(200);
        //mensaje.setPrefHeight(20);
        mensaje.setPrefWidth(400);
        HBox hBox=new HBox(mensaje,confirmar);
        VBox vBox=new VBox(titulo,chat,hBox);
        vBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setPadding(new Insets(10, 10, 10, 0));
        BorderPane borderPane=new BorderPane();
        borderPane.setCenter(vBox);
        var scene = new Scene(borderPane, 800, 560);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}