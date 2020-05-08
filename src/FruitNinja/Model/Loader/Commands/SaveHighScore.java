package FruitNinja.Model.Loader.Commands;

import FruitNinja.Model.Definitions.Command;
import FruitNinja.Model.Loader.SaveLoad;

public class SaveHighScore implements Command {
    SaveLoad saveLoad;

    public SaveHighScore(SaveLoad saveLoad) {
        this.saveLoad = saveLoad;
    }

    @Override
    public void execute() {
        saveLoad.saveHighScore();
    }
}
