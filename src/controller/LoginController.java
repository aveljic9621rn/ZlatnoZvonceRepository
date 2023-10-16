package controller;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import view.ExceptionFrame;
import view.MainMenuFrame;

import java.util.List;

public class LoginController {
    public static Object handleLoginButton(Stage primaryStage, TextField nameTextField, List<String> listClanovi) {
        String username = nameTextField.getText();
        if (!username.isEmpty()) {
            if (listClanovi.contains(username)){
                MainMenuFrame mainMenuFrame = new MainMenuFrame(username);
                mainMenuFrame.start(primaryStage);
            }
            else{
                return new ExceptionFrame("Greska","Ti nisi clan Zlatnog Zvonceta");
            }
        }
        else{
            return new ExceptionFrame("Greska","Ne mozes staviti prazan username");
        }
        return null;
    }
}
