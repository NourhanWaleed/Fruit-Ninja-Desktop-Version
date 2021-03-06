package FruitNinja.Controller;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;

public class Alerts {
    public static void textAlert(String title, String message) {
        Stage window2 = new Stage();
        window2.setMinWidth(250);
        window2.setTitle(title);
        window2.initModality(Modality.APPLICATION_MODAL);
        VBox layout2 = new VBox(20);
        layout2.setPadding(new Insets(10, 10, 10, 10));
        Button closeAlert = new Button("OK");
        closeAlert.setOnAction(e -> window2.close());
        Label alertLabel = new Label(message);
        layout2.getChildren().addAll(alertLabel, closeAlert);
        layout2.setAlignment(Pos.CENTER);
        Scene alertScene = new Scene(layout2, 250, 200);
        window2.setScene(alertScene);
        window2.show();
    }

    public static void imageAlert(String title, String FileName) {
        Stage alert = new Stage();
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle(title);
        alert.setMinHeight(200);
        alert.setMinWidth(250);

        Image image = new Image(FileName);
        ImageView imageView = new ImageView(image);
        // Label label = new Label(FileName);
        VBox layout = new VBox();
        // layout.getChildren().add(label);
        layout.getChildren().add(imageView);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        alert.setScene(scene);
        alert.show();
    }

    public Boolean confirmationDialogue(String title, String message){
        Stage window2 = new Stage();
        AtomicReference<Boolean> confirm = new AtomicReference<>(false);
        window2.setMinWidth(250);
        window2.setTitle(title);
        window2.initModality(Modality.APPLICATION_MODAL);

        VBox layout2 = new VBox(20);
        layout2.setPadding(new Insets(10, 10, 10, 10));
        Button yesBtn = new Button("Yes");
        Button noBtn = new Button("No");

        yesBtn.setOnAction(e -> {window2.close(); confirm.set(true);});
        noBtn.setOnAction(e -> {window2.close();confirm.set(false);});

        HBox hContainer =  new HBox();
        hContainer.getChildren().addAll(yesBtn,noBtn);
        Label alertLabel = new Label(message);
        layout2.getChildren().addAll(alertLabel,hContainer);
        layout2.setAlignment(Pos.CENTER);
        hContainer.setAlignment(Pos.CENTER);
        Scene alertScene = new Scene(layout2, 250, 200);
        window2.setScene(alertScene);
        window2.showAndWait();
        return confirm.get();
    }


}