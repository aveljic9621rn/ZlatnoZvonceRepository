package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AkordiChooseFrame extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button etnoPesmeButton = createStyledButton("Etno pesme");
        Button patriotskePesmeButton = createStyledButton("Patriotske pesme s poznatim autorom");
        Button duhovnePesmeButton = createStyledButton("Duhovne pesme");
        Button autorskePesmeButton = createStyledButton("Autorske pesme");
        Button ruskePesmeButton = createStyledButton("Ruske pesme");
        Button backButton = createStyledButton("Nazad");


        etnoPesmeButton.setOnAction(event -> new AkordiEtnoFrame().start(primaryStage));
        backButton.setOnAction(event -> new MainMenuFrame().start(primaryStage));

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(etnoPesmeButton, patriotskePesmeButton, duhovnePesmeButton, autorskePesmeButton, ruskePesmeButton, backButton);

        StackPane stackPane = new StackPane(root);
        stackPane.setAlignment(Pos.CENTER);
        stackPane.setBackground(new Background(new BackgroundFill(Color.GOLD, CornerRadii.EMPTY, Insets.EMPTY)));
        stackPane.setStyle("-fx-border-color: #4CAF50; -fx-border-width: 2px");

        Scene scene = new Scene(stackPane, 550, 700);
        root.setBackground(new Background(new BackgroundFill(Color.GOLD, CornerRadii.EMPTY, Insets.EMPTY)));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setStyle("-fx-font-size: 16px; -fx-background-color: #4CAF50; -fx-text-fill: white; -fx-padding: 10px 20px");
        button.setOnMouseEntered(event -> button.setStyle("-fx-background-color: #45A049; -fx-font-size: 16px; -fx-text-fill: white; -fx-padding: 10px 20px"));
        button.setOnMouseExited(event -> button.setStyle("-fx-background-color: #4CAF50; -fx-font-size: 16px; -fx-text-fill: white; -fx-padding: 10px 20px"));
        button.setOnMousePressed(event -> button.setStyle("-fx-background-color: #3C853E; -fx-font-size: 16px; -fx-text-fill: white; -fx-padding: 10px 20px"));
        button.setOnMouseReleased(event -> button.setStyle("-fx-background-color: #45A049; -fx-font-size: 16px; -fx-text-fill: white; -fx-padding: 10px 20px"));
        return button;
    }
}

