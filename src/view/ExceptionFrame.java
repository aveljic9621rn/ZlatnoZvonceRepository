package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ExceptionFrame {

	String title;
	String message;
	public ExceptionFrame(String title, String message){
		display(title, message);
	}

	public static void display(String title, String message) {
		Stage popupStage = new Stage();
		popupStage.initModality(Modality.APPLICATION_MODAL);
		popupStage.setTitle(title);

		Label titleLabel = new Label(title);
		titleLabel.setFont(Font.font("Tahoma", 20));
		titleLabel.setTextFill(Color.RED);

		Label messageLabel = new Label(message);
		messageLabel.setFont(Font.font("Tahoma", 16));

		Button closeButton = new Button("Close");
		closeButton.setOnAction(event -> popupStage.close());

		VBox popupLayout = new VBox(10);
		popupLayout.setAlignment(Pos.CENTER);
		popupLayout.setBackground(new Background(new BackgroundFill(Color.GOLD, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
		popupLayout.getChildren().addAll(titleLabel, messageLabel, closeButton);

		Scene scene = new Scene(popupLayout, 250, 150);

		popupStage.setScene(scene);
		popupStage.showAndWait();
	}
}
