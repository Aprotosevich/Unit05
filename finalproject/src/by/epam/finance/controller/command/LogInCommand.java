package by.epam.finance.controller.command;

import by.epam.finance.service.LogInService;

import static by.epam.finance.controller.FinController.PARAM_DELIMETER;

public class LogInCommand implements Command {

    private String login;
    private String password;

    @Override
    public String execute(String req) {
        login = req.substring(0, req.indexOf(PARAM_DELIMETER)).trim();
        password = req.substring(req.indexOf(PARAM_DELIMETER)).trim();

        LogInService logInService = LogInService.getInstance();
        boolean logged = logInService.logIn(login, password);
        if(logged) return "Succesfully logged";
        else return "Invalid UserName or password";
    }
}
