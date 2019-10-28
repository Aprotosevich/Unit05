package by.epam.finance.dao;

import by.epam.finance.bean.User;

import java.util.logging.Logger;

public class UserFactory {

    private static Logger log = Logger.getLogger("UserFactorry Logger");

    private static final UserFactory userFactory = new UserFactory();

    private UserFactory(){};

    public static UserFactory getInstance(){
        return userFactory;
    };

    public boolean saveUser(User user){
            DBSerialize dbSerialize = new DBSerialize(user.getLogin());
        try {
            dbSerialize.save(user);
            return true;
        } catch (DaoException e) {
            log.warning("Exception in save User");
            return false;
        }
    }

    public User takeUserByLogin(String login){
        DBSerialize dbSerialize = new DBSerialize(login);
        try {
            return dbSerialize.takeUserByLogin(login);
        } catch (DaoException e) {
            log.warning("Exception in taking User from Base");
            return null;
        }
    }
}

