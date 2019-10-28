package by.epam.finance.controller;

import by.epam.finance.controller.command.*;

public class FinController {

    private static final FinController controller = new FinController();

    private FinController(){};

    public static FinController getInstance(){
        return controller;
    }

    public static final char PARAM_DELIMETER = ' ';

    public String execute(String reqMapping){
        String commandName = reqMapping.substring(0, reqMapping.indexOf(PARAM_DELIMETER));
        String commandReq = reqMapping.substring(reqMapping.indexOf(PARAM_DELIMETER)).trim();

        Command command = CommandGiver.getInstance().takeCommandByName(commandName);

        if(command == null){
            return "wrong request!";
        }

        else return command.execute(commandReq);

    }

}
