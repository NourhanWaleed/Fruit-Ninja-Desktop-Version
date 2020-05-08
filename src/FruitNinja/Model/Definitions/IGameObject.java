package FruitNinja.Model.Definitions;
import FruitNinja.Model.GameObjects.ObjectType;
import javafx.scene.image.Image;

public interface IGameObject {
    double getXLocation();
    double getYLocation();
    ObjectType getObjectType();
    double getMaxHeight();
    boolean isSliced();
    boolean hasMovedOffScreen();
    void slice();
    Image[] getImages();

}
