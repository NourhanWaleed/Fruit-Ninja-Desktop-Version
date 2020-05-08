package FruitNinja.Controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import FruitNinja.Controller.CustomComponents.ShakeOnHover;
import FruitNinja.Model.Difficulty;
import FruitNinja.Model.GameActions;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


public class MainMenuController implements Initializable {

    @FXML private ImageView mainMenu;
    @FXML private Button randombutton,easybutton,hardbutton,mediumbutton,exitbutton,loadGame,arcade;
    Image image = new Image(getClass().getResource("/FruitNinja/resources/Mainmenu.png").toExternalForm());
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mainMenu.setImage(image);
        randombutton.setOnMouseEntered(new ShakeOnHover(randombutton));
        easybutton.setOnMouseEntered(new ShakeOnHover(easybutton));
        hardbutton.setOnMouseEntered(new ShakeOnHover(hardbutton));
        mediumbutton.setOnMouseEntered(new ShakeOnHover(mediumbutton));
        exitbutton.setOnMouseEntered(new ShakeOnHover(exitbutton));
        loadGame.setOnMouseEntered(new ShakeOnHover(loadGame));
        arcade.setOnMouseEntered(new ShakeOnHover(arcade));

        randombutton.setFocusTraversable(false);
        easybutton.setFocusTraversable(false);
        hardbutton.setFocusTraversable(false);
        mediumbutton.setFocusTraversable(false);
        exitbutton.setFocusTraversable(false);
        loadGame.setFocusTraversable(false);
        arcade.setFocusTraversable(false);

        Media sound = new Media(getClass().getResource("/FruitNinja/resources/Audio/Game-start.wav").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

    }

    @FXML
    public void exitbutton() { System.exit(0); }

    @FXML
    public void easybutton(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GameActions.setDifficulty(Difficulty.EASY);
        GameController.setGameMod("normal");
        Parent root = FXMLLoader.load(getClass().getResource("/FruitNinja/View/Game.fxml"));
        Scene scene = new Scene(root, 800, 600);
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void mediumbutton(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GameActions.setDifficulty(Difficulty.MEDIUM);
        GameController.setGameMod("normal");
        Parent root = FXMLLoader.load(getClass().getResource("/FruitNinja/View/Game.fxml"));
        Scene scene = new Scene(root, 800, 600);
        window.setScene(scene);
        window.show();
    }
    @FXML
    public void hardbutton(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GameActions.setDifficulty(Difficulty.HARD);
        GameController.setGameMod("normal");
        Parent root = FXMLLoader.load(getClass().getResource("/FruitNinja/View/Game.fxml"));
        Scene scene = new Scene(root, 800, 600);
        window.setScene(scene);
        window.show();
    }
    @FXML
    public void randombutton(ActionEvent event) throws IOException  {
        int x = (int) (Math.random() * 3);
        if (x==0)
            hardbutton(event);
        else if (x==1)
            mediumbutton(event);
        else if (x==2)
            easybutton(event);
    }

    @FXML
    public void arcadeButton(ActionEvent event) throws IOException  {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GameActions.setDifficulty(Difficulty.MEDIUM);
        GameController.setGameMod("arcade");
        Parent root = FXMLLoader.load(getClass().getResource("/FruitNinja/View/Game.fxml"));
        Scene scene = new Scene(root, 800, 600);
        window.setScene(scene);
        window.show();
    }

    public void loadGame(ActionEvent event) throws IOException {
        GameController.setFlag(0);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/FruitNinja/View/Game.fxml"));
        GameController.setFlag(1);
        Scene scene = new Scene(root, 800, 600);
        window.setScene(scene);
        window.show();
    }
}
