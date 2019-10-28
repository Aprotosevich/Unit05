package by.epam.finance;

import by.epam.finance.bean.User;
import by.epam.finance.controller.FinController;
import by.epam.finance.controller.UserController;

public class Main {

    public static void main(String[] args) {
        FinController controller = FinController.getInstance();

        String commandCreate = "CREATE_USER maryJ 123qwerty";
        String result1 = controller.execute(commandCreate);
        System.out.println(result1);

        String commandLogin = "LOGIN maryJ 123qwerty";
        String result = controller.execute(commandLogin);
        System.out.println(result);

        UserController userController = UserController.getInstance();
        User user = userController.takeLoggedUser("maryJ");

        String commandAdd = "ADD_ACCOUNT myAcc 500";
        String resultAdd = userController.addAccountToUser(commandAdd, user);
        System.out.println(resultAdd);

        String commandAdd2 = "ADD_ACCOUNT anotherAcc 2500";
        String resultAdd2 = userController.addAccountToUser(commandAdd2, user);
        System.out.println(resultAdd2);

        String commandDelete = "DELETE_ACCOUNT myAcc";
        String resultdelete = userController.deleteAccount(commandDelete, user);
        System.out.println(resultdelete);

        String commandUpdate = "UPDATE_ACCOUNT anotherAcc 30";
        String resultUpdate = userController.updateAccount(commandUpdate, user);

        System.out.println(user.getUserAccounts());

    }

}
