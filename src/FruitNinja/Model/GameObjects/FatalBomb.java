package FruitNinja.Model.GameObjects;


import javafx.scene.image.Image;

public class FatalBomb extends GameObjectClass {
    public FatalBomb() {
        setObjecttype(ObjectType.FATAL_BOMB);
        setImage(0, new Image(getClass().getResource("/FruitNinja/resources/bomb1.png").toExternalForm(),75,75,true,false));
        setImage(1,new Image(getClass().getResource("/FruitNinja/resources/explosive.png").toExternalForm(),75,75,true,false));
        this.setXLocation((int) (Math.random() * 600 +75));
        this.setYLocation(550);
       setMaxHeight(Math.random() * 600 * 0.2);
    }
}
