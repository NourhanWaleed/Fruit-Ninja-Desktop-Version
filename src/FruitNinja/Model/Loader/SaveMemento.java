package FruitNinja.Model.Loader;


import FruitNinja.Model.Difficulty;

public class SaveMemento {
    private int score;
    private int lives;
    private int time;
    private Difficulty difficulty;
    private int highScore;

    public SaveMemento(int score, int lives, int time, Difficulty difficulty) {
        this.score = score;
        this.lives = lives;
        this.time = time;
        this.difficulty = difficulty;
    }

    public SaveMemento(int highScore) {
        this.highScore = highScore;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getLives() {
        return lives;
    }
    public void setLives(int lives) {
        this.lives = lives;
    }
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public Difficulty getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getHighScore() {
        return highScore;
    }
}