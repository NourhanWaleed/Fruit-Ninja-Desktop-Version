package FruitNinja.Model.GameObjects;


import javafx.scene.image.Image;

public class SpecialFruit extends GameObjectClass {
    public SpecialFruit() {
        setObjecttype(ObjectType.SPECIAL_FRUIT);
        int x = (int)(Math.random() * 2);
        switch(x) {
            case 0 : {
                setImage(0,new Image(getClass().getResource("/FruitNinja/resources/Special1.png").toExternalForm()));
                setImage(1,new Image(getClass().getResource("/FruitNinja/resources/Special1s.png").toExternalForm()));;
            }
            break;
            case 1 : {
                setImage(0,new Image(getClass().getResource("/FruitNinja/resources/Special2.png").toExternalForm()));;
                setImage(1,new Image(getClass().getResource("/FruitNinja/resources/Special2s.png").toExternalForm()));;
            }
            break;
        }
        this.setXLocation( (int) (Math.random() * 600 +75 ));
        this.setYLocation(550);
        this.setMaxHeight(Math.random() * 600 * 0.2);
    }
}
