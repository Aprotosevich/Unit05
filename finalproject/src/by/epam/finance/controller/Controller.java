package by.epam.finance.controller;

import by.epam.finance.controller.command.Command;
import by.epam.finance.controller.command.CreateUserCommand;
import by.epam.finance.controller.command.LogInCommand;
import by.epam.finance.controller.command.PossibleCommand;

public class Controller {

    private static final Controller controller = new Controller();

    private Controller(){};

    public static Controller getInstance(){
        return controller;
    }

    public static final char PARAM_DELIMETER = ' ';

    public String execute(String reqMapping){
        String commandName = reqMapping.substring(0, reqMapping.indexOf(PARAM_DELIMETER));
        String commandReq = reqMapping.substring(reqMapping.indexOf(PARAM_DELIMETER)).trim();

        Command command = takeCommandByName(commandName);

        if(command == null){
            return "wrong request!";
        }

        else return command.execute(commandReq);

    }

    // нужно ли создавать новый класс для одного меода?
    private Command takeCommandByName(String commandName) {
        PossibleCommand command = PossibleCommand.valueOf(commandName);

        switch (command) {
            case LOGIN: return new LogInCommand();
            case CREATE_USER: return new CreateUserCommand();
            default: return null;
        }

    }

}
