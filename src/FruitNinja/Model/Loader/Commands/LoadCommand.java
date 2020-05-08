package FruitNinja.Model.Loader.Commands;


import FruitNinja.Model.Definitions.Command;
import FruitNinja.Model.Loader.SaveLoad;

public class LoadCommand implements Command {
    SaveLoad saveLoad;
    public LoadCommand(SaveLoad saveLoad) {
        this.saveLoad = saveLoad;
    }
    public void execute() {
        saveLoad.load();
    }
}
