package FruitNinja.Model.Definitions;


import FruitNinja.Model.GameObjects.GameObjectClass;
import javafx.scene.canvas.GraphicsContext;

public interface IGameActions {

    public void createGameObject();

    void updateObjectsLocations(GraphicsContext gc);

    public void sliceObject(GameObjectClass gameObject);
    public void ResetGame();
}