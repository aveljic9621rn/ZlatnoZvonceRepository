package view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AkordiEtnoFrame extends Application {

    private static final String FILE_PATH = "path/to/your/file.txt";

    private ListView<String> listBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        listBox = new ListView<>();
        VBox root = new VBox(listBox);
        Scene scene = new Scene(root, 200, 300);

        try {
            fillListBoxFromFile();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + FILE_PATH);
            e.printStackTrace();
        }

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void fillListBoxFromFile() throws FileNotFoundException {
        List<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(new File(FILE_PATH));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
        }

        scanner.close();

        listBox.setItems(FXCollections.observableArrayList(lines));
    }
}

