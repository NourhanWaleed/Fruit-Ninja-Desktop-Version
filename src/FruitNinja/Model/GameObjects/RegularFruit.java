package FruitNinja.Model.GameObjects;

import javafx.scene.image.Image;

public class RegularFruit extends GameObjectClass {

    public RegularFruit() {
        setObjecttype(ObjectType.REGULAR_FRUIT);
        int x = (int) (Math.random() * 4);
        switch (x) {
            case 0: {
               setImage(0,new Image(getClass().getResource("/FruitNinja/resources/apple.png").toExternalForm(),75,75,true,false));
               setImage(1,new Image(getClass().getResource("/FruitNinja/resources/slicedapple.png").toExternalForm(),75, 75, true, false));
               setImage(2,new Image(getClass().getResource("/FruitNinja/resources/slicedapple2.png").toExternalForm(),75, 75, true, false));
            }
            break;
            case 1: {
               setImage(0,new Image(getClass().getResource("/FruitNinja/resources/watermelon.png").toExternalForm(),75, 75, true, false));
               setImage(1,new Image(getClass().getResource("/FruitNinja/resources/slicedwatermelon1.png").toExternalForm(),75, 75, true, false));
               setImage(2,new Image(getClass().getResource("/FruitNinja/resources/slicedwatermelon2.png").toExternalForm(),75, 75, true, false));
            }
            break;
            case 2: {
               setImage(0,new Image(getClass().getResource("/FruitNinja/resources/strawberry.png").toExternalForm(),75, 75, true, false));
               setImage(1,new Image(getClass().getResource("/FruitNinja/resources/slicedstrawberry1.png").toExternalForm(),75, 75, true, false));
               setImage(2,new Image(getClass().getResource("/FruitNinja/resources/slicedstrawberry2.png").toExternalForm(),75, 75, true, false));
            }
            break;
            case 3: {
               setImage(0,new Image(getClass().getResource("/FruitNinja/resources/banana.png").toExternalForm(),75, 75, true, false));
               setImage(1,new Image(getClass().getResource("/FruitNinja/resources/slicedbanana.png").toExternalForm(),75, 75, true, false));
               setImage(2,new Image(getClass().getResource("/FruitNinja/resources/halfbanana.png").toExternalForm(),75, 75, true, false));
            }
        }
        this.setXLocation( Math.random() * 600 + 75);
        this.setYLocation(550);
        this.setMaxHeight(Math.random() * 600 * 0.2);
    }
    /*@Override
    public double getMaxHeight() {
        return maxHeight;
    }

    @Override
    public Reference.ObjectType getObjectType() {
        return objectType;
    }*/

}