package view;

import controller.AkordiChooseController;
import javafx.application.Application;
import javafx.beans.binding.DoubleBinding;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainMenuFrame extends Application {

    private String username;

    public MainMenuFrame() {
        this.username = username;
    }

    @Override
    public void start(Stage primaryStage) {
        // Create the main menu layout
        VBox mainMenuLayout = new VBox();
        mainMenuLayout.setSpacing(10);
        mainMenuLayout.setPadding(new Insets(20));

        // Create the welcome label
        Label welcomeLabel = new Label("Cao! Drago mi je sto te vidim :)");
        welcomeLabel.setFont(Font.font("Tahoma", 20));
        mainMenuLayout.getChildren().add(welcomeLabel);

        // Create the buttons

        Font buttonFont = Font.font("Tahoma", 14);

        Button akordiButton = new Button("Akordi");
        Button tekstoviButton = new Button("Tekstovi");
        Button exitButton = new Button("Zatvori");


        Image image = new Image("resources/logo ZZ - light.jpg");
        ImageView imageView = new ImageView(image);

        mainMenuLayout.getChildren().add(imageView);

        akordiButton.setFont(buttonFont);
        tekstoviButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);

        // Bind button widths to the main menu layout width
        DoubleBinding buttonWidthBinding = mainMenuLayout.widthProperty().divide(2).subtract(10);
        akordiButton.prefWidthProperty().bind(buttonWidthBinding);
        tekstoviButton.prefWidthProperty().bind(buttonWidthBinding);
        exitButton.prefWidthProperty().bind(buttonWidthBinding);

        akordiButton.setOnAction(event -> AkordiChooseController.handleAkordiChooseButton(primaryStage));
        exitButton.setOnAction(event -> primaryStage.close());

        // Add the buttons to the main menu layout
        mainMenuLayout.getChildren().addAll(akordiButton, tekstoviButton, exitButton);
        mainMenuLayout.setAlignment(Pos.CENTER);
        mainMenuLayout.setSpacing(20);
        mainMenuLayout.setPadding(new Insets(20));

        mainMenuLayout.setBackground(new Background(new BackgroundFill(Color.GOLD, CornerRadii.EMPTY, Insets.EMPTY)));

        // Create the scene
        Scene scene = new Scene(mainMenuLayout, 550, 700);

        // Set the scene on the primary stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Zlatno Zvonce");
        primaryStage.getIcons().add(new Image("resources/logo ZZ - light.jpg"));

        // Show the primary stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
