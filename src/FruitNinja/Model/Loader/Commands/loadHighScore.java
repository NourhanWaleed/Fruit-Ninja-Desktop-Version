package FruitNinja.Model.Loader.Commands;

import FruitNinja.Model.Definitions.Command;
import FruitNinja.Model.Loader.SaveLoad;

import java.net.URISyntaxException;

public class loadHighScore implements Command {
    SaveLoad saveLoad;

    public loadHighScore(SaveLoad saveLoad) {
        this.saveLoad = saveLoad;
    }

    @Override
    public void execute() {
        try {
            saveLoad.loadHighScore();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
