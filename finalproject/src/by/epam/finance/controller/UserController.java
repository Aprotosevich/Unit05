package by.epam.finance.controller;

import by.epam.finance.bean.Account;
import by.epam.finance.bean.User;
import by.epam.finance.service.AccountService;
import by.epam.finance.service.LogInException;
import by.epam.finance.service.UserService;

import java.util.logging.Logger;

import static by.epam.finance.controller.FinController.PARAM_DELIMETER;

public class UserController {

    private static Logger logger = Logger.getLogger("UserControllerLogger");

    private static final UserController userController = new UserController();

    private UserController(){};

    public static UserController getInstance(){return userController;};

    private UserService userService = UserService.getInstance();
    private AccountService accountService = AccountService.getInstance();

    public User takeLoggedUser(String maryJ) {
        try {
            return userService.takeLoggedUser(maryJ);
        } catch (LogInException e) {
            e.printStackTrace();
            logger.warning("Cannot find User or User don't logged in!");
            return null;
        }
    }

    public String addAccountToUser(String reqMapping, User user){
        String commandName = reqMapping.substring(0, reqMapping.indexOf(PARAM_DELIMETER));
        String commandReq = reqMapping.substring(reqMapping.indexOf(PARAM_DELIMETER)).trim();

        boolean result = false;

        if(commandName.equals("ADD_ACCOUNT")){
            String name = commandReq.substring(0, commandReq.indexOf(PARAM_DELIMETER));
            long amount = Long.parseLong(commandReq.substring(commandReq.indexOf(PARAM_DELIMETER)).trim());
            Account account = accountService.createAccount(name, amount);
            result = userService.addAccToUser(user, account);
        }

       if(result){
           return "Succesfully add acc to User";
       }
       else return "Cannot add acc to User";

    }

    public String deleteAccount(String commandDelete, User user) {
        String commandName = commandDelete.substring(0, commandDelete.indexOf(PARAM_DELIMETER));
        String commandReq = commandDelete.substring(commandDelete.indexOf(PARAM_DELIMETER)).trim();

        boolean result = false;
        String accName = commandReq;

        if(commandName.equals("DELETE_ACCOUNT")){
            result = userService.deleteAcc(user, accName);
        }

        if(result){
            return "deleted account";
        }
        else return "cant delete account";
    }

    public String updateAccount(String commandUpdate, User user) {
        String commandName = commandUpdate.substring(0, commandUpdate.indexOf(PARAM_DELIMETER));
        String commandReq = commandUpdate.substring(commandUpdate.indexOf(PARAM_DELIMETER)).trim();

        boolean result = false;
        String accName = commandReq.substring(0, commandReq.indexOf(PARAM_DELIMETER));
        long newValue = Long.parseLong(commandReq.substring(commandReq.indexOf(PARAM_DELIMETER)).trim());

        if(commandName.equals("UPDATE_ACCOUNT")){
            result = userService.updateAcc(user, accName, newValue);
        }

        if(result){
            return "updated yserr" + user.getLogin();
        }
        else return "cannot update";
    }
}
