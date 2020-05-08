package FruitNinja.Model.GameObjects;

import FruitNinja.Model.Definitions.IGameObject;
import FruitNinja.Model.Difficulty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameObjectClass implements IGameObject {
    private boolean isSliced=false;
    private double XLocation;
    private double YLocation;
    private Image[] images=new Image[3];
    private boolean movingUp=true;
    private static int speed;
    private double maxHeight;
    private ObjectType objecttype;

    public double getXLocation() {
        return XLocation;
    }

    public double getYLocation() {
        return YLocation;
    }

    @Override
    public ObjectType getObjectType() {
        return objecttype;
    }

    @Override
    public double getMaxHeight() {
        return maxHeight;
    }

    public boolean hasMovedOffScreen() {
        return  (YLocation >= 600);
    }

    public boolean isSliced() {
        return isSliced;
    }

    public Image[] getImages(){
        return images;
    }

    public void render(GraphicsContext gc) {
        try{
        if (isSliced){
            gc.drawImage(images[1], XLocation, YLocation,images[1].getWidth(),images[1].getHeight() );
            gc.drawImage(images[2], XLocation+20, YLocation,images[2].getWidth(),images[2].getHeight() );}
        else
            gc.drawImage(images[0], XLocation, YLocation,images[0].getWidth(),images[0].getHeight() );
    }catch(NullPointerException np){
            System.out.println(objecttype.toString());
        }
    }
    public void move(Difficulty difficulty) {
        if(difficulty.equals(Difficulty.EASY)) speed = 4;
        else if(difficulty.equals(Difficulty.MEDIUM)) speed = 8;
        else speed = 12;
        if (movingUp) {
            double newYLocation = YLocation - speed;
            if (newYLocation < maxHeight)
                movingUp = false;
            else
                YLocation = newYLocation;
        } else  YLocation += speed;
    }

    public void slice() {
        isSliced =true;
    }

    // getters and setters
    public void setSliced(boolean sliced) {
        isSliced = sliced;
    }

    public void setXLocation(double XLocation) {
        this.XLocation = XLocation;
    }

    public void setYLocation(double YLocation) {
        this.YLocation = YLocation;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }

    public boolean isMovingUp() {
        return movingUp;
    }

    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

    public static int getSpeed() {
        return speed;
    }

    public static void setSpeed(int speed) {
        GameObjectClass.speed = speed;
    }

    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    public ObjectType getObjecttype() {
        return objecttype;
    }

    public void setObjecttype(ObjectType objecttype) {
        this.objecttype = objecttype;
    }

    public void setImage(int index, Image img){
        if(index >=0 && index < this.images.length) this.images[index] = img;
    }

    public Image getImage(int index){
        if(index >=0 && index < this.images.length) return this.images[index];
        else return  null;
    }
}
