package by.epam.finance.service;

import by.epam.finance.bean.User;
import by.epam.finance.dao.UserFactory;

public class UserService {

    private static final UserService userService = new UserService();

    private UserService(){};

    public static UserService getInstance(){return userService;};

    public User createUser(String login, String password){
        return new User(login, password);
    }

    public boolean saveUser(User user){
        UserFactory userFactory = UserFactory.getInstance();
        return userFactory.saveUser(user);
    }

}
