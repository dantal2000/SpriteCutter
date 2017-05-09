import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

/**
 * Created by dantal2000 on 08.05.2017.
 * <p>
 * It is under MIT license
 */

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ImageView spriteView = new ImageView();
        Pane leftSide = new Pane(spriteView);
        leftSide.setVisible(false);

        TextField inputFileField = new TextField();
        TextField xField = new TextField();
        TextField yField = new TextField();
        TextField widthField = new TextField();
        TextField heightField = new TextField();
        TextField outFileField = new TextField();

        inputFileField.setPromptText("Путь до исходного спрайта:");
        xField.setPromptText("x:");
        yField.setPromptText("y:");
        widthField.setPromptText("width:");
        heightField.setPromptText("height:");
        outFileField.setPromptText("Имя для конечного файла (необязательно):");

        Button submitButton = new Button("Вырезать");
        Label logLabel = new Label("Введите данные");
        logLabel.setWrapText(true);

        submitButton.setOnAction(event -> {
            String inFilePath = inputFileField.getText();
            String x = xField.getText();
            String y = yField.getText();
            String width = widthField.getText();
            String height = heightField.getText();
            String outFilePath = outFileField.getText();

            int count;
            if (outFilePath.length() > 0) count = 6;
            else count = 5;
            String[] params = new String[count];

            params[0] = inFilePath;
            params[1] = x;
            params[2] = y;
            params[3] = width;
            params[4] = height;
            if (count > 5) params[5] = outFilePath;

            try {
                File cut = Cutter.cut(params);
                logLabel.setTextFill(Color.GREEN);
                logLabel.setText("Успешно.\nФайл сохранен - " + cut.getPath());
                spriteView.setImage(new Image(String.valueOf(cut.toURI().toURL())));
                if (!leftSide.isVisible()) leftSide.setVisible(true);
            } catch (IOException | Cutter.IllegalArgumentExc e) {
                e.printStackTrace();
                logLabel.setTextFill(Color.RED);
                logLabel.setText("Произошла ошибка:\n" + e.getMessage());
            }
        });

        VBox rightSide = new VBox(inputFileField, xField, yField, widthField, heightField, outFileField, submitButton, logLabel);
        rightSide.setMaxWidth(300);
        rightSide.setMinWidth(300);

        SplitPane splitPane = new SplitPane(leftSide, rightSide);
        splitPane.setOrientation(Orientation.HORIZONTAL);

        Scene scene = new Scene(splitPane, 400, 400);
        primaryStage.setMinWidth(416);
        primaryStage.setMinHeight(439);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Split Cutter (v1) [GUI]");
        primaryStage.show();
    }
}
