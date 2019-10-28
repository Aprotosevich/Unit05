package by.epam.finance.controller.command;


import by.epam.finance.bean.User;
import by.epam.finance.service.UserService;

import static by.epam.finance.controller.Controller.PARAM_DELIMETER;

public class CreateUserCommand implements Command {



    @Override
    public String execute(String req) {
        String login = req.substring(0, req.indexOf(PARAM_DELIMETER)).trim();
        String password = req.substring(req.indexOf(PARAM_DELIMETER)).trim();

        UserService userService = UserService.getInstance();
        User user = userService.createUser(login, password);

        if(userService.saveUser(user)){
            return "Succesfully create New User";
        }

        else return "SomeThing gone wrong!";
    }

}
