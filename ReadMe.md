# Fruitty Ninja
Fruitty Ninja is a Fruit Ninja clone designed using Javafx and implemented in Java. Fruitty Ninja makes use of various OOP concepts and design patterns acquired during the 4th Semester Programming course (CS272).

### How to RUN
 go to ```out/artifacts/assignment3_6147_6369_6609_6628_jar```. Double click ```assignment3_6147_6369_6609_6628.jar``` or run the ```FruitNinja.bat``` batch file.

### Project Specification
The project was compiled with java-11.0.5.

### Project File Structure

- __PATH\\TO\PROJECT\\assignment3\_6147\_6369\_6609\_6628\\src__
   - __FruitNinja__
     - __Controller__
       - [Alerts.java](FruitNinja/Controller/Alerts.java) *Custom EventListner class* 
       - __CustomComponents__
         - [ShakeOnHover.java](FruitNinja/Controller/CustomComponents/ShakeOnHover.java) *Class for generaating Alert Text boxes [Confirmation, imageAlert and Text ALert]*
       - [GameController.java](FruitNinja/Controller/GameController.java) *Controller class for game objects*
       - [MainMenuController.java](FruitNinja/Controller/MainMenuController.java)*MainMenu Controller executed at the start of the application and when returning home from the game* 
     - [Launcher.java](FruitNinja/Launcher.java) *Launcher class that executes the JavaFx main Application class*
     - [Main.java](FruitNinja/Main.java) *Main class used for executing the main game controller*
     - __Model__
       - __Definitions__
         - [Command.java](FruitNinja/Model/Definitions/Command.java)
         - [IGameActions.java](FruitNinja/Model/Definitions/IGameActions.java) *interfaces provided within the task pdf* 
         - [IGameObject.java](FruitNinja/Model/Definitions/IGameObject.java) *interfaces provided within the task pdf*
       - [Difficulty.java](FruitNinja/Model/Difficulty.java) *Enumerator that defines the current game difficulty*
       - [GameActions.java](FruitNinja/Model/GameActions.java) *communicates with the controller and the model executing commands*
       - __GameObjects__
         - __Factory__
           - [GameObjectFactory.java](FruitNinja/Model/GameObjects/Factory/GameObjectFactory.java) *Factory class responsible for generating In-Game objects*
         - [GameObjectClass.java](FruitNinja/Model/GameObjects/GameObjectClass.java) *Parent Game Object class/implements IGameObject *
         - [DangerousBomb.java](FruitNinja/Model/GameObjects/DangerousBomb.java) *child to GameObjectClass.java*
         - [FatalBomb.java](FruitNinja/Model/GameObjects/FatalBomb.java) *child to GameObjectClass.java*
         - [ObjectType.java](FruitNinja/Model/GameObjects/ObjectType.java) *child to GameObjectClass.java*
         - [RegularFruit.java](FruitNinja/Model/GameObjects/RegularFruit.java) *child to GameObjectClass.java*
         - [SpecialFruit.java](FruitNinja/Model/GameObjects/SpecialFruit.java) *child to GameObjectClass.java*
       - __Loader__
         - __Commands__
           - [LoadCommand.java](FruitNinja/Model/Loader/Commands/LoadCommand.java)
           - [SaveCommand.java](FruitNinja/Model/Loader/Commands/SaveCommand.java)
           - [SaveHighScore.java](FruitNinja/Model/Loader/Commands/SaveHighScore.java)
           - [loadHighScore.java](FruitNinja/Model/Loader/Commands/loadHighScore.java)
         - [SaveLoad.java](FruitNinja/Model/Loader/SaveLoad.java) *Dom XML marshaling and unmarshalling*
         - [SaveMemento.java](FruitNinja/Model/Loader/SaveMemento.java) *Class that maintains game state before saving*
       - [Remote.java](FruitNinja/Model/Remote.java) *Class that executes/ invokes various commands ie invoker*
     - __View__
       - [Game.css](FruitNinja/View/Game.css) *CSS used for Styling*
       - [Game.fxml](FruitNinja/View/Game.fxml) *Dummy view Controlled by [MainController.java](FruitNinja/Controller/MainMenuController.java)*
       - [MainMenu.fxml](FruitNinja/View/MainMenu.fxml) *Dummy view Controlled by [GameController.java](FruitNinja/Controller/GameController.java)*
       - [mainMenu.css](FruitNinja/View/mainMenu.css) *CSS used for Styling*
     - __resources__ *Package containing various game assets*
       - __Audio,Buttons,Fonts__
   - [SavedGame.xml](SavedGame.xml) *XML file for storing Game State*
   - [HighScore.xml](HighScore.xml) *XML file for storing High Score*
   - [module\-info.java](module-info.java) *module-info for making JAR independent of Library location*

### Design patterns implemented
* Singleton _Game Actions Class_
* Factory   _Game Object Factory_
* Command   _Load and Save Operations_
* Memento   _Save Memento Class_
* State     _Game difficulty_

MVC architecture was implemented.

### Sample Run
![Imgur](readmeResources/new.gif)

### Labour division
#####  *```INSERT NAME``` 6147*
task
##### *```INSERT NAME```  6369*
task
##### *Nourhan Waleed     6609*
task
##### *```INSERT NAME```  6628*
task

### UML
![URL TO UML HERE](readmeResources/file.jpg)

### Sequence diagram
![URL TO SEQ HERE](readmeResources/File.jpg)

