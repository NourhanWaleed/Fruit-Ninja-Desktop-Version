package FruitNinja.Model;


import FruitNinja.Model.Definitions.Command;

public class Remote {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}