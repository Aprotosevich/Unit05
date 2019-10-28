package by.epam.finance.dao;

import by.epam.finance.bean.User;
import by.epam.finance.dao.impl.UserDaoImpl;

import java.io.IOException;

public class UserFactory {

    private static final UserFactory userFactory = new UserFactory();

    private UserFactory(){};

    public static UserFactory getInstance(){
        return userFactory;
    };

    public UserDaoImpl takeUser(String login) {
        return null;
    }

    public boolean saveUser(User user){
            String fileName = user.getLogin();
            DBSerialize dbSerialize = new DBSerialize();
            dbSerialize.save(user, fileName);
            return true;
    }

}

