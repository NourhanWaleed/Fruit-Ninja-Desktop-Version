package FruitNinja.Model;
import FruitNinja.Controller.GameController;
import FruitNinja.Model.Definitions.Command;
import FruitNinja.Model.Definitions.IGameActions;
import FruitNinja.Model.GameObjects.*;
import FruitNinja.Model.GameObjects.Factory.GameObjectFactory;
import FruitNinja.Model.Loader.*;
import FruitNinja.Model.Loader.Commands.LoadCommand;
import FruitNinja.Model.Loader.Commands.SaveCommand;
import FruitNinja.Model.Loader.Commands.SaveHighScore;
import FruitNinja.Model.Loader.Commands.loadHighScore;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.AudioClip;

import java.util.ArrayList;



public class GameActions implements IGameActions {
    private ArrayList<GameObjectClass> gameObjects = new ArrayList<GameObjectClass>();
    private static int score = 0;
    private static int lives = 3;
    private static int time = 0;
    private static Difficulty difficulty;
    private ArrayList<GameObjectClass> toBeDeleted = new ArrayList<GameObjectClass>();
    private SaveLoad saveLoad = new SaveLoad();
    private Remote remote = new Remote();
    private Command SaveCommand = new SaveCommand(saveLoad);
    private Command loadCommand = new LoadCommand(saveLoad);
    private Command saveHighScore = new SaveHighScore(saveLoad);
    private Command loadHighScore = new loadHighScore(saveLoad);
    private GameObjectFactory gameObjectFactory = new GameObjectFactory();

    // Singleton
    private static GameActions gameActions;

    private GameActions() { }

    public static synchronized GameActions getInstance() {
        if (gameActions == null)
            gameActions = new GameActions();
        return gameActions;
    }

    @Override
    public void createGameObject() {
        gameObjects.add(gameObjectFactory.createObject());
    }

    @Override
    public void updateObjectsLocations(GraphicsContext gc) {
        for (GameObjectClass x : gameObjects) {
            x.move( difficulty);
            x.render(gc);
        }
    }

   
    @Override
    public void ResetGame() {
        lives = 3;
        score = 0;
        time = 0;
        gameObjects.clear();
    }

    public ArrayList<GameObjectClass> getGameObjects() {
        return gameObjects;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
       GameActions.score = score;
    }

    public static int getTime() {
        return time;
    }

    public static void setTime(int time) {
        GameActions.time = time;
    }

    public static int getLives() {
        return lives;
    }

    public static void setLives(int lives) {
        GameActions.lives = lives;
    }

    public void incrementTime() {
        time++;
    }

    public void scorePlusOne() { score++; }

    public void combo2() { score = score * 2; }

    public void combo3() { score = score * 3; }

    public void combo4() { score = score * 4; }

    public void scorePlusFive() {
        score = score + 5;
    }

    public void loseLife() {
        lives--;
    }

    public void timeBonus(){ if (time >=10 ) time = time -10; }

    public void lifeBonus(){ if(lives < 3) lives = lives + 1;}

    private void scoreMinusFive(){ if (score >= 5) score -= 5; else score=0;}

    private void scoreMinusTwo(){ if (score >= 2) score -= 2;	else score=0;}

    public static Difficulty getDifficulty() {
        return difficulty;
    }

    public static void setDifficulty(Difficulty difficulty) {
        GameActions.difficulty = difficulty;
    }

    public void sliceObject(GameObjectClass gameObject) {
        gameObject.slice();
        if (gameObject instanceof RegularFruit)
            scorePlusOne();
        else if (gameObject instanceof SpecialFruit){
            scorePlusFive();
            lifeBonus();
        }
        else if (gameObject instanceof DangerousBomb)
            loseLife();
    }

    public void sliceObject2(GameObjectClass gameObject) {
        gameObject.slice();
        if (gameObject instanceof RegularFruit)
            scorePlusOne();
        else if (gameObject instanceof SpecialFruit)
            scorePlusFive();
        else if (gameObject instanceof DangerousBomb)
            scoreMinusTwo();
        else if(gameObject instanceof FatalBomb)
            scoreMinusFive();
    }

    public void checkFallingObjects() {
        for (GameObjectClass x : gameObjects) {
            if (x.hasMovedOffScreen()) {
                toBeDeleted.add(x);
                if (!x.isSliced())
                    if (x instanceof RegularFruit || x instanceof SpecialFruit) {
                        loseLife();
                        AudioClip gank = new AudioClip(getClass().getResource("/FruitNinja/resources/Audio/fail.wav").toExternalForm());
                        gank.play();
                    }
            }
        }
        gameActions.getGameObjects().removeAll(toBeDeleted);
        toBeDeleted.clear();
    }

    public void checkFallingObjects2() {
        for (GameObjectClass x : gameObjects)
            if (x.hasMovedOffScreen()) toBeDeleted.add(x);
        gameActions.getGameObjects().removeAll(toBeDeleted);
        toBeDeleted.clear();
    }

    public void saveGame() {
        SaveMemento saveMemento = new SaveMemento(GameActions.getScore(), GameActions.getLives(), GameActions.getTime(),GameActions.getDifficulty());
        saveLoad.setMemento(saveMemento);
        remote.setCommand(SaveCommand);
        remote.pressButton();
    }

    public void loadGame() {
        remote.setCommand(loadCommand);
        remote.pressButton();
    }
    public void saveHighScore(){
        SaveMemento saveMemento = new SaveMemento(GameController.getHighscore());
        saveLoad.setMemento(saveMemento);
        remote.setCommand(saveHighScore);
        remote.pressButton();
    }

    public void loadHighScore(){
       remote.setCommand(loadHighScore);
       remote.pressButton();
    }
}