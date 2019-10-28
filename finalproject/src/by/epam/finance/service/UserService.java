package by.epam.finance.service;

import by.epam.finance.bean.Account;
import by.epam.finance.bean.User;
import by.epam.finance.dao.DBSerialize;
import by.epam.finance.dao.UserFactory;
import by.epam.finance.dao.DaoException;

import java.util.logging.Logger;

public class UserService {

    private static Logger log = Logger.getLogger("UserService Logger");

    private static final UserService userService = new UserService();

    private UserService(){};

    private UserFactory userFactory = UserFactory.getInstance();

    public static UserService getInstance(){return userService;};

    public User createUser(String login, String password){
        return new User(login, password);
    }

    public boolean saveUser(User user){
        return userFactory.saveUser(user);
    }

    public User takeUser(String login){
        return userFactory.takeUserByLogin(login);
    }

    public User takeLoggedUser(String maryJ) throws LogInException {
        User user = userFactory.takeUserByLogin(maryJ);
        if(user.isLogged()){
            return user;
        }
        else throw new LogInException();
    }

    public boolean addAccToUser(User user, Account account) {
        user.addAcount(account);
        DBSerialize dbSerialize = new DBSerialize(user.getLogin());
        try {
            dbSerialize.save(user);
            return true;
        } catch (DaoException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAcc(User user, String accName) {
        user.getUserAccounts().removeIf(
                element -> element.getName().equals(accName)
        );

        try {
            DBSerialize dbSerialize = new DBSerialize(user.getLogin());
            dbSerialize.save(user);
            return true;
        } catch (DaoException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateAcc(User user, String accName, long newValue) {
        boolean result = false;
        for (Account account : user.getUserAccounts()) {
            if (account.getName().equals(accName)) {
                result = true;
                account.setAmount(newValue);
            }
        }

        try {
            DBSerialize dbSerialize = new DBSerialize(user.getLogin());
            dbSerialize.save(user);
            return result;
        } catch (DaoException e) {
            e.printStackTrace();
            return false;
        }

    }
}
