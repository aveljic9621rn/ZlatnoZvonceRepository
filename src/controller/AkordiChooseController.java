package controller;

import javafx.stage.Stage;
import view.AkordiChooseFrame;

public class AkordiChooseController {
    public static void handleAkordiChooseButton(Stage primaryStage){
        AkordiChooseFrame akordiChooseFrame = new AkordiChooseFrame();
        akordiChooseFrame.start(primaryStage);
    }
}
