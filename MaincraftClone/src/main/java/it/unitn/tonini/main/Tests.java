package it.unitn.tonini.main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Tests extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // crea un nuovo GridPane
        GridPane gridPane = new GridPane();

        // crea un nuovo Pane per ogni cella del GridPane
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                Pane pane = new Pane();

                pane.setStyle("-fx-background-color: red; -fx-border-color:black"); // opzionale, per colorare lo sfondo del Pane

                pane.setMinWidth(35);
                pane.setMinHeight(35);

                GridPane.setMargin(pane, new Insets(5));

                gridPane.add(pane, col, row);
            }
        }

        // crea una nuova scena con il GridPane come contenuto principale
        Scene scene = new Scene(gridPane, 600, 400);

        // imposta il titolo della finestra
        primaryStage.setTitle("GridPane Example");

        // imposta la scena come scena principale della finestra
        primaryStage.setScene(scene);

        // mostra la finestra
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}