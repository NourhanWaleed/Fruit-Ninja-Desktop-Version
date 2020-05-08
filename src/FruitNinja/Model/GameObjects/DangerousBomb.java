package FruitNinja.Model.GameObjects;

import javafx.scene.image.Image;


public class DangerousBomb extends GameObjectClass {
    public DangerousBomb() {
        setObjecttype(ObjectType.DANGEROUS_BOMB);
        setImage(0,new Image(getClass().getResource("/FruitNinja/resources/bomb0.png").toExternalForm(),75,75,true,false));
        setImage(1,new Image(getClass().getResource("/FruitNinja/resources/explosive.png").toExternalForm(),75,75,true,false));
        this.setXLocation(Math.random() * 600 + 75);
        this.setYLocation(550);
        this.setMaxHeight(Math.random() * 600 * 0.2);
    }

}
