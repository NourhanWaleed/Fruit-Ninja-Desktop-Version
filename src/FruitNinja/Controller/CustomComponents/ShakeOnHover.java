package FruitNinja.Controller.CustomComponents;

import javafx.animation.RotateTransition;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

public class ShakeOnHover implements EventHandler<MouseEvent>
{
    private Button button;
    private double toAngle =5;
    private double fromAngle =0;
    public ShakeOnHover(Button btn) {
        this.button  = btn;
    }

    public Button getButton() {
        return button;
    }

    @Override
    public void handle(MouseEvent event) {
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(button);
        rotate.setAutoReverse(true);
        rotate.setCycleCount(2);
        rotate.setFromAngle(fromAngle);
        rotate.setToAngle(toAngle);
        rotate.setDuration(Duration.seconds(0.2));
        AudioClip click = new AudioClip(getClass().getResource("/FruitNinja/resources/Audio/ui-button-push.wav").toExternalForm());
        click.play();
        rotate.play();
    }

    public void setToAngle(double toAngle) {
        this.toAngle = toAngle;
    }

    public void setFromAngle(double fromAngle) {
        this.fromAngle = fromAngle;
    }

    public double getToAngle() {
        return toAngle;
    }

    public double getFromAngle() {
        return fromAngle;
    }
}