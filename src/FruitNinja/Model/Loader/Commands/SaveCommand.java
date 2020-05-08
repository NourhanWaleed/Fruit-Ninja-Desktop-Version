package FruitNinja.Model.Loader.Commands;

import FruitNinja.Model.Definitions.Command;
import FruitNinja.Model.Loader.SaveLoad;

public class SaveCommand implements Command {
    private SaveLoad saveLoad;
    public SaveCommand(SaveLoad saveLoad) {
        this.saveLoad = saveLoad;
    }
    public void execute() {
        saveLoad.save();
    }
}
