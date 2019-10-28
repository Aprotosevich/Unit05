package by.epam.finance.controller;

import by.epam.finance.controller.command.*;

public class CommandGiver {

    private static final CommandGiver commandGiver = new CommandGiver();

    private CommandGiver(){};

    public static CommandGiver getInstance(){
        return commandGiver;
    }

    public Command takeCommandByName(String commandName) {
        PossibleCommand command = PossibleCommand.valueOf(commandName);

        switch (command) {
            case LOGIN: return new LogInCommand();
            case CREATE_USER: return new CreateUserCommand();
            default: return null;
        }

    }
}
