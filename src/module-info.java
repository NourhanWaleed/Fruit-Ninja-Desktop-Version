module  FruitNinja{
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.controls;
    requires  javafx.graphics;
    requires java.xml;
    opens FruitNinja.Controller;
    opens FruitNinja.Model;
    opens FruitNinja.View;
    opens FruitNinja;
}