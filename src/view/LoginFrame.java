package view;

import controller.LoginController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import view.fileUtils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class LoginFrame extends Application {

    List<String> listClanovi = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        // Create the login layout
        VBox loginLayout = new VBox();
        loginLayout.setSpacing(10);
        loginLayout.setPadding(new Insets(20));
        loginLayout.setAlignment(Pos.CENTER);
        listClanovi = FileUtils.getClanovi();
        // Create the welcome label
        Label nameLabel = new Label("Upisi svoje ime:");
        nameLabel.setFont(Font.font("Tahoma", 16));
        TextField nameTextField = new TextField();

        // Create the login button
        Button loginButton = new Button("Login");
        loginButton.setFont(Font.font("Tahoma", 14));

        // Event handler for login button
        loginButton.setOnAction(event -> LoginController.handleLoginButton(primaryStage, nameTextField, listClanovi));

        // Event handler for Enter key press
        nameTextField.setOnKeyPressed(event -> {

            if (event.getCode() == KeyCode.ENTER) {
                LoginController.handleLoginButton(primaryStage, nameTextField, listClanovi);
            }
        });

        // Add components to the login layout
        loginLayout.getChildren().addAll(nameLabel, nameTextField, loginButton);
        loginLayout.setBackground(new Background(new BackgroundFill(Color.GOLD, CornerRadii.EMPTY, Insets.EMPTY)));

        // Create the scene
        Scene scene = new Scene(loginLayout, 270, 382);

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
