package FruitNinja.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import FruitNinja.Model.*;
import FruitNinja.Model.GameObjects.FatalBomb;
import FruitNinja.Model.GameObjects.GameObjectClass;
import FruitNinja.Model.GameObjects.RegularFruit;
import FruitNinja.Model.GameObjects.SpecialFruit;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameController implements Initializable {

    @FXML private Canvas canvas;
    @FXML private Label scorelabel, highscorelabel, gamediflabel, Label, lives;
    @FXML private ImageView life1, life2, life3;
    @FXML private Button resetButton;
    private Alerts alerts = new Alerts();

    private double mouseX, mouseY;

    private GraphicsContext gc;
    private Timeline line;
    private GameActions gameActions = GameActions.getInstance();
    private AnimationTimer animationTimer;
    private static int highscore = 0;
    private static int flag = 1;
    private int c = 0;
    private static String gameMode;
    private double gameObjectCreationRate = 3;
    private MediaPlayer mediaPlayer;
    private Image bg = new Image(getClass().getResource("/FruitNinja/resources/background.jpeg").toExternalForm());

    private Image life = new Image(getClass().getResource("/FruitNinja/resources/lives2.png").toExternalForm());

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        life1.setImage(life);
        life2.setImage(life);
        life3.setImage(life);
        gameActions.loadHighScore();
        highscorelabel.setText(Integer.toString(highscore));

        if (flag == 1)
            gameActions.ResetGame();
        else {
            gameActions.loadGame();
        }

        if (gameMode.equals("arcade")){
            gamediflabel.setText("Arcade");
            gameObjectCreationRate =1.0;
        }
        else if (GameActions.getDifficulty().equals(Difficulty.EASY))
            gamediflabel.setText("Easy");
        else if (GameActions.getDifficulty().equals(Difficulty.MEDIUM)){
            gamediflabel.setText("Medium");
            gameObjectCreationRate =1.0;
        }
        else if (GameActions.getDifficulty().equals(Difficulty.HARD)){
            gamediflabel.setText("Hard");
            gameObjectCreationRate =1.0;
        }

        gc = canvas.getGraphicsContext2D();
        line = new Timeline(new KeyFrame(Duration.seconds(gameObjectCreationRate), actionEvent -> {
            gameActions.createGameObject();
            gameActions.incrementTime();
            if (GameActions.getTime() % 20 == 0)
                GameObjectClass.setSpeed((int) (GameObjectClass.getSpeed()*70));
        }));
        line.setCycleCount(Timeline.INDEFINITE);
        line.play();
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long arg0) {

                gc.clearRect(0, 0, 800, 600);
                gc.drawImage(bg, 0, 0, 800, 600);

                if (gameMode.equals("arcade")) {
                    life1.setVisible(false);
                    life2.setVisible(false);
                    life3.setVisible(false);

                    gameActions.checkFallingObjects2();

                    if (GameActions.getTime() == 60)
                        loseGame();
                } else {
                    // has to be there for life bonus
                    life1.setVisible(true);
                    life2.setVisible(true);
                    life3.setVisible(true);

                    if (GameActions.getLives() < 3)
                        life1.setVisible(false);
                    if (GameActions.getLives() < 2)
                        life2.setVisible(false);
                    if (GameActions.getLives() < 1)
                        life3.setVisible(false);

                    gameActions.checkFallingObjects();
                    if (GameActions.getLives() == 0)
                        loseGame();
                }
                gameActions.updateObjectsLocations(gc);
                scorelabel.setText(Integer.toString(GameActions.getScore()));
                Label.setText(formatSeconds(GameActions.getTime()));
                if (GameActions.getScore() > highscore)
                    highscorelabel.setText(Integer.toString(GameActions.getScore()));
            }
        };
        animationTimer.start();
    }

    public void save() { gameActions.saveGame(); }

    public void back(ActionEvent e) {
        animationTimer.stop();
        line.stop();
        if(alerts.confirmationDialogue("Game exit?","Would you like to save the game?")) save();
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/FruitNinja/View/MainMenu.fxml"));
            Scene scene = new Scene(root);
            window.setScene(scene);
        } catch (IOException e1) {
            e1.printStackTrace();
            try {
                reset(null);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }

    }

    private void loseGame() {
        animationTimer.stop();
        line.stop();
        Alerts.imageAlert("game over", getClass().getResource("/FruitNinja/resources/gaemo.png").toString());
        AudioClip lose = new AudioClip(getClass().getResource("/FruitNinja/resources/Audio/GameOver.wav").toExternalForm());
        lose.play();
        if (GameActions.getScore() > highscore) {
            highscore = GameActions.getScore();
            highscorelabel.setText(Integer.toString(highscore));
            gameActions.saveHighScore();
            Alerts.textAlert("Congratulations!", "New Highsore!");
        }
    }

    @FXML
    public void onDrag(MouseEvent event) {
        mouseX = event.getX();
        mouseY = event.getY();

        for (int i = 0; i < gameActions.getGameObjects().size(); i++) {
            if ((mouseX >= gameActions.getGameObjects().get(i).getXLocation()
                    && mouseX <= gameActions.getGameObjects().get(i).getXLocation() + 75)
                    && !gameActions.getGameObjects().get(i).isSliced()
                    && (mouseY >= gameActions.getGameObjects().get(i).getYLocation()
                    && mouseY <= gameActions.getGameObjects().get(i).getYLocation() + 75)) {

                if (gameActions.getGameObjects().get(i) instanceof RegularFruit||gameActions.getGameObjects().get(i) instanceof SpecialFruit) {
                    AudioClip impact = new AudioClip(getClass().getResource("/FruitNinja/resources/Audio/impact.wav").toExternalForm());
                    impact.play();

               } else {
                    Media explodeSound = new Media(getClass().getResource("/FruitNinja/resources/Audio/explode.wav").toExternalForm());
                    mediaPlayer = new MediaPlayer(explodeSound);
                    mediaPlayer.play();
                    //bomb
                }

                if (gameMode.equals("arcade")) {
                    gameActions.sliceObject2(gameActions.getGameObjects().get(i));
                } else {
                    if (gameActions.getGameObjects().get(i) instanceof FatalBomb)
                        loseGame();
                    else if (gameActions.getGameObjects().get(i) instanceof SpecialFruit) {
                        gameActions.sliceObject(gameActions.getGameObjects().get(i));
                        /*
                         * for (int j = 0; j < gameActions.getGameObjects().size(); j++){ if
                         * (gameActions.getGameObjects().get(i) instanceof RegularFruit)
                         * gameActions.sliceObject(gameActions.getGameObjects().get(i)); }
                         */
                    } else
                        gameActions.sliceObject(gameActions.getGameObjects().get(i));
                }
            }
        }
    }

    @FXML
    public void reset(ActionEvent e) throws IOException {
        highscorelabel.setText(Integer.toString(highscore));
        gameActions.ResetGame();
        gameActions.updateObjectsLocations(gc);
        animationTimer.start();
        line.play();
    }

    public static void setGameMod(String gameMod){
        if(gameMod!=null &&!gameMod.contentEquals(""))gameMode = gameMod;
    }

    public static void setFlag(int  inflag){
        flag  = inflag;
    }

    public static int getHighscore() {
        return highscore;
    }

    public static void setHighscore(int hs ) {
        highscore = hs;
    }

    public static String formatSeconds(int timeInSeconds) {
        int secondsLeft = timeInSeconds % 3600 % 60;
        int minutes = timeInSeconds % 3600 / 60;
        int hours = timeInSeconds / 3600;

        String HH = ((hours < 10) ? "0" : "") + hours;
        String MM = ((minutes < 10) ? "0" : "") + minutes;
        String SS = ((secondsLeft < 10) ? "0" : "") + secondsLeft;
        if (Integer.parseInt(HH) > 0) return HH + ":" + MM + ":" + SS;
        else  if(Integer.parseInt(MM)>0)return MM + ":" + SS;
        return SS;
    }
}
